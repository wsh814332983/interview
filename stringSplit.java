package Google;
/*给一个string，返回含有word 的list。word 的定义是空格(大于等于一个）之间的或者引号
之间的，如果引号里面有空格要做为一个word 返回。比如string 是 I have a "faux coat"
要返回[I, have, a, faux coat]
 * 
 * 
 * 
 * 
 */
import java.util.*;
public class stringSplit {
       public static void main(String[] args){
    	   String tem = "I have a \"faux coat\" heee \"dsd\"";
    	   List<String> res = springSplit(tem);
    	   for(String s : res){
    		   System.out.println(s);
    	   }
       }
       public static List<String> springSplit(String s){
    	   List<String> res = new ArrayList<String>();
    	   if(s.length() == 0) return res;
    	   int index = 0 , left = 0;
    	   boolean help = false;
    	   while(index < s.length()){
    		   if(s.charAt(index) == '"' && ! help){
    			   help = true;
    			   left = index + 1;
    		   }else if(s.charAt(index) == '"'){
    			   help = false;
    			   res.add(s.substring(left , index));
    			   left = index + 1;
    		   }else if(s.charAt(index) == ' ' && !help){
    			   String tem = s.substring(left , index );
    			   if(tem == null || tem.length() == 0) {
    				   index++;
    				   left = index;
    				   continue;
    			   }
    			   res.add(tem);
    			   left = index + 1;
    		   }
    		   index++;
    	   }
    	   if(index != left){
    		   res.add(s.substring(left , index));
    	   }
    	   return res;
       }
}
