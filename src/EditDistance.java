
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int result = 0;
		if(word1.length() == 0) return word2.length();
		if(word2.length() == 0) return word1.length();
		
		//make sure word1.length() <= word2.length()
		if(word2.length() < word1.length()){
			String temp = word1;
			word1=word2;
			word2=temp;
		}
		
		/*i-> word1 index, j->word2 index
		 *word1.substring(0,i) -> word2.substring(0,j):
		 *
		 *1. if word1.charAt(i) == word2.chatAt(j), then D(i,j) = D(i-1,j-1);
		 *
		 *2. if word1.charAt(i) != word2.chatAt(j), 
		 *      D(i,j) = Math.min(D(i-1,j), D(i,j-1), D(i-1,j-1)) + 1;
		 *      
		 *Fill pattern
		 *1.1 1.2 1.3 1.4 1.5
		 *1.2 2.1 2.2 2.3 2.4
		 *1.3 2.2 3.1 3.2 3.3
		 */
		
		int[][] matrix = new int[word1.length()+1][word2.length()+1];
		for(int i=0; i<word1.length()+1; i++) matrix[i][0] = i;
		for(int i=0; i<word2.length()+1; i++) matrix[0][i] = i;
		
		for(int i=1; i<word1.length()+1; i++){
			for(int j=i; j<word2.length()+1; j++){
				int row = i; int col =j;
				if(word1.charAt(row-1) == word2.charAt(col-1)) matrix[row][col] = matrix[row-1][col-1];
				else{
					matrix[row][col] = Math.min(matrix[row-1][col], matrix[row][col-1]);
					matrix[row][col] = Math.min(matrix[row][col], matrix[row-1][col-1]);
					matrix[row][col] = matrix[row][col] + 1;
				}
				
				if(row!=col && j>=word1.length()+1) continue;
				row = j; col = i;
				if(word1.charAt(row-1) == word2.charAt(col-1)) matrix[row][col] = matrix[row-1][col-1];
				else{
					matrix[row][col] = Math.min(matrix[row-1][col], matrix[row][col-1]);
					matrix[row][col] = Math.min(matrix[row][col], matrix[row-1][col-1]);
					matrix[row][col] = matrix[row][col] + 1;
				}
			}
		}
		
        return matrix[word1.length()][word2.length()];
    }
}
