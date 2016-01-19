package Google;
import java.util.*;

public class Dijkstra {
	public static void main(String[] args){
		verNode root = buildMap();
		HashMap<verNode , Integer> path = shortPath(root);
		for(verNode node: path.keySet()){
			System.out.println(node.val + ":" + path.get(node) );
		}
	}
   public static verNode buildMap(){
	   verNode root = new verNode(0);
	   verNode r1 = new verNode(1);
	   verNode r2 = new verNode(2);
	   verNode r3 = new verNode(3);
	   verNode r4 = new verNode(4);
	   verNode r5 = new verNode(5);
	   edge e1 = new edge(10 , root , r2);
	   edge e2 = new edge(30 , root , r4);
	   edge e3 = new edge(100 , root , r5);
	   root.list.add(e1);
	   root.list.add(e2);
	   root.list.add(e3);
	   
	   edge e4 = new edge(10 , r3 , r5);
	   r3.list.add(e4);
	   
	   edge e5  = new edge(60 , r4 , r5);
	   edge e6 = new edge(20 , r4 , r3);
	   r4.list.add(e5);
	   r4.list.add(e6);
	   
	   edge e7 = new edge(5 , r1 , r2);
	   edge e8 = new edge(50 , r2 , r3);
	   
	   r2.list.add(e8);
	   r1.list.add(e7);
	  
	  
	   return root;
   }
   public static HashMap<verNode , Integer> shortPath(verNode root){
	   //List<Integer> res = new ArrayList<Integer>();
	   HashMap<verNode , Integer> path = new HashMap<verNode , Integer>();
	   HashMap<verNode , Boolean> map = new HashMap<verNode, Boolean>();
	   verNode cur = root;
	   DFS(cur , path);
	   path.put(cur, 0);
	   //map.put(cur, true);
	   while(cur != null){
		   verNode minpath = null;
		   int minvalue = Integer.MAX_VALUE;
		   for(verNode node : path.keySet()){
			   if(!map.containsKey(node)){
				   if(path.get(node) < minvalue){
					   minvalue = path.get(node);
					   minpath = node;
				   }
			   }
		   }
		   if(minpath == null) break;
		   map.put(minpath, true);
		   for(edge egd : minpath.list){
			   if(!map.containsKey(egd.to) && path.get(egd.to) > minvalue + egd.weight){
				   path.put(egd.to, minvalue + egd.weight);
			   }
		   }
		   
		   //map.put(null, null);
	   }
	   
	   return path;
   }
   public static void DFS(verNode cur , HashMap<verNode , Integer> path){
	   if(cur == null) return;
	   path.put(cur, Integer.MAX_VALUE);
	   for(edge node :  cur.list){
		   verNode next = node.to;
		   if(!path.containsKey(next)){
			   DFS(next , path);
		   }
	   }
   }
}
class verNode{
	int val;
	List<edge> list;
	public verNode(int val){
		list = new ArrayList<edge>();
		this.val = val;
	}
}
class edge{
	verNode from;
	verNode to;
	int weight;
	public edge(int weight , verNode from , verNode to){
		this.weight = weight;
		this.from = from ; 
		this.to = to;
	}
}
