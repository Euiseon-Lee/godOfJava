package chapter8;

public class ReferenceConstructor {
    public static void main(String[] args) {
        ReferenceConstructor referenceConstructor = new ReferenceConstructor();
        referenceConstructor.makeMemberObject();
    }

    public void makeMemberObject() {
        MemberDTO dto1 = new MemberDTO();
        MemberDTO dto2 = new MemberDTO("Euiseon");
        MemberDTO dto3 = new MemberDTO("Euiseon", "01000000000");
        MemberDTO dto4 = new MemberDTO("Euiseon", "01000000000", "inia8inia@gmail.com");
    }
}
