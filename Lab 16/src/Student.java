/**
 * @author Patton Robertson
 * This class creates student objects, and allows the user to calculate GPA, add courses to the GPA, and check if a student is elgible to graduate
 */

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private double gpa;
    private int credits;
    private static int nextId = 1;

    /**
     * Create a student. This is the default constructor of a student object
     */

    public Student() {
        firstName = "";
        lastName = "";
        id = nextId;
        nextId++;
        gpa = 0.0;
        credits = 0;
    }

    /**
     *@param fname - This String is the student's first name
     * @param lname - This Sting is the student's last name
     * This is the non-default constructor for a student object
     */
    public Student(String fname, String lname) {
        firstName = fname;
        lastName = lname;
        id = nextId;
        nextId++;
        gpa = 0.0;
        credits = 0;
    }

    /**
     * Add a course grade to the student's GPA
     * @param creds - Integer for how many credits the course is
     * @param grade - String for the letter grade the student got in the class
     * @throws IllegalArgumentException - If the string given for grade is not plausible in a letter grade system
     */

    public void addCourse(int creds, String grade) throws IllegalArgumentException {
        double gradeGPA;
        if (grade.equals("A")) gradeGPA = 4.0;
        else if (grade.equals("A-")) gradeGPA = 3.7;
        else if (grade.equals("B+")) gradeGPA = 3.3;
        else if (grade.equals("B")) gradeGPA = 3.0;
        else if (grade.equals("B-")) gradeGPA = 2.7;
        else if (grade.equals("C+")) gradeGPA = 2.3;
        else if (grade.equals("C")) gradeGPA = 2.0;
        else if (grade.equals("C-")) gradeGPA = 1.7;
        else if (grade.equals("D+")) gradeGPA = 1.3;
        else if (grade.equals("D")) gradeGPA = 1.0;
        else if (grade.equals("F")) gradeGPA = 0.0;
        else throw new IllegalArgumentException();

        gpa = ((gpa * credits) + (gradeGPA * creds)) / (credits + creds);

        if (gradeGPA > 0) {
            credits += creds;
        }
    }

    /**
     * Prints out a report on the student - Their name, their student id, their GPA, and how many credits they have
     */

    public void report() {
        System.out.println(firstName + ", " + lastName + "\t" + id + "\t"
                + String.format("%.2f", gpa) + "\t" + credits);
    }

    /**
     * Calculates if a student has enough credits to graduate
     * @return true or false based on if the student can graduate
     */
    public boolean canGraduate() {
        return (credits >= 120) && (gpa >= 2.0);
    }


    /**
     * Calculates what year (F, S, J, S) a student is based on credits
     * @return a String of what grade a student is - Freshman, Sophomore, Junior, or Senior
     */
    public String getYear() {
        if (credits < 30) return "First year";
        else if (credits < 60) return "Sophomore";
        else if (credits < 90) return "Junior";
        else return "Senior";
    }
}

