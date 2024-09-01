import java.util.Arrays;
// Do NOT import the java.util.ArrayList class

public class MyArrayList implements MyArrayListInterface {

    private String[] array = new String[10];
    private int size = 0;

    /**
    * Returns the private String array. The String 
    * array should  be a private instance variable
    * but the test cases need access to it so 
    * please return it.
    */
    public String[] getPrivateArray() {
        return array;
    }

    /**
    * Appends the given String to the end of 
    * this list.
    */
    public void add(String str) {
        // create new Array with same length
        String[] newArray = new String[array.length];

        // if array is full, create new Array
        if (size + 1 > newArray.length) {
            // create new Array with 2X length of the original array
            newArray = new String[array.length*2];
        }

        // copy the items in the array to the new array
        System.arraycopy(array, 0, newArray, 0, array.length);

        // add the given string to the end of the original array
        newArray[size] = str;

        //  increase size by 1
        size += 1;

        // copy newarray to array
        array = newArray;
    }

    /**
    * Inserts the given String at the specified 
    * position in this list. Throws 
    * IndexOutOfBoundsException if the index
    * is out of range.
    */
    public void add(int idx, String str) {
        // if index is out of range, throw error
        if (idx > size || idx < 0) {
            throw new IndexOutOfBoundsException("Index " + "is out of bounds!" + size + " " + idx);
        }

        // create new Array with same length
        String[] newArray = new String[array.length];

        // if array is full, create new Array
        if (size + 1 > newArray.length) {
            // create new Array with 2X length of the original array
            newArray = new String[array.length*2];
        }

        // copy the items in the array to the new array with new str in idx
        for (int i=0; i<idx; i++) {
            newArray[i] = array[i];
        }

        newArray[idx] = str;

        for (int i=idx; i<size; i++) {
            newArray[i+1] = array[i];
        }

        // increase size by 1
        size += 1;

        // copy newArray to array
        array = newArray;

    }

    /**
    * Appends all of the elements in items to the 
    * end of this list. Throws NullPointerException
    * if the given MyArrayList is null.
    */
    public void addAll(MyArrayList items) {
        // if given myArray is null, throw error
        if (items == null) {
            throw new NullPointerException("Index" + " is out of bounds!");
        }

        // create new Array with same length
        String[] newArray = new String[array.length];

        // if the array's capacity is not enough, double the length of the array
        while (size + items.size() > array.length) {
            // create new Array with 2X length of the original array
            newArray = new String[array.length*2];
        }        

        // copy the items in the array to the new array
        System.arraycopy(array, 0, newArray, 0, array.length);

        // copy newarray to array
        array = newArray;

        // append all the items to the end of the list
        int index = 0;
        for (int i=size; i<size+items.size(); i++) {
            array[i] = items.get(index);
            index++;
        }

        // increase size by items.length
        size += items.size();
    }

    /**
    * Returns the number of elements in this list.
    */
    public int size() {
        return size;
    }

