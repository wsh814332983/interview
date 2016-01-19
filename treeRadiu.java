package Google;
import java.util.*;
/*
 * 树的直径
 */
public class treeRadiu {
	public static void main(String[] args){
		length = 0;
		TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.left.left = new TreeNode(3);
		 root.left.left.left = new TreeNode(4);
		 root.left.right = new TreeNode(4);
		 root.left.right.left = new TreeNode(5);
		 root.left.right.left.right = new TreeNode(6);
		 getRadi(root);
		 System.out.print(length);
	}
  static class TreeNode{
	  TreeNode left;
	  TreeNode right;
	  int val;
	  public TreeNode(int val){
		  this.val = val;
	  }
  }
  public static void getRadi(TreeNode root ){
	  TreeNode next = root;
	  HashMap<TreeNode , Integer> map = new HashMap<TreeNode , Integer>(); 
	  while(next != null){
		  next = getDepth(next , map);
	  }
  }
  static int length;
  public static TreeNode getDepth(TreeNode root , HashMap<TreeNode , Integer> map ){
	  if(root == null) return root;
	  int l = getHeight(root.left ,   map );
	  int r = getHeight(root.right , map);
	  length = Math.max(length, 1 + l + r);
	  return (l > r ? root.left : root.right);
  }
  public static int getHeight(TreeNode root ,  HashMap<TreeNode , Integer> map ){
	  if(root == null) return 0;
	  if(map.containsKey(root)) return map.get(root);
	  int l = getHeight(root.left , map);
	  int r = getHeight(root.right , map);
	  map.put(root, 1 + (l > r ? l : r));
	  return 1 + (l > r ? l : r);
  }
}
