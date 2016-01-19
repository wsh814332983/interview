package Google;

/*
 * 曼哈顿距离 google it
 */
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mahatonD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             int[][] nums = {
            		 {0 , 0 , 1 , 0 , 0 , 1},
            		 {1 , 0 , 0 , 0 , 1 , 0},
             };
             node n = findBFS(nums);
             node n2 = otherway(nums);
             System.out.println(n.x + " " + n.y + " " + n.distance);
             System.out.println(n2.x + " " + n2.y);
	}
	public static node otherway(int[][] nums){
		List<Integer> forx = new ArrayList<Integer>();
		List<Integer> fory = new ArrayList<Integer>();
		for(int i = 0 ; i < nums.length ; i++){
			for(int j = 0 ; j < nums[0].length ; j++){
				if(nums[i][j] == 1) {
					forx.add(i);
					fory.add(j);
				}
			}
		}
		Collections.sort(forx);
		Collections.sort(fory);
		int midx = forx.get(forx.size() / 2);
		int midy =  fory.get(fory.size() / 2);
		node n = new node();
		n.x = midx;
		n.y = midy;
		return n;
	}
	public static node findBFS(int[][] nums ){
		node n = new node();
		for(int i = 0 ; i < nums.length ; i++){
			for(int j = 0 ; j < nums[0].length ; j++){
				BFS(nums , n , i , j);
			}
		}
		return n;
	}
	public static void BFS(int[][] nums , node n , int i , int j){
		Queue<Integer> que = new LinkedList<Integer>();
		int c = i * nums[0].length + j , level = 0 , dis = 0;
		que.offer(c);
		que.offer(-1);
		HashMap<Integer , Boolean> map = new HashMap<Integer , Boolean>();
		map.put(c , true);
		while(! que.isEmpty()){
			int tem = que.poll();
			while(tem != -1){
				
				int row = tem / (nums[0].length) , col = tem % (nums[0].length);
				//System.out.println(tem + " " + row + " " + col);
				if(nums[row][col] == 1) dis += level;
				if(row + 1 < nums.length && ! map.containsKey(tem + nums[0].length)) {
					que.offer(tem + nums[0].length);
					map.put(tem + nums[0].length , true);
				}
				if(col + 1 < nums[0].length && ! map.containsKey(tem + 1)) {
					que.offer(tem + 1);
					map.put(tem + 1 , true);
				}
				if(row - 1 >= 0 && ! map.containsKey(tem - nums[0].length)) {
					que.offer(tem - nums[0].length);
					map.put(tem - nums[0].length , true);
				}
				if(col - 1 >= 0 && ! map.containsKey(tem - 1)) {
					que.offer(tem - 1);
					map.put(tem - 1 , true);
				}
				tem = que.poll();
			}
			if(que.isEmpty()) break;
			que.offer(-1);
			level++;
		}
		if(dis < n.distance){
			n.x = i;
			n.y = j;
			n.distance = dis;
		}
	}
 static class node{
	 int x ; 
	 int y;
	 int distance;
	 public node(){
		 distance = Integer.MAX_VALUE;
	 }
 }

}

