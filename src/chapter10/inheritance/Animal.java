package chapter10.inheritance;

public class Animal {
    /** 정리해 봅시다
     * 1. 상속을 받는 클래스의 선언문에 사용하는 무엇인가요?
     *      extends
     *
     * 2. 상속을 받은 클래스의 생성자를 수행하면 부모의 생성자도 자동으로 수행되나요?
     *      자동으로 수행된다 (O)
     *      자식 생성자가 실행될 때 항상 super() (부모의 기본 생성자)가 묵시적으로 첫 줄에 삽입
     *      만약 부모 클래스에 매개변수 없는 생성자가 없으면, 자식에서 super(args...)를 직접 호출해야함
     *
     * 3. 부모 클래스의 생성자를 자식 클래스에서 직접 선택하려고 할 때 사용하는 예약어는 무엇인가요?
     *      super()
     *
     * 4. 메소드 Overriding과 Overloading을 정확하게 설명해 보세요.
     *      Overriding - 부모 메서드를 자식이 동일한 시그니처(이름, 매개변수, 리턴타입까지)로 재정의하여 확장함
 *                       실행 시점에는 런타임 타입(다형성) 기준으로 부모 클래스의 메서드는 무시되고 자식 클래스의 메서드가 실행
     *      Overloading - 매개변수의 개수나 타입을 다르게 해서 동일한 역할을 수행하는 메서드를 각기 다른 매개변수를 가질 수 있도록 만드는 것
     *                    컴파일 시점에 어떤 메서드를 쓸지 결정됨
     *
     * 5. A가 부모, B가 자식 클래스라면 A a = new B(); 형태로 객체 생성이 가능한가요?
     *      O (참조 자료형의 형변환, 업캐스팅(Upcasting), 자동 형변환)
     *
     * 6. 명시적으로 형 변환을 하기 전에 타입을 확인하려면 어떤 예약어를 사용해야 하나요?
     *      instanceOf
     *
     * 7. 6에서 사용한 예약어의 좌측에는 어떤 값이, 우측에는 어떤 값이 들어가나요?
     *      객체 / 클래스 타입
     *
     * 8. 6의 예약어의 수행 결과는 어떤 타입으로 제공되나요?
     *      boolean
     *
     * 9. Polymorphism이라는 것은 도대체 뭔가요?
     *      다형성: 하나의 참조 변수(부모 타입)가 여러 형태의 객체(자식 타입)를 참조할 수 있고, 호출되는 메서드가 실제 객체 타입에 따라 달라지는 성질
     */
    protected String name;
    protected String kind;
    protected int legCount;
    protected int iq;
    protected boolean hasWing;
    protected boolean hasVaccinated;

    protected void move() {
        System.out.println("Animal.move()");
    }
    protected void eat() {
        System.out.println("Animal.eat()");
    }
    protected void sleep() {
        System.out.println("Animal.sleep()");
    }
}
