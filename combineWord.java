package Google;

import java.util.*;
/*
 * 给一个字符array  把里面string组合能够形成长word   danc 和 nce 或者 danc 和 e 可以组合成dance。。。
 */

public class combineWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String[] s = {
        	"danc" , "ce" , "hell" , "ello" , "worl" , "d" , "dancesss",	 
         };
         String[] ss = {
        	"dance" , "hello" , "helloworld" , "world",	 
         };
         
         Trie trie = new Trie();
         for(String t : s){
        	 trie.add(t);
         }
         Comparator<String> com = new Comparator<String>(){
        	@Override
        	public int compare(String a , String b){
        		return a.length() - b.length();
        	}
         };
         Arrays.sort(ss , com);
         String res = "";
         for(String t : ss){
        	 //System.out.println(t);
        	 if(trie.combina(t)){
        		 //System.out.println("1" + t);
        		 res = t;
        		 //System.out.println(res);
        	 }
         }
         
         System.out.print(res);
	}
	static class Trie{
		prefixNode prefix;
		suffixNode suffix;
		public Trie(){
			prefix = new prefixNode(' ');
			suffix = new suffixNode(' ');
		}
		public void add(String s){
			prefix.add(s, 0);
			suffix.add(s , 0);
		}
		public boolean combina(String s){
			int left = prefix.match(s, 0);
			int right = suffix.match(s, 0);
			if(left == - 1 || right == -1 || left + right < s.length()) return false;
			add(s);
			return true;
		}
	}
	static class prefixNode{
		char c;
		boolean isEnd;
		prefixNode[] nodes = new prefixNode[256];
		public prefixNode(char c){
			this.c = c;
		}
		public void add(String s , int index){
			if(index == s.length() ) {
				isEnd = true;
				return;
			}
			char tem = s.charAt(index);
			//prefixNode node = null;
			if(nodes[tem - 'a'] == null){
				nodes[tem - 'a'] = new prefixNode(tem);
			}
			nodes[tem - 'a'].add(s, index + 1);
		}
		public int match(String s , int index){
			if(index == s.length() ) return index;
			char tem = s.charAt(index);
			if(nodes[tem - 'a'] == null && !isEnd) return -1;
			else if(nodes[tem - 'a'] == null && isEnd) return index;
			return nodes[tem - 'a'].match(s,  index + 1);
		}
	}
	static class suffixNode{
		char c;
		boolean isEnd;
		suffixNode[] nodes = new suffixNode[256];
		public suffixNode(char c){
			this.c = c;
		}
		public void add(String s , int index){
			if(index == s.length()) {
				isEnd = true;
				return;
			}
			char tem = s.charAt(s.length() - index - 1);
			//prefixNode node = null;
			if(nodes[tem - 'a'] == null){
				nodes[tem - 'a'] = new suffixNode(tem);
			}
			nodes[tem - 'a'].add(s, index + 1);
		}
		public int match(String s , int index){
			if(index == s.length() ) return index;
			char tem = s.charAt(s.length() - index - 1);
			if(nodes[tem - 'a'] == null && !isEnd) return -1;
			else if(nodes[tem - 'a'] == null && isEnd) return index;
			return nodes[tem - 'a'].match(s,  index + 1);
		}
	}

}
