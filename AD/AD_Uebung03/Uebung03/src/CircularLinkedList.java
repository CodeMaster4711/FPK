import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements Iterable<T> {

	// inner class: groups data value and prev/next "pointer"
	private class Node {
		T item;
		Node prev; // pointer to previous node that was inserted beforehand
		Node next; // pointer to next node that was time-wise inserted afterwards
	}

	private Node head; 	  // entry into ring
	private int numElems; // number of items in ring

	// constructor: empty ring
	public CircularLinkedList() {
		head = null;
		numElems = 0;
	}

	// check if ring is empty
	public boolean isEmpty() {
		return head == null;
	}

	// return number of items in queue
	public int size() {
		return numElems;
	}

	/*
	 * enqueue, add element into queue
	 */
	public void enqueue(T item) {
		Node newNode = new Node();
		newNode.item = item;

		if (numElems == 0) {
			newNode.next = newNode;
			newNode.prev = newNode;
			head = newNode;
		} else {
			newNode.next = head;
			newNode.prev = head.prev;
			head.prev.next = newNode;
			head.prev = newNode;
		}
		numElems++;
	}

	// dequeue, remove element from queue and return removed element.

	public T dequeue() {
		if (numElems == 0) {
			return null;
		} else if (numElems == 1) {
			T item = head.item;
			head = null;
			numElems--;
			return item;
		} else {
			T item = head.item;
			head.prev.next = head.next;
			head.next.prev = head.prev;
			head = head.next;
			numElems--;
			return item;
		}
	}

	// iterator over items in the ring, starting at "oldest item"
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int numVisitedItems = 0;
			private Node current = head;

			@Override
			public boolean hasNext() {
				return numElems > 0 && numVisitedItems < numElems;
			}

			@Override
			public T next() {
				if (!hasNext())
					throw new NoSuchElementException();
				Node temp = current;
				numVisitedItems++;
				current = current.next;
				return temp.item;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
