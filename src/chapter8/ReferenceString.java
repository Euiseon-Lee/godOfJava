package chapter8;

public class ReferenceString {
    // 인스턴스 변수: 각 객체가 개별적으로 갖는 필드(= non-static)
    String instanceVariable;

    /** 생성자
     *  1. 만약 별도의 생성자가 없는 경우 매개변수가 없는 ReferenceString()는 컴파일할 때 기본으로 만들어짐 (기본 생성자)
     *  2. 다른 생성자가 있으면 기본 생성자는 자동으로 만들어 지지 않으므로 직접 생성 필요
     *
     *  생성자는 왜 필요하지?
     *  > 자바 클래스의 객체(또는 인스턴스)를 생성하기 위해서 존재
     *
     *  생성자는 리턴 타입을 선언하지 않는다.
     *  - 호출 결과로 해당 클래스의 인스턴스가 생성되어 참조가 반환되는 형태(암묵적).
     *  - 필요하면 this(...)로 다른 생성자를 호출해 초기화 로직을 공유할 수 있다.
     */
    public ReferenceString() {}
    public ReferenceString(String str) {}

    // 메서드 영역
    public static void main(String[] args) {
        ReferenceString referenceString = new ReferenceString();
    }

}
