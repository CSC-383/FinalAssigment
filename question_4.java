package finalassignment;

class CSC383Student {

    int ID;

    String name, Gender, grade;
    double FinalExamMark, MidExamMark, TermExamMark, AssignmentMark, AttendanceMark, TotalMark;

    public CSC383Student(int ID, String name, String Gender, double MidExamMark, double TermExamMark, double AssignmentMark, double AttendanceMark) {
        this.ID = ID;
        this.name = name;
        this.Gender = Gender;
        this.MidExamMark = MidExamMark;
        this.TermExamMark = TermExamMark;
        this.AssignmentMark = AssignmentMark;
        this.AttendanceMark = AttendanceMark;

    }

    double ComputeFinalMarks() {
        FinalExamMark = 90;

        TotalMark = (.3 * FinalExamMark + 0.25 * MidExamMark + 0.25 * TermExamMark + 0.15 * AssignmentMark + 0.05 * AttendanceMark);
        System.out.println("Student's information: ");
        System.out.println("\t ID : " + ID);
        System.out.println("\t Name : " + name);
        System.out.println(" \tGender : " + Gender);

        return TotalMark;
    }

    void ComputeFinalGrade() {
        double marks = TotalMark;

        if (marks >= 90 && marks <= 100) {
            grade = "A";
        } else if (marks >= 87 && marks <= 89) {
            grade = "B+";
        } else if (marks >= 84 && marks <= 86) {
            grade = "B";
        } else if (marks >= 81 && marks <= 83) {
            grade = "B-";
        } else if (marks >= 75 && marks <= 80) {
            grade = "C+";
        } else if (marks >= 70 && marks <= 76) {
            grade = "C";
        } else if (marks >= 65 && marks <= 69) {
            grade = "C-";
        } else if (marks >= 60 && marks <= 64) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println(" \tGrade : " + grade);
    }
}

class test {

    public static void main(String[] args) {
        CSC383Student obj = new CSC383Student(19103094, "Rakibul Hasan", "Male", 100.0, 100.0, 90.0, 100.0);
        System.out.println(" \tTotal mark : " + obj.ComputeFinalMarks());
        obj.ComputeFinalGrade();
    }
}
