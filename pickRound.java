package Google;
/*
 * 拳击比赛 求出所有的每轮对阵
 */
import java.util.*;
public class pickRound {
	static class Node{
		char a , b;
		public Node(char a , char b){
			this.a = a;
			this.b = b;
		}
	}
   public static void main(String[] args){
	  
	  List<Character> nums = new ArrayList<Character>( Arrays.asList('A' , 'B' , 'C' , 'D' ));
	  List<List<Node>> ls = getRound(nums);
	  for(List<Node> no : ls){
		  for(Node node : no){
			  System.out.print(node.a + "," + node.b + " ");
		  }
		  System.out.print("\n");
		  PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		 
	  }
   }
   public static List<List<Node>> getRound(List<Character> nums ){
	   List<List<Node>> res = new ArrayList<List<Node>>();
	   if(nums.size() == 0) return res;
	   if(nums.size() == 2) {
		   Node node = new Node(nums.get(0) , nums.get(1));
		   List<Node> tem = new ArrayList<Node>();
		   tem.add(node);
		   res.add(tem);
		   return res;
	   }
	   if(nums.size() % 2 == 1){
		   for(int i = 0 ; i < nums.size() ; i++){
			   List<Character> h = new ArrayList<Character>(nums);
			   h.remove(i);
			   List<List<Node>> tt  = getRound(h);
			   for(List<Node> ls : tt){
				   ls.add(new Node(nums.get(i) , '.'));
				   res.add(ls);
			   }
		   }
		   return res;
	   }
		   for(int j = 1 ; j < nums.size() ; j++){
			   List<Character> h = new ArrayList<Character>(nums);
			   h.remove(j);
			   h.remove(0);
			   List<List<Node>> tt  = getRound(h);
			   for(List<Node> ls : tt){
				   ls.add(new Node(nums.get(0) , nums.get(j)));
				   res.add(ls);
			   }
		   
	   }
	   return res;
   }
}
