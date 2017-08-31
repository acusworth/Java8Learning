package hello;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;


public class Streams {
    private List<String> stringCollection = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");

    Streams() {}


    public void Filter() {
        System.out.println("Filtered Streams Example");
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a")) // NOTE: Filtering only applies to the stream and does not affect the original List.
                .forEach(System.out::println);
    }

    public void Sorted() {
        System.out.println("Sorted and Filtered Streams Example");
        stringCollection
                .stream()
                .sorted() // NOTE: Sorting only applies to the stream and does not affect the original List.
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public void Mapping() {
        System.out.println("Mapped Streams Example");
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public void Matching() {
        System.out.println("Matched Streams Example");
        boolean anyStartsWithA =
                stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA); // Should return true

        boolean allStartsWithA =
                stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA); // Should return false

        boolean noneStartsWithZ =
                stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ); // Should return true
    }

    public void Counting() {
        System.out.println("Counting Streams Example");
        long startsWithB =
                stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);
    }

    public void Reducing() {
        Optional<String> reduced =
                stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }
}
