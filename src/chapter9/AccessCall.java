package chapter9;

import chapter9.c.javapackage.sub.AccessModifier;

public class AccessCall {
    public static void main(String[] args) {
        AccessModifier accessModifier = new AccessModifier();
        accessModifier.publicMethod();
        // 컴파일 오류 발생: 호출부가 동일한 패키지가 아님
//        accessModifier.protectedMethod();
//        accessModifier.packagePrivateMethod();
//        accessModifier.privateMethod();
    }
}
