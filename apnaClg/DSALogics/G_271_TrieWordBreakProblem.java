package DSALogics;

public class G_271_TrieWordBreakProblem {
/*
 * given an input string and a dictionary of words, find out if the input string can be broken down
 * into a space separated sequence of dictionary words
 */
	
	static class Node{
		Node[] children;
		boolean endOfWord;
		
		public Node() {
			children = new Node[26];
			
			for(Node node : children) {
				node = null;
			}
			
			endOfWord = false;
		}
	}
	
	static class TrieDS{
		
		static Node root = new Node();
		
		public void insert(String str) {
			
			Node currRoot = root;
			
			for(int i=0;i<str.length();i++) {
				int idx = str.charAt(i) - 'a';
				
				//if nothing is present in the given index in child array then add a new node
				if(currRoot.children[idx] == null) {
					Node newNode = new Node();
					currRoot.children[idx] = newNode;
				}
				
				//if the letter is last letter of word : update endOfWord
				if(i == str.length()-1) {
					currRoot.children[idx].endOfWord = true;
				}
				
				//update root
				currRoot = currRoot.children[idx];
			}
		}
		
		public boolean search(String str) {
			
			Node currRoot = root;
			
			for(int i=0;i<str.length();i++) {
				int idx = str.charAt(i) - 'a';
				
				if(currRoot.children[idx] == null) {
					return false;
				}
				if(i == str.length()-1 && currRoot.children[idx].endOfWord == false) {
					return false;
				}
				//updating root
				currRoot = currRoot.children[idx];
			}
			return true;
		}
		
		
		public boolean wordBreak(String key) {
			//base case : if length of the incoming key is 0 then it should always return true, since an empty string is always present
			if(key.length() == 0) {
				return true;
			}
			
			/*
			 * we use recursion here to break the string into two parts and check if both the parts are present 
			 * in the trie ds or not, we keep breaking the word to search this
			 * break will keep moving and once we find both the strings, then we return true
			 */
			
			for(int i=1; i<=key.length(); i++) {
				String firstPart = key.substring(0,i); //i is not included here
				String secondPart = key.substring(i); // i is included here
				
				if(search(firstPart) && wordBreak(secondPart)) { //recursion call here on the second part of the string
					return true;
				}
				
			}
			return false;
		}
		
		
	}
	public static void main(String[] args) {
		String words[] = {"i","like","sam","samsung","mobile"};
		String key = "ilikesamsung";
		
		TrieDS trie = new TrieDS();
		
		for(String word :  words) {
			trie.insert(word);
		}
		
		boolean wordBreakRes = trie.wordBreak(key);
		System.out.println(wordBreakRes);
	}

}
