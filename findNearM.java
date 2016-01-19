package Google;
/*
 * 可以不停的输入树 实现查找和平均值最接近的点
 */
public class findNearM {
  public static void main(String[] args){
	  int[] nums = {3 , 5, 1 , 10 , 3 , 9 , 22 };
	  tree tr = new tree();
	  for(int n : nums){
		  tr.add(n);
	  }
	  tr.add(23);
	  System.out.print(tr.getAvg() +" "+ tr.avg);
  }
}
class tree{
	int count;
	double avg;
	treenode3 root;
	public tree(){
		count = 0;
		avg = 0;
		root = null;
	}
	public int getAvg(){
	   return (int)find(root);	
	}
	public double find(treenode3 node ){
		if(node.val == avg) return avg;
		if(node.val < avg){
			if(node.right == null) return node.val;
			double r = find(node.right);
			if(Math.abs(r - avg) > Math.abs(node.val - avg)) return node.val;
			else return r;
		}else{
			if(node.left == null) return node.val;
			double l = find(node.left);
			if(Math.abs(l - avg) > Math.abs(node.val - avg)) return node.val;
			return l;
		}
	}
	public void add(int v){
		double t = (avg * count);
		count ++;
		avg = (t + v) / count;
		insert(root , v);
	}
	public void insert(treenode3 node , int v){
		if(node == null) {
			root = new treenode3(v);
			return;
		}
		if(node.val == v) return;
		if(node.val < v) {
			if(node.right == null){
				node.right = new treenode3(v);
			}else{
				insert(node.right , v);
			}
		}else{
			if(node.left == null){
				node.left = new treenode3(v);
			}else{
				insert(node.left , v);
			}
		}
	}
}
class treenode3{
	int val;
	treenode3 left;
	treenode3 right;
	public treenode3(int val){
		this.val = val;
	}
	
	
}
