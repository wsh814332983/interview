package Google;
/*
 * 没有相同字母的两个字符串乘积最大
 */
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class wordProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String[] s = {"abc" , "bcd" , "ooo" , "pqs" , "k"};
       System.out.print(getproduct(s));
       
   }
	
	public static int getproduct(String[] words){
		Comparator<String> com = new Comparator<String>(){
			@Override
			public int compare(String a , String b){
				return b.length() - a.length();
			}
		};
		Arrays.sort(words , com);
		node[] nodes = new node[words.length];
		int index = 0;
		for(String s : words){
			nodes[index] = new node(s);
			index++;
		}
		int res = 0;
		for(int i = 0 ; i < words.length ; i++){
			node f = nodes[i];
			for(int j = i + 1 ; j < words.length ; j++){
				node l = nodes[j];
				if((f.map & l.map) != 0) continue;
				if(f.s.length() * l.s.length() > res){
					res = f.s.length() * l.s.length();
					break;
				}
			}
		}
		return res;
	}
   static class node{
	   String s;
	   int map;
	   public node(String s){
		   this.s = s;
		   map = get(s);
	   }
	   public int get(String s){
		   int res = 0;
		   for(int i = 0 ; i < s.length() ; i++){
			   int c = s.charAt(i) - 'a';
			   res |= (1 << c);
		   }
		   return res;
	   }
   }
}
