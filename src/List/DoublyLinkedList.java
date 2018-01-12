package List;

/**
 * 
 * @author Niraj Patel
 * @date 01/10/2017 
 * @param <E>
 */

public class DoublyLinkedList<E> implements List<E> {
	private int size = 0;
	private boolean sorted = false;
	private Node<E> head;
	private Node<E> tail;

	/**
	 * Node class
	 * @param <E>
	 */
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> prev;

		public Node(E data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

	}
	
	
	public DoublyLinkedList(boolean sorted){
		 this.sorted = sorted;
	}
	
	public DoublyLinkedList(){
	
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
			tail.next = new Node<E>(data, tail, null);
			tail = tail.next;
		}
		size++;
	}

	/**
	 * Appends the item at the end of the list. If list is non-empty, then the next
	 * pointer of the current tail changes to the newly create node and it becomes
	 * the new tail of the doubly linked list.
	 * 
	 * @param data
	 *            - the item to be added at the end of the list
	 */
	public void append(E data) {
		add(data);
	}

	/**
	 * If the list is empty head and tail get a new node with its previous and next
	 * pointer pointing to null; otherwise, the current head's previous pointer
	 * point to the new node and the head becomes the new node that is linked to the
	 * previous node.
	 *
	 * 
	 * @param data
	 *            - item to add in front of the list.
	 */

	public void prepend(E data) {
		if (isEmpty()) {
			Node<E> newNode = new Node<E>(data);
			this.head = newNode;
			this.tail = newNode;
		} else {
			head.prev = new Node<E>(data, null, head);
			head = head.prev;
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
	 * Garbage collector does all the work
	 * 
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
			System.out.print("[null");
			while (curr != tail) {
				System.out.print("<= " + curr.data + " =>");
				curr = curr.next;
			}
			System.out.println("<= " + curr.data + " =>null]");
		}
	}

	@Override
	public E itemAt(int index) throws IndexOutOfBoundsException {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound.");
		}
		Node<E> tmp = head;
		while (index > 0) {
			tmp = tmp.next;
			--index;
		}

		return tmp.data;
	}

	@Override
	public void removeFirst() {
		head = head.next; // set head to the next head
		head.prev = null; // unlink the previous node's reference by setting previous to null
		--size;
	}

	@Override
	public void removeLast() {
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev; // set tail to the previous node
			tail.next = null; // unlink the node by setting current node's reference to null
		}
		--size;
	}

	@Override
	public int indexOf(E data) {
		Node<E> tmp = head;
		int index = 0;
		while (tmp != null) {
			if (tmp.data == data) {
				return index;
			}
			tmp = tmp.next;
			index++;
		}

		return -1;
	}

	@Override
	public E[] toArray(E[] array) {

		Node<E> tmp = head;
		for (int i = 0; i < size; ++i) {
			array[i] = tmp.data;
			tmp = tmp.next;
		}
		return array;
	}

	@Override
	public void set(int index, E data) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bound.");
		}
		/**
		 * Small optimization: replace the element from end which is closer to either
		 * end(from or rear). Start from front if index from rear is greater than index
		 * starting from the front and vice versa.
		 */
		int indexFromRear = size - index - 1;

		if (indexFromRear < index) {
			setNodeFromRear(indexFromRear, data); // start from the tail
		} else {
			setNodeFromFront(index, data); // start from the head
		}
	}

	private void setNodeFromFront(int index, E data) {
		Node<E> tmp = head;
		while (index > 0) {
			tmp = tmp.next;
			index--;
		}
		tmp.data = data;
	}

	private void setNodeFromRear(int index, E data) {
		Node<E> tmp = tail;
		while (index > 0) {
			tmp = tmp.prev;
			index--;
		}
		tmp.data = data;

	}
	public String toString() {
		return getString();
	}

	private String getString() {
		StringBuilder sb = new StringBuilder();
		Node<E> curr = head;

		if (isEmpty()) {
			sb.append("[]");
		} else {
			sb.append("[null");
			while (curr != tail) {
				sb.append("<= " + curr.data + " =>");
				curr = curr.next;
			}
			sb.append("<= " + curr.data + " =>null]");
		}
		return sb.toString();
	}

	@Override
	public void reverse() {
		Node<E> currNode = head;
		Node<E> prevNode = null;
		Node<E> nextNode = null;
		
		while(currNode!=null) {
			nextNode = currNode.next; // store the reference to the next node
			currNode.prev = nextNode; //swap the previous and next node's reference
			currNode.next = prevNode; 						
			prevNode = currNode;     
			currNode = nextNode;
		}
		
	  tail = head;
	  head = prevNode;
		
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
		removeNode(currNode,prevNode,currNode.next);
		return currNode.data;
	}

	private void removeNode(Node<E> currNode, Node<E> prevNode,Node<E> nextNode) {
	
		if (currNode == head) {
			head = head.next;
		} else if (currNode == tail) {
			tail = prevNode;
		} else {
			prevNode.next = nextNode; // change the reference to the consecutive node
			nextNode.prev = prevNode;      // next node's reference must be changed to delete the node 
		}
		
	}

	@Override
	public boolean remove(E item) {
		Node<E> currNode = head;
		Node<E> prevNode = head;

		while (currNode != null) {

			if (currNode.data == item) {
				removeNode(currNode, prevNode,currNode.next);
				return true;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}

		return false;
	}

}
