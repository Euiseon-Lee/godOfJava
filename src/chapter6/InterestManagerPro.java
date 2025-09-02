package chapter6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * InterestManagerPro
 * - 교재 요구사항을 충족하면서 실무 포인트(정밀도, 확장성, 검증, 포맷)를 반영한 예제
 */
public class InterestManagerPro {

    // ------------------------------
    // [실무 포인트] 매직 넘버 상수화
    // - 하드코딩 숫자는 추적/수정이 어려움 → 의미 있는 이름의 상수로 선언
    // - 금리 정책/일수 기준 등 변경 가능성이 높은 값은 중앙집중화
    // ------------------------------
    private static final int BASIS_ACT_365 = 365; // Day Count 기준 (간단화: ACT/365)
    private static final Locale LOCALE_KR = Locale.KOREA; // 통화/숫자 포맷 로케일

    // ------------------------------
    // [실무 포인트] 금리 정책을 인터페이스로 분리(전략 패턴)
    // - 상품/구간/시점별로 금리가 달라질 수 있음 → 로직을 분리하면 테스트/변경에 강함
    // - 규칙이 복잡해지면 DB/설정 파일로 뺄 수도 있음(데이터 주도 설계)
    // ------------------------------
    interface InterestPolicy {
        BigDecimal rateFor(int day); // 이율(예: 0.005 = 0.5%)
    }

    // ------------------------------
    // [실무 포인트] 테이블 기반 금리 정책
    // - 구간 경계(<=90, <=180, <=364, 그 이상)와 이율을 테이블로 보관
    // - if-else 체인의 분기 실수를 줄이고, 변경을 한 곳에서 처리
    // ------------------------------
    static class TablePolicy implements InterestPolicy {
        /** NavigableMap
         *  ✔️ 정의
         * NavigableMap<K,V>는 SortedMap을 확장한 인터페이스.
         * 키가 정렬된 상태로 저장되고, 특정 키를 기준으로 “앞/뒤”에 있는 엔트리들을 쉽게 찾을 수 있는 기능이 추가된 Map.
         *
         * ✔️ 자주 쓰는 메서드
         * ceilingEntry(key) : key 이상 중 가장 작은 키와 값 반환
         * floorEntry(key) : key 이하 중 가장 큰 키와 값 반환
         * higherEntry(key) : key 초과 중 가장 작은 키와 값
         * lowerEntry(key) : key 미만 중 가장 큰 키와 값
         */
        private final NavigableMap<Integer, BigDecimal> bands = new TreeMap<>();

        TablePolicy() {
            // 교재 이율을 BigDecimal 문자열 생성자로 정확히 표현 (이진 부동소수 오차 방지)
            bands.put(90,  new BigDecimal("0.005"));   // 1~90일
            bands.put(180, new BigDecimal("0.010"));   // 91~180일
            bands.put(364, new BigDecimal("0.020"));   // 181~364일
            bands.put(Integer.MAX_VALUE, new BigDecimal("0.056")); // 365일 이상
        }

        @Override
        public BigDecimal rateFor(int day) {
            // [실무 포인트] 경계값 정확성
            // - ceilingEntry(day): 키 >= day 중 가장 작은 키를 찾음 → "day가 속하는 구간" 매핑
            // - 정책 해석이 바뀌면(예: <, <=) 여기만 수정하면 됨
            return bands.ceilingEntry(day).getValue();
        }
    }

    private final InterestPolicy policy = new TablePolicy(); // 기본 정책 주입

    // ------------------------------
    // [실무 포인트] 입력 검증
    // - 음수/0/이상치 입력을 조기에 차단 → 예외 메시지로 원인 명확화
    // - "보정"이 필요하면 여기서 보정 정책 적용(예: 음수면 0으로 클램핑 등)
    // ------------------------------
    private static void validate(int day, long amount) {
        if (day <= 0) throw new IllegalArgumentException("day must be > 0");
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");
    }

