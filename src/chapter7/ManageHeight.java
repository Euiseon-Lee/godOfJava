package chapter7;

public class ManageHeight {
    /** 📌 자바 배열 핵심 정리
     *
     * 1) 배열은 객체(Object)
     *    - 모든 배열은 힙에 생성되는 객체이며 length 필드를 가짐(메서드 아님): arr.length
     *    - new로 생성: int[] a = new int[3];
     *    - 참조 자체는 null일 수 있으므로 NPE 주의(예: arr가 null이면 arr.length에서 예외)
     *
     * 2) 기본형 배열 vs 참조형 배열
     *    - 기본형 배열: 값 자체 저장 (int[]/double[]/boolean[] …)
     *    - 참조형 배열: 참조(주소) 저장 (String[]/Student[] …)
     *      Student[] s = new Student[3]; // [null, null, null]
     *      s[0] = new Student(...);      // 요소는 별도로 new 해야 함
     *
     * 3) 2차원 배열 = “배열의 배열”(ragged 가능)
     *    - int[][] m = new int[3][];
     *      m[0] = new int[]{1,2};
     *      m[1] = new int[]{3,4,5};  // 각 행의 길이가 달라도 됨
     *    - 순회할 때는 항상 m[i]가 null이 아닌지, m[i].length를 확인
     *
     * 4) 기본값과 예외
     *    - 기본형 배열의 기본값: 0/0.0/false
     *    - 참조형 배열의 기본값: null
     *    - ArrayIndexOutOfBoundsException: 유효 인덱스는 0..length-1
     *    - NPE: 참조형 요소가 null인 상태에서 사용하면 발생
     *
     * 5) 길이는 불변, “크기 변경”은 복사로
     *    - 생성 후 배열 길이는 변경 불가
     *    - 확장/축소: Arrays.copyOf, System.arraycopy 사용 또는 ArrayList로 전환
     *
     * 6) 비교/출력은 Arrays 유틸 사용
     *    - equals는 참조 비교(내용 비교 아님)
     *      → 1차원 내용 비교: Arrays.equals(a, b)
     *      → 다차원 내용 비교: Arrays.deepEquals(x, y)
     *    - toString도 주소 비슷하게 보임
     *      → 1차원 출력: Arrays.toString(a)
     *      → 다차원 출력: Arrays.deepToString(x)
     *
     * 7) 순회 패턴
     *    - 전통 for: 인덱스가 필요할 때
     *      for (int i = 0; i < arr.length; i++) { ... }
     *    - for-each: 값만 필요할 때(널 요소 주의)
     *      for (int v : arr) { ... }
     *    - 평균 계산 예: Arrays.stream(arr).average().orElse(0)
     *
     * 8) 공변성/형 안전성 주의
     *    - 배열은 “공변”: String[]는 Object[]에 대입 가능하지만,
     *      런타임에 잘못된 저장 시 ArrayStoreException 발생
     *      Object[] o = new String[1]; o[0] = 1; // 예외
     *    - 제네릭 List는 불공변(List<String> ≠ List<Object>) → 형 안전성 더 높음
     *
     * 9) 복사 시 얕은/깊은 복사
     *    - arr.clone()은 1차원에선 내용 복사처럼 보이나,
     *      2차원 이상에선 ‘행 참조’만 복사되는 얕은 복사
     *      → 깊은 복사 필요 시 각 행을 개별적으로 copy
     *
     * 10) 선택 기준(배열 vs 컬렉션)
     *    - 고정 길이/원시형 대량/성능 민감: 배열 선호
     *    - 크기 가변/추가·삭제/유연성: List/Map 등 컬렉션 사용
     *
     * 이 파일에서는:
     *  - gradeHeights는 인스턴스 필드(int[][])로 선언되고 setData()에서 각 행을 new로 할당(가변 2차원)
     *  - printHeights/printAverage는 행별 length를 사용해 안전하게 순회
     */
    /** 정리해 봅시다
     *  1. 배열을 선언할 때 어떤 기호를 변수명의 앞이나 뒤에 사용해야 하나요?
     *      []
     *  2. 배열의 첫번째 위치는 0인가요? 1인가요?
     *      0
     *  3. 배열을 선언할 때 boolean 배열의 크기만 지정했다면 boolean 배열의 [0] 위치에 있는 값은 무엇인가요?
     *      false
     *  4. ArrayIndexOutOfBoundsException 이라는 것은 언제 발생하나요?
     *      0 이상 length 미만 범위를 벗어난 인덱스를 접근할 때 발생
     *  5. 중괄호를 이용하여 배열을 초기화 할 때 중괄호 끝에 반드시 어떤 것을 입력해 주어야 하나요?
     *      ;
     *  6. 2차원 배열을 정의할 때에는 대괄호를 몇 개 지정해야 하나요?
     *      2개
     *  7. 배열을 쉽게 처리해주는 for 문의 문법은 어떻게 되나요?
     *      for-each
     *      for (타입 변수명 : 배열) { ... }
     *  8. 자바 프로그램에 데이터를 전달해 주려면 클래스 이름 뒤에 어떻게 구분하여 나열하면 되나요?
     *      “자바 프로그램에 데이터를 전달한다”
     *          = main() 실행할 때 외부에서 값을 넘긴다는 의미 == String[] args의 값을 채워주는 방법
     *      터미널(명령 프롬프트)에서 클래스 이름 뒤에 공백으로 구분된 문자열을 나열
     *      (예: java MyClass arg1 arg2 arg3...)
     *  9. 자바 프로그램이 시작할 때 전달 받는 내용은 어떤 타입의 배열인가요?
     *      String args[]
     */
    public static void main(String[] args) {
        ManageHeight manageHeight = new ManageHeight();
        manageHeight.setData();
        for (int i = 0; i < 5; i++) {
//            manageHeight.printHeights(i);
            manageHeight.printAverage(i);
        }
    }

    int[][] gradeHeights;

    public void setData () {
        gradeHeights = new int[5][];
        gradeHeights[0] = new int[] {170, 180, 173, 175, 177};
        gradeHeights[1] = new int[] {160, 165, 167, 186};
        gradeHeights[2] = new int[] {158, 177, 187, 176};
        gradeHeights[3] = new int[] {173, 182, 181};
        gradeHeights[4] = new int[] {170, 180, 165, 177, 172};
    }
    public void printHeights (int classNo) {
        System.out.println("Class No: " + (classNo + 1));
        for (int i = 0; i < gradeHeights[classNo].length; i++) {
            System.out.println(gradeHeights[classNo][i]);
        }
    }
    public void printAverage (int classNo) {
        System.out.println("Class No: " + (classNo + 1));
        double sum = 0;
        int count = gradeHeights[classNo].length;
        for (int height : gradeHeights[classNo]) {
            sum += height;
        }
        System.out.println("Average Height: " + sum / count);
    }
}
