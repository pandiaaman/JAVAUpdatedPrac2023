package javaIntro;

public class PatternQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();
		
		//solid rectangle
		System.out.println("solid rectangle");
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		//hollow rectangle
		System.out.println("hollow rectangle");
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				
				if((i<4 && i>=1) && (j<4 && j>=1)) {
					System.out.print("  ");
				}
				else {
				System.out.print("* ");
				}
			}
			System.out.println();
		}
		
		//hollow rectangle 2
		System.out.println("hollow rectangle 2");
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					
					if(i==0 || i==4 || j==0 || j==4) {
						System.out.print("* ");
					}
					else {
						System.out.print("  ");
					}
				}
			System.out.println();
		}
		
		
		//half pyramid
		System.out.println("half pyramid");
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		//half pyramid inverted
		System.out.println("inverted half pyramid");
		for(int i=4;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		//inverted half pyramid rotated by 180
		System.out.println("inverted half pyramid rotated by 180inverted half pyramid rotated by 180");
		for(int i=5;i>1;i--) {
			int j;
			for(j=1;j<i-1;j++) {
				System.out.print(" ");
			}
			for(int k=j; k<=4;k++) {
				System.out.print("*");
			}
//			for(int k=j;j<=5;k++) {
//				System.out.println("# ");
//			}
			System.out.println();
		}
		
		
		System.out.println("inverted half pyramid rotated by 180inverted half pyramid rotated by 180  2");
		for(int i=1;i<=5;i++) {
			for(int k=0;k<(5-i);k++) {
				System.out.print("  ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		//half pyramid with numbers
		System.out.println("half pyramid with numbers");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("inverted half pyramid with numbers");
		for(int i=5; i>0; i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("inverted half pyramid with numbers 2");
		/*
		 * 	i	j	n=5
		 * -------
		 * 	1	5	j=n-i+1
		 * 	2	4
		 * 	3	3
		 * 	4	2
		 * 	5	1
		 */
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=(5-i+1);j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		
		System.out.println("floyd's triangle");
		int k=1;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(k++ + "\t");
			}
			System.out.println();
		}
		
		System.out.println("0-1 triangle");
		k = 0;
		for(int i=1;i<5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(k + " ");
				if(k==0) {
					k=1;
				}else {
					k=0;
				}
			}
			System.out.println();
		}
		
		System.out.println("0-1 triangle 2");
		for(int i=1;i<5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print((i+j)%2==0?"0 ":"1 ");
			}
			System.out.println();
		}
		
		
		System.out.println("butterfly pattern");
		int n= 5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			for(int k1=2*(n-i);k1>0;k1--) {
				System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			for(int k1=0;k1<2*(n-i);k1++) {
				System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		System.out.println("solid rhombus");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int l=1;l<=5;l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		System.out.println("hollow rhombus");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=5;j++) {		
				if(j>1 && j<5 && i!=1 && i!=n) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		System.out.println("number pyramid");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		
		System.out.println("palindrome pattern");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=i;j>=1;j--) {
				System.out.print(j);
			}
			for(int j=2;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		/*
		 * i	j
		 * 1	1	i+0
		 * 2	3	i+1
		 * 3	5	i+2
		 * 4	7	i+3
		 * 5	9
		 */
		
		System.out.println("diamond pattern");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			for(int j=2;j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		System.out.println("diamond pattern with 2*i-1");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=n-1;i>=1;i--) {
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("time taken : " + (endTime - startTime) );
		
	}

}
