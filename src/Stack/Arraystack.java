/**
 * 
 * @author Niraj Patel
 * @date  01/07/2018
 */
public class Arraystack{

	/**
	 * A stack is an unordered collection of item where the addition and removal can
	 * only take place from one end ( the top ). The most recently added item is the
	 * one that is need to be removed first from the stack, also refereed as LIFO
	 * (last in first out), newer items are near to the top and older items are near
	 * to the base. All stack operation takes O(1)
	 * 
	 * 
	 * Array based stack implementation is not ideal stack implementation as it
	 * requires O(n) (copy old array into new array) in case of overflow.
	 * 
	 * @param args
	 */

	final static int MAX_SIZE = 101;
	private static int[] stack = new int[MAX_SIZE];
	private static int top = -1; // initially the stack is empty

	/**
	 * Adds the new item to the top of the stack
	 * 
	 * @param value
	 *            - the item to be added to stack
	 * @throws Exception
	 */

	public static void push(int value) throws Exception{
		top++;
		if (top == MAX_SIZE - 1) {
			System.out.println("Stacck Overflow!");
			throw new Exception("Stack Overflow!");
		}
		stack[top] = value;
	}

	/**
	 * Removes the item from the top of the stack by decrementing top. No need to
	 * update value since it will be overwritten anyway.
	 * 
	 * @throws Exception
	 */
	

	public static void pop()throws Exception{
		if (top == -1) {
			System.out.println("Stack is empty: no element to pop");
			throw new Exception("Stack is empty: no element to pop.");
		}
		top--;
	}
	
	/**
	 * Returns the item at the top of the stack. Does not modify the stack. 
	 * @return - the top item from the stack
	 */
	
	
	public static int peek() throws Exception{
		if(top == -1) {
			System.out.println("Stack is empty");
			throw new Exception("Stack is empty!");
		}
		
		return stack[top];
	}
	
	
	/**
	 * Returns boolean value indicating whether the stack is empty or not.
	 * 
	 * @return true if list is empty,false otherwise.
	 */
	
	public static boolean isEmpty() {
		return top==-1;
	}
	
	/**
	 * Returns the size of the stack
	 * @return - the number of elements in the stack
	 */
	
	public static int size() {
		return top+1;
	}
	
	/**
	 * Prints the items in stack from top to bottom
	 */
	
	public static void print() {
		
		if(isEmpty()) {
			System.out.println("[ ]");
			return ;
		}
		System.out.print("[");
		
		for(int i=top;i>0;--i) {
			System.out.print(stack[i]+",");
		}
		
		System.out.println(stack[0]+"]");
	}
	
	public void testStack() throws Exception {
		//push item on stack
				/**
				 *  
			 	 * |______|
				 * |______|
				 * |______|
				 * |______|
				 * |______|
				 * |______|
				 * 
				 * empty stack
				 */
			
				push(5);
				push(6);
				push(11);
				push(2017);
				
				print();
			
				/**
				 *  After pushing elements on stack 
				 *  
				 * |______|
				 * |______|
				 * |_2017_|
				 * |__11__|
				 * |__6___|
				 * |__5___|
				 */
				
				System.out.println(peek()); //the top item from the stack: 2017
				
				pop(); // remove the top item 2017
				
				/**
				 *  After pushing elements on stack 
				 *  
				 * |______|
				 * |______|
				 * |______|
				 * |__11__|
				 * |__6___|
				 * |__5___|
				 */
				
				System.out.println("After pop() :"+peek());
				print();
				
				//remove all elements until the stack isn't empty
				
				while(!isEmpty()) {
					pop();
				}
			
				print();
				
	}
	

	public static void main(String[] args) throws Exception{
		

		//testing Stack class
		
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(5);
		s.push(7);
		s.push(2017);
		System.out.println(s);
		
		System.out.println("The first item fromt the stack is "+s.peek());
		
		s.pop();
		System.out.println(s); 
		System.out.println("Is the list empty? "+(s.isEmpty()?"Yes":"No"));
		
		while(!s.isEmpty()) {
			s.pop();
		}
		
		
		System.out.println("Is the list empty? "+(s.isEmpty()?"Yes":"No"));
		
		Stack<Character> cs = new Stack<Character>();
		
		cs.push('D');
		cs.push('C');
		cs.push('B');
		cs.push('A');
		
		System.out.println(cs);
		
		System.out.println("The first item from the stack is "+cs.peek());
		
		for(Character c : cs)
			System.out.println(c+ " ");
		
		System.out.println("Is the list empty? "+(s.isEmpty()?"Yes":"No"));
		
	}

}
