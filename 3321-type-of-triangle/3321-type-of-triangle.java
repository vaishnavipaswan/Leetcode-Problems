class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer>tri=new HashSet<>();
        for(int i:nums) tri.add(i);
        if(nums[0]+nums[1]<=nums[2]) return "none";
        if(tri.size()==1) return "equilateral";
        if(tri.size()==2) return "isosceles";
        else return "scalene";
        
    }
}