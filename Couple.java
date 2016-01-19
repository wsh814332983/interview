package Google;
import java.util.*;
/*
 * 电影院中 把情侣都移到一起
 */
public class Couple {
	public static void main(String[] args){
		  int[] num = {2, 1, 3, 1, 3, 2, 4, 4 , 7 , 10};
		  swapPos(num);
		  for(int n : num){
			  System.out.print(n + " ");
		  }
		  
		  
	  }
  public static void swapPos(int[] num){
	  
	  HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
	  for(int i = 0 ; i < num.length ; i++){
		  if(!map.containsKey(num[i])){
			  map.put(num[i], i);
		  }else{
			  if(i % 2 == 1 && map.get(num[i]) == i - 1) continue;
			  if(map.get(num[i]) % 2 == 0) swap(map.get(num[i]) + 1 , i , num);
			  else swap(map.get(num[i]) - 1 , i , num);
			  map.remove(num[i]);
			  i--;
		  }
	  }
  }
  public static void swap(int l , int r , int[] num){
	  int tem = num[l];
	  num[l] = num[r];
	  num[r] = tem;
  }
}
