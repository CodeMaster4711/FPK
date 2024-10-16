import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListReversalTest {
    private ListReversal<Integer> list;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        list = new ListReversal<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @org.junit.jupiter.api.Test
    void reverseIterative() {
        // Vor dem Umkehren: 4 -> 3 -> 2 -> 1
        ListReversal.Node newFirst = list.reverseIterative(list.getFirst());

        // Nach dem Umkehren: 1 -> 2 -> 3 -> 4
        assertEquals(1, newFirst.item);
        assertEquals(2, newFirst.next.item);
        assertEquals(3, newFirst.next.next.item);
        assertEquals(4, newFirst.next.next.next.item);
        assertNull(newFirst.next.next.next.next);

    }

    @org.junit.jupiter.api.Test
    void reverseRecursive() {
        // Vor dem Umkehren: 4 -> 3 -> 2 -> 1
        ListReversal.Node newFirst = list.reverseRecursive(list.getFirst());

        // Nach dem Umkehren: 1 -> 2 -> 3 -> 4
        assertEquals(1, newFirst.item);
        assertEquals(2, newFirst.next.item);
        assertEquals(3, newFirst.next.next.item);
        assertEquals(4, newFirst.next.next.next.item);
        assertNull(newFirst.next.next.next.next);
    }
}
