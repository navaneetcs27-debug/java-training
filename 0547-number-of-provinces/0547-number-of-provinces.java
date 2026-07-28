class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int city = queue.poll();

                    for (int j = 0; j < n; j++) {
                        if (isConnected[city][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }

                provinces++;
            }
        }

        return provinces;
    }
}