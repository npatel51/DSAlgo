package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Niraj Patel
 * @date 01/10/2018
 * @param<E>
 */

public class SinglyLinkedList<E> implements List<E>, Iterable<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	/**
	 * Node class
	 * 
	 * @param <E>
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

	}

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public SinglyLinkedList(E data) {
		Node<E> newNode = new Node<E>(data, null);
		this.head = newNode;
		this.tail = newNode;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(E data) {
		if (isEmpty()) {
			Node<E> newNode = new Node<E>(data);
			head = newNode;
			tail = newNode;
		} else {
			tail.next = new Node<E>(data);
			tail = tail.next;
		}
		size++;
	}

	/**
	 * Appends the item at the end of the list
	 * 
	 * @param data
	 *            - the item to be added at the end of the list
	 */
	public void append(E data) {
		add(data);
	}

	/**
	 * Adds item at the front of the list.
	 * 
	 * @param data
	 *            - data to be added at the front of this list.
	 * 
	 */

	public void prepend(E data) {
		if (isEmpty()) {
			Node<E> newNode = new Node<E>(data);
			this.head = newNode;
			this.tail = newNode;
		} else {
			head = new Node<E>(data, head);
		}
		size++;
	}

	@Override
	public E getFirst() {
		return head.data;
	}

	@Override
	public E getLast() {
		return tail.data;
	}

	/**
	 * Pointing head and tail to null is sufficient since in Java garbage collector
	 * will delete or free up the space when there is nothing referencing to a node.
	 */
	@Override
	public void clear() {
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public void print() {
		Node<E> curr = head;
		if (isEmpty()) {
			System.out.println("[]");
		} else {
			System.out.print("[");
			while (curr != tail) {
				System.out.print(curr.data + " => ");
				curr = curr.next;
			}
			System.out.println(curr.data + " => null]");
		}
	}

	@Override
	public E itemAt(int index) throws IndexOutOfBoundsException {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound.");
		}
		Node<E> currNode = head;
		while (index > 0) {
			currNode = currNode.next;
			--index;
		}

		return currNode.data;
	}

	@Override
	public void removeFirst() {
		head = head.next;
		--size;
	}

	@Override
	public void removeLast() {
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node<E> currNode = head;
			while (currNode.next.next != null) {
				currNode = currNode.next;
			}
			currNode.next = null;
			tail = currNode;
		}
		--size;
	}

	@Override
	public int indexOf(E data) {
		Node<E> currNode = head;
		int index = 0;
		while (currNode != null) {
			if (currNode.data == data) {
				return index;
			}
			currNode = currNode.next;
			index++;
		}

		return -1;
	}

	@Override
	public E[] toArray(E[] array) {

		Node<E> currNode = head;
		for (int i = 0; i < size; ++i) {
			array[i] = currNode.data;
			currNode = currNode.next;
		}
		return array;
	}

	@Override
	public void set(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound.");
		}

		Node<E> currNode = head;
		while (index > 0) {
			currNode = currNode.next;
			--index;
		}
		currNode.data = element;
	}

	public String toString() {
		return getToString();
	}

	private String getToString() {
		StringBuilder sb = new StringBuilder();
		Node<E> curr = head;
		if (isEmpty()) {
			sb.append("[]");
		} else {
			sb.append("[");
			while (curr != tail) {
				sb.append(curr.data + " => ");
				curr = curr.next;
			}
			sb.append(curr.data + " => null]");
		}
		return sb.toString();
	}

	@Override
	public void reverse() {
		Node<E> currNode = head;
		Node<E> nextNode = null;
		Node<E> prevNode = null;
		while (currNode != null) {
			nextNode = currNode.next; // store the reference to the next node
			currNode.next = prevNode; // change the reference of current node to previous one
			prevNode = currNode;
			currNode = nextNode; // use the previously saved reference to keep moving forward
		}
		tail = head; // the head becomes the new tail
		head = prevNode; // the last node becomes the new head
	}

	@Override
	public E remove(int index) {

		if (index < 0 || index >= size) {
			return null;
		}

		Node<E> currNode = head;
		Node<E> prevNode = head;

		while (index > 0) {
			prevNode = currNode;
			currNode = currNode.next;
			index--;
		}
		removeNode(currNode, prevNode);
		return currNode.data;
	}

	@Override
	public boolean remove(E item) {
		Node<E> currNode = head;
		Node<E> prevNode = head;

		while (currNode != null) {

			if (currNode.data == item) {
				removeNode(currNode, prevNode);
				return true;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}

		return false;
	}

	private void removeNode(Node<E> currNode, Node<E> prevNode) {
		if (currNode == head) {
			head = head.next;
		} else if (currNode == tail) {
			tail = prevNode;
		} else {
			prevNode.next = currNode.next; // change the reference to the consecutive node
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator<E>(head);
	}

	public class SinglyLinkedListIterator<E> implements Iterator<E> {

		Node<E> head;

		public SinglyLinkedListIterator(Node<E> head) {
			this.head = head;
		}

		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException("There are no element(s) in the list.");
			E data = head.data;
			head = head.next;
			return data;
		}

	}

}
