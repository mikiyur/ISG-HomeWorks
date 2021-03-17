package hw4_myLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.add("01");
        myList.add("02");
        myList.add("04");
        myList.add("05");
        System.out.println("has 032: " + myList.contains("032") + "  has 04:" + myList.contains("04"));
        myList.add(2, "3");
        System.out.println("value with index 4: " + myList.get(4));
        myList.print();

        System.out.println("remove with index 4: " + myList.remove(4));
        System.out.println("remove with value 0002: " + myList.remove("0002"));
        myList.print();
    }
}
