package Google;
import java.util.*;
/*
 * 建图后 层打印
 */
public class printPairSet {
   public static void main(String[] args){
	   Dpair p1 = new Dpair("a" , "b");
	   Dpair p2 = new Dpair("a" , "d");
	   Dpair p3 = new Dpair("b" , "c");
	   Dpair p4 = new Dpair("d" , "e");
	   Dpair p5 = new Dpair("d" , "f");
	   Dpair p6 = new Dpair("d" , "g");
	   Set<Dpair> st = new HashSet<Dpair>();
	   st.add(p5);
	   st.add(p2);
	   st.add(p6);
	   st.add(p4);
	   st.add(p3);
	   st.add(p1);
	   print(st);
   }
   public static void print(Set<Dpair> pair){
	   ddddnode node = buildTree(pair);
	   print(node , 0);
   }
   public static void print(ddddnode node , int level){
	   for(int i = 0 ; i < level ; i++){
		   System.out.print(" ");
	   }
	   System.out.println(node.s);
	   for(ddddnode n :node.nodes){
		   print(n , level + 1);
	   }
   }
   public static ddddnode buildTree(Set<Dpair> set){
	   HashMap<String , ddddnode> map = new HashMap<String , ddddnode>();
	   for(Dpair pair : set){
		   String f = pair.first;
		   String se = pair.second;
		   ddddnode first = null;
		   ddddnode second = null;
		   if(map.containsKey(f)){
			   first = map.get(f);
		   }else{
			   first = new ddddnode(f);
			   first.isHead = true;
			   map.put(f, first);
		   }
		   if(map.containsKey(se)){
			   second = map.get(se);
			   second.isHead = false;
		   }else{
			   second = new ddddnode(se);
			   second.isHead = false;
			   map.put(se, second);
		   }
		   first.nodes.add(second);
	   }
	   ddddnode res = null;
	   for(ddddnode node : map.values()){
		   if(node.isHead) res = node;
	   }
	   return res;
   }
}
class Dpair{
	String first;
	String second;
	public Dpair(String first , String second){
		this.first = first;
		this.second = second;
	}
}
class ddddnode{
	boolean isHead;
	String s;
	List<ddddnode> nodes;
	public ddddnode(String s){
		this.s = s;
		nodes = new ArrayList<ddddnode>();
	}
}
