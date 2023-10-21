package A_intro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

interface NormalInterfaceEx{
	
	public int calcSum(ArrayList<Integer> arr);
	
	//static methods are allowed
	public static void printHello() {
		System.out.println("hello");
	}
	
	//default methods are allowed
	public default void printHi() {
		System.out.println("hi");
	}
}

interface NarkerInterfaceEx{
	//no methods
}

@FunctionalInterface
interface FunctionalInterfaceEx{
	//ONLY one method
	public int calcProd(ArrayList<Integer>arr);
	
	//static methods are allowed
	public static void printHello() {
		System.out.println("hello");
	}
}

class CheckFuncInterface implements FunctionalInterfaceEx{
	String name;
	ArrayList<Integer> arr;
	@Override
	public int calcProd(ArrayList<Integer> arr) {
		return arr.stream().reduce(1, (res, val) -> res*val);
	}
}

class VehicleOne{
	String name;
	String year;
	int value;
	
	public VehicleOne(String name, String year,int value) {
		this.name = name;
		this.year = year;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "VehicleOne [name=" + name + ", year=" + year + "]";
	}
	
	public int runVehicle() {
		System.out.println("running0");
		return 1;
	}
	
}

public class A2_Keywords {
	
//	(){
//		System.out.println("anonymous function");
//	}

	public static void main(String[] args) {
		System.out.println("hello there");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		
		String dateOne = df.format(new Date());
		VehicleOne car = new VehicleOne("toyota",dateOne,4);
		VehicleOne car2 = new VehicleOne("honda", dateOne,5);
		VehicleOne car3 = new VehicleOne("merc", dateOne,1);
		System.out.println(car);
		
		//using var keyword from java 10
		var value = car.runVehicle();
		
		System.out.println(value);
		
		//streams in java 8
		//filter map reduce
		streamsExample();
		
		List<VehicleOne> vehicleList = Arrays.asList(car, car2, car3);
		
//		String nameConcat = vehicleList.stream().reduce("", () -> )
		int sumValue = vehicleList.stream().map(VehicleOne::getValue).reduce(0, Integer::sum);
		System.out.println(sumValue);
		
		//lambda expression to call the functional interface
		FunctionalInterfaceEx funInt = (ArrayList<Integer>arr) -> {
			return arr.stream().reduce(1, (res, val) -> res*val);
		};
		
		funInt.calcProd(new ArrayList<Integer>());
		
	}
	
	public static void streamsExample() {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(7);
		
		List<Integer> listStream = intList.stream().filter(x -> x%2==0).collect(Collectors.toList());
		
		listStream.forEach(x -> System.out.println(x));
		
		intList.stream().map(x -> x*x).forEach(x -> System.out.println(x));
		
		int sum = intList.stream().reduce(0, (total,x )-> total+x);
		System.out.println(sum);
	
		NormalInterfaceEx.printHello();
		
		
	}
	
}
