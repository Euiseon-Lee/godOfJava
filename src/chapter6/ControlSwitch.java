package chapter6;

public class ControlSwitch {
    public static void main(String[] args) {
        ControlSwitch exam = new ControlSwitch();
        exam.switchStatement(1);
        exam.switchStatement(2);
        exam.switchStatement(3);
        exam.switchStatement(4);
        exam.switchStatement(5);
        exam.switchStatement(6);

    }

    public void switchStatement(int numberOfWheel) {
        switch (numberOfWheel) {
        case 1:
            System.out.println(numberOfWheel+":It is one foot bicycle.");
            break;
        case 2:
            System.out.println(numberOfWheel+":It is motor cycle or bicycle.");
            break;
        case 3:
            System.out.println(numberOfWheel+":It is a three wheel car.");
            break;
        case 4:
            System.out.println(numberOfWheel+":It is a car.");
            break;
        default:
            System.out.println(numberOfWheel+":It is an expensive car.");
            break;
        }
    }

    public void switchCalender(int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + " has 31 days.");
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + " has 30 days.");
                break;

            case 2:
                System.out.println(month + " has 28 or 29 days.");
                break;

            default:
                System.out.println(month + " is not a month.");
                break;
        }
    }
}
