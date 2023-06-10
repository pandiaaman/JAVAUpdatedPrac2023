package basics;

public class Z_CreatingSQLQueries {

	public static void main(String[] args) {
//		generateRandomName();
		//insert into students(sfname,slname,scontact,sage,classid) values('x','asd','867',17,6);
		System.out.println("insert into students(sfname,slname,scontact,sage,classid,smarksone,smarkstwo,smarksthree,smarksfour,smarksfive,smarkssix) "
				+ "values");
		for(int i=1; i<=8; i++) {
			for(int j=1; j<=20; j++) {
				System.out.println("('"+ generateRandomName() +"',"
						+ "'"+ generateRandomName() +"',"
						+ "'91" + ((int)(8045 + Math.random()*(9999-8046))) + "',"
						+ ((int)((i+5) + Math.random()*((i + 3-1)+1))) +","
						+ i + ","
						+ ((int)(10 + Math.random()*(50-10 + 1))) + ","
						+ ((int)(10 + Math.random()*(50-10 + 1))) + ","
						+ ((int)(10 + Math.random()*(50-10 + 1))) + ","
						+ ((int)(10 + Math.random()*(50-10 + 1))) + ","
						+ ((int)(10 + Math.random()*(50-10 + 1))) + ","
						+ ((int)(10 + Math.random()*(50-10 + 1))) + ""
						+ "),");
			}
		}
	}
	
	public static StringBuffer generateRandomName() {
		int n = (int)( 3 + Math.random()*(9-3+1));
		StringBuffer name = new StringBuffer("");
		
//		System.out.println((char)90); //65-90
		for(int i=0;i<n;i++) {
			int val = (int)(65 + Math.random()*(90-65+1));
			char ch = (char) val;
			name.append(ch);
		}
		
		
		
		return name;
	}

}
