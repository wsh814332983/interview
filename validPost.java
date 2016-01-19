package Google;

import CtCILibrary.TreeNode;
/*
 * 对的后续遍历
 */
public class validPost {
	public static void main(String[] args){
		int[] nums1 = {7,4,6,5};
		
		System.out.print(isValid(nums1));
	}
	public static boolean isValid(int[] nums){
		int i = nums.length - 1;
		TreeNode root = new TreeNode(nums[i]);
		i--;
		while(i >= 0 ){
			int val = nums[i];
			TreeNode cur = root;
			while(i >=0 && nums[i] == val){
				if(val > cur.data){
					if(cur.left != null) return false;
					if(cur.right == null) {
						cur.right = new TreeNode(val);
						i--;
					}
					else cur = cur.right;
				}else{
					if(cur.left == null) {
						cur.left = new TreeNode(val);
						i --;
					}
					else cur = cur.left;
				}
			}
			
		}
		return true;
	}
}
