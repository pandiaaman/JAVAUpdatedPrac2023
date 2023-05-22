package DSALogics;

public class G_11_ArrayListImpl<T> {

	static class ArrayList<T>{
		
		//variables
		private Object[] array;
		private int size;
		private float capacity;
		
		//constructors
		public ArrayList(){
			this.array = new Object[10];
			this.size = 0;
			this.capacity = 0.75f;
		}
		
		public ArrayList(int size) {
			this();
			array = new Object[size];
		}
		
		public ArrayList(int size, float capacity) {
			this(size);
			this.capacity = capacity;
		}
		
		//no explicit setters for size and capacity
		//getters
		public int size() {
			return this.size;
		}
		
		public float capacity() {
			return this.capacity;
		}
		
		//add(T val)
		public boolean add(T val) {
			//grow
			
			return addAt(size, val);
			
		}
		
		//addAt(int index, T val)
		public boolean addAt(int index, T val) {
			
			if(index <-1 || index > this.size) {
				return false;
			}
			//grow
			if(this.size >= this.capacity*(this.array.length)) {
				grow();
			}
			for(int i=this.size; i>index;i--) {
				this.array[i] = this.array[i-1];
			}
			this.array[index] = val;
			this.size++;
			return true;
		}
		
		//remove(T val)
		public boolean remove(T val) {
			//removes the first occurance of the value
			for(int i=0;i<this.size;i++) {
				if(val.equals(this.array[i])) {
					removeAt(i);
					return true;
				}
			}
			return false;
			
		}
		
		//removeAt(int index)
		public boolean removeAt(int index) {
			
			if(index < -1 || index > this.size) {
				return false;
			}
			//shrink
			if(this.size < 3*(this.array.length)) {
				shrink();
			}
			
			for(int i= index; i<=this.size;i++) {
				this.array[i] = this.array[i+1];
			}
			this.size--;
			return true;
		}
		
		//get(int index)
		public T get(int index) {
			
			T val = (T)this.array[index];
			
			return val;
		}
		
		//set(int index, T val) //updates the value without changing size
		public boolean set(int index, T val) {
			
			this.array[index] = val;
			
			return true;
		}
		
		//grow()
		public void grow() {
			
			int newSize = 3*(this.array.length)/2;
			
			Object[] tempArr = new Object[newSize];
			
			for(int i=0;i<size;i++) {
				tempArr[i] = this.array[i];
			}
			
			this.array = tempArr;
			
		}
		
		//shrink()
		public void shrink() {
			
			int newSize = 4*(this.array.length)/5;
			
			Object[] tempArr = new Object[newSize];
			
			for(int i=0;i<size;i++) {
				tempArr[i] = this.array[i];
			}
			
			this.array = tempArr;
		}
		
		//tostring
		public String toString() {
			String res = "[";
			
			for(int i=0; i<this.size; i++) {
				res+=this.array[i] + ", ";
			}
			res = res.substring(0,res.length()-2);
			return res+"]";
		}
		
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arrlist = new G_11_ArrayListImpl.ArrayList<Integer>();

		arrlist.add(2);
		arrlist.add(5);
		arrlist.add(8);
		
		System.out.println(arrlist.size());
		System.out.println(arrlist);
		
		arrlist.set(1, 44);
		System.out.println(arrlist);
		
		arrlist.addAt(2, 4);
		System.out.println(arrlist);
	
		arrlist.remove(4);
		System.out.println(arrlist);
	}

}
