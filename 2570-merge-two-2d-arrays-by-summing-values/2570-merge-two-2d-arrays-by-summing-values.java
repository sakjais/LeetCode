class Solution {
    public int[][] mergeArrays(int[][] a, int[][] b) {
       HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i][0])) {
                map.put(a[i][0], map.get(a[i][0]) + a[i][1]);
            } else {
                map.put(a[i][0], a[i][1]);
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i][0])) {
                map.put(b[i][0], map.get(b[i][0]) + b[i][1]);
            } else {
                map.put(b[i][0], b[i][1]);
            }
        }
        int[] c = new int[map.size()];
        int length = 0;
        for(java.util.Map.Entry<Integer,Integer>entry:map.entrySet()){
            c[length++] = entry.getKey();
        }
        Arrays.sort(c);
        int[][] d = new int[map.size()][2]; 
        for(int i = 0;i<map.size();i++){
            d[i][0] = c[i];
            d[i][1] = map.get(c[i]);
        }
        return d;
    }
}