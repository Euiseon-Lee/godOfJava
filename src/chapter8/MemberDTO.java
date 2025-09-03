package chapter8;

public class MemberDTO {

    /** 자바 패턴 중 DTO(Data Transfer Object)
     *  - 계층/네트워크 사이에서 데이터 "전송"을 위한 단순한 그릇(주로 가변).
     *  - 많은 인자를 다루면 생성자 오버로딩 대신 빌더/정적 팩터리/record 고려.
     *
     *  1. record (Java 16+)
     *  자동으로 불변 객체 + Getter + equals/hashCode 만들어 줌.
     *  장점: 간결, 불변, equals/hashCode 자동.
     *  단점: Setter 없음(값 변경 불가) → 전송용보다는 VO에 가깝다.
     *
     *  2. 빌더 패턴
     *  많은 필드를 선택적으로 넣을 때 유용.
     *  MemberDTO dto = new MemberDTO.Builder()
     *     .name("의선")
     *     .phone("010-1234-5678")
     *     .build();
     *
     *  - VO(Value Object)는 값 동등성과 불변성에 초점을 둔다(개념상 구분).
     */
    private String name;
    private String phone;
    private String email;

    //생성자1 - 아무 정보도 모를 때
    public MemberDTO() {}

    //생성자2 - 이름만 알 때
    public MemberDTO(String name) {
        this.name = name;
    }

    //생성자3 - 이름과 전화번호만 알 때
    public MemberDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    //생성자4 - 모든 정보를 알고 있을 때
    public MemberDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public MemberDTO getMemberDTO() {
        /** DTO를 만들 때의 장점
         *  자바의 메서드의 리턴 타입은 한 가지만 선정 가능
         *  복합적인 데이터를 리턴할 시 객체 자체를 리턴하도록 할 수 있음
         */
        MemberDTO dto = new MemberDTO();
        // 중간 생략
        return dto;
    }

}
