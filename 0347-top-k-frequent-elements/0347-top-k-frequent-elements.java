class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[]=new int[k];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        List<Integer> freq[]=new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(freq[entry.getValue()]==null) freq[entry.getValue()]=new ArrayList<>();
            freq[entry.getValue()].add(entry.getKey());
        }
        int j=0;
        for(int i=freq.length-1;i>=0;i--){
            if(freq[i]!=null){
                for(int l=0;l<freq[i].size();l++){
                    if(j<res.length){
                        res[j]=freq[i].get(l);
                        j++;
                    }
                    else break;
                }
                if(j>res.length-1) break;
            }
        }
        return res;
    }
}