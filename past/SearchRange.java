public class SearchRange {
    public int [] searchRange(int[] nums, int target) {
        
        int [] result = new int[] {-1, -1};

        // Corner Cases
        if(nums == null || nums.length == 0) {
            return result;
        }

        // Search for the first
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midNum = nums[mid];

            if(midNum == target) {
                end = mid;
            } else if(midNum < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(nums[start] == target) {
            result[0] = start;
        } else if(nums[end] == target) {
            result[0] = end;
        } else {
            return result;
        }

        // Search for the last
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midNum = nums[mid];

            if(midNum == target) {
                start = mid;
            } else if(midNum < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(nums[end] == target) {
            result[1] = end;
        } else {
            result[1] = start;
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}