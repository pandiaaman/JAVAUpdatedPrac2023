package DSALogics;

/*
 * complexity : O(2^n)
 * 
 * tower of hanoi contains n no of disks on the source tower
 * it has in total of 3 towers, source, helper and destination
 * our task is to shift all the disks from source to destination
 * a bigger disk can not be kept on top of a smaller disk at any time
 * 
 * solution : if there are two disks : we take 3 steps to shift from source to destination
 * if there are three disks :top two will take 3 to helper, then we put that one to dest and another 3 to put back the 
 * first two disks back on the first so 7 steps
 * 
 * we move n-1 disks at a time,(leaving the first) to the helper, then we put the one on desn, then 
 * again all n-1 back on desn
 */
public class F_TowerOfHanoiRecursion {
	
	public static void main(String[] args) {
		int n=3; // n is the no of disks
		towerOfHanoiSolution(n,"Source","Helper","Desitnation");

	}
	
	public static void towerOfHanoiSolution(int n, String source, String helper, String dest) {
		//base case
		if(n==1) {
			System.out.println("tranfer  final the disk " + n + " from " + source + " to " + dest);
			return;
		}
		
		
		//shifting the top n-1 disks from source to helper
		towerOfHanoiSolution(n-1, source, dest, helper);
		//now transfer that one disk to destination
		System.out.println("tranfer the disk " + n + " from " + source + " to " + dest);
		//putting back those n-1 disks back on the first one
		towerOfHanoiSolution(n-1, helper, source, dest);
		
	}

}
