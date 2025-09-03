package chapter8;

public class ReferencePass {
    public static void main(String[] args) {
        ReferencePass referencePass = new ReferencePass();
        // ⚠️ 주의: Java는 기본형/참조형 모두 pass-by-value다.
        // 여기서 'passByReference'라는 이름은 "참조값의 복사본을 넘기고, 같은 객체의 내부 상태를 변경"하는 데모일 뿐,
        // 언어 차원의 pass-by-reference(호출자 변수 자체를 바꾸는 전달 방식)는 아니다.
        /** referencePass.callPassByValue(); 실행 결과
         * Before passByValue
         * a = 10
         * b = b
         *
         * In passByValue
         * a = 20
         * b = ZZ
         *
         * After passByValue    >> 기존 값이 변경되지 않음!
         * a = 10
         * b = b
         *
         *
         * 왜 String(참조형)인데 바깥 b가 유지될까?
         *  - 자바는 항상 pass-by-value. 참조형도 "참조값의 복사본"이 매개변수로 전달된다.
         *  - 메서드 안에서 b = "ZZ"는 "로컬 b가 가리키는 대상"만 바꾸는 '재할당'일 뿐,
         *    바깥 변수 b가 가진 참조값은 변하지 않는다.
         *
         * String 불변성(immutable) 메모:
         *  - String은 내부 내용을 수정할 수 없어서 "변경"처럼 보이는 모든 연산이 새 객체를 만든다.
         *  - 그러나 바깥 b가 유지되는 핵심 이유는 '불변성'이 아니라 'pass-by-value'이다.
         *    (가변 객체여도 '재할당'은 외부에 전파되지 않음. 내부 상태 변경만 전파됨)
         *
         * 메모리 그림
         * [Heap]                     [Stack: callPassByValue]       [Stack: passByValue]
         * "b"  <── R1 ── b (outer)   a=10, b=R1                     a=10, b=R1' (R1의 복사)
         * "ZZ" <── R2                └─ passByValue(a,b) 호출 ──▶   b = R2 (재할당, 로컬만 변경)
         *
         * 참고: b = "ZZ" (리터럴 풀 참조) 과 b = new String("ZZ") (새 인스턴스)는
         *      생성 방식은 다르지만, 둘 다 '로컬 b'의 참조 재할당이라는 점에서 외부 b에는 영향이 없다.
         */
        referencePass.callPassByValue();
        System.out.println();
        System.out.println();

        /** referencePass.callPassByReference() 실행 결과
         * Before passByReference
         * member.name = Euiseon
         *
         * In passByReference
         * member.name = Zzocho
         *
         * After passByReference
         * member.name = Zzocho
         *
         * 왜 바깥에서 값이 바뀌어 보였나?
         *  - 매개변수 member는 참조값의 복사본을 받음 → 호출자와 같은 객체를 가리킴.
         *  - 그 객체의 필드 변경(member.name = "Zzocho")은 같은 객체의 상태를 바꾸기 때문에 호출자에서도 그대로 보임.
         *  - 반대로, 매개변수 member를 새 객체로 재할당하면(=다른 참조값으로 바꾸면) 호출자에 영향 없음.
         */
        referencePass.callPassByReference();

    }
    public void callPassByValue() {
        int a = 10;
        String b = "b";
        System.out.println("Before passByValue");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();
        passByValue(a, b);
        System.out.println();
        System.out.println("After passByValue");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    public void passByValue(int a, String b) {      // 매개변수 b는 R1을 복사받은 또 다른 변수(껍데기)
        a = 20;
        b = "ZZ";       // 리터럴 풀 참조(이미 있으면 재사용). 핵심: 로컬 b의 '재할당'이라 외부 b에는 영향 없음.
        System.out.println("In passByValue");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    public void callPassByReference() {
        MemberDTO member = new MemberDTO("Euiseon");
        System.out.println("Before passByReference");
        System.out.println("member.name = " + member.name);
        System.out.println();
        passByReference(member);
        System.out.println();
        System.out.println("After passByReference");
        System.out.println("member.name = " + member.name);


        // 👇 재할당은 전파 안 됨 증명
        /** 실행 결과
         * In reassign
         * member.name = Chanjoo
         * After reassign (should stay Zzocho)
         * member.name = Zzocho
         */
        System.out.println();
        System.out.println("---------");
        reassign(member);
        System.out.println("After reassign (should stay Zzocho)");
        System.out.println("member.name = " + member.name);
    }
    public void passByReference(MemberDTO member) {
        // 매개변수에 내부 변경 발생
        // member 매개변수는 호출자와 같은 객체를 보고 있으므로, 그 객체의 필드(name)를 바꾸면 힙에 있는 실제 객체가 수정됨.
        member.name = "Zzocho";
        System.out.println("In passByReference");
        System.out.println("member.name = " + member.name);
    }
    private void reassign(MemberDTO member) {
        // 참조 재할당 (호출자에는 영향 없음)
        // 새 객체 생성 + 매개변수 변수가 그 새 객체를 가리키게 함
        member = new MemberDTO("Chanjoo");
        System.out.println("In reassign");
        System.out.println("member.name = " + member.name);
    }
}
