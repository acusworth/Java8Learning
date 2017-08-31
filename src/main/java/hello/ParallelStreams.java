package hello;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreams {
    private int max;
    private List<String> values = new ArrayList<>(max);

    public ParallelStreams(){
        this(1000000);
    }

    public ParallelStreams(int max) {
        this.max = max;
        for (int i = 0; i < max; i++){
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    public void SequentialSorting(){
        System.out.println("Sequential Sorting Example");
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println("Number of Items: " + count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("Sequential sort took: %d ms", millis));
    }

    public void ParallelSorting(){
        System.out.println("Parallel Sorting Example");
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println("Number of Items: " + count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("Parallel sort took: %d ms", millis));
    }


}
