import java.util.Arrays;
import java.util.Comparator;

public class MinHeap<E> {
	private E[] heap;
	private int index = -1; // # of items in the heap / pointer to indicate where in the array
	private Comparator<E> comparator;  //comparator to define priorities of an Object

	public MinHeap() {
		heap = (E[])  new Object[11]; //default capacity
	}
	public MinHeap(Comparator<E> comparator) {
		heap = (E[])  new Object[11];
		this.comparator = comparator;
	}
	
	//MinHeap supports following operations: insert(E data), deleteMin(),peek() or min(),isEmpty(), and size()
	public boolean isEmpty() {
		return index == -1;
	}
	public int size() {
		return index + 1;
	}
	public E peek() {
		return min();
	}

	public E min() {
		if(isEmpty()) throw new IllegalArgumentException("Heap is empty!");
		return heap[0];
	}

	public void insert(E item) {
		//increment the pointer for insertion
		++index;
		//ensure the capacity
		if(index  == heap.length) {
			doubleCapacity(heap);
		}
		int childIndex = index;
		int parentIndex = (childIndex-1)/ 2;

		//percolate to maintain the heap invariant, while the item is smaller than
		//its parent item keep exchanging till the conditions are true
		while(childIndex > 0 && smaller(item,heap[parentIndex])) {
			heap[childIndex] = heap[parentIndex];
			childIndex = parentIndex;
			parentIndex = (childIndex-1)/ 2; //calculate the  parent index
		}

		heap[childIndex] = item; //put the item in the array

	}
	private void swap(int childIndex, int parentIndex) {
		E temp =  heap[childIndex];
		heap[childIndex] = heap[parentIndex];
		heap[parentIndex] = temp;
	}

	//if comparator is not defined the items are prioritized based on their natural ordering defined
	private boolean smaller(E item1, E item2) {
		if (comparator == null) {
			return ((Comparable<E>) item1).compareTo(item2) < 0;
		}
		return comparator.compare(item1,item2) < 0;
	}
	//double the size of array
	private void doubleCapacity(E[] heap) {
		this.heap = Arrays.copyOf(heap, heap.length * 2);
	}

	//deletes the root (i.e. the smallest item in the heap)
	public E deleteMin() {
		E ret = heap[0];
		//delete the root and replace it with the last item in the heap
		heap[0] = heap [index];
		heap[index] = null;        //remove the last item as well
		--index;                  // since deleted the last item the index must be decremented
		minHeapify(0);       // min-heapify to restore the min-heap property
		return ret;
	}

	private void minHeapify(int index) {

		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;
		int smallestItem  = index;

		if(leftChildIndex < this.size() && smaller(heap[leftChildIndex], heap[smallestItem])) {
			smallestItem = leftChildIndex;
		}
		if(rightChildIndex < this.size() && smaller(heap[rightChildIndex], heap[smallestItem])) {
			smallestItem = rightChildIndex;
		}

		//if current item is the smallest than its right and left child -- done!
		if(smallestItem != index) {
			swap(smallestItem,index);
			minHeapify(smallestItem);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.size() == 0)
			return "[]";

		sb.append("[ ");

		for (int i = 0; i < this.size(); ++i) {
			sb.append(heap[i] + " ");
		}
		sb.append("]");

		return sb.toString();
	}
}

