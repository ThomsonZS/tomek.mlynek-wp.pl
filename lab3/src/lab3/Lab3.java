package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {

    public static void main(String[] args) {
        System.out.println("=== zad 1 ===");
        zad1();
        System.out.println("\n\n === zad 2 ===");
        zad2();
        System.out.println("\n\n === zad 3 ===");
        zad3();
    }
    
    
    public static void zad1() {
        Set<String> zbiorDni = new TreeSet<>(); //deklarujemy sobie zbór tak jak w instrukcji jest napisane
        // i wkładamy do niego wszystkie dni tygodnia poprzez .add():
        
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("Środa");
        zbiorDni.add("Czwartek");
        zbiorDni.add("Piątek");
        zbiorDni.add("Sobota");
        zbiorDni.add("Niedziela");
        
        System.out.println(zbiorDni);
        /*
        
       1. czym się różni HashSet od TreeSet? 
        Hashset - kolejność wyświetlania elementów ulega zmianom, nie ma żadnej kontroli nad tym
        TreeSet - tutaj zawsze elementy ustawią się w takiej samej kolejności. 
        
       2. której klasy użyć w jakiej sytuacji?
        HashSet - wtedy, gdy nie interesuje nas konkretna kolejność elementów, tylko chcemy sprawdzić czy coś istnieje po prostu w danym zbiorze
        TreeSet - gdy interesuje nas dostęp do posortowanego zbioru bo sortowanie tego zbioru występuje za każdym razem gdy dodajemy do niego element
        
       3. czy były wymagane jakiekolwiek zmiany w kodzie poza miejscem tworzenia
        obiektu (new HashSet<>() / new TreeSet<>()) ? - TAK. Kompilator zwracał błąd, ponieważ należało zaimprtować:
        import java.util.TreeSet;. Oprócz tego, nie było żadnej innej zmiany w kodzie.
        */
    }
    
    
    public static void zad2() {
        // robimy mape w której nazwa przedmiotu związana jest z nauczycielem
        
        Person t1 = new Teacher("Tomasz", "Klimek", "", "");
        Person t2 = new Teacher("Piotr", "Piela", "", "");
        Person t3 = new Teacher("Jerzy", "Pejaś", "", "");
        
        Map<String, Person> przemiot_nauczyciel = new HashMap<>(); 
        
        przemiot_nauczyciel.put("programowanie obiektowe", t1);
        przemiot_nauczyciel.put("Modelowanie i symulacja", t2);
        przemiot_nauczyciel.put("Kryptografia", t3);
        
        //dla pewnosci czy wszystko dziala, wyswietlam moją mape
        for(String przedmiot : przemiot_nauczyciel.keySet()) {
            Person teacher = przemiot_nauczyciel.get(przedmiot);
            System.out.println(przedmiot + " - " + teacher);
        }
        // zgodnie z instrukcją, wyświetlamy tylko nauczyciela prowadzącego “programowanie obiektowe”
        String przedmiot = "programowanie obiektowe";
        Person teacher = przemiot_nauczyciel.get(przedmiot);
        System.out.println("--> "+przedmiot + " - " + teacher);
        
        
        //Przygotuj kilka list zawierających grupy studentów- 
        Person s1 = new Student("Jan","Kowalski");
        Person s2 = new Student("Krzysztof","Nowak");
        Person s3 = new Student("imie3","nazwisko3");
        Person s4 = new Student("imie4","nazwisko4");
        Person s5 = new Student("imie5","nazwisko5");
        Person s6 = new Student("imie6","nazwisko6");
        
        // teraz tworze listy i przypisuje do nich studentów
        List<Person> lista1 = new ArrayList<>();
        lista1.add(s1);
        lista1.add(s2);
        List<Person> lista2 = new ArrayList<>();
        lista2.add(s3);
        lista2.add(s4);
        List<Person> lista3 = new ArrayList<>();
        lista3.add(s5);
        lista3.add(s6);
        
        
    Map<String, List<Person>> grupy = new HashMap<>();// deklaruje mape. 
    
    grupy.put("32a", lista1);
    grupy.put("32b", lista2);
    grupy.put("32c", lista3);
    
    
    System.out.println("Grupa 32a:");
    List<Person> grupa32a = grupy.get("32a");// mapa to postać w której jeden rekort składa się w formie <klucz,wartośc>
    //w tym przypadku kluczami są grupy, czyli 32a,32b,32c a wartoścami listy.

    for (Person osoba : grupa32a) { 
        System.out.println("   "+ osoba);
    }

    }  
    
    
    public static void zad3() {
        List<Product> produkty = new ArrayList(); // lista
        Map<Integer, Product> id_produkt = new HashMap<>(); 
        Map<String,List<Product>> kategoria_produkty = new HashMap<>(); 
        try { // musimy umieśćić wszystko w bloku try catch. Dlaczego? Bo w pracy z plikami, strumieniami, zaciąganiem 
            //czegoś z sieci zawsze może zdażyć się coś czego nie przewidzimy np. odczyt pliku który fizycznie nie istnieje
            // uszkodzony plik, adres url który nie istnieje itp. Try catch zabezpiecza aplikacje przed wywaleniem się
            BufferedReader in = new BufferedReader(new FileReader("plik.txt"));// 
            String s = in.readLine(); 
            while(s!=null) { 
                
                String[] pola = s.split(";"); // teraz odczytaną linijkę oddzielamy
            Product prod = new Product (Integer.parseInt(pola[0]),  
                    
                                        pola[1],
                                        Double.parseDouble(pola[2]),
                                        pola[3]);
            produkty.add(prod); 
            id_produkt.put(Integer.parseInt(pola[0]), prod);
            s = in.readLine();
                if (s == null) // zabezpieczenie, zeby program nie wywalal sie przy odczytaniu ostatniego elementu
                    break;
            }
            
            //Test
            for (Product produkt : produkty) {
                System.out.println(produkt);
            }
            //mapa, która pozwoli na szybkie znalezienie produktu po id- testujemy dzialanie 
              for(Integer id : id_produkt.keySet()) {
                Product prod = id_produkt.get(id);
                System.out.println("id: "+ id + ", produkt: " + prod);
                }
            
            for (Product prod : produkty) { //przechodze po mojej liście ze wszystkimi produktami
                
                kategoria_produkty.computeIfAbsent(prod.getCategory(), k -> new ArrayList<Product>()).add(prod);

                    /*
                    metoda computeIfAbsent() sprawdza czy klucz o nazwie w tym przypadku "prod.getCategory()" występuje już w 
                    naszej mapie.
                    jeżeli nie występuje to ten zapis "k -> new ArrayList<Product>()).add(prod)" powoduje dodanie naszego produktu z 
                    listy
                    czyli generalnie jest to sytuacja w ktorej dodaje pierwszy raz element do nowej kategorii bo na 
                    początku on wlasnie nie istnieje.
                    "kategoria_produkty.computeIfAbsent(prod.getCategory(), k -> new ArrayList<Product>()).add(prod)"
                
                    Jeżeli istnieje to powoduje ze stara lista produktów pod danym kluczem (kateogrią jest kopiowana)
                i następnie przez końcówkę ".add(prod)" dodawany jest nowy produkt do tej listy i znowu zapisywane do tego samego klucza
                   
                    */
               
                    
                       
            }
            
            //Test
            for(String kategoria : kategoria_produkty.keySet()) {
                List<Product> _tmp_produkty = kategoria_produkty.get(kategoria);
                String produktyPoKategorii = "";
                for (Product produkty2 : _tmp_produkty) {
                    produktyPoKategorii += produkty2.toString();
                }
                System.out.println("|--> kategoria: "+ kategoria + " <--|          produkt: " + produktyPoKategorii);
            }

        
            
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

