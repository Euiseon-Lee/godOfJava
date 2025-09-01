package chapter6;

public class ControlLabel {
    public static void main(String[] args) {
        ControlLabel controlLabel = new ControlLabel();
        controlLabel.printTimesTable();
        controlLabel.printTimesTableSkip4Case1();
        controlLabel.printTimesTableSkip4Case2();
        controlLabel.printTimesTableSkipAfter4Case1();
        controlLabel.printTimesTableSkipAfter4Case2();
    }
    public void printTimesTable() {
        // [중첩 for문 기본]
        // i: 2~9 (단), j: 1~9 (곱해지는 수)
        // 모든 단 * 1~9 출력
        System.out.println("\n----- 1. printTimesTable() -----");
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
    public void printTimesTableSkip4Case1() {
        // [continue 사용 - 안쪽 반복문]
        // i==4 또는 j==4인 경우 현재 루프를 건너뜀
        // → 4단 전체와 각 단에서 4곱셈은 출력되지 않음
        System.out.println("\n----- 2. printTimesTableSkip4Case1() ----------");
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == 4 || j == 4) continue;
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
    public void printTimesTableSkip4Case2() {
        // [continue 사용 - 바깥/안쪽 반복문 분리]
        // 바깥 루프: i==4일 때 전체 단 건너뜀
        // 안쪽 루프: j==4일 때 해당 곱셈만 건너뜀
        // → 제어를 단계적으로 분리해서 명시적으로 처리
        System.out.println("\n----- 3. printTimesTableSkip4Case2() ----------");
        for (int i = 2; i < 10; i++) {
            if (i == 4) continue;
            for (int j = 1; j < 10; j++) {
                if (j == 4) continue;
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
    public void printTimesTableSkipAfter4Case1() {
        // [break 사용]
        // j==4가 되면 안쪽 루프 전체 종료
        // → 각 단마다 3까지만 출력되고 이후 곱셈은 모두 건너뜀
        System.out.println("\n----- 4. printTimesTableSkipAfter4Case1() ----------");
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == 4) break;
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
    public void printTimesTableSkipAfter4Case2() {
        // [라벨 + continue]
        // j==4일 때 'startLabel'로 점프 → 바깥 루프의 다음 반복 시작
        // → i=2 단에서 j=4가 나오면 2단의 남은 곱셈은 모두 건너뛰고 3단으로 진행
        // 라벨이 없으면 바깥 루프 제어 불가능, 이 예시는 라벨 continue의 전형적 사용
        System.out.println("\n----- 5. printTimesTableSkipAfter4Case2() ----------");
        startLabel:
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == 4) continue startLabel;
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
}
