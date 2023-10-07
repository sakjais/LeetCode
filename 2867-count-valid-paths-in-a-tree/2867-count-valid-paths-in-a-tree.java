class Solution {
    List<Integer>[] G;
    long ans = 0;
    public long countPaths(int n, int[][] edges) {
        G = new ArrayList[n+1];
        for (int i=0; i <= n; i++) {
            G[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            G[e[0]].add(e[1]);
            G[e[1]].add(e[0]);
        }
        dfs(1, -1);
        return ans;
    }
    

    public long[] dfs(int u, int prev) { 
        
        boolean isp = isPrime(u);
        
        long primeChildren = 0;
        long nonPrimeChildren = 0;
        
        for (int v : G[u]) {
            if (v == prev) {
                continue;
            }
            long[] next = dfs(v, u);
            if ( ! isp) {
                ans += primeChildren * next[1];
                ans += nonPrimeChildren * next[0];
            } else {
                ans += nonPrimeChildren * next[1];
            }        
            primeChildren += next[0];
            nonPrimeChildren += next[1];
        }
        
        long[] res = new long[2];
        if (isp) {
            ans += nonPrimeChildren;
            res[0] = nonPrimeChildren+1;
        } else {
            ans += primeChildren;
            res[0] = primeChildren;
            res[1] = nonPrimeChildren+1;
        }
        return res;
    }
    
    
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}