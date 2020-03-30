package lab3;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String groupId;
    private List<Double> grades = new ArrayList<>();
    
    public Student(String firstName, String lastName,/*zad nr 2 wymusilo dodanie tego:*/ String emailAdress, String groupId) {
        super(firstName, lastName, emailAdress);
        this.groupId = groupId;
    }
    
    public Student(String firstName, String lastName) {
        super(firstName, lastName, "");
    }
    

    public String getStudent() {
       return super.getFirstName() +" "+ super.getLastName();
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public List<Double> getGrades() {
        return grades;
    }
    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    public double getGradesAverage() { // zadanie 3
        double average = 0; //deklaruje zmienną która będzie sumą wszystich ocen
        for(double grade : grades) { // iteruje po mojej tablicy ze wszystkimi ocenami
            average += grade; //każdy element z tablicy sumuję
        }
        return average/grades.size(); //zwracam średnia czyli suma ocen dzielona na ilość ocen
    }
}

