class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<Integer>[] leftSum = new ArrayList[n + 1];
        List<Integer>[] rightSum = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSum[i] = new ArrayList<>();
            rightSum[i] = new ArrayList<>();
        }

        generate(left, 0, 0, 0, leftSum);
        generate(right, 0, 0, 0, rightSum);

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSum[i]);
        }

        int total = 0;
        for (int x : nums) total += x;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            List<Integer> l = leftSum[i];
            List<Integer> r = rightSum[n - i];

            for (int s1 : l) {
                int target = total / 2 - s1;

                int idx = Collections.binarySearch(r, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < r.size()) {
                    int sum = s1 + r.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                if (idx > 0) {
                    int sum = s1 + r.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }

    private void generate(int[] arr, int index, int count, int sum,
                          List<Integer>[] list) {
        if (index == arr.length) {
            list[count].add(sum);
            return;
        }

        generate(arr, index + 1, count, sum, list);
        generate(arr, index + 1, count + 1, sum + arr[index], list);
    }
}