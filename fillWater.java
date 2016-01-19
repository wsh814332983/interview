package Google;

import java.util.*;
/*
 * 给你很多杯子 有各自容量 用这些杯子去fill一个大杯子 问最少使用几次小杯子  不同容量的杯子可以反复使用
 * 
 */
public class fillWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] nums = {1,3,5,6,25};
         List<Integer> list = fill(nums , 70);
         for(int n : list){
        	 //System.out.print(n + " ");
         }
	}
	public static List<Integer> fill(int[] nums , int k){
		int[] help = new int[k + 1];
		int[] cut = new int[k + 1];
		Arrays.fill(help, Integer.MAX_VALUE);
		help[0] = 1;
		for(int i = 0 ; i <= k ; i++){
			for(int j = 0 ; j < nums.length ; j++){
				if(i - nums[j] >= 0 && help[i - nums[j]] > 0){
					help[i] = Math.min(help[i], help[i - nums[j]] + 1);
					cut[i] = nums[j];
				}
			}
		}
		int ttt = cut.length - 1;
		while(ttt > 0){
			System.out.println(cut[ttt]);
			ttt -= cut[ttt];
		}
		if(help[k] == Integer.MAX_VALUE) return null;
		List<Integer> list = new ArrayList<Integer>();
		int tem = k;
		int index = k;
		while(tem > 0 ){
			for(int i = 0 ; i < nums.length ; i++){
				if(tem - nums[i] >= 0 && help[tem] - 1 == help[tem - nums[i]]) {
					list.add(nums[i]);
					tem = tem - nums[i];
				}
			}
		}
		return list;
	}

}
