/**
 * This IntegerSet is a representation of a set of unordered distinct integers.
 * An array will be used to represent this set.
 * 
 * @author USER
 * 
 */
public class IntegerSet {
	/**
	 * The array that representing a set. This element, once initialized, holds
	 * the set property at all time.
	 */
	int[] element;

	/**
	 * Create a new IntegerSet from a set provided. The new set will have the
	 * same elements as the set provided.
	 * 
	 * @param set
	 */
	public IntegerSet(IntegerSet set) {
		// create an array with the same size
		this.element = new int[set.element.length];

		// copy all elements
		for (int i = 0; i < this.element.length; i++)
			this.element[i] = set.element[i];
	}

	/**
	 * Create an integer set from the array provided. If the array has many
	 * element with the same value, initialize the set's element with only the
	 * distinct array's elements.
	 * 
	 * @param array
	 *            original array
	 */
	public IntegerSet(int[] array) {
		// check that array exists
		if (array == null)
			return;
		if (array.length < 2) {
			element = array;
			return;
		}
		java.util.Arrays.sort(array);
		// copy all elements
		int[] tmp = new int[array.length];
		tmp[0] = array[0];
		int i = 1, j = 1;
		while (i < array.length) {
			// only copy if an adjacant element different
			if (array[i] != array[i - 1]) {
				tmp[j] = array[i];
				j++;
			}
			i++;
		}
		element = java.util.Arrays.copyOf(tmp, j);
	}

	/**
	 * This method will check that the array provided is considered a set or
	 * not. An array is considered a set if all of its elements are distinct.
	 * 
	 * @para data an array of integer to test for a set property
	 * @return true if this array is a set, and false otherwise.
	 */
	public static boolean isASet(int[] data) {
		if (data.length == 0)
			return false;
		java.util.Arrays.sort(data);
		for (int i = 0; i < data.length - 1; ++i) {
			if (data[i] == data[i + 1])
				return false;
		}
		return true;
	}

	/**
	 * This method will check that the number is a member of this set or not.
	 * 
	 * @param number
	 *            an integer to check
	 * @return true if the number is a member of this set, and false otherwise.
	 */
	public boolean isMember(int number) {
		return false;
	}

	/**
	 * Check that this set is empty or not
	 * 
	 * @return true if this set is empty, and false otherwise
	 */
	public boolean isEmpty() {
		if (this.element.length == 0)
			return true;
		else
			return false;
	}

	/**
	 * Check whether this IntegerSet is a subset of the set provided. Set A is a
	 * subset of B if all elements in A are in B.
	 * 
	 * @param set
	 *            the set provided.
	 * @return true if this IntegerSet is a subset of the set provided, and
	 *         false otherwise.
	 */
	public boolean isSubsetOf(IntegerSet set) {
		return false;
	}

	/**
	 * Check whether this IntegerSet is equal to the set provided. Two set is
	 * considered to be equal if they are subset of each other.
	 * 
	 * @param set
	 *            the set provided.
	 * @return true if both set are equal, and false otherwise.
	 */
	public boolean equals(IntegerSet set) {
		if (set.isEmpty())
			return false;
		if (this.element.length != set.element.length)
			return false;
		for (int i = 0; i < element.length; ++i) {
			if (element[i] != set.element[i])
				return false;
		}
		return true;
	}

	/**
	 * Union this IntegerSet with the set provided, the result is a new
	 * IntegerSet which all of its elements are member of this IntegerSet or the
	 * provided set.
	 * 
	 * @param set
	 *            the set provided.
	 * @return new IntegerSet that is the result from union
	 */
	public IntegerSet union(IntegerSet set) {
		return null;
	}

	/**
	 * Intersect this IntegerSet with the set provided, the result is a new
	 * IntegerSet which all of it elements are member of this IntegerSet and the
	 * provided set.
	 * 
	 * @param set
	 *            the set provided
	 * @return new IntegerSet that is the result from intersection
	 */
	public IntegerSet intersect(IntegerSet set) {
		return null;
	}
	
	public int getMin(){
		if(element.length == 0){
			throw new NullPointerException();
		}
		else{
			return element[0];
		}
	}

	public int getMax(){
		if(element.length == 0){
			throw new NullPointerException();
		}
		else{
			return element[element.length-1];
		}
	}
}
