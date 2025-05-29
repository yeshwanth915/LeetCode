class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length+1;
        int n2 = edges2.length+1;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        createAdj(adj1,edges1,n1);
        createAdj(adj2,edges2,n2);

        int[] color1 = new int[n1];
        Arrays.fill(color1,-1);
        int[] count1 = new int[2];
        bipartite(adj1,color1,count1);

        int[] color2 = new int[n2];
        Arrays.fill(color2,-1);
        int[] count2 = new int[2];
        bipartite(adj2,color2,count2);

        int maxSecond = Math.max(count2[0],count2[1]);
        int[] ans = new int[n1];
        for(int i = 0; i < n1; i++){
            ans[i] = count1[color1[i]]+maxSecond;
        }
        return ans;
    }
    private void bipartite(List<List<Integer>> adj,int[] color, int[] count){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        color[0] = 0;
        count[0] = 1;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : adj.get(u)){
                if(color[v] == -1){
                    color[v] = 1 - color[u];
                    count[color[v]]++;
                    queue.add(v);
                }
            }
        }
    }
    private void createAdj(List<List<Integer>> adj, int[][] edges, int nodes){
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }
}