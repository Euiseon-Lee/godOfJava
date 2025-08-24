package chapter4;

public class PrimitiveTypes {
    /** 기본 자료형의 기본 값
     *  변수 타입 4개: 지역변수 매개변수 인스턴스변수 클래스변수
     * - 지역변수(local): 메서드/블록 내부. 기본값 없음 → 사용 전 반드시 초기화(컴파일 에러 방지).
     * - 매개변수(parameter): 호출 시 값이 전달되므로 '기본값' 개념 없음(항상 초기화된 상태로 시작).
     * - 인스턴스 변수(field): 객체 필드. 기본값 자동 초기화(int=0, boolean=false, 참조=null 등).
     * - 클래스 변수(static field): static 필드. 기본값 자동 초기화.
     *
     */
    int intDefault1;
    public void defaultValues() {
        int intDefault2;
        System.out.println("intDefault1 = " + intDefault1);     // 0 출력
        //System.out.println("intDefault2 = " + intDefault2);     // 지역변수는 기본 값 할당 없이 사용하면 오류 발생
    }
    public static void main (String[] args) {
        PrimitiveTypes types = new PrimitiveTypes();
        types.defaultValues();
        types.checkByte();
        types.checkChar();
    }
    public void checkByte() {
        byte byteMin = -128;
        byte byteMax = 127;
        System.out.println("byteMin = " + byteMin);
        System.out.println("byteMax = " + byteMax);

        byteMin = (byte) (byteMin - 1);
        byteMax = (byte) (byteMax + 1);
        System.out.println("byteMin - 1 = " + byteMin);     // 127 (최댓값) == [ 01111111 ]
        System.out.println("byteMax + 1 = " + byteMax);     // -128 (최솟값) == [ 10000000 ]
    }
    public void checkOtherTypes() {
        short shortMax = 32767;         // Short.MAX_VALUE;
        int intMax = 2147483647;        // Integer.MAX_VALUE;
        long  longMax = 9223372036854775807L;   // 반드시 숫자 끝에 L 표기 필요

        // float(4byte)와 double(8byte)은 소수점 값을 처리
        // 간단한 계산에서는 사용하나 돈 계산 등에서는 해당 자료형 대신 "BigDecimal" 클래스 사용 권장 (new BigDecimal("0.1") 처럼 문자열 생성자 사용)
        // 이유: float와 double은 제공 범위를 넘으면 그 값의 정확성을 보장하지 않음 (이진 부동소수 오차 존재 → 0.1, 0.01 등 정확히 표현 불가)
    }
    public void checkChar() {
        // char는 2byte 정수형 (0 ~ 65535) ==> 이 범위를 BMP(Basic Multilingual Plane, 기본 다국어 평면)이라 지칭
        // ==> int로 형변환이 가능
        // 모양은 홑따옴표 안에 유니코드 이스케이프 형태로 적는다 ==> \\uXXXX (16진수 4자리)
        // 문자 자체라기 보다는 UTF-16 코드 유닛 하나를 표현 (BMP 범위 내 char 1개로 표현 가능)
        // 이모지, 고대문자 등은 BMP 밖에 있어서 char 2개가 필요 == 서로게이트 페어
        char charMin = '\u0000';
        char charMax = '\uffff';
        System.out.println("charMin = [" + charMin + "]");      // 공백 출력
        System.out.println("charMax = [" + charMax + "]");      // ? 출력 (환경/폰트마다 다르게 보임)

        int intValue = 'a';
        System.out.println("intValue = [" + intValue + "]");    // 97 출력 (ASCII)

        char c = '가';       // 유니코드 코드포인트 U+AC00 (10진수 44032) == BMP 범위 안에 있어서 char 1개로 표현 가능
        
        // 서로게이트 페어
        String emoji = "😀"; // U+1F600
        System.out.println("emoji length = " + emoji.length());                                 // 2 (char 단위)
        System.out.println("emoji codePoints = " + emoji.codePointCount(0, emoji.length()));    // 1 (실제 문자 1개)

    }
    public void checkBoolean() {
        // boolean의 기본 값은 false
        boolean flag = true;
        System.out.println(flag);
        flag = false;
        System.out.println(flag);
    }

}
