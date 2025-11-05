class Solution{
    public int compare(int[] a,int[] b){
        if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
        return Integer.compare(a[1],b[1]);
    }
    public void insertInSet(TreeSet<int[]> main,TreeSet<int[]> sec,int[] p,int x,long[] sum){
        if(main.size()<x||compare(p,main.first())>0){
            main.add(p);
            sum[0]+=1L*p[0]*p[1];
            if(main.size()>x){
                int[] smallest=main.pollFirst();
                sum[0]-=1L*smallest[0]*smallest[1];
                sec.add(smallest);
            }
        }else sec.add(p);
    }
    public void removeFromSet(TreeSet<int[]> main,TreeSet<int[]> sec,int[] p,int x,long[] sum){
        if(main.remove(p)){
            sum[0]-=1L*p[0]*p[1];
            if(!sec.isEmpty()){
                int[] largest=sec.pollLast();
                main.add(largest);
                sum[0]+=1L*largest[0]*largest[1];
            }
        }else sec.remove(p);
    }
    public long[] findXSum(int[] nums,int k,int x){
        int n=nums.length;
        long[] sum=new long[1];
        HashMap<Integer,Integer> map=new HashMap<>();
        Comparator<int[]> comp=(a,b)->{
            if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        };
        TreeSet<int[]> main=new TreeSet<>(comp);
        TreeSet<int[]> sec=new TreeSet<>(comp);
        long[] res=new long[n-k+1];
        int i=0,j=0;
        while(j<n){
            int num=nums[j];
            int oldFreq=map.getOrDefault(num,0);
            if(oldFreq>0)removeFromSet(main,sec,new int[]{oldFreq,num},x,sum);
            map.put(num,oldFreq+1);
            insertInSet(main,sec,new int[]{oldFreq+1,num},x,sum);
            if(j-i+1==k){
                res[i]=sum[0];
                int outNum=nums[i];
                int outFreq=map.get(outNum);
                removeFromSet(main,sec,new int[]{outFreq,outNum},x,sum);
                if(outFreq==1)map.remove(outNum);
                else{
                    map.put(outNum,outFreq-1);
                    insertInSet(main,sec,new int[]{outFreq-1,outNum},x,sum);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
