package Google;
/*
 * 比如 3 0 1 0 这个数组  当3出现时返回 4  第一个零出现时 返回 1  第二个零出现时 因为1已经输出过 就只能往1的下一位找 2 没有出现过 返回2
 */
public class intervalTree {
   public static void main(String[] args){
	   intervaltree1 tree =new intervaltree1(1 , 4);
	  int[] nums = { 3 , 0 , 1 ,0};
	  int[] res = new int[nums.length];
	  int i = 0 ;
	  for(int n : nums){
		  res[i] = tree.root.findKth(n + 1);
		  tree.root.deleteNode(res[i]);
		  System.out.print(res[i] + " ");
		  i++;
	  }
	  
   }
}
class intervaltree1{
	intervalnode root;
	public intervaltree1(int l , int r){
		root = build(l , r);
		
	}
	public intervalnode build(int l , int r){
		if(l > r) return null;
		if(l == r) return new intervalnode(l , r);
		intervalnode root = new intervalnode(l , r);
		int mid = (l + r) / 2;
		root.left = build(l , mid);
		root.right = build(mid + 1 , r);
		root.cover = (root.left == null ? 0 : root.left.cover)  + (root.right == null ? 0 : root.right.cover);
		return root;
	}
}
class intervalnode{
	int start;
	int end ;
	int cover;
	intervalnode left;
	intervalnode right;
	public intervalnode(int s , int e){
		this.start = s;
		this.end = e;
		this.cover = 1;
	}
	public int findKth(int n){
		if(this.start == this.end) return start;
		//int mid = (start + end) / 2;
		int c = this.left == null ? 0 : this.left.cover;
		if(c < n){
			return this.right.findKth(n - c);
		}else{
			return this.left.findKth(n);
		}
	}
	public void deleteNode(int val){
		cover--;
		if(this.left != null && this.left.start == this.left.end && this.left.start == val)  {
			this.left = null;
			return;
		}
		if(this.right != null && this.right.start == this.right.end && this.right.start == val)  {
			this.right = null;
			return;
		}
		int mid = (start + end) / 2;
		if(val <= mid){
			this.left.deleteNode(val);
		}else{
			this.right.deleteNode(val);
		}
	}
}