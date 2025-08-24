package chapter5;

public class OperatorTilde {
    public static void main(String[] args) {
        /** 비트 NOT 연산자
         *
         * 📝 2의 보수(Two's Complement) 정리
         *
         * ✅ 정의
         * - 자바의 byte, short, int, long 은 모두 "부호 있는 정수(signed integer)"
         * - 음수는 2의 보수(two's complement) 방식으로 표현됨
         * - n비트 이진수에서 값 해석:
         *   → 값 = -(MSB × 2^(n-1)) + (나머지 자리값 합)
         *
         * ✅ 음수 계산법
         * 1) 양수 → 음수 변환 (저장하기 위한 규칙):
         *    - 모든 비트를 반전(1의 보수)
         *    - +1을 더한다
         *    예:  +2 = 00000010 (8bit)
         *         반전 = 11111101
         *         +1   = 11111110 → -2
         *
         * 2) 음수 → 절댓값 구하기 (해석하기 위한 규칙):
         *    - 모든 비트를 반전
         *    - +1
         *    예: 11111110
         *       반전 = 00000001
         *       +1   = 00000010 → 값 = -2
         *
         * ✅ 범위
         * - n비트에서 표현 가능 범위 = -2^(n-1) ~ 2^(n-1)-1
         * - byte(8bit): -128 ~ 127
         *
         * ✅ 예시 (8bit)
         *  +1 : 00000001
         *  -1 : 11111111
         *  +2 : 00000010
         *  -2 : 11111110
         *  +127 : 01111111
         *  -128 : 10000000
         *
         * ✅ 자바에서 주의
         * - byte/short 연산은 int(32bit)로 자동 승격 후 처리됨
         *   → ~b 의 결과는 int
         * - unsigned로 모든 비트를 양수 자리값의 합으로 해석하고 싶다면 (b & 0xFF) 같은 마스크 필요
         *      byte b = (byte)0b11111110;  // 내부 비트: 11111110
         *      System.out.println(b);           // signed 해석 → -2
         *      System.out.println(b & 0xFF);    // unsigned 해석 → 254
         */
        OperatorTilde operator = new OperatorTilde();
        byte b = 127;                       // [ 01111111 ]
        operator.printTildeResult(b);       // Original value = 127 / Tilde value = -128


        b = 1;                              // [ 00000001 ]
        operator.printTildeResult(b);       // Original value = 1 / Tilde value = -2 [ 11111110 ]
    }

    public void printTildeResult(byte b) {
        System.out.println("Original value = " + b);
        System.out.println("Tilde value = " + (byte) ~b);
    }
}
