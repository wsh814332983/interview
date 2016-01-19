package Google;
/*
 * 在a最短的win里面  含有b所有字符 并且是按b的循序出现。 求这win最小值
 */
import java.util.*;

public class minWinInOrder {
   public static void main(String[] args){
	   String s = "bcabdrcdytbdcaad";
	   String b = "bcd";
	   System.out.print(getMin(s , b));
   }
   public static int getMin(String s , String b){
	   HashMap<Character , List<Integer>> map = new HashMap<Character , List<Integer>>();
	   for(int i = 0 ; i < s.length() ; i++){
		   char c = s.charAt(i);
		   if(! map.containsKey(c)){
			   map.put(c, new ArrayList<Integer>());
		   }
		   map.get(c).add(i);
	   }
	   List<List<Integer>> ls = new ArrayList<List<Integer>>();
	   for(int i = 0 ; i < b.length() ; i++){
		   ls.add(map.get(b.charAt(i)));
	   }
	   int res = s.length();
	   for(int i = 0 ; i < ls.get(0).size() ; i++){
		   int head = ls.get(0).get(i);
		   int left = head;
		   for(int j = 1 ; j < ls.size() ; j++){
			   int index = 0;
			   List<Integer> help = ls.get(j);
			   while(index < help.size() && help.get(index) < head) index++;
			   if(index == help.size()) break;
			   head = help.get(index);
			   if(j == ls.size() - 1){
				   if(head - left + 1 < res) res = head - left + 1;
			   }
		   }
	   }
	   return res;
   }
}
