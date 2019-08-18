public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if(A == null || A.length == 0) {
            return;
        }

        int len = A.length;
        int start = (len - 2) / 2;

        while(start >= 0) {
            siftDown(A, start, len - 1);
            start--;
        }
    }

    private void siftDown(int[] a, int start, int end) {
        int nodeToMove = start;

        while(nodeToMove * 2 + 1 <= end) {
            int leftChild = nodeToMove * 2 + 1;
            int rightChild = leftChild + 1;
            int swapMark = nodeToMove;

            if(leftChild <= end && a[nodeToMove] > a[leftChild]) {
                swapMark = leftChild;
            }

            if(rightChild <= end && a[swapMark] > a[rightChild]) {
                swapMark = rightChild;
            }

            if(swapMark == nodeToMove) {
                return;
            } else {
                int temp = a[nodeToMove];
                a[nodeToMove] = a[swapMark];
                a[swapMark] = temp;
                
                nodeToMove = swapMark;
            }
        }
        
    }
}
