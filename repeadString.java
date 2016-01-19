package Google;
/*
 * 
 * Google: Write a program to return the longest repeating substring in a string.
Write a program to return the longest repeating substring in a string.
eg. for "ababab", "abab" is the longest repeating substring.
 */
import java.util.*;
/*
 * 一个字符串中 反复出现最长的字符  banana 返回 ana ， banan 返回 an；
 */
public class repeadString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String s = "banana";
         Prefix p = new Prefix();
         for(int i = 0 ; i < s.length() ; i++){
        	 p.add(s.substring(i , s.length()));
         }
         
         System.out.print(p.res.s);
	}
	static class node{
		int len;
		String s;
	}
	static class Prefix{
		PrefixNode root;
		node res ;
		public Prefix(){
			root = new PrefixNode(' ');
			res = new node();
		}
		public void add(String s ){
			root.add(s, 0, res);
		}
	}
    static class PrefixNode{
    	char c;
    	PrefixNode[] nodes = new PrefixNode[256];
    	public PrefixNode(char c ){
    		this.c = c;
    		
    	}
    	public void add(String s , int index , node res){
    		if(index == s.length()) return;
    		char t = s.charAt(index);
    		if(nodes[t ] == null) nodes[t] = new PrefixNode(c);
    		else{
    			if(index > res.len) {
    				res.len = index;
    				res.s = s.substring(0 , index + 1);
    			}
    		}
    		nodes[t].add(s, index + 1 , res);
    	}
    	
    }
}
