package Google;
import java.util.*;
/*
 * 找环的题 n = n的各位数相成  看n是否会反复出现
 */
public class HappyNum {
	public static void main(String[] args){
		System.out.print(isHappy(3));
	}
	public static boolean isHappy(int n) {
	       HashMap<Integer , Boolean> map = new HashMap<Integer , Boolean>();
	       while(true){
	           if(n == 1) return true;
	           map.put(n , true);
	           int tem = 0;
	           while(n > 0){
	               tem += (n % 10) * (n % 10 );
	               n /= 10;
	           }
	           n = tem;
	            System.out.println(n);
	           if(map.containsKey(n)) return false;
	       }
	    }
}
