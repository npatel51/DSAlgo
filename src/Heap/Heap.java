package Heap;

import java.util.Arrays;

public class Heap {

	private int[] heap;
	private int index = -1;

	public boolean isEmpty() {
		return index == -1;
	}
	
	public Heap() {
		heap = new int[11]; // default size
	}

	public Heap(int size) {
		heap = new int[size];
	}

	public Heap(int[] array) {
		heap = Arrays.copyOf(array, array.length);
		index = array.length - 1;
	}

	private int size() {
		return index + 1;
	}

	private int parentIndex(int i) {
		return (int) Math.floor(i / 2);
	}

	private int leftChildIndex(int i) {
		return 2 * i + 1;
	}

	private int rightChildIndex(int i) {
		return 2 * i + 2;
	}

	public int parent(int i) {
		if (i <= 0 || i > size())
			throw new IllegalArgumentException("Invalid index.");
		return heap[(i - 1) / 2];
	}

	public int leftChild(int i) {
		if (i < 0 || i * 2 + 1 > size())
			throw new IllegalArgumentException("Invalid index.");
		return heap[i * 2 + 1];
	}

	public int rightChild(int i) {
		if (i < 0 || i * 2 + 1 > size())
			throw new IllegalArgumentException("Invalid index.");
		return heap[(i + 1) * 2];
	}

	public void buildMaxHeap() {
		for (int i = (int) Math.floor(heap.length / 2); i >= 0; --i) {
			maxHeapify(i);
		}
	}

	public void insert(int data) {
		if (index == heap.length) {
			heap = Arrays.copyOf(heap, this.size() * 2);
		}
		int i = ++index;
		int pIndex = parentIndex(i);

		while (i > 0 && data > heap[pIndex]) {
			heap[i] = heap[pIndex];
			i = pIndex;
			pIndex = parentIndex(i);
		}
		heap[i] = data;
	}

	public void delete() {
		poll();
	}
	// delete the root/head of the heap
	public void poll() {
		// replace root with the last element in the array
		// float down A[0] till the max-heap property is restored
		heap[0] = heap[index];
		heap[index] = 0;
		index--;
		maxHeapify(0);

	}

	private void maxHeapify(int index) {
		int left = leftChildIndex(index);
		int right = rightChildIndex(index);
		int largest = index;

		if (left < this.size() && heap[left] > heap[largest])
			largest = left;
		if (right < this.size() && heap[right] > heap[largest])
			largest = right;

		if (largest != index) {
			swap(index, largest);
			maxHeapify(largest); // recursively swap until max-heap property is reserved
		}
	}

	private void swap(int parentIndex, int largest) {
		int temp = heap[parentIndex];
		heap[parentIndex] = heap[largest];
		heap[largest] = temp;
	}

	public int max() {
		return peek();
	}

	public int peek() {
		return heap[0];
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
