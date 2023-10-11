package basics;
import java.util.*;

public class TestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "John Doe, John Watson Doe, Jane Perter Parker, Peter Parker, John Peter Doe, Marry Jane-watson, Peter jane Parker, "
				+ "John Travis Doe, Jane Parker, Marry doe Jane-watson, Ram Krishna, Ram hari Krishna, Hari Om-Sai, Hari Shanti Om-Sai";
//		str = new StringBuilder(str).insert(str.length()-2,	2).toString();
//		System.out.println(str);
		String res = solution(str,"Company");
		System.out.println(res);
	}



 public static String solution(String S, String C) {
     String finalResult = "";
     String[] allnames = S.split("[,]",0);
    
     Map<String,Integer> namemap = new HashMap<String,Integer>();


     for(String s: allnames){
         String nameparts[] = s.trim().split(" ");
         int parts =  nameparts.length;
         // int spaces = s.length() - s.replaceAll(" ","").length();
         // System.out.println(s.trim() + " " + nameparts.length + " ");
         String firstname = nameparts[0];
         String lastname="";
         if(parts==3){
             lastname = nameparts[2];
         }else{
             lastname= nameparts[1];
         }

         lastname = lastname.replaceAll("-","");

         // System.out.println(firstname + " "+ lastname);
         String res = firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+C.toLowerCase()+".com";

         if(!namemap.containsKey(res)){
             namemap.put(res,1);
         }else{
            
             int value = namemap.get(res);
             System.out.println("entering here for "+ res + " " + value);
             namemap.put(res,value+1);
             int back = res.length() - C.length() - 1;
             
             System.out.println(back);
             System.out.println(C.length());
             res = new StringBuilder(res).insert(res.length() - C.length() - 5,	namemap.get(res)).toString();
             //  System.out.println("after edit " + res);
         }
         // System.out.println(res);

         finalResult = finalResult+s+" <"+ res+">, ";
     }

     // System.out.println("asdf--------------------------------");
     // for(Map.Entry<String,Integer> entry : namemap.entrySet()){
     //     System.out.println(entry.getKey() + " " + entry.getValue());
     // }
     // System.out.println(finalResult);
     return finalResult.substring(0,finalResult.length()-2);
 }
}
