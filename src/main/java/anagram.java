import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
	
	
	public class anagram {

	public static void main(String s[]){
		
		Map<Character, Integer> map = new TreeMap<>();
		
		char input[]={'A','A','B','C'};		
		for(char ch : input){
			map.compute(ch,(key,value)->{
				if(value==null){
					return 1;
				}
				else{
					return value+1;
				}
			});
		}
	    int nums[]= {10,2,5,8,9,11,30};
	   int result= lengthOfLIS(nums);
	   System.out.println(result + "This is nums");
	}
		
	public static int lengthOfLISL(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    int[] max = new int[nums.length];
	 
	    for(int i=0; i<nums.length; i++){
	        max[i]=1;
	        for(int j=0; j<i;j++){
	        	System.out.println(nums[i] + " " + nums[j]);
	            if(nums[i]>nums[j]){
	            	System.out.println(nums[i] + " " + nums[j]);
	                max[i]=Math.max(max[i], max[j]+1);
	                System.out.println(Math.max(max[i], max[j]+1));
	            }
	        }
	    }
	 
	    int result = 0;
	    for(int i=0; i<max.length; i++){
	        if(max[i]>result)
	            result = max[i];
	    }
	    return result;
	}
	
	public static int lengthOfLIS(int[] nums) {
	    if(nums==null || nums.length==0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>(); 
	 
	    System.out.println(list.get(list.size()-1));
	    for(int num: nums){
	        if(list.size()==0 || num>list.get(list.size()-1)){
	      	            list.add(num);
	        }else{
	            int i=0; 
	            int j=list.size()-1;
	 
	            while(i<j){
	                int mid = (i+j)/2;
	                if(list.get(mid) < num){
	                    i=mid+1;
	                }else{
	                    j=mid;
	                }
	            }
	 
	            list.set(j, num);
	        }
	    }
	 
	    return list.size();
	}
	
	
 public static boolean wordPattern(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            {
	        	System.out.println(index.put(pattern.charAt(i), i) + "  inside this is ");
	    	    System.out.println(index.put(words[i], i) + " inside this is another");
	        	return false;
	            }
	        else{
	    System.out.println(index.put(pattern.charAt(i), i) + "   this is ");
	    System.out.println(index.put(words[i], i) + " this is another");
	        }

	    return true;
	}

}
