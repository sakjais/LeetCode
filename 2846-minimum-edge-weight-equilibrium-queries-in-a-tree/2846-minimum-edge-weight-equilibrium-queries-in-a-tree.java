class Solution {
    List<List<int[]>> graph;
    int[] parentOf;
    int[] depthLevel;
    int[][] wtFreq;
    int[][] parentOfMatrix;
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        graph = new ArrayList<>();//shows how the connections are made in the tree
        parentOf = new int[n];
        depthLevel = new int[n]; //shows depth level of each node
        wtFreq = new int[n][27];//from root to a particular node what is the freq of occurence of a pariticular weight value

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        //forming the graph or say tree 
        for(int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        populateData(0, -1, 1, new int[27]);
        parentOf[0] = 0;
        //used binary lifting here
        parentOfMatrix = buildparentOfMatrix();

        int[] results = new int[queries.length];

        for(int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            int LcaUsingBinaryLifting = LcaUsingBinaryLifting(u, v);
            //total number of weightValues occruring between vertex u and v minus the freq of weightValue occuring maximum number of times between vertex or say node u and v is the answer for the current query
            int maxFreq_U_V = 0, totalWtFreq_U_V = 0;

            for(int wtVal = 1; wtVal <= 26; wtVal++) {
                int freq = wtFreq[LcaUsingBinaryLifting][wtVal];
                int freqU = wtFreq[u][wtVal];
                int freqV = wtFreq[v][wtVal];

                totalWtFreq_U_V += freqU + freqV - 2 * freq;

                if(freqU + freqV - 2 * freq > maxFreq_U_V) {
                    maxFreq_U_V = freqU + freqV - 2 * freq;
                }
            }

            results[q] = totalWtFreq_U_V - maxFreq_U_V;
        }

        return results;
    }

    private int LcaUsingBinaryLifting(int u, int v) {
        if(depthLevel[u] > depthLevel[v]) {
            return LcaUsingBinaryLifting(v, u);
        }

        int depthLevelDiff = depthLevel[v] - depthLevel[u];

       //bring the nodes at the same level, for that start form the more deep node and going their depthLevel difference upward 
        for(int bitPos = 0; bitPos < 31; bitPos++) {
            if((depthLevelDiff & (1 << bitPos)) != 0) {
                int parentOfOfV = parentOfMatrix[bitPos][v];
                v = parentOfOfV;
            }
        }
        
        //to check if the one of them is LcaUsingBinaryLifting of other
        //in case u is LcaUsingBinaryLifting of both u and v
        if(u == v) return v;

        //starting from root, keep finding the common ancestor 
        for(int bitPos = 30; bitPos >= 0; bitPos--) {
            //if there comes a point when there ancesstors are not equal move u and v to their ancestors
            if(parentOfMatrix[bitPos][u] != parentOfMatrix[bitPos][v]) {
                u = parentOfMatrix[bitPos][u];
                v = parentOfMatrix[bitPos][v];
            }
        }
        //finally the lca will be their immediate parent, therefore return it
        return parentOfMatrix[0][v];
    }
    //DFS of graph or say tree
    //populateData is used to populate the depthLevel, parentOf, and wtFreq arrays or say vector which will help us to calculate LcaUsingBinaryLifting and answer the queries
    private void populateData(int node, int par, int level, int[] wts) {
        depthLevel[node] = level;
        parentOf[node] = par;

        for(int i = 0; i <= 26; i++) {
            wtFreq[node][i] = wts[i];
        }

        for(int[] child : graph.get(node)) {
            if(child[0] == par) continue;

            wts[child[1]]++;
            populateData(child[0], node, level + 1, wts);
            wts[child[1]]--;
        }
    }

    //binary lifting used here 
    private int[][] buildparentOfMatrix() {
        int n = parentOf.length, limit = 31;
        int[][] parMat = new int[limit][n];
        
        //for immediate parents of each node they will be same as that of parent array
        parMat[0] = parentOf;
        
        //form indx to (2 ^ bitPos) upward in the graph or say tree
        for(int bitPos = 1; bitPos < limit; bitPos++) {
            for(int indx = 0; indx < n; indx++) {
                //parent (2^(bitPos-1)) upward
                // currNode----->((2^(bitPos-1)) upward from currNode)(prevParent)----------->(2^(bitPos-1)) upward form prevParent-------->target(parMat[bitPos][indx])((2^(bitPos)) upward from)
                int prevParent = parMat[bitPos - 1][indx];
                parMat[bitPos][indx] = parMat[bitPos - 1][prevParent];
            }
        }

        return parMat;
    }
}