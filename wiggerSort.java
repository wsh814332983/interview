package Google;

public class wiggerSort {
  public static void main(String[] args){
	  int nums[] = new int[30];
	  for(int i = 0 ; i < 30 ; i++){
		  nums[i] = generate(30);
		  System.out.print(nums[i] + " ");
	  }
	  System.out.print("\n");
	  wigger(nums);
	  for(int i = 0 ; i < 30 ; i++){
		  System.out.print(nums[i] + " ");
	  }
  }
  public static int generate(int n){
	  return (int)(Math.random() * (n + 1));
  }
  public static void wigger(int[] nums){
	  boolean flag = true;
	  int index = 0;
	  while(index < nums.length - 1){
		  if(flag && nums[index] > nums[index + 1]){
			  int tem = nums[index];
			  nums[index] = nums[index + 1];
			  nums[index + 1] = tem;
			  
		  }else if( ! flag && nums[index] < nums[index + 1]){
			  int tem = nums[index];
			  nums[index] = nums[index + 1];
			  nums[index + 1] = tem;
		  }
		  flag = ! flag;
		  index ++;
	  }
  }
}
