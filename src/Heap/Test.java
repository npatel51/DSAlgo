package Heap;

public class Test {

	public static void main(String[] args) {

		Heap hp = new Heap();

		hp.insert(8);
		hp.insert(7);
		hp.insert(9);
		hp.insert(4);
		hp.insert(3);
		hp.insert(6);
		hp.insert(5);

		System.out.println(hp);

		while (!hp.isEmpty()) {
			System.out.println(hp);
			hp.poll();
		}

		int[] arr = { 8, 7, 3, 4, 9, 6, 5 };

		hp = new Heap(arr);
		hp.buildMaxHeap();

		while (!hp.isEmpty()) {
			System.out.println(hp);
			hp.poll();
		}

	}

}
