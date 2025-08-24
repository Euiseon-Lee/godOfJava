package chapter5;

public class OperatorCasting {
    public static void main(String[] args) {
        /** 형 변환 (Casting)
         * - 작은 타입 → 큰 타입 : 자동 형 변환 (promotion)
         * - 큰 타입 → 작은 타입 : 명시적 캐스팅 필요 (데이터 손실 가능)
         * - boolean은 숫자로 변환 불가
         *
         * 오버플로 (Overflow)
         * 정수형은 비트 개수가 정해져 있어 (byte=8bit, short=16bit, int=32bit …)
         * 그래서 가질 수 있는 값의 범위도 딱 정해져 있음.
         *      byte: -128 ~ 127
         *      short: -32,768 ~ 32,767
         *      int: 약 -21억 ~ +21억
         * → 이 범위를 벗어나면 비트가 잘리면서 다른 값이 되어버림.
         */
        OperatorCasting operator = new OperatorCasting();
        operator.casting();
    }

    public void casting(){
        byte byteValue = 127;
        short shortValue = byteValue;       // 범위가 작은 타입에서 큰 타입으로 변환할 때는 별도로 캐스팅 명시할 필요 없음

        shortValue++;                       // byte의 최댓값을 넘겼으나 short의 최댓값보다는 작음
        System.out.println(shortValue);     // 128 [ 00000000 100000000 ] (16bit)

        // short → byte (명시적 캐스팅 필요, narrowing)
        byteValue = (byte) shortValue;
        System.out.println(byteValue);      // -128 [ 100000000 ] (8bit, 오버플로)

        // int에서의 오버플로
        int max = Integer.MAX_VALUE;        //  2147483647 (2^31 - 1)
        int min = Integer.MIN_VALUE;        // -2147483648 (-2^31)

        System.out.println("MAX = " + max);
        System.out.println("MAX + 1 = " + (max + 1));       // 오버플로 → 최소값으로 순환 (-2147483648)
        System.out.println();

        System.out.println("MIN = " + min);
        System.out.println("MIN - 1 = " + (min - 1));       // 언더플로 → 최대값으로 순환 (2147483647)
    }
}
