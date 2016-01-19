/**
 * 
 */
package Google;
import java.util.*;
/**
 * @author tianxiangzhang
 *题目是给一个n*m 的二维数组返回一个一维数组，这个数组包含之前数组的对角线的和。
下面是例子：
[1, 2, 3
4, 5, 6
7, 8, 9] 要返回 [7, 12, 15, 8, 3]
 */
public class Diagnose {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {
				{1 ,2 ,3},
				{4 , 5 ,6},
				{7, 8 , 9},
				
		};
           List<Integer> ls = getDiagnose(nums);
           for(int n : ls){
        	   System.out.println(n);
           }
	}
	public static List<Integer> getDiagnose(int[][] nums){
		List<Integer> res = new ArrayList<Integer>();
		if(nums.length == 0) return res;
		int n = nums.length , m = nums[0].length;
		int d = gcd(n - 1, m - 1);
		int[] dis = new int[2];
		dis[0] = (n - 1) / d;
		dis[1] = (m - 1)/ d;
		for(int i = 0 ; i < m ; i++){
			int num = 0 , row = n - 1 , col = i;
			while(row >= 0 && col >= 0){
				num += nums[row][col];
				row -= dis[0];
				col -= dis[1];
			}
			if(i == 0 || i == m - 1){
				res.add(num);
			}else if(num != nums[n - 1][i]){
				res.add(num);
			}
		}
		for(int i = 1 ; i < m ; i++){
			int num = 0 , row = 0 , col = i;
			while(row < n  && col < m){
				num += nums[row][col];
				row += dis[0];
				col += dis[1];
			}
			if( i == m - 1){
				res.add(num);
			}else if(num != nums[0][i]){
				res.add(num);
			}
		}
	    return res;
	}
    public static int gcd(int a , int b){
    	if(b <= 1) return 1;
    	if(a % b == 0) return b;
    	return gcd(b , a % b);
    }
}
