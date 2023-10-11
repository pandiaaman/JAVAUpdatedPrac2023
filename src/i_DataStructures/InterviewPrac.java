package i_DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class InterviewPrac {
 public static void main(String[] args) {
//	 System.out.println("ads");
	 //having an interview with an
	 //bi gram : characters adjacent
	 
	 //string, int=> level of gram , p=> no of results :: retruns array top p occuring n gram in descending order of frequency
	 
	 
	 String str = "having an interview with an";
	 
	 int n= 2;
	 int p = 5;
	 
	 List<String> ngramsop = ngram(str, n, p);
	 
	 for(String s : ngramsop) {
		 System.out.println(s);
	 }
 }
 
 public static List<String> ngram(String str, int n, int p){
	 List<String> ngrams = new ArrayList<String>();
	 
	 TreeMap<Integer, String> tm= new TreeMap<Integer, String>();
	 
	 
	 tm.put(1,"ha");
	 
	 String[] strarr = str.split("\\s");
	 for(String s : strarr) {
		 for(int i=0; i<s.length()-n;i++) {
			 String op = s.substring(i, i+n);
			 ngrams.add(op);
		 }
	 }
	 
//	 for(int i=0; i<str.length()-n;i++) {
//		 String op = str.substring(i, i+n);
//		 if(!Pattern.matches("[\\s]{1}[\\w]*", op)) {
//			 ngrams.add(op);
//		 }
//	 }
	 
	 return ngrams;
 }
 
}
