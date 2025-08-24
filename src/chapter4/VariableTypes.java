package chapter4;

public class VariableTypes {
    int instanceVariable;
    static int classVariable;
    public void method (int parameter) {
        int localVariable;
    }
    public void anotherMethod (int parameter) {
        if (true) {
            int localVariable;
            if (true) {
                int localVariable2;     // 중괄호 사이에는 동일한 이름의 지역변수를 선언할 수 없다.
            }
        }
        if (true) {
            int localVariable;
        }
    }
}
