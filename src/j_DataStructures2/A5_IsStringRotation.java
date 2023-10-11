package j_DataStructures2;

import java.util.Scanner;

/*
 * Write an efficient program to test if two given String is a rotation of each other or not, 
 * e.g. if the given String is "XYZ" and "ZXY" then your function should return true, 
 * but if the input is "XYZ" and "YXZ" then return false.
 */
public class A5_IsStringRotation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the first string");
		String str1 = sc.nextLine();
		
		System.out.println("enter the second string");
		String str2 = sc.nextLine();
		
		StringBuilder sb1 = new StringBuilder(str1);
		StringBuilder sb2 = new StringBuilder(str2);
		sb2.reverse();
		
		if(sb1.toString().equals(sb2.toString())) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
	}
}
