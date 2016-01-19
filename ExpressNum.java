package Google;
 
public class ExpressNum  {
	
	public static void main(String[] args){
		String[] s = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
		ExpressionTreeNode r = build(s);
		System.out.print(r.symbol);
		System.out.print(r.left.symbol);
		System.out.print(r.left.left.symbol);
        
		
		
	}
	public static ExpressionTreeNode build(String[] expression) {
        // write your code here
        return build(expression , 0 , expression.length - 1);
    }
    public static ExpressionTreeNode build(String[] expression , int l , int r){
        if(l > r) return null;
        if(l == r) return new ExpressionTreeNode(expression[l]);
        if(r - l == 2){
             ExpressionTreeNode root = new ExpressionTreeNode(expression[(l + r) / 2]);
             root.left = new ExpressionTreeNode(expression[l]);
             root.right = new ExpressionTreeNode(expression[r]);
             return root;
        }
        int count = 0;
        int index = l;
        while(index <= r){
            if(isOpe(expression[index]) && count == 0){
                ExpressionTreeNode root = new ExpressionTreeNode(expression[index]);
                root.left = build(expression , l , index - 1);
                root.right = build(expression , index + 1 , r);
                return root;
            }
            if(expression[index] == "("){
                count++;
            }
            if(expression[index] == ")"){
                count--;
            }
            index++;
        }
        return build(expression , l + 1 , r - 1);
    }
    public static boolean isOpe(String s){
        return s == "+" || s == "-";
    }
}
 class ExpressionTreeNode {
	     public String symbol;
	     public ExpressionTreeNode left, right;
	      public ExpressionTreeNode(String symbol) {
	          this.symbol = symbol;
	          this.left = this.right = null;
	      }
	  }
