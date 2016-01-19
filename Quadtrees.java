package Google;
/*
 * 四叉树
 */
public class Quadtrees {
	public static void main(String[] args){
		int[][] nums1 = { {0 ,0} ,{1 , 1}};
		int[][] nums2 = {{ 0 , 1 } , { 1 , 1}};
		System.out.print(same(nums1 , nums2));
	}
	public static int same(int[][] nums1 , int[][] nums2 ){
		QuadNode one = buildTree(nums1 , nums1.length , 0 ,0);
		QuadNode two = buildTree(nums2 , nums2.length , 0 , 0);
		return numberOf(one , two);
	}
	public static int numberOf(QuadNode a , QuadNode b){
		int res = 0 ;
		if(a.nodes[0] == null && b.nodes[0] == null) return (a.val == b.val && a.val == 1) ? 1 : 0;
		for(int i = 0 ; i < 4 ; i ++){
			if(a.nodes[i].val != 0 && b.nodes[i].val != 0) res += numberOf(a.nodes[i] , b.nodes[i]);
		}
		
		return res;
	}
     public static QuadNode buildTree(int[][] nums , int size , int l , int r){
    	 if(size < 1) return null;
    	 if(size == 1) return new QuadNode(nums[l][r]);
    	 size /= 2;
    	 QuadNode root = new QuadNode();
    	 int[][] tem = {{l , r} , { l + size , r} , {l , r + size } , { l + size , r + size}};
    	 for(int i = 0 ; i < 4 ; i ++){
    		 root.nodes[i] = buildTree(nums , size , tem[i][0] , tem[i][1]);
    		 root.val += root.nodes[i].val;
    	 }
    	 return root;
     }
}
class QuadNode{
	QuadNode[] nodes = new QuadNode[4];
	int val;
	public QuadNode(){
		
	}
	public QuadNode(int val){
		this.val = val;
	}
}