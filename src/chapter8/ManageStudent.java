package chapter8;

public class ManageStudent {
    public static void main(String[] args) {
        ManageStudent manageStudent = new ManageStudent();
        Student[] student = null;
        student = manageStudent.addStudents();
        manageStudent.printStudents(student);
    }

    public Student[] addStudents() {
        Student[] students = new Student[3];
        students[0] = new Student("Lim");
        students[1] = new Student("Min");
        students[2] = new Student("Sook", "Seoul", "01000000000", "ask@godofjava.com");
        return students;
    }

    public void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
