package Google;
/*
 * 有insertX和insertY两个函数  这两个函数会把坐标的第一向线化为很多部分  输入一个findXY 可以找到对应区间  区间的号定义随你
 */
public class divideSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] nums = {1 , 3 , 5  ,7 , 9 , 10 };
       TreeNode root = build(nums , 0 , nums.length - 1);
       System.out.println(find(root , 11));
       root.add(13);
       System.out.print(find(root , 11));
	}
	public static TreeNode build(int[] nums , int l , int r){
		if(l > r) return null;
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = build(nums , l , mid - 1);
		root.right = build(nums , mid  + 1 , r);
		return root;
	}
	static class TreeNode{
		TreeNode right;
		TreeNode left;
		int l;
		int r;
		
		public TreeNode(int l){
			this.l = l;
			this.r = l + 1;
		}
		public void add(int v){
			if(v == l) return;
			if(v < l){
				if(left == null) left = new TreeNode(v);
				left.add(v);
			}else{
				if(right == null) right = new TreeNode(v);
				right.add(v);
			}
		}
	}
	
   public static int find(TreeNode root , int x){
	   if(root == null) return -1;
	   if(root.l == x) return root.l;
	   TreeNode par = null;
	   TreeNode cur = root;
	   int help = find(cur , par , x);
	   return help;
   }
   public static int find(TreeNode cur , TreeNode par , int x){
	   if(cur == null) return par.l;
	   if(cur.l == x) return x;
	   if(cur.l > x){
		   par = cur;
		   cur = cur.left;
		   return find(cur , par , x);
	   }else{
		   if(cur.right == null && par == null) return cur.r;
		   return find(cur.right , par , x);
	   }
   }
}
