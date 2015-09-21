public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
        //a kind of statistic problem
        //if I choose a digit as root randomly, then Number of leftBranch * rightBranch
        //base case: if n=0 return 1; n=1, return 1; n=2 return 2; n=3 return 5; n=4, return 14;
        //so if n=4; 1*5+1*2+2*1+5*1 = 14
		//so if n=5; 1*14+1*5+2*2+5*1+ 14*1= 42
        //so I need an array to store those information
        if(n<1) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 5;
        
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        array[3] = 5;
        
        for(int i=4; i<n+1; i++){
            int left = 0; int right= i-1;
            while( left<right){
                array[i] += 2*array[left]*array[right];
                left++; 
                right=i-1-left;
            }
            
            
            //if number of digits at left == right
            if(left == right) array[i] += array[left]*array[right];
            
        }
        
        return array[n];
    }

}
