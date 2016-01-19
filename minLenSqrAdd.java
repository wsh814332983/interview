package Google;

import java.util.*;

/*given an integer ，find 最小长度minlen 的expression of integer， minlen 定义为多少个完
  全平方数相加
   例如 14 = 1 + 4 + 9， minlen = 3
  follow up： how to optimize-- 
 * 
 * 
 */
public class minLenSqrAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.print(length(5));
	}
	private static int length(int a){
		if(a == 1) return 1;
		int[] tem = new int[(int)Math.sqrt(a)];
		for(int i = 0 ; i < tem.length ; i++){
			tem[i] = i + 1;
		}
		int[] help = new int[a + 1];
		for(int i = 1 ; i <= a ;i++){
			help[i] = i;
			for(int j = 0 ; j < tem.length ; j++){
				if(i - tem[j] * tem[j] < 0) break;
				if(i - tem[j] *tem[j] >= 0 && help[i - tem[j] * tem[j]] + 1 < help[i]) help[i] = help[i - tem[j] * tem[j]] + 1;
			}
		}
		return help[a];
	}

}
class mm extends minLenSqrAdd{
	
	public static int length(int a){
		return 10;
	}
}