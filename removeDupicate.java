package Google;
import java.util.*;
/*
 * 移除相同字符串
 */
public class removeDupicate {
    public static void main(String[] args){
    	String[] s = {"hello" , "ebay" , "hello" , "say" , "eba" , "hel" , "s" , "ebay" };
    	List<String> res = removeDup(s);
    	for(String ss : res){
    		System.out.print(ss + "  ");
    	}
    }
	public static List<String> removeDup(String[] s){
		Trie trie = new Trie();
		List<String> res = new ArrayList<String>();
		for(String tem : s){
			if(!trie.add(tem)) res.add(tem);
		}
		return res;
	}
	
	static class TrieNode{
		char c;
		boolean isEnd;
	    TrieNode[] children = new TrieNode[256];
	    public TrieNode(){
	    	
	    }
	    public TrieNode(char c){
	    	this.c = c;
	    }
	    public boolean add(String s , int index){
	    	if(index == s.length()) {
	    		boolean help = false;
	    		if(isEnd) help = true;
	    		isEnd = true;
	    		return help;
	    	}
	    	char cc = s.charAt(index);
	    	if(children[cc] == null) children[cc] = new TrieNode(cc);
	    	boolean ise = children[cc].add(s, index + 1);
	    	return ise;
	    }
	}
	static class Trie{
		TrieNode root;
		public Trie(){
			root = new TrieNode();
		}
		public boolean add(String s){
			return root.add(s, 0);
		}
	}
}
