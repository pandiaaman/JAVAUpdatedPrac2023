package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B_Streams {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		List<Integer> als = new ArrayList<Integer>(); //upcasting
		als.add(1);
		
		List<Integer> ial = Arrays.asList(2,3,4,5,6);
		
		als.addAll(ial);
		
		//printing list using streams
		als.stream().forEach(System.out::println);
		
		List<Integer> ialupdated = ial.stream().map(x->x*2).collect(Collectors.toList());
		ialupdated.forEach(System.out::println);
		
		
		int[] iar = new int[] {1,2,3,4,5,6};
		//converting int[] to List<Integer>
		List<Integer> iarl = Arrays.stream(iar).boxed().collect(Collectors.toList());
		iarl.forEach(System.out::println);
		
		List<Integer> nums = Arrays.asList(1,2,5,4,3,6,8,7);
		
		nums.stream().map(x->x*2).forEach(System.out::println);
		nums.stream().map(x->x*2).forEach(x->System.out.println(x));
		
		List<Integer> numstimes2 = nums.stream().map(x->x*2).collect(Collectors.toList());
		
		/*
		 * streams cant be consumed again after being used once
		 */
		
		Stream<Integer> numsStream = nums.stream();
		//numsStream.forEach(System.out::println);
		
		//above the stream has been consumed, so we can not use it again
		try { //will throw IllegalStateException if above line 43 is uncommented
			//showing how we can use multiple stream methods one after other
			numsStream.map(x->x).filter(x->x%2==0).map(x->x*x).sorted().collect(Collectors.toList()).forEach(System.out::println); 
		}catch(IllegalStateException e) {
			System.out.println("error :" + e);
			e.printStackTrace();
		}
		
		
		/*
		 * filter takes in a method of type Predicate, which is a functional interface, having the method test inside it, that returns
		 * 	true or false
		 * 
		 */
		
		//lets say we want to pass a predicate into the filter method of our choice that has multiple requirements
			//predicate is a functional interface so we create a anonymous inner class for it
		
		Predicate<Integer> predi = new Predicate<Integer>(){
			//test is an abstract method present inside this functional interface that must be declared
			@Override
			public boolean test(Integer t) {
				// lets say an integer is filtered on the basis that if the sum of digits is 5
				int sum = 0;
				while(t>0) {
					int r = t%10;
					sum += r;
					t /= 10;
				}
				if(sum == 5) {
					return true;
				}
				return false;
			}
		}; //anonymous inner classes are statements hence must end with ;
		
		//lets use the above created predicate
		
		List<Integer> arrList = Arrays.asList(123,203,122,348,983,100,500,410,320,473);
		arrList.stream().filter(predi).forEach(System.out::println); //prints only the values whose digits sum to 5
		
		//lets use lambda expression to write the above predicate
		Predicate<Integer> prediLambda = /*new Predicate<Integer>() {
			@Override
			public boolean test*/ /*(Integer */t/*)*/ -> {
				int sum = 0;
				while(t>0) {
					int r = t%10;
					sum += r;
					t/= 10;
				}
				if(sum == 5) {
					return true;
				}
				return false;
			};		
//		};
		
		//predicate as a lambda expression for filtering even numbers
		Predicate<Integer> predLambdaEven = t -> t%2==0; //thats it
			
	
		/*
		 * similarly map uses Function as an input, which is a functional interface that has the method apply in it
		 */
		Function<Integer,Integer> func = new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer t) {
				// returns the square
				return t*t;
			}
		};
		
		List<Integer> numsMap = Arrays.asList(2,3,4,5);
		numsMap.stream().map(func).forEach(System.out::println);
		
		//function for map using lambda
		Function<Integer,Integer> funcSqLambda = t -> t*t;
		
		/*
		 * reduce : in big data we have map and reduce
		 * we use reduce to conclude the whole stream to one single value
		 * that value can be a list
		 */
		
		List<Integer> numsRed = Arrays.asList(1,3,4,5,6,3,4,5,2);
		int sumOfSquaresOfEvenValues = numsRed.stream().filter(x->x%2==0).map(x->x*x).reduce(0, (a,b)->a+b);
		System.out.println(sumOfSquaresOfEvenValues);
		System.out.println(32+36+4);
		
		
		
		/*
		 * stack and heap in java : 
		 * 
		 */
		
			
		long endTime = System.currentTimeMillis();
		System.out.println("time taken : " + (endTime - startTime));
	}

}
