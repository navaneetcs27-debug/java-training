class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;

        for (int w : weights) {
            if (w > low) {
                low = w;
            }
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int d = 1;
        int load = 0;

        for (int w : weights) {
            if (load + w > capacity) {
                d++;
                load = 0;
            }
            load += w;
        }

        return d <= days;
    }
}