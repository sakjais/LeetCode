class Solution {
    int n;
    String [] words;
    int [] groups;
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) { 
        this.n=n;
        this.words=words;
        this.groups=groups;
        
        List<String> res=new ArrayList<>();
        
        List<String> res1= helper(0,res,0);
        List<String> res2=helper(0,res,1);
        if(res1.size()>res2.size()){
            return res1;
        }else{
            return res2;
        }
    }
    
    public List<String> helper(int i,List<String> curr, int currBit){
        if(i>=n) return curr;
        
        if(groups[i]==currBit){
            return helper(i+1,curr,currBit);
        }
        
        List<String> res2=new ArrayList<>(curr);
        res2.add(words[i]);

        return helper(i+1, res2, groups[i]);
        
    }
    
    
}