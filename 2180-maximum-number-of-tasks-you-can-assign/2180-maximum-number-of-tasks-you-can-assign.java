class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l=0;
        int r=Math.min(tasks.length,workers.length);
        while(l<r){
            int mid=(l+r+1)/2;
            int used=0;
            TreeMap<Integer,Integer>avl=new TreeMap<>();
            for(int i=workers.length-mid;i<workers.length;i++)
                avl.put(workers[i],avl.getOrDefault(workers[i],0)+1);
                boolean can=true;
                for(int i=mid-1;i>=0;--i){
                    int t=tasks[i];
                    int w=avl.lastKey();
                    if(w>=t) dec(avl,w);
                    else{
                        Integer key=avl.ceilingKey(t-strength);
                        if(key==null || ++used>pills){
                            can=false;
                            break;
                        }
                        dec(avl,key);
                    }
                }
                if(can) l=mid;
                else r=mid-1;
            }
            return l;
        }
        public void dec(TreeMap<Integer,Integer>m,int k){
            int c=m.get(k);
            if(c==1) m.remove(k);
            else m.put(k,c-1);
        }
}