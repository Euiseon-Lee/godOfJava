package chapter10.inheritance;

public class ChildCasting extends ParentCasting {
    public ChildCasting() {}
    public ChildCasting(String name) {}
    public void printName() {
        System.out.println("printName() - ChildCasting");
    }
    public void printAge() {
        System.out.println("printAge() - 18 month");
    }

    public static void main(String[] args) {
        /** 업캐스팅과 다운캐스팅
         *  - 업캐스팅: “자식은 곧 부모다(Child is-a Parent)”가 성립하므로 자동(암시적) 허용
         *  - 다운캐스팅: 다운캐스팅은 항상 위험할 수 있으니 명시적 캐스트가 필요하고, 런타임에 실제 객체가 그 타입이어야만 성공
         *  캐스트는 객체를 바꾸지 않고 변수의 정적 타입(“관점”)만 바꾼다.
         *
         * 정적 타입(Static Type): 변수 선언부에 적힌 타입, 컴파일러가 기준으로 삼아서 접근 가능한 멤버(필드, 메서드) 를 제한.
         * 런타임 타입(Runtime Type): 실제 new로 생성된 객체 타입, JVM은 메서드 호출할 때 이 타입 기준으로 동적 디스패치(오버라이딩 메서드 실행)
         * 자바는 정적 타입 언어라서, 정적 타입을 기준으로 컴파일 시점 검사를 먼저 하고, 실제 실행은 런타임 타입에 따라 동작한다.
         */

        ParentCasting p = new ChildCasting();           // 업캐스팅(Upcasting) — 암시적 OK
//        ChildCasting child = new ParentCasting();     // 불가능! > 부모 타입의 객체를 자식 타입 변수에 대입할 수 없어서

        ParentCasting p1 = p;                           // 같은 참조 복사(여전히 ChildCasting 인스턴스)
        ChildCasting child = (ChildCasting) p1;         // 다운캐스팅(Downcasting) — 명시적 캐스트 필요
    }
}
