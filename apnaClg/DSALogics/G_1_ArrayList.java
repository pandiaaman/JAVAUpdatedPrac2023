package DSALogics;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class G_1_ArrayList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		//since we are making an object of list, we get only the methods that are provided to us by the List interface
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		//this is a proper array list and has all the methods that are provided to us by array list
		
		arrlist.add(2);
		arrlist.add(4);
		arrlist.add(3);
		arrlist.add(1);
		
		System.out.println(arrlist);
		Collections.sort(arrlist);
		System.out.println(arrlist);
		
		arrlist.remove(2);
		System.out.println(arrlist);
		
		arrlist.add(2,4);
		System.out.println(arrlist);
		
		arrlist.set(2, 5);
		System.out.println(arrlist);
		
		System.out.println(arrlist.size());
		
		Collections.sort(arrlist, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2-i1;
			}
		});
		
		System.out.println(arrlist);
		
		Collections.sort(arrlist);
		System.out.println(arrlist);
		
		Collections.sort(arrlist,Collections.reverseOrder());
		System.out.println(arrlist);
		
		
		
		
		Integer[] arr = new Integer[] {1,2,3,4,5,6};
		List<Integer> list2 = new ArrayList<Integer>();
		
		Arrays.sort(arr);
		
		for(int i : arr) {
			list2.add(i);
		}
		
		Collections.sort(list2);
		Collections.frequency(list2, 4);
		
		
		
//		//List<Integer> al =  Arrays.asList(arr);
		List<Integer> al = new ArrayList<Integer>(Arrays.asList(arr));
		
		
		
		
	}

}
