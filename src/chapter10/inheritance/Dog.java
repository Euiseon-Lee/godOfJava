package chapter10.inheritance;

public class Dog extends Animal {
    protected boolean livesYard;
    public void move() {
        System.out.println("Dog move()");
    }
    public void eat() {
        System.out.println("Dog.eat()");
    }
    public void sleep() {
        System.out.println("Dog.sleep()");
    }
}
