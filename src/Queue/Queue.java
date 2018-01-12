import java.util.Iterator;
import java.util.NoSuchElementException;

/***
 * 
 * @author Niraj Patel
 * @date  01/06/2018
 */
public class Queue<E> implements Iterable<E> {

	private int size; // number elements on queue
	private Node<E> head; // front of the queue
	private Node<E> tail; // end of the queue

	/**
	 * Node class
	 */
	public static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	// Constructor
	public Queue() {

	}

	/**
	 * Adds the item at the end of the queue.
	 * 
	 * @param data
	 *            - item to be appended at the end of the queue
	 */

	public void enqueue(E data) {
		Node<E> newNode = new Node<E>(data);
		if (isEmpty()) {
			tail = newNode;
			head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		++size;
	}

	/**
	 * Removes the front item from the queue.
	 * 
	 * @return - the longest item in the list (or the front item of the queue)
	 */
	public void dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty!");
		} else if (head == tail) {
			head = null; // set both to null since to meet isEmpty()'s conditions
			tail = null;
		} else {
			head = head.next;
		}
		--size;
	}

	/**
	 * 
	 * @return - The front item from the queue without removing it.
	 * @throws NoSuchElementException
	 */
	public E front() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty!");

		return head.data;
	}

	/**
	 * 
	 * @return - the end/rear item of the queue.
	 * @throws NoSuchElementException
	 */
	public E end() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty!");
		return tail.data;
	}

	/**
	 * 
	 * @return- the current size of this queue
	 */
	public int size() {
		return size;
	}

	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	/**
	 * 
	 * @return - returns a pretty string containing all elements of the queue
	 */

	public String getString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[");
		Node<E> temp = head;

		while (temp.next != null) {
			sb.append(temp.data + "<-");
			temp = temp.next;
		}

		sb.append(temp.data + "]");
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator<E>(head);
	}

	// Iterator for queue

	public class QueueIterator<E> implements Iterator<E> {

		private Node<E> node;

		public QueueIterator(Node<E> head) {
			node = head;
		}

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException("Queue has no elements!");
			E data = node.data;
			node = node.next;
			return data;
		}

	}
	
	public String toString() {
		if (this.isEmpty()) {
			return "[ ]";
		}
		return getString();
	}

}
