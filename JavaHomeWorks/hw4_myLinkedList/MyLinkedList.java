package hw4_myLinkedList;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    public void add(String s) {
        if (s == null) return;
        if (first == null) {
            first = new Node(s);
            last = first;
            size++;
        } else {
            Node newNode = new Node(s);
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
            size++;
        }
    }

    public void add(int index, String s) {
        if (s == null) throw new NullPointerException("The list doesn't accept null value");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index " + index);
        if (index == 0 || index == size) {
            add(s);
            return;
        }
        Node newNode = new Node(s);
        Node current = getNode(index);
        newNode.previous = current;
        newNode.next = current.next;
        current.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }

    public boolean contains(String s) {
        if (s == null) return false;
        Node current = first;
        while (current != null) {
            if (current.value.equals(s)) return true;
            current = current.next;
        }
        return false;
    }

    public String get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        if (index == 0) return first.value;
        if (index == size-1) return last.value;
        Node current = getNode(index);
        return current.value;
    }

    public String remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        Node current = getNode(index);
        return current.value;
    }

    public boolean remove(String s) {
        if (contains(s)){
            Node current = first;
            while (!current.value.equals(s)){
                current = current.next;
            }
            remove(current);
            return true;
        }
        return false;
    }

    public void print() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("MyLinkedList [");
        Node current = first;
        while (current != null) {
            sBuilder.append(current.value);
            current = current.next;
            if (current != null) sBuilder.append(", ");
        }
        sBuilder.append("]");
        System.out.println(sBuilder.toString());
    }

    private Node getNode(int index){
        Node current = first;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current;
    }

    private void remove (Node node){
        if (node == first) {
            first = node.next;
            first.previous = null;
            return;
        }
        if (node == last) {
            last = node.previous;
            last.next = null;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public int size() {
        return size;
    }

    private static class Node {
        String value;
        Node previous;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }
}
