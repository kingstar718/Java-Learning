package top.wujinxing.java8;

/**
 * @author 01397208
 * @date 2022-08-07
 */
public class Person {

    String firstName;

    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" + "\"firstName\": \"" + firstName + "\", " + "\"lastName\": \"" + lastName + "\"}";
    }

}
