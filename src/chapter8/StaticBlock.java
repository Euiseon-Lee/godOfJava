package chapter8;

public class StaticBlock {
    static int data = 1;
    public StaticBlock() {
        System.out.println("StaticBlock Constructor");
    }

    /** static block
     *  - 클래스가 JVM에 "처음 로드될 때" 단 한 번 실행되는 초기화 블록.
     *  - 생성자보다 먼저 실행되며, 주로 static 필드 초기화나 필수 준비 작업에 사용된다.
     *  - 여러 개 선언하면 작성한 순서대로 실행된다.
     *
     *  주의:
     *  - static 블록은 인스턴스 멤버에는 직접 접근할 수 없다.
     *    (객체를 생성한 후라야 인스턴스 필드를 사용할 수 있음)
     *  - 모든 객체가 공유하는 static 변수는 인스턴스를 통해서도 접근 가능하지만,
     *    결국 하나의 저장 공간만 존재한다.
     */
    static {
        System.out.println("*** First static block ***");
        data = 3;
    }
    static {
        System.out.println("*** Second static block ***");
        data = 5;
    }

    public static int getData() {
        return data;
    }
}
