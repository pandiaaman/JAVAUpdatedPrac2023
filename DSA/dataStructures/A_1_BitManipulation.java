package dataStructures;

public class A_1_BitManipulation {

	public static void main(String[] args) {
		System.out.println("bit manipulation");
		
		//to write a binary number in java : 0b
		int number = 0b0010101; //21
		System.out.println(number);
		
	//last bit of an odd decimal number is always 1 and of an even number is always 0
		int n = 8;
		System.out.println(n&1); //to check if the number is EVEN or ODD
		
		if((n&1) == 0) {
			//if no is even
			System.out.println("no is even");
		}
		
	//to calculate the number of digits in a given decimal number : log10(n)+1
		int p = 12534568;
		System.out.println("no of digits in p : " + (int)(Math.log10(p)+1));
		
	//number of bits in a binary number : log2(n)+1
		int b = 7; //0111
		System.out.println("no of bits in b : " + (int)(Math.log(b)+1));
		
	//swapping two numbers
		int a1 = 7;
		int a2 = 4;
		System.out.println("before swapping : a1 " + a1 + " and a2 " + a2);
		a1 = a1^a2;
		a2 = a1^a2;
		a1 = a1^a2;
		System.out.println("after swapping : a1 " + a1 + " and a2 " + a2);
		
	//find the ith bit
		//to find the 5th bit, right shift by 5 and check if no is having last bit as 1 or 0 using the odd even concept
		int n1 = 79; // 01001111
		//to find 7th bit (7-1)
		int n7 = n1>>6;
		System.out.println("to check if bit is 0 or 1 : " + (n7&1));
		
	//better way to find the ith bit
		//left shift 1 by i times and & with the number
		int n1lsby7 = 1<<6;
		int res = n1&n1lsby7;
		System.out.println(res>>6);
		
		
	//set ith bit : by setting we mean always make the bit 1
		//if 0 then 1, if 1 then 1 : OR with 1
		int n2 = 7; //0111
		//set 4th bit
		int n1lsby4 = 1<<3; //1000 //bit starts from 0 so thats why to left shift 1 by 4 we use 3
		System.out.println((n2|n1lsby4));
		
		
	//calculate the no of set bits
	//i) we will right shift by 1 till the time no is 0 and check if the last bit is 1 or 0
		int n3 = 73; //1001001
		int countsetbits1 = 0;
		while(n3!=0) {
			
			if((n3&1)==1)
				countsetbits1++;
			n3 = n3>>1;
		}
		System.out.println(countsetbits1);
		
	//ii) n&(n-1) ************* IMPORTANT
		n3 = 73;
		int countsetbits2 = 0;
		while(n3!=0) {
			n3 = n3&(n3-1);
			countsetbits2++;
		}
		System.out.println(countsetbits2);
		
		
	//find the no of bits to change for conversion of a to b
		int a9 = 44; //101100
		int b9 = 54; //110110
		
		//to check the different bits use XOR
		int ab9 = a9^b9; //contains 1 at all the bits which are different
		//now to calculate the no of bits to be changed => use n&(n-1) on ab9
		int changebits = 0;
		while(ab9!=0) {
			ab9 = ab9&(ab9-1);
			changebits++;
		}
		System.out.println("no of bits to change " + changebits);
		
	//find if the no is power of 2 : 
		int isPowerOf2 = 256;
		//n&n-1 removes the latest set bit(1) from the binary,
		//if the no is power of 2, then it must have only 1 set bit
		if((isPowerOf2&(isPowerOf2-1)) == 0) {
			System.out.println("yes its power of two");
		}
		
	}
}
