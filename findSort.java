package Google;
/*
 * find missing numbers 
 */
import java.util.*;
/*
 * A sorted array contains integers from 1..n with m of them missing. Find all missing numbers.

Example:
n = 8 , m = 2
arr = [1,2,4,5,6,8]
Result has to be {3, 7}.
 */
public class findSort {
 public static void main(String[] args){
	 List<Integer> res = new ArrayList<Integer>();
	 int[] nums = { 1,2,4,5,6,8};
	 find(nums , 3, 0 , nums.length - 1 , res);
	for(int n : res){
		System.out.print(n + " ");
	}
	
 }
 public static void find(int[] nums ,int mis , int l , int r , List<Integer> res){
	 if(l > r) return;
	 int mid = (l + r) / 2;
	
	 
	if(l == mid || nums[mid - 1] - nums[l] == mid - 1 - l){
		int pre = l == 0 ? 0 : nums[l - 1];
		for(int i = 1 ; i < nums[l] - pre; i++){
			res.add(pre + i);
		}
		if(l != mid){
			for(int i = 1 ; i < nums[mid] - nums[mid - 1] ; i++){
				res.add(nums[mid - 1] + i);
			}
		}
	}else{
		find(nums , mis , l , mid - 1 , res);
	}
	if(r == mid || nums[r] - nums[mid + 1] == r - mid - 1){
		if(mid != r){
			for(int i = 1 ; i  < nums[mid  +1] - nums[mid] ; i++){
				res.add(nums[mid] + i);
			}
		}
		int after = r == nums.length - 1 ? nums.length + mis + 1 : nums[r + 1];
		for(int i = 1 ; i < after - nums[r] ; i++){
			res.add(nums[r] + i);
		}
	}else{
		find(nums , mis , mid + 1 , r , res);
	}
 }
}
