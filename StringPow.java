package Google;

import java.util.*;
/*
 * a --- [1 , 9];
 * b --- [1 , 99];
 * 字符串求pow
 */
public class StringPow {
  public static void main(String[] args){
	  System.out.print(pow(9 , 3));
	  
  }
  public static String pow(int a , int b){
	  if(a == 0) return "0";
	  if(b == 0) return "1";
	  return pow(String.valueOf(a) , b);
  }
  public static String pow(String a , int b){
	  if(b == 0) return "1";
	  if(b < 0) return "1 / " + pow(a , -b);
	  String res = null;
	  while(b > 0){
		  if(b % 2 == 1){
			  res = mulit(res , a);
		  }
		  a = mulit(a , a);
		  b >>= 1;
	  }
	  return res;
  }
  public static String mulit(String a , String b){
	  if(a == null)  return b;
	  if(b == null)  return a;
	  if(a.length() == 0) return b;
	  if(b.length() == 0) return a;
	  int[] help = new int[a.length() + b.length() - 1];
	  for(int i = 0 ; i < a.length() ; i++){
		  for(int j = 0 ; j < b.length() ; j++){
			  help[i + j] += (a.charAt(a.length() - i - 1) - '0') * (b.charAt(b.length() - 1 - j) - '0') ;
		  }
	  }
	  StringBuffer sb = new StringBuffer();
	  int carry = 0 ;
	  for(int i = 0 ; i < a.length() + b.length() - 1; i++){
		  
		  sb.insert(0 , (help[i] + carry) % 10);
		  carry = (help[i] + carry) / 10;
	  }
	  if(carry > 0){
		  sb.insert(0, carry);
	  }
	  return sb.toString();
  }
}
