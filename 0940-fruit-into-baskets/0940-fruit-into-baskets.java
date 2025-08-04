class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int j=0;
        int max=0;
        for(int i=0;i<fruits.length;i++){
            map.put(fruits[i],map.getOrDefault(fruits[i],0)+1);
            while(map.size()>=3){
            map.put(fruits[j],map.get(fruits[j])-1);
            if(map.get(fruits[j])==0) map.remove(fruits[j]);
            j++;
        }
        int curr= i-j+1;
        max=Math.max(max,curr);
        }
        return max;
    }
}