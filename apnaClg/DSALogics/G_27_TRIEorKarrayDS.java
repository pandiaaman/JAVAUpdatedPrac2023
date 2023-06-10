package DSALogics;
/*
 * TRIE is also called retrieval tree 
 * its like a binary search tree but with k no of possible children for each node, unlike the binary tree, that can have two children
 * it is generally used to store strings in case we have large string data sets
 * it gives us the search time complexity of O(word length) which is way better than O(log n) provided by BST or RED BLACK TREE OR AVL TREE
 */
public class G_27_TRIEorKarrayDS {

	
	static class Node{
		Node[] children;
		boolean endOfWord;
		
		public Node() {
			//the children array stores what the next letter is, it is initialized with null and the next letter is not null
			children = new Node[26]; //taking in information from a to z in the array
			for(int i=0;i<children.length;i++) {
				children[i] = null;
			}
			//endOfWord is false and becomes true when the upcoming node in the branch is end of word for some word
			endOfWord = false;
		}
	}
	
	static class TrieDS{
		//defining the root node, which is always null in TRIE, as its only job is to take us to the other words
		static Node root = new Node();
		
		public void printRootChildrenTemp() {
			for(int i=0;i<root.children.length;i++) {
				System.out.println(root.children[i] + " " + i);
			}
		}
		public void insert(String word) {
//			System.out.println("inserting word " + word);
//			int level = 0;
//			printRootChildrenTemp();
			
			Node currRoot = root; //putting root value in currRoot since root is static and we should not update it
			
			//traversing through each letter of the word
			for(int i=0; i<word.length(); i++) {
//				System.out.println("inserting " + word.charAt(i));
				//check if the letter exists in the children array of the root node
				int idx = word.charAt(i) - 'a';
				
				if(currRoot.children[idx] == null) { // - 'a' means we are getting the index for each character
					//add new node
					currRoot.children[idx] = new Node();
//					System.out.println("created node at " + idx + " at level " + level);
				}
				//checking if the letter is the last letter in the word
				if(i == word.length() - 1) {
					currRoot.children[idx].endOfWord = true; //the child that we are adding furhter is the last element
				}
				
				//updating the root value
				currRoot = currRoot.children[idx];
//				level++;
			}
			
		}
		
		public void search(String word) {
			//to search is very much similar to the insertion process
			//first we check if the letter is present in the children of the root node, if not then word not present, 
			//if present then we go furhter to next letter, when we reach last letter of our word, we check if the 
			//endofword is set to true, if yes then word is present else not
			
			Node currRoot = root;
			
			for(int i=0; i<word.length();i++) {
//				System.out.println("checking letter " + word.charAt(i));
				int idx = word.charAt(i) - 'a';
//				System.out.println("index is " + idx);
				
				if(currRoot.children[idx] == null) {
					System.out.println("root.children[idx] == null : not present");
					return;
				}
				else { //root has a child node at index idx
					if(i == word.length()-1) { //check if this the end of the word
						if(currRoot.children[idx].endOfWord == true) {
							System.out.println("present");
						}else {
							System.out.println("not present reached last");
							return;
						}
					}
					//updating root to the next child
					currRoot = currRoot.children[idx];
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		String[] words = {"the", "there", "a", "their", "any"};

		TrieDS trie = new TrieDS();
		
		for(String word : words) {
			trie.insert(word);
		}
		trie.printRootChildrenTemp();
		trie.search("any");
		trie.search("an");
	}

}
