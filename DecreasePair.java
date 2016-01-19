package Google;
import java.util.*;
/*
 * 求array 里unordered pair 的数量(前一个数比后一个数大)比如{1, 3, 2}里面有一个(3, 2), {1, 2,
   3}里面没有, {3, 2, 1}里面有三个(3, 2) (3, 1) (2, 1)
 * 
 */
public class DecreasePair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] nums = {1 , 3 , 4 , 2 };
       System.out.print(numPairs(nums));
	}
	public static int numPairs(int[] nums){
		List<Integer>[] lists = new List[nums.length];
		for(int i = 0 ; i < nums.length ;i++){
			List<Integer> best = null;
			for(int j = 0 ; j < i ; j++){
				if(nums[i] < nums[j]){
					best = new ArrayList<Integer>(lists[j]);
				}
			}
			if(best == null){
				best = new ArrayList<Integer>();
			}
			best.add(nums[i]);
			lists[i] = best;
		}
		int res = 0;
		for(List<Integer> l : lists){
			res += l.size() - 1;
		}
		return res;
	}

}
