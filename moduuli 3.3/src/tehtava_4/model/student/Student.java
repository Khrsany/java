package tehtava_4.model.student;

import tehtava_4.model.Person;

public class Student extends Person {

    private String studentNumber;

    public Student(String name, int age, int internalId, String studentNumber) {
        super(name, age, internalId);
        this.studentNumber = studentNumber;

        // SAAN käyttää protected-juttuja, koska olen aliluokka:
        celebrateBirthday(); // protected metodi -> OK
        // age++;            // myös suora käyttö olisi OK aliluokassa
        // internalId = 123; // EI SALLITTU - tämä on package-private Person-paketissa, eri paketti
    }

    public String getStudentNumber() { return studentNumber; }

    public String studentInfo() {
        // SPECIES on public static final -> näkyy kaikkialle
        return "Student{species=" + SPECIES + ", name=" + getName()
                + ", number=" + studentNumber + "}";
    }
}
