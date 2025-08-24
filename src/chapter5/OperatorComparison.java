package chapter5;

public class OperatorComparison {
    public static void main(String[] args) {
        OperatorComparison operator = new OperatorComparison();
        operator.comparison();
    }

    public void comparison() {
        // 등가 비교 연산자 (==, !=)
        // 모든 기본 자료형과 참조 자료형에서 사용 가능
        // 기본 자료형에서는 내용을 비교 BUT 참조형에서 사용할 경우, 동일 객체인지를 비교

        // 실제 타입은 다르더라도 수치형(정수 및 실수)끼리의 비교는 가능
        // 1) 기본형 vs 기본형 (자동 승격)
        char charValue = 'a';
        System.out.println(97 == charValue);          // true (char 'a' → 97로 승격)

        int intValue = 1;
        double doubleValue = 1.0;
        System.out.println(intValue == doubleValue);  // true (둘 다 double로 승격되어 1.0 == 1.0)

        // 2) 부동소수 비교 주의
        // double/float는 이진 부동소수 오차 → 일반적으로 == 대신 허용 오차(epsilon)로 비교:
        double x = 0.1 * 3;
        double y = 0.3;
        System.out.println(x == y);                   // false일 가능성 높음
        System.out.println(Math.abs(x - y) < 1e-9);   // 권장 방식


        // 3) NaN, 0.0과 -0.0
        // IEEE‑754 규칙: NaN은 어떤 값과도 같지 않다(자기 자신 포함)
        // 체크는 항상 Double.isNaN(x)로!
        // 참고: NaN은 모든 비교(>, <, >=, <=)도 false, 오직 !=만 true.
        System.out.println(Double.NaN == Double.NaN);       // false
        System.out.println(Double.isNaN(Double.NaN));       // true
        System.out.println(0.0 == -0.0);                    // true (값 비교는 같음)
        System.out.println(Double.compare(0.0, -0.0) > 0);  // true (양의 0이 더 큼)

        // 4) 참조형의 == (동일 객체 비교)
        // 문자열 리터럴 풀 착시: 동일한 문자열 리터럴은 String Pool에 단 하나만 저장되어 재사용되는 반면, `new String()`으로 생성된 문자열은 힙에 별도의 객체로 생성되어 주소값이 달라지는 현상을 의미
        // System.out.println("java" == "java");      // true (풀 공유) → equals 사용 습관!
        String s1 = new String("java");
        String s2 = new String("java");
        System.out.println(s1 == s2);                 // false (서로 다른 객체)
        System.out.println(s1.equals(s2));            // true  (내용 동일)

        // 대소 비교 연산자 (Relational Operator)
        // <, >, <=, >=
        // boolean과 Wrapper가 아닌 참조 자료형에서는 사용 불가능 (컴파일 에러)
        // Wrapper(Integer, Double 등)는 자동 언박싱되어 비교 가능
        // 문자열 순서는 compareTo로 비교
        System.out.println("apple".compareTo("banana") < 0); // true (사전식 비교)

        // instanceOf 연산자와 비트 연산자는 10장에서..
    }
}
