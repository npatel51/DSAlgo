import java.util.NoSuchElementException;

/***
 * 
 * @author Niraj Patel
 * @date  01/06/2018
 */
public class ArrayBasedQueue {

	/**
	 * A queue is a list or collection with restraint that insertion must happen at
	 * the rear ( or tail ) and deletion or dequeue must happen at the front (or
	 * head). ” As an element enters the queue it starts at the rear and makes its
	 * way toward the front, waiting until that time when it is the next element to
	 * be removed. The item longest in the list is removed first, also know as FIFO.
	 * 
	 * e.g. printer, processor. All printer tasks gets in line, if the printer is
	 * busy it cannot simply deny the job. It is as queue works, if you are first in
	 * line you get served first and if you are last in the line you must wait until
	 * all ahead of you are served.
	 * 
	 */

	private static int MAX_SIZE = 101;
	private static int[] queue = new int[MAX_SIZE];
	private static int head = -1; // initially the list is empty
	private static int tail = -1;

	/**
	 * Takes the item to insert in the queue and inserts it at the end of the queue.
	 * 
	 * @param data
	 *            - adds new item to the rear or tail of the queue
	 */

	public static void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue is full!");
			return;
		} else if (isEmpty()) {
			head = 0;
			tail = 0;
		} else {
			tail = (tail + 1) % MAX_SIZE; // allows to fill in the empty slots
		}
		queue[tail] = data;

	}

	private static boolean isFull() {
		return (tail + 1) % MAX_SIZE == head; // if tail is one less than the head
	}

	/**
	 * Removes the front item from the queue. In this implementation, head is
	 * incremented to imitate that behavior.
	 * 
	 * @return - the longest item in the list (or the front item of the queue)
	 */

	public static void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!"); // or throw exception instead
		} else if (head == tail) {
			head = -1;
			tail = -1;
		} else {
			head = (head + 1) % MAX_SIZE;
		}
	}

	/**
	 * 
	 * @return - the front (or the longest) item in the list without deleting it.
	 */
	public static int front() {
		return queue[head];
	}

	/**
	 * 
	 * @return - false if list is not empty, true otherwise
	 */

	public static boolean isEmpty() {
		return tail == -1 && head == -1;
	}

	/**
	 * 
	 * @return - number of items in the queue
	 */
	public static int size() {
		return tail - head + (head == 0 ? 1 : 0);
	}

	/**
	 * Prints the queue
	 */

	public static void print() {

		if (isEmpty()) {
			System.out.println("[ ]");
			return;
		}
		System.out.print("[");

		for (int i = head; i < tail; ++i) {
			System.out.print(queue[i] + "<-");
		}

		System.out.println(queue[tail] + "]");
	}

	public static void test_queue() {

		enqueue(1);
		enqueue(3);
		enqueue(5);
		enqueue(7);

		print();

		System.out.println("Size of the queue: " + size());
		System.out.println("Front of the queue: " + front());
		System.out.println("Is the queue empty? " + (isEmpty() ? "Yes" : "No"));

		dequeue();
		System.out.println("Front of the queue: " + front());
		print();

		enqueue(11);
		enqueue(13);
		enqueue(17);
		enqueue(21);

		System.out.println("Size of the queue: " + size());
		System.out.println("Front of the queue: " + front());

		while (!isEmpty()) {
			dequeue();
			print();
		}
	}

	public static void main(String[] args) throws NoSuchElementException {

		Queue<Integer> q = new Queue<Integer>();

		System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));

		q.enqueue(4);
		q.enqueue(8);
		q.enqueue(12);
		q.enqueue(18);
		q.enqueue(32);
		q.enqueue(14);
		q.enqueue(23);

		System.out.println(q);

		// using the iterator

		for (Integer item : q) {
			System.out.print(item + " ");
		}
		System.out.println();

		System.out.println("Size of the queue: " + q.size());
		System.out.println("Front of the queue: " + q.front());
		System.out.println("End of the queue: " + q.end());
		System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));

		while (!q.isEmpty()) {
			q.dequeue();
			System.out.println(q);
		}

	}

}
