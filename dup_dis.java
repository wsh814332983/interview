package Google;
import java.util.*;

/*
 * 有个List<String>,里面有duplicates，比如[A,B,B,A,C].现在有另一个input 是一个int 存放
minimal distance。
要求return 的list 里让duplicate 之间的最小距离大于等于输入的minimal distance。
example 是
[A, B, B], 2 -> [B, A, B] (2 - 0 >= 2)
[A, B, B], 1 -> (any permutation)
[A, B, B], 3 -> (no solution; throw exception, return error code, etc)
45.
1
 * 
 * 
 */
public class dup_dis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          char[] nums = {'A' , 'B' , 'B' , 'D' , 'D'};
          try {
			char[] res = reorder(nums , 3);
			for(char c : res){
				System.out.print(c + " ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
	}
	public static char[] reorder(char[] nums , int k) throws Exception{
		HashMap<Character , Node11> map = new HashMap<Character , Node11>();
		dup_dis help = new dup_dis();
		List<Node11> ls = new ArrayList<Node11>();
		for(char n : nums){
			if(map.containsKey(n)){
				
				map.get(n).val += 1;
				//System.out.print(map.get(n).val + " ");
			}else{
				 
				//Node node = new Node(1 , n);
				map.put(n , help.new Node11(1 , n));
			}
		}
		for(Node11 node : map.values()){
			ls.add(node);
		}
		Collections.sort(ls);
		int index = 0 , mark = 0;
		Arrays.fill(nums , '1');
		for(Node11 node : ls){
			char c = node.c;
			while(index < nums.length && node.val != 0){
				nums[index] = c;
				node.val -= 1;
				index += k;
				System.out.print(index + " ");
			}
			if(node.val != 0) throw new Exception("d");
			
			while(mark < nums.length && nums[mark] != '1'){
				mark++;
			}
			 if(mark == nums.length) break;
			index = mark;
		}
		return nums;
	}
   class Node11 implements Comparable<Node11>{
	   int val;
	   char c;
	    Node11(int val , char c){
		   this.val = val;
		   this.c = c;
	   }
	   @Override
	   public int compareTo(Node11 b){
		   return b.val - this.val;
	   }
   }
}
