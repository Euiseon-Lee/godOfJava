package chapter4;

public class ProfilePrint {
    /** 정리해 봅시다.
     * 1. 네 가지 종류의 변수 구분
     *      지역 변수 : 중괄호 내에 선언되는 변수이며 기본형의 경우 반드시 기본 값 지정(초기화) 필요
     *      매개 변수 : 메서드로 전달되는 변수
     *      인스턴스 변수 : 클래스 내, 메서드 밖에 존재하며 static으로 선언되지 않은 변수
     *      클래스 변수 : 클래스 내, 메서드 밖에 존재하며 static으로 선언된 변수
     *
     * 2. 변수의 이름을 지을 때 대문자로 시작해도 되나요?
     *      가능하지만 자바 컨벤션 참고 필요
     *          클래스/인터페이스: UpperCamelCase
     *          변수/메서드: lowerCamelCase
     *          상수(static final): UPPER_SNAKE_CASE
     *
     * 3. 자료형에는 기본 자료형과 어떤 자료형이?
     *      참조형 (Reference)
     *
     * 4. 기본 자료형에는 몇 가지가 있나요?
     *      8개 (byte, short, int, long, float, double, char, boolean)
     *
     * 5. 기본 자료형 중 정수형에는 어떤 것들이 있나요?
     *      byte, short(2B), int(4B), long (8B)
     *
     * 6. byte는 몇 비트인가요?
     *      8bit (부호 비트 1개와 값 비트 7개), -128 ~ 127
     *
     * 7. byte는 왜 만들었을까요?
     *      파일/네트워크에서 "날 것의 데이터"를 다루는 표준 단위 (0과 1의 바이트 스트림으로 구성)
     *          예) 이미지 파일, 음악 파일, 패킷 데이터 → 전부 byte[]로 다룸.
     *          InputStream/OutputStream 계열 API가 byte[] 기반임.
     *      메모리 절약
     *          int는 4바이트라서 배열 100만 개 만들면 4MB.
     *          같은 값을 byte 배열로 하면 1MB만 차지 → 임베디드, IoT, 메모리 제약 환경에 유리.
     *      코드 의미 명확화
     *          타입이 byte로 선언돼 있으면 "이 값은 1바이트 단위"라는 걸 코드에서 바로 알 수 있음
     *
     * 8. int와 long 중 어떤 타입이 더 큰 숫자를 처리할 수 있나요?
     *      long
     *
     * 9. 소수점을 처리하는 타입은 어떤 것이 있나요?
     *      float(4B), double(8B)
     *
     * 10. char는 정수형인가요?
     *      네, int 값으로 변환이 가능 (2B), 범위는 0 ~ 65535
     *
     * 11. a라는 것을 char로 정의할 때 어떤 기호로 감싸주어야 하나요?
     *      홑따옴표('a'), 또는 유니코드 이스케이프('\\u0061')
     *
     * 12. true와 false 두 개의 값만을 가지는 타입은 어떤 것인가요?
     *      boolean
     */
    private byte age;
    private String name;
    private boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public byte getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public boolean isMarried() {
        return isMarried;
    }

    public static void main(String[] args) {
        ProfilePrint p = new ProfilePrint();
        p.setAge((byte) 35);
        p.setName("Euiseon");
        p.setMarried(false);

        System.out.println(p.getAge());
        System.out.println(p.getName());
        System.out.println(p.isMarried());
    }
}
