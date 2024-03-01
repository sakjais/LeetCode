class Solution {
    private class Node {
        private HashMap<List<Character>, Node> map = new HashMap<>();
        private int count;
    }
    public long countPrefixSuffixPairs(String[] words) {
        Node root=new Node();
        long cnt=0;
        for(String s:words){
            Node n=root;
            int len=s.length();
            for(int i=0;i<len;i++){
                cnt+=(n=n.map.computeIfAbsent(List.of(s.charAt(i),s.charAt(len-i-1)),t->new Node())).count;
            }
            n.count++;
        }
        return cnt;
    }
}