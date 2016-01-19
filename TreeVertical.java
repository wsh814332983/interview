package Google;
/*
 * 树从vertical层遍历
 */
class TreeNodever{
	TreeNodever left , right;
	int val;
	public TreeNodever(int val){
		this.val = val;
	}
}
public class TreeVertical {
	public static void main(String[] args){
		TreeNodever root = new TreeNodever(8);
		root.left = new TreeNodever(5);
		root.left.left = new TreeNodever(9);
		root.left.right = new TreeNodever(7);
		root.left.right.left = new TreeNodever(1);
		root.left.right.left.left = new TreeNodever(13);
		root.left.right.left.left.left = new TreeNodever(19);
		root.left.right.right = new TreeNodever(12);
		root.right = new TreeNodever(4);
		root.right.right = new TreeNodever(11);
		root.right.right.left = new TreeNodever(3);
		printVertical(root);
	}
   public static int verticalMin(TreeNodever root, int num){
	   if(root == null)  return num;
	   int res =Math.min(verticalMin(root.right , num + 1), verticalMin(root.left , num - 1));
	   
	   return res;
   }
   public static int verticalMax(TreeNodever root , int num){
	   if(root == null) return num;
	   int res = Math.max(verticalMax(root.right , num + 1), verticalMax(root.left , num - 1));
	   return res;
   }
   public static void printVertical(TreeNodever root){
	   if(root == null) return ;
	   int min = verticalMin(root  , 0 );
	   int max = verticalMax(root , 0);
	   for(int i = min ; i <= max ; i++){
		   print(root , i , 0);
	       System.out.print("\n");
	   }
   }
   public static void print(TreeNodever root , int level , int cur){
	   if(root == null ) return ;
	   if(cur == level){
		   System.out.print(root.val + " ");
	   }
	   print(root.left , level , cur - 1);
	   print(root.right , level , cur + 1);
   }
}
