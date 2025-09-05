package chapter10.inheritance;

public class InheritanceOverriding {
    public static void main(String[] args) {
        /** 실행 결과
         * ParentOverriding() constructor
         * ChildOverriding() constructor
         * printName() - ChildOverriding        <- 자식 클래스의 메서드가 실행됨
         *
         * ✅ 부모 클래스에 선언되어 있는 메서드와 동일하게 자식 클래스의 메서드를 선언하면 자식 클래스의 메서드만 수행된다.
         */
        ChildOverriding child = new ChildOverriding();
        child.printName();
    }
}
