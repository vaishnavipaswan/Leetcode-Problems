/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int p=peak(mountainArr);
        int n1=search(mountainArr,target,0,p);
        int n2=search(mountainArr,target,p+1,mountainArr.length()-1);
        if(n1!=-1) return n1;
        else return n2;
    }
    public static int search(MountainArray nums,int target,int start,int end){
        boolean isAsc=nums.get(start)<nums.get(end);
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums.get(mid)==target) return mid;
            if(isAsc){
            if(target<nums.get(mid)) end=mid-1;
            else start=mid+1;
            }
            else{
                if(target>nums.get(mid)) end=mid-1;
                else start=mid+1;
            }
        }
        return -1;
    }
    public static int peak(MountainArray  mountainArr){
        int start=0;
        int end=mountainArr.length()-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)) end=mid;
            else start=mid+1;
        }
        return start;
    }
}