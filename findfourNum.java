package Google;

import java.util.*;
/*
 * 把 出现次数大于1/4的数 全部找出   是sorted
 */
public class findfourNum {
   public static void main(String[] args){
	   int[] nums = { 1 , 1 , 1 , 3 ,4 ,7 ,7 , 7 , 7 , 9 , 10};
	   List<Integer> res = get(nums);
	   for(Integer n : res){
		   System.out.print(n + " ");
	   }
   }
   public static List<Integer> get(int[] nums){
	   List<Integer> res = new ArrayList<Integer>();
	   int len = nums.length , k = (int)Math.ceil(len / 4) , l = 0 , r = len - 1;
	   get(nums , 0 , r , k , res);
	   
	   return res;
   }
   public static void get(int[] nums , int l , int r , int k , List<Integer> res){
	   if(r - l < k ) return;
	   int[] tem = findRange(nums , l , r , k);
	   if(tem[1] - tem[0] >= k) res.add(nums[(l + r) / 2]);
	   get(nums , l , tem[0] - 1 , k , res);
	   get(nums , tem[1] + 1 , r , k , res);
	   
   }
   public static int[] findRange(int[] nums , int l , int r , int k){
	   int tem[] = {- 1 , -1};
	   if(l > r) return tem;
	   int n = nums[(l + r) / 2] , left = l , right = r;
	   while(left <= right){
		   int mid = (left + right) / 2;
		   if(nums[mid] == n){
			   if(mid == l || nums[mid - 1] != n){
				   tem[0] = mid;
				   left = mid;
				   right = r;
			   }else if(mid == r || nums[mid  +1] != n){
				   tem[1] = mid ;
				   left = l;
				   right = mid;
			   }
			   if(tem[0] != -1 && tem[1] != -1){
				   return tem;
			   }
			   if(tem[0] == -1){
				   right = mid - 1;
			   }else left = mid + 1;
		   }else if(nums[mid] > n){
			   right = mid - 1;
		   }else{
			   left = mid + 1;
		   }
	   }
	   return tem;
   }
}
