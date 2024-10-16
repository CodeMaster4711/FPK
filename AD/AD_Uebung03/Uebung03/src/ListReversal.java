import java.util.Iterator;

public class ListReversal<Item> {

    private Node first;     // first element of linked list

    class Node {
        Item item;
        Node next;
    }

    public Node getFirst() {  // getter
        return first;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Node reverseIterative(Node first) {
        Node prev = null;
        Node current = first;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node reverseRecursive(Node first) {
        if (first == null || first.next == null) {
            return first;
        }
        Node newHead = reverseRecursive(first.next);
        first.next.next = first;
        first.next = null;
        return newHead;
    }
}
