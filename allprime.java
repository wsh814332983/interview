package Google;


import java.util.*;
public class allprime {
	public static void main(String[] args){
		System.out.print(countPrimes(499979));
	}
	public static int countPrimes(int n) {
        if(n <= 2) return 0;
     List<Integer> res = new ArrayList<Integer>(); 
     res.add(2);
     for(int i = 3 ; i <= n ; i++){
         boolean flag = false;
         for(int j = 0 ; j < res.size() ; j++){
             if(i % res.get(j) == 0) {
                 flag = true;
                 break;
             }
         }
         if(!flag) res.add(i);
     }
     for(int t : res){
    	 System.out.print(t + " ");
     }
     return res.size();
    }
}
