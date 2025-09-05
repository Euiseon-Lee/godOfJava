package chapter10.inheritance;

public class ChildOverriding extends ParentOverriding {
    public ChildOverriding(){
        System.out.println("ChildOverriding() constructor");
    }
    // 부모 클래스보다 접근 제어자의 범위가 좁아질 수 없음 (public > protected > void > private)
    public void printName(){
        // 부모 클래스에서 void 라고 선언되어 있어서
        // 부모 클래스를 Overriding한 메서드의 리턴 타입을 다르게 리턴하면 안 된다
        System.out.println("printName() - ChildOverriding");
    }
}
