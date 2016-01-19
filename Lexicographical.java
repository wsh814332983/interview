package Google;
import java.util.*;
/*
 * 给你个sort好的字符串array寻找 这些char的排列循序  不一定是 abcd 这样的循序
 */
public class Lexicographical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"ze", "yxf", "xd", "wd", "vd", "ua", "tt", "sz", "rd",
				  "qd", "pz", "op", "nw", "mt", "ln", "ko", "jm", "il",
				  "ho", "gk", "fa", "ed", "dg", "ct", "bb", "ba"
				  };
		HashMap<Character , Graphnode> map = buildMap(s);
		List<Character> res = topsort(map);
		
		for(Character c :  res){
			System.out.print(c + " ");
		}
	}
	public static HashMap<Character , Graphnode> buildMap(String[] s){
		HashMap<Character , Graphnode> res = new HashMap<Character , Graphnode>();
		for(int i = 0 ; i < s.length - 1 ; i++){
			String s1 = s[i];
			String s2 = s[i + 1];
			int index = 0;
			while(index < s1.length()){
				if(s1.charAt(index) != s2.charAt(index)){
					Graphnode t2 = null;
					if(res.containsKey(s2.charAt(index))) t2 = res.get(s2.charAt(index));
					else {
						t2 = new Graphnode(s2.charAt(index));
						res.put(s2.charAt(index), t2);
					}
					if(res.containsKey(s1.charAt(index))){
						res.get(s1.charAt(index)).addNode(t2);
					}else{
						res.put(s1.charAt(index), new Graphnode(s1.charAt(index)));
						res.get(s1.charAt(index)).addNode(t2);
					}
					break;
				}
				index++;
			}
			
		}
		return res;
	}
	public static List<Character> topsort(HashMap<Character , Graphnode> graph){
		List<Character> res = new ArrayList<Character>();
		boolean[] vis = new boolean[26];
		Stack<Character> stack = new Stack<Character>();
		for(Graphnode node : graph.values()){
			if(vis[node.c - 'a']) continue;
			vis[node.c - 'a'] = true;
			DFS(node , vis , stack);
		}
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
	}
   public static void DFS(Graphnode node , boolean[] vis , Stack<Character> stack){
	   for(Graphnode tem : node.children.values()){
		   if(vis[tem.c - 'a']) continue;
		   vis[tem.c - 'a'] = true;
		   //System.out.print(tem.c);
		   DFS(tem , vis , stack);
	   }
	   stack.push(node.c);
   }
}
class Graphnode{
	char c;
	HashMap<Character , Graphnode> children;
	public Graphnode(char c){
		children = new HashMap<Character , Graphnode>();
		this.c = c;
	}
	public void addNode(char node){
		if(children.containsKey(node)) return;
		children.put(node, new Graphnode(node));
	}
	public void addNode(Graphnode node){
		if(children.containsKey(node.c)) return;
		children.put(node.c, node);
	}
}
