import java.util.*;

class Solution {

    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        int MOD = 1_000_000_007;

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            if (cur.dist > dist[cur.node])
                continue;

            for (Pair nei : graph.get(cur.node)) {

                long newDist = cur.dist + nei.dist;

                if (newDist < dist[nei.node]) {

                    dist[nei.node] = newDist;
                    ways[nei.node] = ways[cur.node];

                    pq.offer(new Pair(nei.node, newDist));
                }

                else if (newDist == dist[nei.node]) {

                    ways[nei.node] =
                            (ways[nei.node] + ways[cur.node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}