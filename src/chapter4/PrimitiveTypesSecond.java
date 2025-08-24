package chapter4;

public class PrimitiveTypesSecond {
    // 인스턴스 필드 - Primitives
    int intDefault1;
    byte byteDefault;
    short shortDefault;
    long longDefault;
    float floatDefault;
    double doubleDefault;
    char charDefault;
    boolean booleanDefault;

    // 인스턴스 필드 - Reference
    String refDefaultField;

    // 클래스 변수 (static)
    static int staticDefault;

    public static void main(String[] args) {
        PrimitiveTypesSecond second = new PrimitiveTypesSecond();
        second.defaultValues();
    }
    public void defaultValues() {
        /* 출력되는 기본 값
            byteDefault = 0
            shortDefault = 0
            intDefault1 = 0
            longDefault = 0
            floatDefault = 0.0
            doubleDefault = 0.0
            charDefault =
            booleanDefault = false
         */
        System.out.println("byteDefault = " + byteDefault);
        System.out.println("shortDefault = " + shortDefault);
        System.out.println("intDefault1 = " + intDefault1);
        System.out.println("longDefault = " + longDefault);
        System.out.println("floatDefault = " + floatDefault);
        System.out.println("doubleDefault = " + doubleDefault);
        System.out.println("charDefault = " + charDefault);
        System.out.println("booleanDefault = " + booleanDefault);

        System.out.println("staticDefault = " + staticDefault);         // 0
        System.out.println("refDefaultField = " + refDefaultField);     // null
    }
}
