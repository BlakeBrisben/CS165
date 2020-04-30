// HashTable.java - code for hashing assignment
// Author: ?????
// Date:   ?????
// Class:  CS165
// Email:  ?????

import java.util.*;

public class HashTable implements IHash {
    // Method of hashing
    private HashFunction hasher;
    // Hash table : an ArrayList of "buckets", which store the actual strings
    private ArrayList<List<String>> hashTable;
    /**
     * Number of Elements
     */
    private int numberOfElements;
    private int numberOfBuckets;
    int bucket, el;

    /**
     * Initializes a new instance of HashTable.
     * <p>
     * Initialize the instance variables. <br>
     * Note: when initializing the hashTable, make sure to allocate each entry in the HashTable
     *       to a new a HashBucket or null, your choice.
     * @param numberOfBuckets   the size of the hashTable
     * @param hasher the type of hashing function
     */
    public HashTable(int numberOfBuckets, HashFunction hasher) {
        this.numberOfBuckets = numberOfBuckets;
        this.hasher = hasher;
        hashTable = new ArrayList<List<String>>(this.numberOfBuckets);
        for(int i = 0; i < numberOfBuckets; i++)
        {
        	hashTable.add(new ArrayList<String>());
        }
    }

    @Override
    public boolean insert(String key) {
    	int code = hasher.hash(key) % numberOfBuckets;
    	
    	if(search(key) == null)
        {
    		numberOfElements++;
        	
        	hashTable.get(code).add(key);
        
        	return true;
        }
    	
        
    	return false;
    }

    @Override
    public boolean remove(String key) {
    	int code = hasher.hash(key) % numberOfBuckets;
    	
        if(key.equals(search(key)))
        {
        	hashTable.get(code).remove(key);
        	return true;
        }
        else
        	return false;
    	
    	
        
    }

    @Override
    public String search(String key) {
    	
    	int code = hasher.hash(key);
   	
    	if(!hashTable.get(code%numberOfBuckets).equals(null))
    		if(hashTable.get(code%numberOfBuckets).contains(key))
    		return key;
    	
    	return null;
    }

    @Override
    public int size() {
    	return numberOfElements;
    }

    

    // Return iterator for the entire hashTable,
    // must iterate all hashBuckets that are not empty
    public class HashIterator implements Iterator<String> {
        // The current index into the hashTable 
        private int currentIndex;
        // The current iterator for that hashBucket
        private Iterator<String> currentIterator = null;
        
        HashIterator() {
            // YOUR CODE HERE
        	currentIndex = 0;
        	currentIterator = hashTable.get(currentIndex).iterator();
        }

        @Override
        public String next() {
        	try 
        	{
        		return currentIterator.next();
        	}
        	catch(NoSuchElementException e)
        	{
        		
        		currentIndex++;
        		
        		try
        		{
        			while(true)
        			{
	        			if(hashTable.get(currentIndex).size() != 0)
	        			{
	        				currentIterator = hashTable.get(currentIndex).iterator();
	        				return currentIterator.next();
	        			}
	        			else
	        			{
	        				currentIndex++;
	        			}
        			}
        		}
        		catch(Exception w)
        		{
        			throw new IllegalStateException();
        		}
        	}
        	
        }
        @Override
        public boolean hasNext() {
        	int count = currentIndex+1;
        	Iterator<String> check = null;
        	if(currentIterator.hasNext())
        	{
        		return true;
        	}
        	else
        	{
        		while(count < hashTable.size())
        		{
        			check = hashTable.get(count).iterator();
        			if(check.hasNext())
        				return true;
        			
        			count++;
        		}
        		return false;
        		
        	}
        	
        	
        }
    }

    // Return an iterator for the hash table
    @Override
    public Iterator<String> iterator() {
        
        return hashTable.size() != 0 ? new HashIterator() : null;
              		
       
    }

    /**
     * Does not use the iterator above. Iterates over one bucket.
     *
     * @param index the index of bucket to iterate over
     * @return an iterator for that bucket
     */
    @Override
    public Iterator<String> iterator(int index) {
        List<String> bucket = hashTable.get(index);
        return bucket != null ? bucket.iterator() : null;
    }

    // Prints entire hash table.
    // NOTE: This method is used extensively for testing.
    @Override
    public void print() {
        Debug.printf("HashTable size: " + size());

        for (int index = 0; index < hashTable.size(); index++) {
            List<String> list = hashTable.get(index);
            if (list != null) {
                Debug.printf("HashTable[%d]: %d entries", index, list.size());
                for (String word : list) {
                    Debug.printf("String: %s (hash code %d)", word, hasher.hash(word));
                }
            }else {
                Debug.printf("HashTable[%d]: %d entries", index, 0);
            }
        }
    }

	@Override
	public int size(int index) {
        return hashTable.get(index).size();
    }
}
