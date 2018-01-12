package List;

public class SinglyLinkedListTest {
	
	public static void println(Object line) {
		System.out.println(line);
	}
	

	public static void main(String[] args) {
	
		SinglyLinkedList<Integer> sll =  new SinglyLinkedList<Integer>();
		sll.add(2);
		sll.add(-9);
		sll.add(8);
		sll.add(4);
		sll.print();
		
		sll.prepend(1);
		sll.print();
		
		sll.append(10);
		sll.print();
		
		sll.prepend(0);
		sll.append(11);
		sll.print();
		
		println("The size of the list is: "+sll.size());
		println("Index of element 9: "+sll.indexOf(-9));
		println("Item at 2: "+sll.itemAt(2));
		println("First element: "+sll.getFirst());
		println("Last element: "+sll.getLast());
		println("Is empty?"+(sll.isEmpty()?"Yes":"No"));
		
		sll.removeFirst();
		println("After removing first item:");
		sll.print();
		
		sll.removeLast();
		println("After removing last item:");
		sll.print();
		
		Integer[] arr = new Integer[sll.size()];
	
		sll.toArray(arr);
		
		for(Integer e:arr)
			System.out.print(e+ " ");
		
		println("");
		
		sll.set(4, 9);
		sll.set(2, 3);
		
		System.out.println(sll);
		
		sll.reverse();
		sll.print();
		
		System.out.println("Item removed: "+sll.remove(1));
		sll.print();
		
		sll.remove((Integer)3);
		sll.print();
		
		for( Integer e : sll ) {
			System.out.print(e+ " ");
		}
		
	
	}

}
