package Google;

import java.util.*;
/*
 *  判断一个int是不是旋转180度后还是原来的数字，比如16891还是16891，返回 true。

    之后follow up，给一个数n，返回所有的满足刚才条件的数，比如n＝1 ［0，1，8］，n＝2 ［11，69，96，88］
 * 
 */
public class getRotatNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       List<Integer> res = getR(5);
       for(int n : res){
    	   System.out.print(n + " ");
       }
	}
	public static List<Integer> getR(int n){
		List<Integer> res = new ArrayList<Integer>();
		if(n <= 0) return res;
		int[] odd = {0 , 1 , 8};
		int[] pair = {6 ,9};
		List<String> s = get(n , odd , pair);
		for(String tem : s){
			int k = Integer.parseInt(tem);
			int in = (int) Math.pow(10, n - 1);
			if(k < in) continue;
			res.add(k);
		}
		return res;
	}
   public static List<String> get(int n , int[] odd , int[] pair){
	   
	   List<String> res = new ArrayList<String>();
	   if(n == 0){
		   res.add("");
		   return res;
	   }
	   if(n == 1) {
		   for(int i = 0 ; i < odd.length ; i++){
			   res.add(String.valueOf(odd[i]));
		   }
		   return res;
	   }
	   
	   List<String> left = get(n - 2 , odd , pair);
	   for(String num : left){
		   for(int i = 0 ; i < odd.length ; i++){
			   
			   String t = String.valueOf(odd[i]) + num + String.valueOf(odd[i]);
			   res.add(t);
		   }
	   }
	   for(String num : left){
		   for(int i = 0 ; i < pair.length ; i++){
			  String t = String.valueOf(pair[i]) + num + String.valueOf(pair[1 - i]);
			  res.add(t);
		   }
	   }
	   return res;
   }
}
