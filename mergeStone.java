package Google;

/*
 * 有N堆石子，现要将石子有序的合并成一堆，规定如下：每次只能移动相邻的2堆石子合并，合并花费为新合成的一堆石子的数量。求将这N堆石子合并成一堆的总花费最小（或最大）。
 * 经典dp问题
 */
import java.util.*;

public class mergeStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] nums = {3 , 4 , 2 , 2 , 1};
       System.out.print(merge(nums));
	}
	public static int merge(int[] nums){
		int[][] help = new int[nums.length][nums.length];
		for(int i = 0 ; i < nums.length ; i++){
			help[i][i] = 0;
		}
		int[] sum = new int[nums.length];
		for(int i = 0 ; i < nums.length ; i++){
			sum[i] = nums[i] + (i == 0 ? 0 : sum[i - 1]);
		}
		for(int k = 1 ; k < nums.length ; k++){
			for(int i = 0 ; i < nums.length - k ; i++){
				int j = i + k;
				help[i][j] = Integer.MAX_VALUE;
				int tem = sum[j] - (i == 0 ? 0 : sum[i - 1]);
				for(int v = 0 ; v < k ; v++){
					help[i][j] = Math.min(help[i][j], help[i][i + v] + help[ i + v + 1][j] + tem);
				}
			}
		}
		return help[0][nums.length - 1];
	}

}
