package c_DataStrucutures;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Na_CreateHashMap<K,V> implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	HashMap<String, Integer> hashMapRef = new HashMap<String, Integer>();
	
	static class Node<K,V> {
		final K key; //since key cant be changed
		V value;
		final int hash;
		Node<K,V> next;
	
		public Node(int hash, K key, V value, Node<K,V> next) {
			this.key = key;
			this.hash = hash;
			this.value = value;
			this.next = next;
		}

		public V getValue() {
			return value;
		}

		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		public Node<K, V> getNext() {
			return next;
		}

		public void setNext(Node<K, V> next) {
			this.next = next;
		}

		public K getKey() {
			return key;
		}

		public int getHash() {
			return hash;
		}
		
		 public final String toString() {
			 return key + "=" + value; 
		 }
		 
		 public final boolean equals(Object o) {
			 if(o == this) {
				 return true;
			 }
			 if(o instanceof Na_CreateHashMap.Node<?,?>) {
				 if(this.getKey().equals(((Na_CreateHashMap.Node<?,?>) o).getKey())) {
					 if(this.getValue().equals(((Na_CreateHashMap.Node<?,?>) o).getValue())) {
						 return true;
					 }
				 }
			 }
			 return false;
		 }
		
	}
	/*
	 * features
	 * --------
	 * hash maps are very much alike hash tables
	 * every element in the map is called an entry (helps in utilizing Map.Entry<p,q> and map.entrySet() methods for traversal)
	 * hash maps store key value pairs, allowing null key and null values (unlike hash table)
	 * hash maps are not synchronized that is they are not thread safe (unlike hash table)
	 * for thread safety, we can use Collections.synchronizedMap()
	 * hash maps do not guarantee to retain the order of the elements (unlike linkedHashMap and TreeMap)
	 * 
	 * internal functionality:
	 * ----------------------
	 * hash maps uses Node<key, value> to store the entries
	 * HashMap stores entries into multiple singly linked lists, called buckets or bins. 
	 * Default number of bins is 16 and it’s always power of 2.
	 * HashMap works on hashing algorithm and uses hashCode() and equals() method on key for get and put operations
	 * HashMap capacity is always power of 2.
	 * 
	 * process
	 * -------
	 * HashMap use singly linked list to store elements, these are called bins or buckets.
	 * put method : 
	 *  When we call put method, hashCode of key is used to determine the bucket that will be used to store the mapping. 
	 *  Once bucket is identified, hashCode is used to check if there is already a key with same hashCode or not.
	 *  If there is an existing key with same hashCode, then equals() method is used on key.
	 *  If equals returns true, then value is overwritten, otherwise a new mapping is made to this singly linked list bucket.
	 *  If there is no key with same hashCode then mapping is inserted into the bucket.
	 * get method:
	 *  again key hashCode is used to determine the bucket to look for the value.
	 *  After bucket is identified, entries are traversed to find out the Entry using hashCode and equals method.
	 *  If match is found, value is returned otherwise null is returned. 
	 *  
	 * There are much more things involved such as hashing algorithm to get the bucket for the key, rehashing of mappings etc.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
