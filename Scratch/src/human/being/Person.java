package human.being;

import java.time.LocalDate;
import java.time.Period;

/*
 * An immutable class. More accurately, this is a class definition written
 * in such a war that instances of it (Person objects) cannot have their properties
 * changed once created. In short: getters but no public setters.
 */
class Person {
    // properties (fields or instance variables)
    private String name;
    private LocalDate birthDate;

    // constructors
    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    // accessor methods
    /**
     * Returns the Person's age in whole years
     * This can be derived from the birthdate and today's date.
     * You basically need to get the period of time (in whole years) between
     * the birthDate and today's date.
     */
    public int getAge() {
        Period period = Period.between(getBirthDate(), LocalDate.now());
        return period.getYears();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // toString()
    public String toString() {
        return String.format("Person: name = %s, birthDate = %s, age = %s", getName(), getBirthDate(), getAge());
    }
}