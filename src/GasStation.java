
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//corner cases
        if(gas == null || cost == null) return -1;
        if(cost.length == 1 && cost[0]>gas[0]) return -1;
        if(cost.length == 1 && cost[0]<=gas[0]) return 0;
        
        /* 1. Simplify this question to below:
         * could car arrive the last stop from the first stop?
         * this is easy. count accumulated-remain-oil, if it is smaller than 0, return false.
         * 
         * 2. Then let us see the difference between the simplified question and the original question:
         * Bus can start from any station, which means starting from 1st station may fail, but starting
         * from last one may success - surplus oil accumulated during the beginning period can cover
         * the oil shortage after it!
         * 
         * So, could we solve this difference based on the simplified solution?
         * Yes.
         * accumulated-remain-oil is important.
         * If accumulated-remain-oil >= 0, which means every station lays between this station and beginning station
         * can be start point.
         * If accumulated-remain-oil < 0, which means non station lays between this station and beginning station
         * can be start point.
         * So we can use accumulated-remain-oil to Find the Start Point, and start point has a native feature-
         * accumulated-remain-oil after start point is >=0, otherwise, it could not be start point.
         * 
         * When we find the possible start point, we only has one problem left:
         * can accumulated-remain-oil after start point cover oil shortage before it?
         * -----s++
         * A global accumulated-remain-oil can solve this problem.
         */
        
        int startPoint = 0;
        int accumulatedGlobal = 0;
        int accumulatedPeriod = 0;
        for(int i=0; i<cost.length; i++){
        	accumulatedGlobal = accumulatedGlobal + (gas[i] - cost[i]);
        	accumulatedPeriod = accumulatedPeriod + (gas[i] - cost[i]);
        	//period shortage, find possible start point
        	if(accumulatedPeriod < 0){
        		startPoint = i+1;
        		accumulatedPeriod = 0;
        	}
        }
        
        //total cost > total gas (accumulated-remain-oil after period can not cover shortage)
        if(accumulatedGlobal < 0) return -1;
        
        return startPoint;
    }
}
