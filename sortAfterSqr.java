package Google;
/*
 * sort 好的数组 每个数平方后 返回重新sort好的数组
 */
public class sortAfterSqr {
  public static void main(String[] args){
	  int[] nums = {-10 , -2 , -1 };
	  int[] res = sort(nums);
	  for(int n : res){
		  System.out.print(n + " ");
	  }
  }
  public static int[] sort(int[] nums){
	  int l = 0 , left = 0 ,  r = nums.length - 1 , index = nums.length - 1;
	  while(left < nums.length && nums[left] < 0) left++;
	  int[] res = new int[nums.length];
	  while(l < left || r >= left){
		  int a = (l < left ? nums[l] * nums[l] : -1);
		  int b = (r >= left ? nums[r] * nums[r] : -1);
		  if(b >= a) {
			  res[index--] = b;
			  r--;
		  }else {
			  res[index--] = a;
			  l++;
		  }
	  }
	  return res;
  }
}
