class Solution {
    public int countWays(List<Integer> arr) {
        Collections.sort(arr);
        int ways=0, ans=0;
        
         if(arr.get(0)>ans){
           
            ways++;
        }
         ans++;
        for(int i=1;i<arr.size();i++){
          
       
              if(arr.get(i-1)<ans && arr.get(i)>ans){
                ways++;
            }
          
               ans++;
          
        }
        
                if(arr.get(arr.size()-1)<ans){
                    ans++;
                    ways++;
                  }
        
        return ways;
    }
}