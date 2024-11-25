import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class HashtableProbingLazyDeleteTest {

    // checks delete
    @Test
    public void delete() {
        HashtableProbingLazyDelete<Integer, String> studentIDs = new HashtableProbingLazyDelete<>(10);
        studentIDs.put(1, "Mueller");
        studentIDs.put(4, "Huber");
        studentIDs.put(8, "Schmitt");
        studentIDs.put(11, "Maier");
        studentIDs.put(21, "Bauer");

        /* Hashtable content before delete: |   | 1 | 11  | 21  | 4 |   |    |   |  8 |     | */
        studentIDs.delete(11);
        assertFalse(studentIDs.contains(11));  // 11 should be removed
        assertTrue(studentIDs.contains(21));   // 21 should be still in hash list
        System.out.println("Size of studentIDs list: " + studentIDs.size());
        assertTrue(studentIDs.size() == 4);  // list should contain 4 entries
    }


    // checks if table size is halved when there are too many invalid items
    @Test
    public void deleteCorrectlyContracted() {
        HashtableProbingLazyDelete<Integer, String> studentIDs = new HashtableProbingLazyDelete<>(10);
        studentIDs.put(1, "Mueller");
        studentIDs.put(4, "Huber");
        studentIDs.put(8, "Schmitt");
        studentIDs.put(11, "Maier");
        studentIDs.put(21, "Bauer");

        /* Hashtable content before delete: |   | 1 | 11  | 21  | 4 |   |    |   |  8 |     | */
        studentIDs.delete(1);
        studentIDs.delete(4);
        studentIDs.delete(8);
        studentIDs.delete(11);
        TreeMap<Integer, String> t;

        // after 4 deletes there is only 1 entry in the table of size m=10 -> table size must be halved to 5
        assertEquals( 5, studentIDs.getTableSize());
    }

    // checks if put inserts values at keys that were previously marked as invalid

    @Test
    public void insertAfterDelete() {
        HashtableProbingLazyDelete<Integer, String> studentIDs = new HashtableProbingLazyDelete<>(10);
        studentIDs.put(1, "Mueller");
        studentIDs.put(8, "Schmitt");
        studentIDs.put(11, "Maier");


        // Hashtable content before delete: |   | 1 |  11  |    |   |   |    |   |  8 |     |
        studentIDs.delete(11);
        studentIDs.put(31, "Lenz");

        // check that last entry "Lenz" has been put to deleted position
        assertEquals(31, (int) studentIDs.getTableEntryAtIndex(2));
    }

}