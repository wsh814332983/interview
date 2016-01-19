package Google;
/*
 * 1234101112 。。。。N 这样的一个数  给你个index 找出那个index上的digital 
 */

public class getNum {
    public static void main(String[] args){
    	System.out.print(getNum(15));
    }
    public static int getNum(int n){
    	int k = 1 , tem = 9 , range = 9;
    	while(n > range){
    		n -= range;
    		k++;
    		tem *= 10;
    		range = k * tem ;
    	}
       int num = (int)Math.pow(10, k - 1);
       //System.out.print(k + " " + num + " ");
       int pos = (n - 1) / k , pos2 =  (n - 1) % k;
       
       num += pos;
       //System.out.print(n);
       String t = String.valueOf(num);
       return (t.charAt(pos2) - '0');
    }
}
