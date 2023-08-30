public class Student {
    //instance variables
    private String FN;
    private String LN;
    private int ID;
    private double GPA;
    private int total_credits;
    static int next_ID = 1;

    //next id method
    public static int getNextID() {
        int new_ID = next_ID;
        next_ID++;
        return new_ID;
    }
    //Student constructor
    public Student(String fname, String lname){
        this.FN = fname;
        this.LN = lname;
        this.total_credits = 0;
        this.GPA = 0;
        this.ID = getNextID();
    }
    //add course method
    public void addCourse(int num_credits, String grade){
        double class_gpa = 0.0;
        if(grade.equals("A")){
            class_gpa = 4.0;
        } else if(grade.equals("A-")){
            class_gpa = 3.7;
        } else if(grade.equals("B+")){
            class_gpa = 3.3;
        } else if(grade.equals("B")){
            class_gpa = 3.0;
        } else if(grade.equals("B-")){
            class_gpa = 2.7;
        } else if(grade.equals("C+")){
            class_gpa = 2.3;
        } else if(grade.equals("C")){
            class_gpa = 2.0;
        } else if(grade.equals("C-")){
            class_gpa = 1.7;
        } else if(grade.equals("D+")){
            class_gpa = 1.3;
        } else if(grade.equals("D")){
            class_gpa = 1.0;
        } else if(grade.equals("F")){
            class_gpa = 0.0;
        } else {
            class_gpa = 0.0;
        }
        double new_gpa_top = (GPA * total_credits) + (class_gpa * num_credits);
        double new_gpa_bottom = (total_credits + num_credits);
        GPA = new_gpa_top / new_gpa_bottom;
        total_credits += num_credits;
    }
    //report method
    public void report(){
        System.out.print(FN + " " + LN + " -");
        System.out.print(" Student ID: " + ID);
        System.out.printf(" GPA: " + "%.2f" , GPA);
        System.out.println(" Total credits: " + total_credits);
    }

    //can graduate method
    public boolean canGraduate(){
        if(total_credits >= 120 && GPA >= 2.0){
            return true;
        } else {
            return false;
        }
    }
}
