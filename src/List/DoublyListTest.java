package List;

public class DoublyListTest {
	
	public static void println(Object line) {
		System.out.println(line);
	}
	public static void main(String[] args) {
	 DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
	 
	 	dll.add(2);
		dll.add(-9);
		dll.add(8);
		dll.add(4);
		dll.print();
		
		dll.prepend(1);
		dll.print();
		
		dll.append(10);
		dll.print();
		
		dll.prepend(0);
		dll.append(11);
		dll.print();
		
		println("The size of the list is: "+dll.size());
		println("Index of element 9: "+dll.indexOf(-9));
		println("Item at 2: "+dll.itemAt(2));
		println("First element: "+dll.getFirst());
		println("Last element: "+dll.getLast());
		println("Is empty?"+(dll.isEmpty()?"Yes":"No"));
		
		dll.removeFirst();
		println("After removing first item:");
		dll.print();
		
		dll.removeLast();
		println("After removing last item:");
		dll.print();
		
		
		System.out.println("Set method test");
		for(int i=0;i<dll.size();++i) {
			dll.set(i, i+1);
		}
		//toString method gets invoked
		System.out.println(dll);
		
		dll.reverse();
		dll.print();
	
		println("After removing item at spefied index: ");
		dll.remove(5);
		dll.print();
		
		
		println("After removing item from the list: ");
		dll.remove((Integer)5);
		dll.print();
		
		while(dll.size()!=0) {
			dll.removeLast();
		}
		
		dll.print();
	 
	}

}
