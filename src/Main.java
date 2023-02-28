import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(2);
        list.add(45);
        list.add(23);
        list.add(12);
        list.add(6);

        // Задание 1
        findMinMax(list.stream(), Integer::compareTo, (min, max) -> System.out.println("min: " + min + ", max: " + max));

        // Задание 2
        findNumberEvenNumbers(list);

    }

    // Задание 1
    public static <T> void findMinMax (Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    // Задание 2

    public static void findNumberEvenNumbers (List<Integer> list) {
        Stream<Integer> stream = list.stream().filter(a -> a % 2 == 0);
        System.out.println("Количество четных чисел: " + stream.count());
    }
}