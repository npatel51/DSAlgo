import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 
 * @author Niraj Patel
 * @date  01/07/2018
 */
public class Stack<E> implements Iterable<E>{
	
	private Node<E> top; // top of the stack
	private int size;    //keeps track of the size
	
	public Stack() {
		
	}
	
	private static class Node<E>{
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

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds the new item to the top of the stack
	 * 
	 * @param data - the item to be added to stack
	 * 
	 */

	public void push(E data) {
		if (this.isEmpty()) {
			top = new Node<E>(data, null);
		} else {
			top = new Node<E>(data, top); // the next node of this newly created node is  
		}                                 // the previous node in the stack
		++size;
	}

	/**
	 * Removes the item from the top of the stack by changing the top to
	 * point to the next item in the stack.
	 * 
	 * @throws NoSuchElementException
	 */
	
	public void pop() throws Exception {
		if (this.isEmpty()) {
			throw new NoSuchElementException("Stack has no element to pop!");
		} else {
			top = top.next;
		}
		--size;
	}

	/**
	 * 
	 * @return - the item at the top of the stack without deleting it from the stack.
	 * @throws Exception
	 */
	public E peek() throws Exception {
		if(this.isEmpty())
			throw new Exception("Stack is empty");
		return this.top.data;
	}

	public int size() {
		return size;
	}

	/**
	 * 
	 * @return A nicely formated string to represent stack.
	 */
	public String getString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		Node<E> temp = top;
		
		while(temp.next!=null) {
			sb.append(temp.data+"->");
			temp = temp.next;
		}
		
		sb.append(temp.data+"]");
		return sb.toString();
	}
	
	public String toString() {
		if(this.isEmpty()) {
			return "[ ]";
		}
		return getString();
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator<E>(top);
	}
	
	//Iterator for stack
	
	private class StackIterator<E> implements Iterator<E>{
		Node<E> currNode;
		public StackIterator(Node<E> top) {
			currNode = top;
		}

		@Override
		public boolean hasNext() {
			return currNode!=null;
		}

		@Override
		public E next() {
			if(!hasNext()) throw new NoSuchElementException("Stack has no items.");
			E data = currNode.data;
			currNode = currNode.next;
			return data;
		}

		
	}
}
