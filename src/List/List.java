package List;

public interface List<E> {

	/**
	 * Appends item at the end of the list
	 * 
	 * @param data
	 *            - item to add to the list
	 */

	public void add(E data);

	/**
	 * Clears the list
	 */
	public void clear();

	/**
	 * Print the data of the list in a sequence
	 */
	public void print();

	/**
	 * Return the item at specified index, if index is not within the range return
	 * -1
	 * 
	 * @param index
	 * @return the item at the given index
	 */
	public E itemAt(int index);

	/**
	 * The last element in the list, without removing it
	 * 
	 * @return - the top item in the list
	 */
	public E getFirst();

	/**
	 * The last element in the list, without removing it
	 * 
	 * @return - the last item in the list
	 */
	public E getLast();

	/**
	 * Removes the first item from the list,updates the head.
	 */
	public void removeFirst();

	/**
	 * Removes the last item from the list,updates the tail.
	 */
	public void removeLast();

	/**
	 * Remove the item at specified index and return it's value if item is in the
	 * list
	 * 
	 * @param index
	 *            - the index of the item to be removed from the list.
	 * @return - null if the item is not in the list, else the element removed
	 */
	public E remove(int index);

	/**
	 * Remove the first occurrence of the given item from the list.
	 * 
	 * @param item
	 *            - the item that needs to be removed
	 * @return - true if item is not present in the list, otherwise false
	 */
	public boolean remove(E item);

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element.
	 * 
	 * @param data
	 *            - item to be searched
	 * @return - the index of given item, if not available returns -1
	 */
	public int indexOf(E data);

	/**
	 * Returns an array containing all of the elements in this list in sequence; the
	 * runtime type of the returned array is that of the specified array.
	 * 
	 * @param array
	 *            - the array to be filled with the list item
	 * @return - the array filled with data from the list in a sequential order.
	 */
	public E[] toArray(E[] array);

	/**
	 * Returns boolean value true/false depending on list status.
	 * 
	 * @return- true if list is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Total element/item in the list
	 * 
	 * @return - the size of the list
	 */
	public int size();

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 *            - the index that needs to be updated
	 * @param element
	 *            - the item to be replaced at the specified position
	 */

	public void set(int index, E element);

	/**
	 * Reverse the list - reverse the order of item in which the occurs.
	 */
	public void reverse();




}
