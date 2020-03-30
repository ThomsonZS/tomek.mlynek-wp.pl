package lab3;


import lab3.EmailRecipient;


public class Person implements EmailRecipient  {
    private String firstName;
    private String lastName;
    private String emailAddress; //do zadania nr 2
    
    public Person(String firstName, String lastName, /* do zad 2*/String emailAdress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAdress; //do zad 2
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    /*
    to jest do zadania 2. Jezeli jakaś klasa implementuje interfejs to musi mieć dokładną 
    definicję tej metody. W tym przypadku w interfejsie zadklarowalismy email adres,
    ale w klasie która implementuje ten interfejs to musimy już zdefiniować tą funckję
    W tym przypadku zwracamy w tej metodzie wartość stringa bo tak jest w instrukcji
    */
    public String getEmailAddress() {
       return this.emailAddress;
    }
}

