package Google;
/*
 * 一个array 里面找最大的这样的h:有h 个数大于等于h
 */
public class Hindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] nums = {3 , 4 , 5 , 8 , 9 ,6};
         System.out.println(Hindex(nums));
         for(int n : nums){
        	 System.out.print(n + " ");
         }
	}
	public static int Hindex(int[] nums){
		int  l = 0 , r = nums.length - 1 ;
		while(l <= r){
			int index = (l + r) / 2;
			int p = partion(nums , l , r , index);
			if(nums[p] == p ) return p ;
			if(nums[p] > p ) l = p + 1;
			else if(nums[p] < p ) r = p - 1;
		}
		return -1;
	}
	public static int partion(int nums[] , int l , int r , int index){
		int n = nums[index];
		while(l < r){
			while(l < r && nums[r] < n) r--;
			while(l < r && nums[l] >= n) l++;
			if(l == r) break;
			swap(nums , l , r);
		}
		swap(nums , l , index);
		
		return l;
	}
	public static void swap(int[] nums , int l , int r){
		int tem = nums[l];
		nums[l] = nums[r];
		nums[r] = tem;
	}

}
