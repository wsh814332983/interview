package Google;
/*
 * 
 * 第一个轮是给一个字符串，比如{a,b}xy{c,d,e}，返回所有的combination，也就是axyc, axyd,
axye, bxyc, bxyd, bxye
 */
import java.util.*;
public class comString {
   public static void main(String[] args){
	    String s = "{a,b}xy{c,d,e}";
	    List<String> res =  get(s , 0 , s.length() - 1);
	    for(String ss : res){
	    	System.out.print(ss + " ");
	    }
   }
   public static List<String> get(String s , int index , int right){
	   int left = index , count = 0;
	   List<String> res = new ArrayList<String>();
	   while(index <= right){
		   char c = s.charAt(index);
		   if(c == '{') {
			   count++;
		   }
		   else if(c == '}'){
			   count--;
			   if(count == 0){
				   List<String> tem = get(s , left + 1 , index - 1);
				   left = index + 1;
				   while(index <= right && s.charAt(index) != '{' && s.charAt(index) != ',') index++;
				   String kk = s.substring(left , index);
				   if(res.size() != 0){
					   List<String> help = new ArrayList<String>();
					   for(String s1 : res){
						   for(String s2 : tem){
							   help.add(s1 + s2 + kk);
						   }
					   }
					   res = help;
				   }else{
					   for(String s1 : tem){
						   res.add(s1 + kk);
					   }
				   }
				   if(index > right) break;
				   left = s.charAt(index) == '{' ? index  : index + 1;
				   if(s.charAt(index) == '{') index--;
			   }
		   }else if(count == 0){
			   while(index <= right && s.charAt(index) != '{' && s.charAt(index) != ',') index++;
			   String kk = s.substring(left , index);
			   res.add(kk);
			   if(index > right) break;
			   left = s.charAt(index) == '{' ? index  : index + 1;
			   if(s.charAt(index) == '{') index--;
		   }
		   index++;
	   }
	   return res;
   }
}
