package c_DataStrucutures;

public class Aa_CreateStack<T> {

	int lastElementPointer; //points to the last element in the stack array
	Object[] stackArr; //stack array
	
	//implementing stack using Arrays
	public Aa_CreateStack(){
		stackArr = new Object[11]; //11 is the initial capacity
		this.lastElementPointer = 0;
	}
	
	public Aa_CreateStack(int capacity) {
		super();
		stackArr = new Object[capacity];	
	}
	
	public synchronized T push(T item) {
//		System.out.println("stack length : " + (double)(this.stackArr.length)*2/3);
//		System.out.println("lastElementPointer" + (double)this.lastElementPointer);
		if((double)this.lastElementPointer >=(double)(this.stackArr.length)*2/3) {
			grow();
		}
		stackArr[this.lastElementPointer++] = item;
		return item;
	}
	
	public int grow() {
		System.out.println("has to grow");
		int currentLength = stackArr.length;
		System.out.println("length was " + currentLength);
		currentLength = currentLength*3/2; //increasing the size of the array
		System.out.println("new length " + currentLength);
		Object[] stackArrCopy = new Object[currentLength];
		this.stackArr = stackArrCopy;
		
		return currentLength;
 	}
	
	public synchronized T pop() {
		T poppedItem = null;
		try {
		poppedItem = (T) this.stackArr[--this.lastElementPointer];
		}catch(Exception e) {
			System.out.println("exception : " + e);
		}
		return poppedItem;
	}
	
	public int getSize() {
		return this.lastElementPointer;
	}
	
	public int search(T val) {
		int i = 0;
		while(i < this.lastElementPointer) {
			if(val == (T)this.stackArr[i]) {
				return i+1;
			}
			i++;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		int size = this.getSize();
		return size==0?true:false;
	}
	public String toString() {
		System.out.println("inside tostring : lastelpointer " + this.lastElementPointer);
		int i = 0;
		String res="";
		while(i < this.lastElementPointer) {
			System.out.print(this.stackArr[i] + " ");
			i++;
		}
		System.out.println();
		return res;
	}
	
	public static void main(String[] args) {
		Aa_CreateStack<Integer> stack = new Aa_CreateStack<Integer>();
		
		System.out.println(stack.isEmpty());
		
		System.out.println("size " + stack.getSize());
		stack.push(3);
		System.out.println("size " + stack.getSize());
		stack.push(5);
		System.out.println("size " + stack.getSize());
		stack.push(7);
		System.out.println("size " + stack.getSize());
		stack.push(9);
		System.out.println("size " + stack.getSize());
		stack.push(1);
		System.out.println("size " + stack.getSize());
		
		System.out.println(stack);
		System.out.println(stack.pop());
		
		System.out.println(stack);
		System.out.println("size " + stack.getSize());
		
		System.out.println("searching for element 7 " + stack.search(7));
		
		stack.push(11);
		System.out.println("size " + stack.getSize());
		stack.push(15);
		System.out.println("size " + stack.getSize());
		stack.push(18);
		System.out.println("size " + stack.getSize());
		stack.push(6);
		System.out.println("size " + stack.getSize());
		stack.push(34);
		System.out.println("size " + stack.getSize());
		stack.push(44);
		System.out.println("size " + stack.getSize());
		stack.push(32);
		System.out.println("size " + stack.getSize());
		stack.push(55);
		System.out.println("size " + stack.getSize());
		stack.push(95);
		System.out.println("size " + stack.getSize());
		stack.push(23);
		System.out.println("size " + stack.getSize());
		
		
	}

}
