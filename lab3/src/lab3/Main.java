package lab3;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Set<String> zbiorDniH = new HashSet<>();
        Set<String> zbiorDniT = new TreeSet();

        zbiorDniH.add("poniedzialek");
        zbiorDniH.add("wtorek");
        zbiorDniH.add("sroda");
        zbiorDniH.add("czwartek");
        zbiorDniH.add("piatek");
        zbiorDniH.add("sobota");
        zbiorDniH.add("niedziela");

        zbiorDniT.add("poniedzialek");
        zbiorDniT.add("wtorek");
        zbiorDniT.add("sroda");
        zbiorDniT.add("czwartek");
        zbiorDniT.add("piatek");
        zbiorDniT.add("sobota");
        zbiorDniT.add("niedziela");


        for(String dzien : zbiorDniH){
            System.out.println("dzien: " + dzien);
        }
       System.out.println("");
        for(String dzien : zbiorDniT){
            System.out.println("dzien: " + dzien);
        }
        System.out.println("");


        Map<String, List<Student>> grupy = new HashMap<>();

        List<Student> grupa32 = new ArrayList<>();
        List<Student> grupa33 = new ArrayList<>();


        MapSubject m = new MapSubject("przedmioty");

        Student s1 = new Student("ww", "J", "32", "ww@j.com");
        Student s2 = new Student("ss", "AA", "32", "ss@aa.com");
        Student s3 = new Student("bb", "bb", "33", "bb@j.com");
        Student s4 = new Student("zz", "cc", "32", "zz@j.com");
        Student s5 = new Student("xx", "dd", "33", "xx@j.com");

        grupa32.add(s1);
        grupa32.add(s2);
        grupa32.add(s4);

        grupa33.add(s3);
        grupa33.add(s5);

        grupy.put("32", grupa32);
        grupy.put("33", grupa33);

        List<Student> g = grupy.get("32");

        for(Student s : g){
            System.out.println("grupa.. 32 " + s);
        }
        System.out.println("");

        Teacher t1 = new Teacher("Jaro", "Kaczi", "przyroda", "przyra@tt.com");
        Teacher t2 = new Teacher("Mateusz", "elmoro", "programowanie obiektowe", "oop@tt.com");
        Teacher t3 = new Teacher("Marcin", "xxx", "Android", "android@tt.com");

        m.addTeacher(t2);
        Teacher returnedTeacher = m.getTeacher("programowanie obiektowe");
        System.out.println(returnedTeacher.getFirstName());
    }
}
