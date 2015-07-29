import java.util.*;


public class Subsets2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList());
        
        //corner case
        if(nums.length < 1) return result;
        
        Arrays.sort(nums);
        
        //add each element into result
        for(int i=0; i<nums.length; i++){
            //count cur digit duplicates
            int counter = 1;
            int cur = nums[i];
            i++;
            for(; i<nums.length; i++){
                if(nums[i]==cur) counter++;
                else break;
            }
            i--;
            
            //add all possible dup combinations
            ArrayList<ArrayList<Integer>> dup = new ArrayList<ArrayList<Integer>>();
            for(int j=1; j<=counter; j++){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int k=0; k<j; k++){
                    temp.add(cur);
                }
                dup.add(temp);
            }
            
            
            //get current result size
            int curResultSize = result.size();
            
            //add all dup combines into result
            result.addAll(dup);
            
            //combine all possible combination with existed subsites
            for(int j=1; j<curResultSize; j++){
                for(int k=0; k<dup.size(); k++){
                	ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
                    temp.addAll(new ArrayList<Integer>(dup.get(k)));
                    result.add(temp);
                }
            }
        }
        
        return result;
    }
}
