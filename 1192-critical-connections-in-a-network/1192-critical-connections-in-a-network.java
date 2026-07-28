import java.util.*;

class Solution {
    List<List<Integer>> graph;
    List<List<Integer>> ans;
    int[] disc, low;
    int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList<>();
        ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc, -1);

        time = 0;

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, -1);
            }
        }

        return ans;
    }

    private void dfs(int u, int parent) {
        disc[u] = low[u] = time++;

        for (int v : graph.get(u)) {
            if (v == parent)
                continue;

            if (disc[v] == -1) {
                dfs(v, u);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    ans.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}