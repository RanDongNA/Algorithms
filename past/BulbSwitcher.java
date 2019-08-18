public class Solution {
    public int bulbSwitch(int n) {
        if(n < 0) {
        	return 0;
        }

        if(n < 4) {
        	return 1;
        }

        int last = (n - 1) % 6 <= 3 ? 1 : (n - 1) % 6 - 2;
        int afterRound3 = 1 + (n - 1) / 6 * 3 + last; 
        boolean lastIsOn = (n + 1) % 6 < 3;
        int toggleTimes = n - 3;
        if(toggleTimes % 2 != 0) {
        	if(lastIsOn) {
        		afterRound3 -= 1;
        	} else {
        		afterRound3 += 1;
        	}
        }

        return afterRound3;
    }
}


0: f f f f f f  f f f f f f

1: o o o o o o  o o o o o o

2: o f o f o f  o f o f o f

3: o f f f o o  o f f f o o - 6

4: o f f f o o  o f f f o f - 5

1-1
2-1
3-1
4-1
5-2
6-3
7-4
8-4
9-4
10-4
11-5
12-6

(n - 1) % 6 <= 3 -> 1
(n - 1) % 6 > 3 -> (n - 1) % 6 - 2 