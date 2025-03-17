class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int [][] arr=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            arr[i][0]=nums[i];
            arr[i][1]=map.get(nums[i]);
        }
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                if(a[1]!=b[1]) return a[1]-b[1];
                else return b[0]-a[0];
            }
        });
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i][0];
        }
        return nums;
    }
}