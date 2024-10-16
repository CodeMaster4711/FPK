import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class CircularLinkedListTest {

    // when queue has a single element, this should be the removed element
    @Test
    public void dequeueSingleElementinQueue() {
        CircularLinkedList<String> r = new CircularLinkedList<>();
        String s = "X";
        r.enqueue("X");
        String removed = r.dequeue();
        assertSame(removed, s);
        assertEquals(0, r.size());
    }

    // when queue is empty, removed element should be null
    @Test
    public void dequeueNoElementinQueue() {
        CircularLinkedList<String> r = new CircularLinkedList<>();
        String removed = r.dequeue();
        assertNull(removed);
        assertEquals(0, r.size());
    }

    // when queue has >1 element, check that removed element is the one that was added first
    @Test
    public void dequeue() {
        CircularLinkedList<String> r = new CircularLinkedList<>();
        r.enqueue("A");
        r.enqueue("B");
        r.enqueue("C");
        String removed = r.dequeue();
        assertSame(removed, "A");
        assertEquals(2, r.size());
    }


    // queue correctly emptied? -> enqueue A, dequeue, enqueue B -> ring should only contain B
    @Test
    public void queueCorrectlyEmptied() {
        CircularLinkedList<String> r = new CircularLinkedList<>();
        r.enqueue("A");
        r.dequeue();
        r.enqueue("B");
        StringBuilder result = new StringBuilder();
        for (String s : r) {
            result.append(s);
            result.append(" ");
        }
        assertEquals("B", result.toString().trim());
        assertEquals(1, r.size());
    }

    // enqueue A, B, C and D -> check that they are in correct order
    @Test
    public void enqueue() {
        CircularLinkedList<String> r = new CircularLinkedList<>();
        r.enqueue("A");
        r.enqueue("B");
        r.enqueue("C");
        r.enqueue("D");
    	StringBuilder result = new StringBuilder();
		for (String s : r) {
			result.append(s);
			result.append(" ");
		}
		assertEquals("A B C D", result.toString().trim());
        assertEquals(4, r.size());
    }
}


