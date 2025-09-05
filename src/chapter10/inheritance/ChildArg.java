package chapter10.inheritance;

public class ChildArg extends ParentArg {
    // 부모 클래스에 매개 변수가 없는 기본 생성자가 없는 경우 해결책
    // 1. 부모 클래스에 매개 변수가 없는 기본 생성자를 만든다
    // 2. 자식 클래스에서 부모 클래스의 생성자를 명시적으로 지정하는 "super()" 사용
    public ChildArg() {
        /** Q. ChildArg 클래스에서 String을 받는 생성자를 만들면 알아서 String을 매개 변수로 하는 부모 클래스의 생성자를 호출하지 않을까?
         *  A. 자바는 부모의 매개 변수가 없는 기본 생성자를 찾는 것이 Default
         *     그래서 부모의 기본 생성자가 없는 경우 반드시 super()를 사용해서 부모 생성자를 반드시 호출해야 한다.
         *  +) 부모 클래스의 생성자를 호출하는 super()는 반드시 자식 클래스의 생성자에서 가장 첫 줄에 나와야 한다.
         */
        super("ChildArg");
//        super(null);              // reference to ParentArg is ambiguous
        System.out.println("ChildArg Constructor");
    }
}
