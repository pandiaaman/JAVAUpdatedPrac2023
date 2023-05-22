package DSALogics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class F_8_PairingForParty {

	/*
	 * no of ways in which you can invite n people to your party single or in pairs
	 */
	
	public static int callGuests(int n) {
		
		if(n<=1) {
			return 1;
		}
		
		int singleCalls = callGuests(n-1); //since if we call someone single, now we have n-1 more people to call
		
		int pairCalls = (n-1)*callGuests(n-2); //n-1 people if we select one, then need to call from remaining n-2
		
		return pairCalls + singleCalls;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(callGuests(4));
		
		
		
	}

}