    // ------------------------------
    // [실무 포인트] 단리 계산(교재 요구 충족)
    // - 내부 계산은 BigDecimal 사용: 돈/금융은 이진 부동소수 오차가 허용되지 않음
    // - 반올림 정책 명시: setScale(0, HALF_UP) → '원 단위' 반올림 예시
    // - 반환은 BigDecimal: 상위 레이어에서 포맷/표시를 책임지게 분리
    // ------------------------------
    public BigDecimal simpleAmount(int day, long amount) {
        validate(day, amount);
        BigDecimal p = BigDecimal.valueOf(amount);   // 원금
        BigDecimal r = policy.rateFor(day);          // 이율
        BigDecimal interest = p.multiply(r);         // 이자 = 원금 × 이율

        // [실무 포인트] 반올림 정책
        // - 어디서 반올림할지(매 스텝 vs 최종) 정책 결정이 필요
        // - 여기서는 이자 금액을 원 단위로 반올림
        /** RoundingMode
         *  ✔️ 정의
         * java.math.RoundingMode는 BigDecimal 반올림 정책을 정의하는 enum.
         * 금융, 과학 계산 등에서 “어떻게 반올림할지”를 코드로 명시.
         *
         * ✔️ 주요 모드
         * HALF_UP : 일반적인 “5 이상 올림” 방식 (학교에서 배우는 반올림)
         * HALF_DOWN : “5 초과일 때만 올림” (5는 버림)
         * HALF_EVEN : “은행가 반올림” (5일 때 짝수 쪽으로) → 누적 오차 줄임
         * UP : 무조건 올림
         * DOWN : 무조건 버림
         * CEILING : 양수는 올림, 음수는 버림
         * FLOOR : 양수는 버림, 음수는 올림
         */
        interest = interest.setScale(0, RoundingMode.HALF_UP);

        return p.add(interest); // 원금 + 이자
    }

    // ------------------------------
    // [심화] 복리 계산
    // - 실무에서는 월복리/연복리/일복리 등 다양한 케이스가 존재
    // - 여기선 간단히 연복리를 day/365로 지수 적용
    // - 지수 계산(Math.pow)은 부득이 double → 결과는 BigDecimal로 감싸고 반올림
    // ------------------------------
    public BigDecimal compoundAmount(int day, long amount) {
        validate(day, amount);
        BigDecimal p = BigDecimal.valueOf(amount);
        BigDecimal r = policy.rateFor(day);

        double factor = Math.pow(1 + r.doubleValue(), (double) day / BASIS_ACT_365);
        BigDecimal compounded = p.multiply(BigDecimal.valueOf(factor));

        // 표시 기준에 맞게 원 단위로 반올림
        return compounded.setScale(0, RoundingMode.HALF_UP);
    }

    // ------------------------------
    // [실무 포인트] 출력/표시 포맷 분리
    // - 내부 계산과 UI/표시를 분리하면 테스트/재사용성 증가
    // - 로케일/포맷 정책을 한 곳에서 관리 (ERP/리포트/영수증 일관성)
    // ------------------------------
    private static String formatKR(BigDecimal amount) {
        NumberFormat nf = NumberFormat.getNumberInstance(LOCALE_KR);
        return nf.format(amount) + "원";
    }

    // ------------------------------
    // [데모] 교재 요구사항: 1~365일(또는 10일 간격) 금액 출력
    // - 실무 포인트: I/O(System.out)와 계산 로직을 분리했고, 포맷팅도 별도 메서드 사용
    // ------------------------------
    public static void main(String[] args) {
        InterestManagerPro im = new InterestManagerPro();
        long money = 1_000_000L; // 100만원

        // 10일 간격 출력 (교재 7번 요구사항)
        for (int day = 1; day <= 365; day += 10) {
            BigDecimal simple   = im.simpleAmount(day, money);
            BigDecimal compound = im.compoundAmount(day, money);

            // [실무 포인트] 포맷/로케일 일관 적용
            System.out.printf("day=%3d | 단리=%s | 복리=%s%n",
                    day, formatKR(simple), formatKR(compound));
        }
    }
}