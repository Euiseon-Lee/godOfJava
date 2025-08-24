package chapter3;

public class Profile {
    /*
     * 1. 클래스와 객체의 차이점을 말해 주세요.
     *      > 클래스는 객체의 상태와 행동을 나타내는 설계도. 객체(인스턴스)는 실제 사물을 나타내는 것이며 클래스로 객체를 생성.
     * 2. 객체를 생성하기 위해서 꼭 사용해야 하는 예약어?
            > new / new 말고도 리플렉션(Class.forName(), newInstance()) 같은 방법도 존재
     * 3. 객체를 생성하기 위해서 사용하는 메소드 같이 생긴 클래스 이름에 소괄호가 있는 것을 뭐라고 하나요?
     *      > 생성자. 매개변수 없는 생성자는 "기본 생성자"이며, 이 경우 따로 작성하지 않아도 javac 실행 시 자동으로 추가됨.
     * 4. 객체의 메소드를 사용하려면 어떤 기호를 객체 이름과 메소드 이름 사이에 넣어주어야 하나요?.
     *      > "." p.setName("John");
     * 5. 여러분들이 메소드를 사용하기 위해서는 어떤 것을 만들어야 하나요?
     *      > 객체 / static 메소드는 객체 없이도 사용할 수 있다
     * 6. 5번 문제에서 만들어야 하는 것은 어떤 예약어를 사용하고, 클래스의 무엇을 사용해야 하나요?
     *      > new, 생성자
     */
    public static void main (String[] args) {
        Profile p = new Profile();
        p.setName("Min");
        p.setAge(20);
        p.printName();
        p.printAge();
    }
    private String name;
    private int age;
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int val) {
        this.age = val;
    }
    public void printName() {
        System.out.println("My name is " + name);
    }
    public void printAge() {
        System.out.println("My age is " + age);
    }
}
