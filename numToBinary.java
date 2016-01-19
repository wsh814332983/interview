package Google;

public class numToBinary {
  public static void main(String[] args){
	  System.out.print(toBinary(-4.125));
	 // System.out.print(rangeBitwiseAnd(1 , 2147483647));
  }
  public static String toBinary(double a){
	  int fisrt = (int)a;
	  double last = Math.abs(a - fisrt);
	  StringBuffer sb = new StringBuffer();
	  while(fisrt != 0){
		  if((fisrt & 1) == 1) sb.insert(0 , 1);
		  else sb.insert(0 , 0);
		  fisrt /= 2;
	  }
	  if(last == 0.0) return sb.toString();
	  sb.append('.');
	  while(last != 0){
		  last *= 2;
		  if(last >= 1){
			  sb.append(1);
			  last -= 1;
		  }
		  else sb.append(0);
		  if(sb.length() > 32) return "error";
	  }
	  return sb.toString();
  }
  public static int rangeBitwiseAnd(int m, int n) {
	  if(m == 0) return 0;
      if(m == n) return m;
      int mid = m + (n - m) / 2;
      int l = rangeBitwiseAnd(m , mid);
      int r = rangeBitwiseAnd(mid + 1 , n);
      return (l & r);
  }
}
