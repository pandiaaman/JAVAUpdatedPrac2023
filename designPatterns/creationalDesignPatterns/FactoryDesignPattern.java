package creationalDesignPatterns;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * 
 */

interface Vehicle{
	public void driveVehicle();
}

class Car implements Vehicle{

	private int tyres = 4;
	
	public Car() {
		System.out.println("car created");
	}
	
	@Override
	public void driveVehicle() {
		// TODO Auto-generated method stub
		System.out.println("car drives on " + tyres + " tyres");
	}
	
}

class Bike implements Vehicle{

	private int tyres = 2;
	
	public Bike() {
		System.out.println("bike created");
	}
	
	@Override
	public void driveVehicle() {
		// TODO Auto-generated method stub
		System.out.println("bike drives on " + tyres + " tyres");
	}
	
}

class VehicleFactory{
	private static Vehicle vehicle;
	
	public static Vehicle getVechicle(String in) {
		if(in.equals("car")) {
			vehicle = new Car();
		}
		if(in.equals("bike")) {
			vehicle = new Bike();
		}
		
		return vehicle;
	}
}


public class FactoryDesignPattern {

	public static void main(String... args) throws NullPointerException {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = new Date();
		System.out.println(df.format(date));
		
		System.out.println("enter the vehicle you want to create");
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		
		Vehicle vehicle = VehicleFactory.getVechicle(in);
		
		
		vehicle.driveVehicle();
	}
}
