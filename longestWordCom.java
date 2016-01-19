package Google;

import java.util.*;
/*
 * set中能组成最大的map中得单词
 */

public class longestWordCom {
  public static void main(String[] args){
	  List<String> map = new ArrayList<String>();
	  Set<String> set = new HashSet<String>();
	  map.add("word");
	  map.add("two");
	  map.add("helloword");
	  map.add("careercup");
	  map.add("onetwo");
	  set.add("two");
	  set.add("career");
	  set.add("cup");
	  //System.out.print(help(set , "careercup"));
	  System.out.print(find(set , map));
  }
  public static String find(Set<String> set , List<String> map){
	  Comparator<String> com = new Comparator<String>(){
		@Override
		public int compare(String a , String b){
			return a.length() - b.length();
		}
	  };
	  Collections.sort(map , com);
	  int min = Integer.MAX_VALUE;
	  for(String s : set){
		  int l = s.length();
		  if(l < min){
			  min = l;
		  }
	  }
	  for(int i = map.size() - 1 ; i >= 0 ; i--){
		  if(map.get(i).length() < min ) return "";
		  if(help(set , map.get(i))) {
			  return map.get(i);
		  }
	  }
	  return "";
  }
  public static boolean help(Set<String> set , String s){
	  boolean[] help = new boolean[s.length() + 1];
	  help[0] = true;
	  int index = 0;
	  while(index < s.length()){
		  for(int i = index + 1 ; i <= s.length() ; i++){
			  String tem = s.substring(index , i);
			  if(set.contains(tem) && help[index]){
				  help[i] = true;
			  }
		  }
		  index++;
	  }
	  return help[s.length()];
  }
}
