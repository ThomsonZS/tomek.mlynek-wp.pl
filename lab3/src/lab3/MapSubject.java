package lab3;

import java.util.HashMap;


public class MapSubject {
    private java.util.Map<String, Teacher> przedmioty = new HashMap<>();
    private String name;

    public MapSubject(String name){
        this.name = name;
    }

    public void addTeacher(Teacher t){
        przedmioty.put(t.getCourseName(), t);
    }

    public Teacher getTeacher(String przedmiot){
        for(String subject : przedmioty.keySet()){
            Teacher teacher = przedmioty.get(subject);
            if(subject == przedmiot){
                return teacher;
            }
            //System.out.println(przedmiot + " " + teacher.getFirstName() + " " + teacher.getLastName());
        }
        return null;
    }

}