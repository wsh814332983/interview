package Google;

import java.util.*;
/*
 * 求最长等差数列
 */
public class equlsub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int[] nums = {4 ,3 ,5 ,8, 10 , 9 , 11 , 10 , 13 , 18 , 13 , 23};
          Node res = get(nums);
        //  System.out.print(res.len);
          for(Node n : res.map.get(5)){
        	  System.out.print(n.val + " ");
          }
	}
	public static Node get(int[] nums){
		
		List<Node> list = new ArrayList<Node>();
		for(int i = 0 ; i < nums.length ; i++){
			Node tem = new Node(nums[i] , 1);
			for(int j = 0 ; j < i ; j++){
				Node h = list.get(j);
				int diff = nums[i] - nums[j];
				List<Node> help = null;
				if(h.map.containsKey(diff)){
					help = new ArrayList<Node>(h.map.get(diff));
				}else{
					help = new ArrayList<Node>();
					help.add(h);
				}
				help.add(tem);
				if(help.size() > tem.len){
					tem.len = help.size();
				}
				tem.map.put(diff, help);
			}
			list.add(tem);
		}
		Node res = null;
		for(Node n : list){
			if(res == null || n.len > res.len){
				res = n;
			}
		}
		return res;
	}
   static class Node{
	   HashMap<Integer , List<Node>> map;
	   int val;
	   int len;
	   public Node(int v , int len){
		   this.val = v;
		   this.len = len;
		   map = new HashMap<Integer , List<Node>>();
	   }
   }
}
