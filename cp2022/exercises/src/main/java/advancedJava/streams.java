package advancedJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<String>();
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");


        // Ta streams kanun mia seira apo operations san functional programming
        // Panta to teleutaio prp nane terminal operation dld me ;
        // Ta operations mesa sto stream den prepei na:
        // Einai mutable variables
        // Kai den prepei na allazun to data tou source dld na kanun add i remove

        Stream.of("a","b","c","d")
            .map(s -> {
                System.out.println("map: " + s);
                return s.toUpperCase();
            })
            .forEach(s -> System.out.println("forEach: " + s));

        // Mporw na perasw kai collections san arguments

        myList.stream()
            .map(s -> s.toUpperCase())
            .forEach(s -> System.out.println("forEach:" + s));


        // Example where order matters
        // Ta return calls ginonte passed sto epomeno function
        Stream.of("d2", "a2", "b1", "b3", "c")
        .map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        })
        .filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("A");
        })
        .forEach(s -> System.out.println("forEach: " + s));
        
        // map:     d2
        // filter:  D2
        // map:     a2
        // filter:  A2
        // forEach: A2
        // map:     b1
        // filter:  B1
        // map:     b3
        // filter:  B3
        // map:     c
        // filter:  C


        // To sorted leiturgei horizontally. Perna ola ta stixeia
        Stream.of("d2", "a2", "b1", "b3", "c")
        .sorted((s1, s2) -> {
            System.out.printf("sort: %s; %s\n", s1, s2);
            return s1.compareTo(s2);
        })
        .filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("a");
        })
        .map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        })
        .forEach(s -> System.out.println("forEach: " + s));
            
        // sort:    a2; d2
        // sort:    b1; a2
        // sort:    b1; d2
        // sort:    b1; a2
        // sort:    b3; b1
        // sort:    b3; d2
        // sort:    c; b3
        // sort:    c; d2
        // filter:  a2
        // map:     a2
        // forEach: A2
        // filter:  b1
        // filter:  b3
        // filter:  c
        // filter:  d2

        // Den mporw na exw reuse tou stream.
        // Molis kalesw terminal operation prepei na kanw
        // Neo stream chain an thelw na to xrisimopiisw ksana
        // streamSupplier.get().anyMatch(s -> true);   // ok
        // streamSupplier.get().noneMatch(s -> true);  // ok


        // Advanced operations, this is our sample of persons
        List<streamsPerson> persons =
        Arrays.asList(
            new streamsPerson("Max", 18),
            new streamsPerson("Peter", 23),
            new streamsPerson("Pamela", 23),
            new streamsPerson("David", 12));


        // Collect einai terminal operation gia na metatrepsei ta elements
        // tou stream se kati allo px list set map.
        // To collect dexete a Collector
        List<streamsPerson> filtered = persons
            .stream()
            .filter(p -> p.name.startsWith("P"))
            .collect(Collectors.toList());
        
        System.out.println(filtered);    // [Peter, Pamela]


        // FlatMap. Map an object into multiple others
        // Reduce. Combine all elements of the stream into a single result

        // ParallelStream running with threads
    }
}
