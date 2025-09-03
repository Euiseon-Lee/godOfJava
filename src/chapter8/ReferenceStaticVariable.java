package chapter8;

public class ReferenceStaticVariable {
    static String name;
    public ReferenceStaticVariable() {}
    public ReferenceStaticVariable(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        ReferenceStaticVariable ref = new ReferenceStaticVariable();
        ref.checkName();
    }
    public void checkName() {
        ReferenceStaticVariable ref1 = new ReferenceStaticVariable("Euiseon");
        System.out.println(ref1.name);      // Euiseon

        ReferenceStaticVariable ref2 = new ReferenceStaticVariable("Zzocho");
        System.out.println(ref1.name);      // Zzocho
    }
}
