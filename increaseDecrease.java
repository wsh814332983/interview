package Google;
/*
 * 递增然后递减的array找index。
 */

public class increaseDecrease {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int[] nums = { 1 , 3 ,7 ,10 , 11 ,12 ,3  , 2 , 1};
           System.out.print(getMax(nums));
	}
	public static int getMax(int[] nums){
		if(nums.length == 0) return 0;
		int l = 0 , r = nums.length - 1 ; 
		while(l <= r){
			int mid = (l + r) / 2;
			System.out.println(mid + " " + l + " " + r);
			if(mid == 0 && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
				return nums[0];
			}else if(mid == 0) return nums[mid + 1];
			if(mid == nums.length - 1) return nums[nums.length - 1];
			if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return nums[mid];
			if( nums[mid] < nums[mid + 1]){
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		return nums[l];
	}

}
