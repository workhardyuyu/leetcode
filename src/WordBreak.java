import java.util.HashSet;
import java.util.Set;

/*my thought: s.substring(0,i) can be divided into many segments, then confused.
 * 
 * weakness: I forget the previous substring follow the same rule and 
 * do not take advantage of previous string.
 * 
 * Since both current string and previous string can be divided into many segments, 
 * which means they obey the same rule,
 * then we should remember (using array or something) the combination of previous string and
 * only care about the relationship between current string and previous string.
 * 
 * So, the rule should be 
 * 1. s.substring(0,i+1) is in dictionary (!!i+1, not i)
 * 2. possible[j] is true and s.substring(j+1,i+1) is in dictionary (!!j+1, i+1, not i)
 * */

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		//corner case
        if(s.length()<1) return false;
        if(wordDict.size()<1) return false;
        
        //an array to remember possible combination of previous string
        boolean[] possible = new boolean[s.length()];
        
        //initiate first letter
        if(wordDict.contains(s.substring(0,1))) possible[0]=true;
        
        //possible situation: 1. s.substring(0,i) is in dictionary 2. possible[j] is true and s.substring(j,i) is in dictionary
        for(int i=1; i<s.length(); i++){
            for(int j=0; j<i; j++){
                if(wordDict.contains(s.substring(0,i+1)) || (possible[j] && wordDict.contains(s.substring(j+1,i+1)) )){
                    possible[i] = true;
                    break;
                }
            }
        }
        
        return possible[s.length()-1];
    }
}
