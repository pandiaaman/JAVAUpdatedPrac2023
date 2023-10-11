package i_DataStructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class JavaStringRevision {

	public static void main(String[] args) throws ParseException {
		System.out.println("stirng");
		
		String str = new String("hello there how are you");
		
		char[] charr = str.toCharArray();
		for(char c : charr) {
			System.out.print(c + ", ");
		}
		
		System.out.println();
		String[] strarr = str.split(" ");
		for(String s : strarr) {
			System.out.print(s + " , ");
		}
		
		System.out.println();
		List<String> strlist = Arrays.asList(strarr);
		strlist.forEach(System.out::print);
		
		System.out.println();
		str = str.trim();
		System.out.println(str.replace('e', 'a'));
		System.out.println(str);
		str = str.concat("??");
		System.out.println(str);
		System.out.println(str.repeat(3));
		System.out.println(str.contains("he"));
		System.out.println(str.indexOf(" "));
		System.out.println(str.substring(5).trim());
		
		char[] ch = new char[] {'a','b','c','d','e','f'};
		String str2 = new String(ch);
		System.out.println(str2);
	
		
		StringBuffer strbuf = new StringBuffer("stringbuffer"); //mutable
		System.out.println(strbuf);
		strbuf.append("here");
		System.out.println(strbuf);
		System.out.println(strbuf.reverse());
		
		String strr1 = "welcome";
		String strr2 = "aman";
		
		System.out.println(strr1.compareTo(strr2));
		System.out.println(strr2.compareTo(strr1));
		
		String num = "23";
		int numm = Integer.parseInt(num);
		System.out.println(numm + 5);
		
		String num2 = String.valueOf(numm);
		System.out.println(num2);
		
		
		//tree map uses comparator
		TreeMap<String, Integer> tmap = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		
		tmap.put("a", 1);
		tmap.put("b", 2);
		tmap.put("c", 3);

		for(Map.Entry<String, Integer> val : tmap.entrySet()) {
			System.out.println(val.getKey() + "=>" + val.getValue());
		}
		
		
		List<Movie> movies = new ArrayList<Movie>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		movies.add(new Movie("adf",formatter.parse("02/11/1997")));
		movies.add(new Movie("basdf",formatter.parse("02/11/1999")));
		movies.add(new Movie("cwer",formatter.parse("02/11/2002")));
		movies.add(new Movie("dgqe",formatter.parse("02/11/2004")));
		movies.add(new Movie("erh",formatter.parse("02/11/1978")));
		movies.add(new Movie("gwer",formatter.parse("02/11/1966")));
		
		Collections.sort(movies);
		
		for(Movie m: movies) {
			System.out.println(m);
		}
		
		
		//regex
		System.out.println(Pattern.matches("\\s", " "));
		System.out.println(Pattern.matches("\\w", "a"));
		System.out.println(Pattern.matches("\\w", "9"));
		System.out.println(Pattern.matches("\\w", "aa"));
		System.out.println(Pattern.matches("\\W", "#"));
		System.out.println(Pattern.matches("\\W", "@"));
		System.out.println(Pattern.matches("\\W", "8"));
		System.out.println(Pattern.matches("\\d", "6"));
		System.out.println(Pattern.matches("\\d", "e"));
		System.out.println(Pattern.matches("\\D", "a"));
		System.out.println(Pattern.matches("\\D", " "));
		
		System.out.println(Pattern.matches("[\\w]*", "asdd45"));
		System.out.println(Pattern.matches("[\\w]*[\\W]{1}", "asd45!"));
		System.out.println(Pattern.matches("[\\w]+[.]*[\\w]+[@]{1}[\\w]+.com", "pandiaaman16@gmail.com"));
		
		
		
		
		
		
	}
}

class Movie implements Comparable<Movie>{
	private String mname;
	private Date releaseDate;
	
	public Movie(String mname, Date releaseDate) {
		this.mname = mname;
		this.releaseDate = releaseDate;
	}
	
	@Override
	public String toString() {
		return "name : " + this.mname + " released :" + this.releaseDate;
	}

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return o.mname.compareTo(this.mname);
	}
}

