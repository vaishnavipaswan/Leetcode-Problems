class Solution {
    int mod = (int) 1e9 + 7;
    public int maximumScore(List<Integer> nums, int k) {
        int n=nums.size();
        int arr[][]=new int[n][0];
        for(int i=0;i<n;i++){
            arr[i]=new int[]{i,prime(nums.get(i)),nums.get(i)};
        }
        int left[]=new int[n];
        int right[]=new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        Deque<Integer> s=new ArrayDeque<>();
        for(int [] a: arr){
            int i=a[0],f=a[1];
            while(!s.isEmpty() && arr[s.peek()][1]<f){
                s.pop();
            }
            if(!s.isEmpty()){
                left[i]=s.peek();
            }
            s.push(i);
        }
         s.clear();
        for(int i=n-1;i>=0;--i){
            int f=arr[i][1];
            while(!s.isEmpty() && arr[s.peek()][1]<=f){
                s.pop();
        }
        if(!s.isEmpty()){
            right[i]=s.peek();
        }
        s.push(i);
    }
    Arrays.sort(arr,(a,b)->b[2]-a[2]);
    long ans=1;
    for(int [] a: arr){
        int i=a[0],x=a[2];
        int l=left[i],r=right[i];
        long count=(long)(i-l)*(r-i);
        if(count<=k){
            ans=ans*qpow(x,count)% mod;
            k-=count;
        }
        else{
            ans=ans*qpow(x,k)%mod;
            break;
        }
    }
    return (int) ans;
   }
   int prime(int n){
    int i=2;
    Set<Integer> res=new HashSet<>();
    while(i<=n/i){
        while(n%i==0){
            res.add(i);
            n/=i;
        }
        i++;
    }
    if(n>1){
        res.add(n);
    }
    return res.size();
   }
   int qpow(long a,long n){
    long ans=1;
    while(n>0){
        if((n&1)==1){
            ans=ans*a%mod;
        }
        a=a*a%mod;
        n>>=1;
      }
      return (int) ans;
    }
}