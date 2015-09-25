public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int lo = 1,hi = n;
		while(lo<=hi) {
		    int med = (lo+hi)/2;
			if(isBadVersion(med)) {
				if(med==1 || !isBadVersion(med-1))
					return med;
				hi = med;				
			} else {
				lo = med+1;
			}
		}
		return -1;
	}
}

 public int firstBadVersion(int n) {
    int lo = 1, hi = n;
    while (lo <= hi) {
        int med = lo + (hi -  lo)/2;
        if (isBadVersion(med)) {
            if (med == 1 || !isBadVersion(med-1))
                return med;
            hi = med;
        } else {
            lo = med + 1;
        }
    }
    return -1; //no solution found.
}