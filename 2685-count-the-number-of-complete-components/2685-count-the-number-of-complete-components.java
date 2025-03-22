class Solution {
    ArrayList<Integer> [] adj;
    boolean[] visit;
    public int countCompleteComponents(int n, int[][] edges) {
        adj = new ArrayList[n];
        for(int i = 0;i < n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] ele: edges){
            adj[ele[0]].add(ele[1]);
            adj[ele[1]].add(ele[0]);
        }
        int cnt = 0;
        visit = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visit[i]){
                ArrayList<Integer> collect = new ArrayList<>();
                dfs(i, collect);
                int len = collect.size();
                int op = 0;
                for(int ele: collect){
                    if(len-1 != adj[ele].size()){
                        op = 1;
                        break;
                    }
                }
                if(op == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int node, ArrayList<Integer> collect){
        visit[node] = true;
        collect.add(node);
        for(int ele: adj[node]){
            if(!visit[ele]){
                dfs(ele, collect);
            }
        }
    }
}