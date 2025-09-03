package chapter8;

public class MethodVarargs {
    public static void main(String[] args) {
        MethodVarargs mv = new MethodVarargs();
        mv.calculateNumbers(new int[]{1,2,3,4,5});
    }
    public void calculateNumberWithArray(int[] numbers) {}

    /** 임의 개수의 매개변수 (가변인자, Arbitrary Number of Arguments)
     *  "(Type... paramName)"으로 선언 시 개별 인자 여러 개를 주거나, 아예 배열을 줄 수도 있음.
     *      calculateNumbers(1, 2, 3, 4, 5);     // OK
     *      calculateNumbers(new int[]{1,2,3});  // OK (배열 직접 전달)
     *
     *  하나의 메서드에서는 한 개만 사용이 가능하고, 여러 개의 매개 변수가 있는 경우 가장 마지막에 선언해야 한다.
     *  내부에서 배열을 생성하므로, 성능 민감한 코드에서 매우 자주 호출되는 경우엔 배열 생성 비용이 누적 가능. (일반적인 상황에선 무시 가능)
     */
    public void calculateNumbers(int... numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        System.out.println("Total = " + total);
    }
}
