
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//corner cases
        if(gas == null || cost == null) return -1;
        if(cost.length == 1 && cost[0]>gas[0]) return -1;
        if(cost.length == 1 && cost[0]<=gas[0]) return 0;
        
        /* First, count how much oil left at each station. 
         * If accumulated oil is smaller than 0 at a station,
         * that means start-station could not locate between dummy starter station and that station.
         * And that also means start-station only locates in the rest period (from i+1).
         * There could be multiple period whose accumulated oil is smaller than 0,
         * which means the accumulated oil in rest period should cover whole previous shortage.
         * (Global accumulated left-oil should > 0)*/
        int startPoint = 0;
        int accumulatedGlobal = 0;
        int accumulatedPeriod = 0;
        for(int i=0; i<cost.length; i++){
        	accumulatedGlobal = accumulatedGlobal + (gas[i] - cost[i]);
        	accumulatedPeriod = accumulatedPeriod + (gas[i] - cost[i]);
        	//period shortage
        	if(accumulatedPeriod < 0){
        		startPoint = i+1;
        		accumulatedPeriod = 0;
        	}
        }
        
        //total cost > total gas (rest does not cover whole previous shortage)
        if(accumulatedGlobal < 0) return -1;
        
        return startPoint;
    }
}
