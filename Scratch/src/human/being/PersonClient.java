package human.being;

import java.time.LocalDate;

class PersonClient {

    public static void main(String[] args) {
        Person p1 = new Person("Lui", LocalDate.of(1990,12,22));

        System.out.println(p1);
        System.out.println();
        System.out.printf("%s is %s years old.", p1.getName(), p1.getAge());
    }
}