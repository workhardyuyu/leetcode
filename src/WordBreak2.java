import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class WordBreak2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        //corner case
        if(s.length()<1) return result;
        if(wordDict.size()<1) return result;
        
        //an arraylist of arrayList<Integer> to remember all possible start poins of each position
        ArrayList<ArrayList<Integer>> possible = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        possible.add(temp);
        if(wordDict.contains(s.substring(0,1))) temp.add(0);
        
        //possible situation: 1. s.substring(0,i+1) is in dictionary 2. possible[j] is true and s.substring(j+1,i+1) is in dictionary
       for(int i=1; i<s.length(); i++){
           temp = new ArrayList<Integer>();
           possible.add(temp);
           
           if(wordDict.contains(s.substring(0,i+1))) temp.add(0);
           
           for(int j=0; j<i; j++){
               if(possible.get(j).size()>0 && wordDict.contains(s.substring(j+1,i+1)) ) temp.add(j);
           }
       }
       
       //if no combination return null result
       if(possible.get(s.length()-1).size() < 1) return result;
       
       //back trace all possible start point, !! treat number array 01234 as string is much easier!!
       ArrayList<String> allIndexes = new ArrayList<String>();
       for(Integer index: possible.get(s.length()-1)){
           int end = s.length()-1;
           allIndexes.add(String.valueOf(index) + String.valueOf(end));
       }
       
       while(true){
           boolean flag = false;
           ArrayList<String> oldAllIndexes = allIndexes;
           allIndexes = new ArrayList<String>();
           //check every last digit of all records in allIndexes, if 0, continue, if not, record all 
           for(int i=0; i< oldAllIndexes.size(); i++){
               char index = oldAllIndexes.get(i).charAt(0);
               if( index == '0'){
                   allIndexes.add(oldAllIndexes.get(i));
                   continue;
               }
               
               flag = true;
               for(int j=0; j< possible.get(index-'0').size(); j++){
                   allIndexes.add(possible.get(index-'0').get(j) + oldAllIndexes.get(i));
               }
               
           }
           
           if(flag == false) break;
       }
       
       //build all results
       for(int i=0; i<allIndexes.size(); i++){
           String indexes = allIndexes.get(i);
           String tempResult = s.substring(0, indexes.charAt(1)-'0'+1);;
           
           for(int j=2; j<indexes.length(); j++){
               int start = indexes.charAt(j-1)-'0';
               int end = indexes.charAt(j)-'0';
               tempResult = tempResult + " "+ s.substring(start+1, end+1);
           }

           result.add(tempResult);
       }
       
       //return
       return result;
        
    }
}