    /**
    * Returns true if this list contains no elements
    * otherwise it returns false.
    */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }

        return false;
    }

    /**
    * Returns the element at the specified index in 
    * this list. Throws indexOutOfBoundsException 
    * if the index is out of range.
    */
    public String get(int idx) {
        // if out of range, throw error
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("Index" + " is out of bounds!");
        }

        return array[idx];
    }

    /**
    * Replaces the element at the specified position
    * in the list with the given String. Returns  
    * the element previously at the specified 
    * position. Throws IndexOutOfBoundsException if
    * the index is out of range.
    */
    public String set(int idx, String str) {
        // if out of range, throw error
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("Index" + " is out of bounds!");
        }

        // else, replace the element
        String prevItem = array[idx];

        array[idx] = str;
        
        return prevItem;
    }

    /**
    * Removes the element at the specified position 
    * in this list. Shifts any subsequent elements
    * to the left. Returns the element that was 
    * removed from the list. 
    * Throw indexOutOfBoundsException if the index
    * is out of range.
    */
    public String remove(int idx) {
        // if index is out of range, throw error
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException("Index" + " is out of bounds!");
        }

        // store item in idx
        String prevItem = array[idx];

        // make newArray with same length
        //String[] newArray = new String[array.length];
        String[] newArray = new String[size-1];

        // copy array until idx 
        for (int i=0; i<idx; i++) {
            newArray[i] = array[i];
        }

        // copy array after idx
        for (int i=idx+1; i<size; i++) {
            newArray[i-1] = array[i];
        }
        
        // decrease size by 1
        size -= 1;

        // copy newArray to array
        array = newArray;

        return prevItem;
    }


    /**
    * Removes the first occurrence of the specified 
    * element from this list and returns true if it
    * is present. False is returned if the list
    * does not contain the specified element.
    */
    public boolean remove(String str) {
        // for loop to evaluate whether str is present 
        for (int i=0; i<size; i++) {
            // if item is str, remove and return true
            if (array[i].equals(str)) {
                remove(i);
                // unnecessary?
                String[] newArr = new String[array.length*2];
                System.arraycopy(array, 0, newArr, 0, array.length);
                array = newArr;
                // 
                return true;
            }
        }

        // if str was not in the array, return false
        return false;
    }

    /**
    * Returns the index of the first occurrence of
    * the specified String in this list, or -1 if
    * this list does not contain the element.
    */
    public int indexOf(String str) {
        for (int i=0; i<size; i++) {
            // if str is in the array, return the index
            if (array[i].equals(str)) {
                return i;
            }
        }

        // if not, return -1
        return -1;
    }

    /**
    * Returns the index of the last occurrence of
    * the specified String in this list, or -1 if 
    * this list does not contain the element.
    */
    public int lastIndexOf(String str) {
        for (int i=size-1; i>=0; i--) {
            // if str is in the array, return the index
            if (array[i].equals(str)) {
                return i;
            }
        }

        // if not, return -1
        return -1;
    }

    /**
    * Returns true if this list contains the
    * specified String otherwise it returns false.
    */
    public boolean contains(String str) {
        // iterate through the array to find whether list contains str
        for (int i=0; i<size; i++) {
            // if str is in the array, return true
            if (array[i].equals(str)) {
                return true;
            }
        }

        // if not, return false
        return false;
    }

    /**
    * Returns a new MyArrayList that contains a 
    * portion of this list between the specified 
    * fromIndex, inclusive, and toIndex, 
    * exclusive. Throws IndexOutOfBoundsException
    * if the either index is out of range.
    */
    public MyArrayList subList(int fromIndex, int toIndex) {
        // if index is out of range, throw error
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index" + " is out of bounds!" + fromIndex + " " + toIndex);
        }
        // if (fromIndex < 0 || toIndex < 0) {
        //     throw new IllegalArgumentException(fromIndex + " " + toIndex);
        // }

        // make newArray
        MyArrayList newArray = new MyArrayList();

        // cut array into portion
        for (int i=fromIndex; i<toIndex; i++) {
            newArray.add(array[i]);
        }
        
        // if the length is less than 10, trim the array
        // if (newArray.size() < 10) {
        //     newArray.trimToSize();
        // }
        
        return newArray;
    }
    /**
    * Returns a new array containing all of the 
    * elements in this list in proper sequence 
    * (from first to last element). 
    */
    public String[] toArray() {
        // make newArray
        String[] newArray = new String[size];

        // copy items from array to newArray
        System.arraycopy(array, 0, newArray, 0, size);

        return newArray;
    }

    /**
    * Trims the capacity of this instance array  
    * to be the list's current size.
    */
    public void trimToSize() {
        // make newArray
        String[] newArray = new String[size];

        // copy items from array to newArray
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    /**
    * Returns a String containing all the elements 
    * in the list seperated by a comma and a space.
    * The string return is enclosed in square 
    * brackets. For example, [abc, def, ghi]
    */
    public String toString() {
        String str = "[";

        for (int i=0; i<size-1; i++) {
            str += array[i] + ", ";
        }

        str += array[size-1] + "]";

        return str;
    }
  
}
