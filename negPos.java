package Google;
/*
 * neg的全移到左边  pos移到右边  但是pos 里面相对循序不能变  neg也是一样
 */
public class negPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] nums = {  1 ,  3 ,  -2 ,  2 , -4};
         reorder(nums);
         for(int n : nums){
        	 System.out.print(n + " ");
         }
	}
	public static void reorder(int[] nums){
		
		int count = 0;
		for(int i = nums.length - 1 ; i >= 0 ; i--){
			if(nums[i] < 0) count++;
			else swap(nums , i , i + count);
		}
		
		
	}
	public static void swap(int[] nums , int l , int r){
		int tem = nums[l];
		nums[l] = nums[r];
		nums[r] = tem;
	}
	
}
