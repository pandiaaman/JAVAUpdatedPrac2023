package DSALogics;
import java.util.Scanner;
public class A_2_ArraysPatterns {
	public static void main(String[] args) {
		//this file helps us to create different patterns using arrays
		Scanner sc = new Scanner(System.in);
		System.out.println("which of the following patterns you want to make \n "
				+ "select from below \n"
				+ "1. square of stars \n"
				+ "2. triangle of stars \n"
				+ "3. pyramid \n"
				+ "4. circle"
				+ "5. ");
		int k=sc.nextInt();
		
		switch(k) {
		case 1:{
			System.out.println("enter the length of the side of square");
			int a = sc.nextInt();
			if(a>0) {
			starssquare(a);
			}
			else {
				System.out.println("please enter a positive value");
			}
			break;
		}
		case 2:{
			System.out.println("enter the base length of the triangle");
			int base=sc.nextInt();
			if(base >0) {
			startriangle(base);
			}
			else {
				System.out.println("values should be positive");
			}
			break;
		}
		case 3:{
			System.out.println("enter the base length of the pyramid");
			int base=sc.nextInt();
			if(base >0) {
			starpyramid(base);
			}
			else {
				System.out.println("values should be positive");
			}
			break;
		}
		case 4:{
			System.out.println("enter the diameter of the circle");
			int diameter = sc.nextInt();
			if(diameter<3) {
				System.out.println("enter the diameter greater than 3");
			}
			else {
				//starcircle(diameter);
			}
			break;
		}
	}
	}
	
	//function to make a square of stars
	public static void starssquare(int a) {
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	//function to make a triangle of stars
	public static void startriangle(int base) {
		for(int i=1;i<=base;i++) {
			for(int k=base-i;k>=0;k--) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void starpyramid(int base) {
		for(int i=1;i<=base;i++) {
			for(int k=base-i;k>0;k--) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for(int i=1;i<=base;i++) {
			for(int k=1;k<=i;k++) {
				System.out.print(" ");
			}
			for(int j=base-i;j>0;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
}
