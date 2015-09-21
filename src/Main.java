import java.util.HashSet;
import java.util.Set;


public class Main {
	public static void main(String[] str){
		UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
		int[] a = {1,2,2};
		int[] b = {2,1,5,1};
		Set<String> set = new HashSet<String>();
		set.add("go");
		set.add("goal");
		set.add("goals");
		set.add("specia");
		System.out.println(s.numTrees(6));
	}
}
