package chapter10.inheritance;

public class Inheritance {
    public static void main(String[] args) {
        /** 상속
         *  부모 클래스에서는 기본 생성자를 만들어 놓는 것 이외에는 상속을 위해서 추가 작업할 부분은 없음
         *  자식 클래스는 클래스 선언 시 extends 다음에 부모 클래스 이름을 적음
         *  자식 클래스의 생성자가 호출되면 자동으로 부모 클래스의 매개 변수 없는 생성자가 실행됨
         *  자식 클래스에서는 부모 클래스에 있는 public, protected로 선언된 모든 인스턴스 및 클래스 변수와 메서드를 사용할 수 있음
         */
        Child child = new Child();
        child.printName();
    }
}
