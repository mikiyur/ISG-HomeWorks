package hw4_myLinkedList;

public class MyLinkedList <E>{
    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E value){
        if (value == null) throw new NullPointerException("The list doesn't accept null value");
        if (first == null) {
            first = new Node<>(value);
            last = first;
            size++;
        } else {
            Node<E> newNode = new Node<>(value);
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
            size++;
        }
    }

    public void add(int index, E value){
        if (value == null) throw new NullPointerException("The list doesn't accept null value");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index " + index);
        if (index == 0 || index == size) {
            add(value);
            return;
        }
        Node<E> newNode = new Node<>(value);
        Node<E> current = getNode(index-1);
        newNode.previous = current;
        newNode.next = current.next;
        current.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }

    public boolean contains(E value){
        if (value == null) return false;
        Node<E> current = first;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        if (index == 0) return first.value;
        if (index == size-1) return last.value;
        Node<E> current = getNode(index);
        return current.value;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        Node<E> current = getNode(index);
        remove(current);
        return current.value;
    }

    public boolean remove(E value){
        if (contains(value)){
            Node<E> current = first;
            while (!current.value.equals(value)){
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

    private Node<E> getNode(int index){
        Node<E> current = first;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current;
    }

    private void remove (Node node){
        if (node == first) {
            first = node.next;
            first.previous = null;
            size--;
            return;
        }
        if (node == last) {
            last = node.previous;
            last.next = null;
            size--;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
        size--;
    }

    public int size() {
        return size;
    }

    private static class Node <E>{
        E value;
        Node<E> previous;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }
}
