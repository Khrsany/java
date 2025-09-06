package tehtava_4.system;

import tehtava_4.model.Person;
import tehtava_4.model.student.Student;

public class AccessDemo {
    public static void main(String[] args) {
        Person p = new Person("Ada", 30, 999);
        Student s = new Student("Abbas", 22, 777, "S12345");

        // --- Mitä voin käyttää täältä (eri paketti, ei aliluokka)? ---
        System.out.println("Species: " + Person.SPECIES); // public static final -> OK

        // public-metodit -> OK
        System.out.println(p.info());
        p.setName("Ada Lovelace");
        System.out.println(p.getName());

        // private -> EI SAA SUORAAN (kommentoitu, muuten ei käänny)
        // p.name = "X";

        // protected -> EI SAA täältä, koska tämä luokka ei ole aliluokka
        // p.celebrateBirthday();

        // package-private -> EI SAA, eri paketti kuin Person
        // p.internalId = 0;
        // p.resetInternalId();

        // Student on aliluokka -> se on saanut käyttää protected-juttuja omassa luokassaan
        System.out.println(s.studentInfo());

        // Varmistetaan, että Person public toimii edelleen:
        System.out.println(p.info());
    }
}

