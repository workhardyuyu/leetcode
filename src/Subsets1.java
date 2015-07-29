import java.util.*;


public class Subsets1 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        //corner case
        if(nums.length == 0) return result;
        
        Arrays.sort(nums);
        
        //add each element into result
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            //we will extend result in the for loop, so we have to get its cur size first
            int curResultSize = result.size();
            
            //insert new digit as a subset
            List<Integer> temp  = new ArrayList();
            temp.add(cur);
            result.add(temp);
            
            //combine new digit with existed subsets
            for(int j=1; j<curResultSize; j++){
            	//Cannot use get directly!! pointer!!!
                temp = new ArrayList(result.get(j));
                temp.add(cur);
                result.add(temp);
            }
        }
        
        return result;
    }

}
