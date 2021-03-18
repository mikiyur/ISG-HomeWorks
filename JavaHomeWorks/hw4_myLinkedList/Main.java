package hw4_myLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.add("01");
        myList.add("02");
        myList.add("04");
        myList.add("05");
        myList.print();

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
