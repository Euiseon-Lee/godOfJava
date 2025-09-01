package chapter6;

public class ControlDoWhile {
    /** do-while
     *  조건이 맞지 않으면 한 번도 실행이 안 되는 while과 달리 do-while은 적어도 한 번은 반복 문장이 실행됨
     *
     *  1️⃣ for / while / do-while 구조 차이
     *  - for: 반복 횟수가 명확할 때
     *  - while: 조건이 참인 동안 → 횟수 불명확할 때
     *  - do-while: 최소 1번은 실행해야 할 때
     *
     *  2️⃣ 반복 제어 키워드 정리
     *  - break: 가장 가까운 반복문 즉시 종료
     *  - continue: 이번 회차만 건너뛰고 다음 반복으로 진행
     *  - label + break/continue: 바깥 루프까지 제어 가능 (하지만 가독성 낮음, 꼭 필요할 때만)
     *
     *  3️⃣ 무한 루프와 탈출 방법
     *  - while(true) { ... } 형태 → 보통 break와 함께 사용
     *  - 예: 사용자 입력 대기, 서버 요청 처리 루프 등 실무에 많이 쓰임
     *
     *  4️⃣ 성능/가독성 팁
     *  - 중첩 반복문은 시간 복잡도 O(N²) 이상으로 늘어남 → 필요 없는 중첩 줄이는 습관
     *  - break와 continue는 남용하면 가독성 저하 → 조건문 분리로 대체 가능
     */
    public static void main(String[] args) {
        ControlDoWhile controlDoWhile = new ControlDoWhile();
        controlDoWhile.doWhile();
        controlDoWhile.infiniteLoop();
    }
    public void doWhile(){
        ControlSwitch control = new ControlSwitch();
//        int loop = 0;
        int loop = 13;
        do {
            loop++;
            control.switchCalender(loop);
        } while(loop < 12);
    }

    public void infiniteLoop(){
        int count = 0;
        while (true) {
            if (count++ > 5) break; // 탈출 조건
            System.out.println("count = " + count);
        }
    }
}
