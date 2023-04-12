package i_DataStructures;

public class C_UsingDynamicArray {

	public static void main(String[] args) {
		C_DynamicArray darr = new C_DynamicArray(8);
		
		System.out.println("size in beginning : " + darr.getSize());
		System.out.println("capacity in beginning : " + darr.getCapacity());
		
		darr.add("aman");
		darr.add("anisha");
		darr.add("ayaz");
		darr.add("kaju");
		darr.add("sanchit");
		
		darr.insert("sourav", 2);	
		darr.insert("vaibhav", 6);
		
		try {
		darr.insert("lol", 12);
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		darr.deleteData("vaibhav");
		darr.deleteData("pop");
		
		darr.deleteIndex(2);
		
		System.out.printf("%n");
		System.out.println("current size : " + darr.getSize());
		System.out.println("current capacity : " + darr.getCapacity());
		
		darr.add("anand");
		darr.add("kunal");
		darr.add("sumit");
		
		darr.add("aanchal");
		
		int search = darr.searchData("sumit");
		System.out.println(search);
		
		System.out.printf("%n");
		System.out.println(darr);
		System.out.println("current size : " + darr.getSize());
		System.out.println("current capacity : " + darr.getCapacity());

		
		C_DynamicArray darrInt = new C_DynamicArray(5);
		
		System.out.println("size in beginning : " + darrInt.getSize());
		System.out.println("capacity in beginning : " + darrInt.getCapacity());
		
		darrInt.add(1);
		darrInt.add(5);
		darrInt.add(8);
		
		System.out.println(darrInt);
		
	}

}
