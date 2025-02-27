class Solution {
    public static int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int maxLength = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j], length = 2;
                while (set.contains(a + b)) {
                    int temp = a + b;
                    a = b;
                    b = temp;
                    length++;
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength >= 3 ? maxLength : 0;
    }
}