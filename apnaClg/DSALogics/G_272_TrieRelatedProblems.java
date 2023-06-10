package DSALogics;

import DSALogics.G_27_TRIEorKarrayDS.TrieDS;

public class G_272_TrieRelatedProblems {

	
	static class Node{
		Node[] children;
		boolean endOfWord;
		
		public Node() {
			children = new Node[26];
			
			for(int i = 0; i<children.length; i++) {
				children[i] = null;
			}
			
			endOfWord = false;
		}
	}
	
	static class TrieDS{
		
		static Node root = new Node();
		
		public void insert(String str) {
			
			Node currRoot = root;
			
			for(int i=0; i<str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				
				if(currRoot.children[idx] == null) {
					Node newNode = new Node();
					currRoot.children[idx] = newNode;
				}
				
				//eow
				if(i == str.length()-1) {
					currRoot.children[idx].endOfWord = true;
				}
				
				//updating root
				currRoot = currRoot.children[idx];
				
			}
		}
		
		
		public boolean search(String key) {
			Node currRoot = root;
			
			for(int i=0; i<key.length(); i++) {
				int idx = key.charAt(i) - 'a';
				
				if(currRoot.children[idx] == null) {
					return false;
				}
				
				if(i==key.length()-1 && currRoot.children[idx].endOfWord==false) {
					return false;
				}
				
				//updating root
				currRoot = currRoot.children[idx];
			}
			return true;
			
		}
		
		//Q1 : check if there is any word in the given dictionary of words containing the prefix
		public boolean startsWithPrefix(String prefix) {
			
			Node currRoot = root;
			
			for(int i=0; i<prefix.length(); i++) {
				int idx = prefix.charAt(i) - 'a';
				
				if(currRoot.children[idx] == null) {
					return false;
				}
			
				currRoot = currRoot.children[idx];
			}
			return true;
		}
		
	}
	
	
	public static void main(String... args) {
		String[] words = {"apple","app","mango","man","woman","men","women"};

		String prefix1 = "apple";
		String prefix2 = "moon";
		
		TrieDS trie = new TrieDS();
		
		for(String word : words) {
			trie.insert(word);
		}
		
		System.out.println(trie.startsWithPrefix(prefix1));
		System.out.println(trie.startsWithPrefix(prefix2));
	}
	
}
