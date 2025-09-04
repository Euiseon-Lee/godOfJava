package chapter9.c.javapackage;

//java.lang 패키지 / 같은 패키지 외에는 전부 import 필요
//import static을 사용해서 static한 변수나 메서드를 지정하면 굳이 클래스 이름을 지정하지 않아도 마치 PackageStatic 클래스에 선언된 것처럼 사용 가능
//Q. 만약 Package 클래스에 import한 동일한 이름의 static 변수나 메서드가 자신의 클래스에 있다면?
//A. static 메서드나 변수가 중복되는 상황에서 자신의 클래스에 있는 static 변수나 메서드가 import static으로 가져온 것보다 우선시 된다.
import static chapter9.c.javapackage.sub.SubStatic.subStaticMethod;

public class PackageStaticImport {
    public static void main(String[] args) {
        subStaticMethod();
    }
}
