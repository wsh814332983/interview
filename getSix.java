package Google;

import java.util.Date;

public class getSix {
 public static long getNum(long n){
	 long  res = 1;
	 while(n > 0 ){
		 res *= n;
		 n--;
		 System.out.println(n);
	 }
	 
	 return res;
 }
 
 public static void main(String[] args){
	 long k = getNum(30);
	 long t = toSix(k);
	 System.out.println(k);
	 System.out.print(Integer.MAX_VALUE);
 }
 public static long toSix(long n){
	 long res = 0;
	 int carry = 0 , k = 0;
	 while(n > 0){
		 res = (long) (res + (n % 6 * Math.pow(10, k)));
		 k++;
		 n /= 6;
	 }
	 return res;
 }
}
