package chapter8;

public class ReferenceOverloading {
    public static void main(String[] args) {}

    /** Overloading (오버로딩)
     *  - 같은 이름의 메서드를 "매개변수 목록"이 다르게 선언하는 것.
     *    (매개변수의 타입, 개수, 순서 중 하나라도 다르면 다른 메서드로 인식)
     *  - 리턴 타입만 다른 것은 오버로딩이 아니다.  ← 중요!
     *  - 오토박싱/가변인자/형변환이 겹치면 호출이 모호해져 컴파일 에러가 날 수 있다.
     *
     *  왜 필요한가?
     *  - 같은 역할(의미)의 연산에 같은 이름을 쓰되, 입력 형태만 달리 받고 싶을 때 가독성과 사용성이 좋아진다.
     *
     *  참고) 오버로딩 vs 오버라이딩
     *  - 오버로딩: 같은 클래스 안에서 파라미터 목록을 바꿔 "정의"를 여러 개.
     *  - 오버라이딩: 상속 관계에서 부모 메서드와 "시그니처 동일"하게 "재정의".
     */
    public void print(int data) {}
    public void print(String data) {}
    public void print(int intData, String stringData) {}
    public void print(String stringData, int intData) {}
}
