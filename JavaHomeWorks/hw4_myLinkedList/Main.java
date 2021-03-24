package hw4_myLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");

        myList.add("01");
        myList.add("02");
        myList.add("04");
        myList.add("05");
        myList.print();
        Stream <MyLinkedList<String>> stream = Stream.of(myList);
        Stream stream2 = Stream.of(linkedList);
        Stream stream3 = linkedList.stream();
        stream.peek(System.out::println).collect(Collectors.toSet());


        System.out.println("has 03: " + myList.contains("03"));
        System.out.println("has 04:" + myList.contains("04"));
        myList.add(2, "03");
        System.out.println("value with index 4: " + myList.get(4));
        myList.print();

        System.out.println("remove with index 4: " + myList.remove(4));
        System.out.println("remove with value 02: " + myList.remove("02"));
        myList.print();
    }
}
