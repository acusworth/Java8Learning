package hello;

import org.joda.time.LocalTime;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        // Hello World
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());


        // Default Methods
        Formulations formulations = new Formulations();

        System.out.println(formulations.calculate(100));
        System.out.println(formulations.sqrt(16));

        // Lambda functions
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        /*
            Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        */

        System.out.println("Names before sorting: " + names);

        Collections.sort(names, (a, b) -> b.compareTo(a));

        System.out.println("Names after sorting: " + names);


        // Functional Interfaces
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from); // Note any suggestion made here is covered in next section
        Integer converted = converter.convert("123");
        System.out.println("Functional Interface converted value: " + converted);

        // Method References - Static
        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("321");
        System.out.println("Method Reference with Functional Interface converted value: " + converted1);

        // Method References - Object
        Something something = new Something();
        Converter<String, String> converter2 = something::startsWith;
        String converted2 = converter2.convert("Java");
        System.out.println("Java starts with: " + converted2);

        // Constructor References
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

        System.out.println(person.getWholeName());


    }
}
