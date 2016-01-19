package Google;

/*
 * 用preorder和postorder建树
 */
import java.util.*;
public class prepos {
  static class TreeNode{
	  int val;
	  TreeNode left;
	  TreeNode right;
	  public TreeNode(int val){
		  this.val = val;
	  }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] pre = { 7 , 8 , 2 , 1 , 4 ,3 , 1 , 9};
        int[] pos = {2 , 1 , 8 , 9 , 1 ,3 , 4 , 7};
        TreeNode root = recon(pre , pos);
        for(Integer n : pre(root)){
        	System.out.print(n + " ");
        }
        System.out.print("\n");
        for(Integer n : pos(root)){
        	System.out.print(n + " ");
        }
	}
	public static List<Integer> pos(TreeNode node){
		List<Integer> ls = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(node != null){
			stack.push(node);
			node = node.left;
		}
		while(!stack.isEmpty()){
			if(stack.peek().right == node){
				node = stack.pop();
				ls.add(node.val);
			}else{
				node = stack.peek().right;
				while(node != null){
					stack.push(node);
					node = node.left;
				}
			}
			
		}
		return ls;
	}
	public static List<Integer> pre(TreeNode node){
		List<Integer> ls = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(node != null){
			stack.push(node);
			ls.add(node.val);
			node = node.left;
		}
		while(!stack.isEmpty()){
			node = stack.pop();
			node = node.right;
			while(node != null){
				ls.add(node.val);
				stack.push(node);
				node = node.left;
			}
		}
		return ls;
	}
	public static TreeNode recon(int[] pre , int[] pos){
		HashMap<Integer , Integer> map = new HashMap<Integer , Integer>();
		for(int i = 0 ; i < pos.length ; i++){
			map.put(pos[i], i);
		}
		TreeNode root = recon(pre , 0 , pre.length - 1 , 0 , map );
		return root;
	}
   public static TreeNode recon(int[] pre , int l , int r , int index , HashMap<Integer , Integer> map){
	   if(l > r) return null;
	   int head = pre[index];
	   
	   TreeNode root = new TreeNode(head);
	   if(l == r) return root;
	   int mid = map.get(pre[index + 1]);
	   TreeNode left = recon(pre , l ,  mid, index + 1 , map);
	   TreeNode right = recon(pre , mid + 1 , r - 1 , index + 2 + mid - l , map);
	   root.left = left;
	   root.right = right;
	   return root;
	   
   }
}
