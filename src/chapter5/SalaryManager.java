package chapter5;

public class SalaryManager {
    /** 직접해 봅시다.
     *
     * 1. 값을 할당할 때 사용하는 연산자의 기호는 무엇인가요?
     *      대입 연산자 (=)
     *
     * 2. 기본적인 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지를 계산할 때 사용하는 연산자의 기호는 무엇인가요?
     *      +, -, *, /, %
     *
     * 3. +=는 무엇을 할 때 사용하는 연산자인가요?
     *      +=는 기존 변수에 저장되어 있던 값과 += 뒤에 오는 값을 더해서 변수에 저장
     *
     * 4. 여러분들이 연산의 순서를 모르거나 확실히 하고 싶을 때에는 어떤 기호를 사용해야 하나요?
     *      괄호
     *
     * 5. ==와 !=의 차이는 무엇인가요?
     *      == 는 같다, !=는 같지 않다.
     *
     * 6. <와 <=의 차이는 무엇인가요?
     *      A < B는 A가 B보다 작다. A <= B는 A가 B보다 작거나 같다.
     *
     * 7. ! 연산자는 어떤 타입에 사용할 수 있나요?
     *      boolean
     *
     * 8. ? :로 표시하는 삼항 연산자의 ?와 : 뒤에 명시해 주는 값은 무엇을 의미하나요?
     *      조건 ? 값1(조건이 true일 때) : 값2(조건이 false일 때)
     *
     * 9. 자바는 형 변환을 한다고 했는데, short의 값을 long에 할당할 때에는 어떤 것을 해 주어야 하나요?
     *      아무 것도 할 필요 없음 (long이 short 보다 비트가 더 크기 때문에 자동 형변환 발생)
     *
     * 10. 반대로 long 값을 short에 할당할 때에는 어떤 것을 해 주어야 하나요?
     *      (short) 라는 명시적 형변환이 필요
     *
     * 11. 9와 10의 경우 중 어떤 경우가 기존 값이 사라지고, 엉뚱한 값으로 바뀔 수 있나요?
     *      long 값을 short에 할당 할 때 엉뚱한 값이 들어갈 수 있다. 그 이유는 short는 2byte, long은 8byte라 하위 16비트만 남고, 상위 비트는 잘려서 데이터 손실 발생.
     *
     */
    private static final double TAX_RATE = 0.125;
    private static final double NP_RATE  = 0.081;
    private static final double HI_RATE  = 0.135;

    public static void main(String[] args) {
        SalaryManager salaryManager = new SalaryManager();
        System.out.println(salaryManager.getMonthlySalary(20000000));
    }

    public double getMonthlySalary(int yearlySalary) {
        double monthlySalary = yearlySalary / 12.0;         // yearlySalary가 int, 12.0이 double이니까 자동으로 double 연산 >> 자동 형변환
        double tax   = calculateTax(monthlySalary);
        double np    = calculateNationalPension(monthlySalary);
        double hi    = calculateHealthInsurance(monthlySalary);

        return monthlySalary - (tax + np + hi);
    }

    public double calculateTax(double monthlySalary) {
        double workTax  = monthlySalary * TAX_RATE;
        System.out.println("근로 소득세 = " + workTax);
        return workTax;
    }

    public double calculateNationalPension(double monthlySalary) {
        double pension = monthlySalary * NP_RATE;
        System.out.println("국민 연금 = " + pension);
        return pension;
    }

    public double calculateHealthInsurance(double monthlySalary) {
        double healthInsurance = monthlySalary * HI_RATE;
        System.out.println("건강 보험료 = " + healthInsurance);
        return healthInsurance;
    }
}