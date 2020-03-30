package lab3;

public class Teacher extends Person {    
    private String courseName;
    
    public Teacher(String firstName, String lastName,/*zad nr 2 wymusilo dodanie tego:*/ String emailAdress, String courseName) {
        super(firstName, lastName, emailAdress);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }  
    
   
   
    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName() + ", " 
                + this.courseName + ", " + super.getEmailAddress();
    }
}
