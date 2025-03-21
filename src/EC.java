public class EC {
    public static int[] sumTarget(int[] A, int K) {
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < A.length; right++) {
            currentSum += A[right]; // Expand window by adding right element

            // Shrink window from left if sum exceeds K
            while (currentSum > K && left <= right) {
                currentSum -= A[left];
                left++;
            }

            // Check if we found the target sum
            if (currentSum == K) {
                return new int[]{left, right}; // Return found subarray indices
            }
        }

        return new int[]{-1, -1}; // No valid subarray found
    }

    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 7, 5};
        int K1 = 12;
        System.out.println(java.util.Arrays.toString(sumTarget(A1, K1))); // [1, 3] or [3, 4]

        int[] A2 = {1, 2, 3, 7, 5};
        int K2 = 5;
        System.out.println(java.util.Arrays.toString(sumTarget(A2, K2))); // [1, 2] or [4, 4]

        int[] A3 = {1, 2, 3, 7, 5};
        int K3 = 7;
        System.out.println(java.util.Arrays.toString(sumTarget(A3, K3))); // [3, 3]

        int[] A4 = {1, 2, 3, 7, 5};
        int K4 = 11;
        System.out.println(java.util.Arrays.toString(sumTarget(A4, K4))); // [-1, -1]
    }
}
