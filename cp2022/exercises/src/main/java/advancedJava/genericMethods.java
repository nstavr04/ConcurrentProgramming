package advancedJava;

import java.util.Collection;

public class genericMethods {
    public static void main(String[] args) {
        System.out.println("Hello");

        Integer[] nums = {1,2,3,4};
        Character[] chars = {'a','b','c','d'};

        genericPrint(nums);
        genericPrint(chars);

    }

    // This is a generic method example where we can call it to print numbers or characters
    public static <T> void genericPrint(T[] arr){
        for(T i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    // Generic Methods
    public static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for(T o : a){
            c.add(o);
        }
    }
}
