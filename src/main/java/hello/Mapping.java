package hello;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
    private Map<Integer, String> map = new HashMap<>();

    public Mapping() {
        System.out.println("Mapping Example");
        for (int i=0; i<10; i++){
            map.putIfAbsent(i, "val" + i);
        }

    }

    public void PrintMap(){
        map.forEach((id, val) -> System.out.println(val));
    }

    public void ComputeMap(){
        System.out.println("Computing for a Map");
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println("Get value from Map at key 3: " + map.get(3));

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println("Does map contain key 9: " + map.containsKey(9));

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println("Does map contain key 23: " + map.containsKey(23));

        map.computeIfAbsent(3, num -> "bam");
        System.out.println("Get value from Map at key 3: " + map.get(3));
    }

    public void RemoveFromMap(){
        System.out.println("Removing from a Map");
        map.remove(3, "val3");
        System.out.println("Get value from Map at key 3: " + map.get(3));

        map.remove(3, "val33");
        System.out.println("Get value from Map at key 3: " + map.get(3));
    }

    public void GetDefaultMap(){
        System.out.println("Get or Default from a Map");
        System.out.println(map.getOrDefault(42, "not found")); //There is no Key 42, not found will return.

        map.putIfAbsent(42, "val" + 42);
        System.out.println(map.getOrDefault(42, "not found")); //Should now return val42
    }
    public void MapMerge(){
        System.out.println("Merging Map values");
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println("Value at key 9: " + map.get(9)); // Comes back with val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println("Value at key 9: " + map.get(9)); // Comes back with val9concat
    }

}
