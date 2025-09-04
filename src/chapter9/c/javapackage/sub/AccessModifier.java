package chapter9.c.javapackage.sub;

public class AccessModifier {
    /** 접근 제어자
     *  - public: 누구나 접근 가능
     *  - protected: 같은 패키지 내에 있거나 상속받은 경우에만 접근 가능
     *  - package-private: 같은 패키치 내에 있을 때만 접근 가능
     *  - private: 같은 최상위 클래스 내부(중첩 타입 포함)에서만 접근 가능
     *  !! 서브패키지는 같은 패키지가 아니다.  com.a ≠ com.a.b.
     *
     * ✅ 접근 제어자를 활용할 수 있는 범위
     *  1) 최상위 타입(클래스/인터페이스/enum/record): public 또는 (package-private) 만 가능
     *      → protected/private는 불가
     *
     *  2) 멤버(필드/메서드/생성자/중첩 타입): 네 가지 전부 가능 (public/protected/package-private/private)
     *
     *  - 특수 규칙
     *      0) 최상위(Top-level) 타입은 public 또는 (package-private) 만 가능. protected/private는 불가.
     *      1) 인터페이스 멤버
     *          필드: 암묵적으로 public static final
     *          메서드: 기본은 public abstract
     *          default/static(Java 8+), private/private static(Java 9+) 허용
     *      2) 오버라이드 시 가시성 축소 금지
     *          재정의 메서드는 가시성을 더 좁힐 수 없음(넓히는 건 가능)
     *          예) 부모 protected → 자식 public(가능), 자식 private(불가)
     *      3) 생성자
     *          private 생성자: 싱글턴, 정적 팩터리 전용, 인스턴스화 차단
     *          protected 생성자: 상속 전용
     *          public/package-private: 일반 공개/패키지 내부 전용
     *      4) 중첩 타입(Nested class)
     *          바깥 클래스의 private 멤버에도 접근 가능(컴파일러가 보조 접근자 생성)
     *      5)enum 생성자
     *          외부에서 new 불가. 일반적으로 private로만 둠(사실상 외부 호출 차단 목적)
     *  💥 베스트 프랙티스
     *
     * 1. 최소 공개 원칙
     *      처음엔 private로 시작 → 꼭 필요할 때만 범위를 넓혀라
     *      라이브러리 설계 시 내부 구현은 (package-private) 로 숨기고, 퍼사드만 public
     * 2. 필드는 private + 접근자
     *      캡슐화(유효성 검사, 불변 보장, 교체 용이)
     *      불변 객체라면 private final + 생성자/빌더로 값 설정
     * 3. protected는 신중히
     *      패키지 경계 넘어가면 의도치 않은 결합을 초래할 수 있음
     *      가능하면 상속 대신 조합(composition) + (package-private) 로 제어
     * 4. 오버라이드 가시성 주의
     *      인터페이스 구현 메서드는 반드시 public(안 그러면 컴파일 에러)
     * 5. 테스트 코드
     *      같은 패키지에 두면 (package-private) 로도 테스트 가능
     *      모듈 환경에서는 opens/exports 고려
     */
    public void publicMethod() {}
    protected void protectedMethod() {}
    void packagePrivateMethod() {}
    private void privateMethod() {}
}
