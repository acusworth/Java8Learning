package hello;


import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class HelloWorld {
    public static void main(String[] args) {
        // Hello World
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

        // Lambda Scopes

        // Local Variables
        final int num = 1; // Also valid without "final" but "num" can NOT be reused. "num" must be implicitly final.
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String converted4 = stringConverter.convert(2); // Should result in 3

        System.out.println(converted4);

        // Built in Functional Interfaces

        // Predicates
        System.out.println("Predicate String Length");
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo")); // Should return true
        System.out.println(predicate.negate().test("foo")); // Should return false

        System.out.println("Predicate Booleans");
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        System.out.println(nonNull.test(false)); // Should return true
        System.out.println(isNull.test(null)); // Should return true

        System.out.println("Predicate String Emptiness");
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(isEmpty.test("Boop")); // Should return false
        System.out.println(isNotEmpty.negate().test("")); // Should return true

        // Functions
        System.out.println("Function Interface");
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123")); //Should come back as String "123"

        // Suppliers
        System.out.println("Suppliers");
        Supplier<Person> personSupplier = Person::new;
        Person personGuy = personSupplier.get(); // Makes a new person. Does not accept args.

        System.out.println(personGuy.getWholeName());

        // Consumers
        System.out.println("Consumers");
        Consumer<Person> greetings = (p) -> System.out.println("Hello, I'm " + p.getWholeName());
        greetings.accept(new Person("Luke","Skywalker"));

        // Comparators
        System.out.println("Comparators");
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("John", "Doe");
        Person p2 = personSupplier.get();

        System.out.println(comparator.compare(p1,p2)); // Should return 0 as the default first name is also John.

        p2.setFirstName("Jane");

        System.out.println(comparator.compare(p1,p2)); // Should return a value > 0
        System.out.println(comparator.reversed().compare(p1,p2)); //Should return a value < 0

        // Optionals
        System.out.println("Optionals");
        Optional<String> optional = Optional.of("bam");

        optional.isPresent(); // True
        optional.get(); // "bam"
        optional.orElse("fallback"); // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"

        // Streams
        System.out.println("Basic Streams");
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c3", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        // Step by step Sequential Streams
        Streams streams = new Streams();

        streams.Filter();
        streams.Sorted();
        streams.Mapping();
        streams.Matching();
        streams.Counting();
        streams.Reducing();

        // Parallel Streams

        ParallelStreams parallelStreams = new ParallelStreams(1023824);

        parallelStreams.SequentialSorting();
        parallelStreams.ParallelSorting();

        // Mapping

        Mapping mapping = new Mapping();

        mapping.PrintMap();
        mapping.ComputeMap();
        mapping.RemoveFromMap();
        mapping.GetDefaultMap();
        mapping.MapMerge();

        // Date API

        Clock clock = Clock.systemDefaultZone(); // Clocks are aware of time zones!!
        long millis = clock.millis(); // Used instead of System.currentTimeMillis()

        System.out.println("Aprox Current time in milliseconds: " + millis);

        Instant instant = clock.instant(); // Instantaneous point in time
        Date legacyDate = Date.from(instant); // Legacy date code in java.util.Date

        System.out.println("Legacy Date/Time: " + legacyDate);

        // Timezones

        System.out.println(ZoneId.getAvailableZoneIds()); // Prints all avail time zones

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println("Is Berlin before Brazil East: " + now1.isBefore(now2)); // False, duh!

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println("Time between Berlin and Eastern Brazil in hours: " + hoursBetween);
        System.out.println("Time between Berlin and Eastern Brazil in minutes: " + minutesBetween);









    }
}
