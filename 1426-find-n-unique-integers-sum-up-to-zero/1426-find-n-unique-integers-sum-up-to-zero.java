class Solution {
    public int[] sumZero(int n) {
        int arr[]=new int[n];
        int num=1;
        for(int i=0;i<n/2;i++){
            arr[i]=num;
            arr[n-1-i]=-num;
            num++;
        }
        if(n%2!=0) arr[n/2]=0;
        return arr;
    }
}