public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        int numEdges = edges.length;
        if (numEdges != n-1) {
            return false;
        }
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
            rank[node] = 1;
        }
        for (int[] edge: edges) {
            if (!union(edge[0], edge[1], parent, rank)) {
                return false;
            }
        }
        return true;
    }
    public int find(int node, int[] parent) {
        int p = parent[node];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public boolean union(int node1, int node2, int[] parent, int[] rank) {
        int p1 = find(node1, parent);
        int p2 = find(node2, parent);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
