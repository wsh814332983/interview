package Google;

import java.util.*;
/*八乘八的棋盘，给我一个初始位置和目标位置，然后我只能走对角线（同一条对角线一直走
算一步），让我写个算法求走多少步。。。然后我死也想不出来怎么算，最后他一解释，说最
多只能有两步，两步都走不到就永远都走不到了。所以查一查到底走不走的到，再看看能不
能一步走到，这题就搞掂了。
 * 
 * 
 * 
 */
public class canReach {
   public static void main(String[] args){
	   int[][] nums = {
			   { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			   { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			   { 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0},
			   { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			   { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			   { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			   { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			   { 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0},
			   
	   };
	   System.out.print(canReach1(nums , 1 , 3));
   }
   public static boolean canReach1(int[][] nums , int row , int col){
	   int c = row * nums.length + col;
	   Queue<Integer> que = new LinkedList<Integer>();
	   que.offer(c);
	   que.offer(-1);
	   while(!que.isEmpty()){
		   c = que.poll();
		   while(c != -1){
			   if(inDiagnose(nums , c , que)) return true;
			   c = que.poll();
		   }
		   if(que.isEmpty()) return false;
		   que.offer(-1);
	   }
	   return false;
   }
   public static boolean inDiagnose(int[][] nums , int c , Queue<Integer> que){
	   int row = c / nums[0].length , col = c % nums[0].length;
	   for(int i = 0 ; i < nums.length ; i++){
		   if(row + i < nums.length && col + i < nums.length ){
			   if(nums[row + i][col + i] == 1) return true;
			   if(nums[row + i][col + i] == -1) continue;
			   nums[row + i][col + i] = -1;
			   que.offer((row + i) * nums.length + col + i);
		   }else if(row + i < nums.length && col - i >=0 ){
			   if(nums[row + i][col - i] == 1) return true;
			   if(nums[row + i][col - i] == -1) continue;
			   nums[row + i][col - i] = -1;
			   que.offer((row + i) * nums.length + col - i);
		   }else if(row - i >= 0 && col - i >=0 ){
			   if(nums[row - i][col - i] == 1) return true;
			   if(nums[row - i][col - i] == -1) continue;
			   nums[row - i][col - i] = -1;
			   que.offer((row - i) * nums.length + col - i);
		   }else if(row - i >= 0 && col + i < nums.length ){
			   if(nums[row - i][col + i] == 1) return true;
			   if(nums[row - i][col + i] == -1) continue;
			   nums[row - i][col + i] = -1;
			   que.offer((row - i) * nums.length + col + i);
		   }
	   }
	   return false;
   }
}
