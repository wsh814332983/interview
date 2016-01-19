package Google;
/*
 * 一个数可以分解成多少个平方数相加
 */
public class leastSqrNum {
 public static void main(String[] args){
	 System.out.print(leastSqr(16));
 }
 public static int leastSqr(int n){
	 int table[] = new int[n + 1];
	 for(int i = 1 ; i <= n ; i++){
		 table[i] = i;
		 for(int j = 1 ; j <= (int)Math.sqrt(i) ; j++){
			 table[i] = Math.min(table[i], table[i - j * j] + 1);
		 }
	 }
	 return table[n];
 }
 
}
