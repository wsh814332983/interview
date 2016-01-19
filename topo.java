package Google;
import java.util.*;
public class topo {
	public static void main(String[] args){
		char[][] board = { 
				{'a' , 'b'},
				{'a' , 'a'},
		};
		String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
		List<String> s = findWords(board , words);
		for(String t : s){
			System.out.println(t);
		}
	}
	public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String s : words){
            trie.insert(s);
        }
        Set<String> list = new HashSet<String>();
        boolean[][] vis = new boolean[board.length][board[0].length];;
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                DFS(trie.root , 0 , board , i , j  , list , vis);
            }
        }
        List<String> res = new ArrayList<String>();
        for(String s : list){
            res.add(s);
        }
        return res;
    }
    public static void DFS(TrieNode node , int len , char[][] board , int row , int col ,  Set<String> list , boolean[][] vis){
    	 
    	if(vis[row][col]) return;
    	if(node.isEnd ){
    	   
           list.add(node.s);
           return;
       } 
      
       
       
       vis[row][col] = true;
       if(node.contains(board[row][col])){
           if(row + 1 < board.length) DFS(node.getNode(board[row][col]) , len + 1 , board , row + 1 , col , list , vis);
           if(row - 1 >= 0 ) DFS(node.getNode(board[row][col]) , len + 1 , board , row - 1 , col , list , vis);
           if(col + 1 < board[0].length) DFS(node.getNode(board[row][col]) , len + 1 , board , row , col + 1 , list , vis);
           if(col - 1 >= 0) DFS(node.getNode(board[row][col]) , len + 1 , board , row , col - 1 , list , vis);
       }
       vis[row][col] = false;
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String s){
        root.insert(s , 0);
    }
    
}
class TrieNode{
    HashMap<Character , TrieNode> children = new HashMap<Character , TrieNode>();
    boolean isEnd;
    String s;
    public void insert(String s , int index){
        if(index == s.length()){
            isEnd = true;
            this.s = s;
           
            return;
        }
        char c = s.charAt(index);
        if(!children.containsKey(c)){
            children.put(c , new TrieNode());
        }
        children.get(c).insert(s , index + 1);
    }
    public TrieNode getNode(char c){
        return children.get(c);
    }
    public boolean contains(char c){
        if(children.containsKey(c)) return true;
        return false;
    }
   }