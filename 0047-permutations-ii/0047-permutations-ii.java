class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i:nums) mp.put(i,mp.getOrDefault(i,0)+1);
        res= permute(nums,tempList,res,mp);
        return res;
    }
    public List<List<Integer>> permute(int[] nums, List<Integer> tempList, List<List<Integer>> res,HashMap<Integer,Integer> mp){
        if(tempList.size()==nums.length && !res.contains(tempList)) {
            res.add(new ArrayList<>(tempList));
        }
        else{
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            if(entry.getValue()>0){
                tempList.add(entry.getKey());
                mp.put(entry.getKey(),entry.getValue()-1);
                permute(nums,tempList,res,mp);
                mp.put(tempList.get(tempList.size()-1),mp.get(tempList.get(tempList.size()-1))+1);
                tempList.remove(tempList.size()-1);
            }
        }
        }
        return res;
    }

}