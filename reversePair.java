package Google;

import java.util.*;
/*
 * find reverse pair in two arrays
There are two arrays A1 and A2. Find out the pairs of numbers in A2 which were in reverse order
in A1. For ex.
A1 = 2 6 5 8 1 3 A2 = 1 2 3 4 5 6 Answer: 1 & 2 5 & 6
 */

public class reversePair {
 static List<Node> list = new ArrayList<Node>();
 static class Node{
	 int a;
	 int b;
	 public Node(int a , int b){
		 this.a = a;
		 this.b = b;
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] n1 = {2,6 ,5, 8, 1, 3};
       int[] n2 = {1 ,2 ,3 ,4 ,5 ,6};
       System.out.println(getPair(n1 , n2));
       for(Node no : list){
    	   System.out.println(n1[no.a] + " " +n1[no.b]);
       }
	}
 
	public static int getPair(int[] n1 , int[] n2 ){
		HashMap<Integer ,  Integer> map = new HashMap<Integer , Integer>();
		for(int i = 0 ; i < n1.length ; i++){
			map.put(n1[i], i);
		}
		int[] tem = new int[n2.length];
		int index = n2.length - 1;
		for(int i = n2.length - 1 ; i >= 0 ; i--){
			if(map.containsKey(n2[i])){
				tem[index--] = map.get(n2[i]);
			}
		}
	   int res = get(tem , 0 , tem.length - 1);	
	   return res;
	}
	public static int get(int[] tem , int l , int r){
		if(l >= r) return 0;
		int mid = (l + r) / 2;
		int left = get(tem , l , mid);
		int right = get(tem , mid + 1 , r);
		return merge(tem , l , mid , r) + left + right;
	}
	public static int merge(int[] tem , int l , int mid , int r){
		int res = 0;
		int[] help = new int[r - l + 1];
		int index = help.length - 1;
		int left = mid;
		int right = r;
		while(left >= l || right > mid){
			if(left >= l && right > mid){
				//System.out.print(index);
				if(tem[left] > tem[right]){
					res += right - mid;
					for(int i = right ; i > mid ; i--){
						list.add(new Node(tem[left] , tem[i]));
					}
					help[index] = tem[left--];
				}else{
					
					help[index] = tem[right];
					right--;
				}
			}else{
				if(left >= l){
					help[index] = tem[left--];
				}else{
					help[index] = tem[right--];
				}
			}
			index--;
		}
		for(int i = l ; i <= r ; i++){
			tem[i] = help[i - l];
		}
		return res;
	}
}
