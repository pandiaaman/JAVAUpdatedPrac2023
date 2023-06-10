package DSALogics;
import java.util.*;

public class G_26_HashMapImplementation<K,V> {
	
	static class Node<K,V>{
		K key;
		V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	static class HashMapImpl<K,V>{
		
		
		int n; // n is the no of total elements or total nodes
		int N; // N is the no of buckets in the array
		
		private LinkedList<Node<K,V>>[] buckets;
		
		//constructor
		public HashMapImpl() {
			this.N = 4;
			for(int i=0;i<N;i++) {
				buckets[i] = new LinkedList<Node<K,V>>();
			}
		}
		
		private int hashFunction(K key) {
			//using the hashCode method, it also generates negative values, hence taking absolute
			return (Math.abs(key.hashCode()) % this.N); //taking remainder using N(no of buckets in array) since we want the value
														//to be between 0 and N-1
		}
		
		private void rehash() {
			LinkedList<Node<K,V>>[] oldBuckets = this.buckets;
			
			this.N = this.N*2;
			this.buckets = new LinkedList [this.N];
			
			for(int i=0;i<this.N*2;i++) {
				buckets[i] = new LinkedList<Node<K,V>>();
			}
			for(int i = 0; i<oldBuckets.length; i++) {
				LinkedList<Node<K,V>> ll = oldBuckets[i];
				
				buckets[i] = (LinkedList<Node<K, V>>) ll.clone();
//				for(int j=0; j<ll.size(); j++) {
//					Node<K,V> node = ll.get(j);
//					put(node.key, node.value);
//				}
			}
		}
		
		public void checkRehash(){
			double lambda = this.n/this.N;
			if(lambda > 2.0) { //2.0 is the value of K
				//rehashing
				rehash();
			}
		}
		
		public void put(K key, V value) {
			int bucketIndex = hashFunction(key); //hashFunction is a hashing method, that takes key as input and gives the bucket index
			LinkedList<Node<K,V>> listOnIndex = this.buckets[bucketIndex];
			//checking if the key exists in the list
			for(Node<K,V> node : listOnIndex) {
				if(key.equals(node.key)) { //if key exists then update
					node.value = value;
					checkRehash();
					return;
				}
			}
			//if key does not exist
			Node<K,V> node = new Node<K,V>(key, value);
			listOnIndex.add(node); //adding the new node to the list
			this.n++;
			checkRehash();
			
			
		}

		public void printMap() {
			for(int i=0; i<this.N; i++) {
				LinkedList<Node<K,V>> listAtIndex = this.buckets[i];
				for(Node<K,V> node : listAtIndex) {
					System.out.print(node.key + " -> " + node.value);
					System.out.println();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		HashMapImpl<String, Integer> map = new HashMapImpl<String, Integer>();
		map.put("India", 130);
		map.put("China", 200);
		map.put("US", 50);
		map.put("Russia", 56);
		
		map.printMap();
	}
	
}
