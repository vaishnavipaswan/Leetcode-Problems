class Solution {
    public int nextBeautifulNumber(int n) {
        List<Integer> list=new ArrayList<>();
        generate(0,new int[10],list);
        Collections.sort(list);
        for(int num:list){
            if(num>n) return num;
        }
        return -1;
    }
    public void generate(long num,int count[],List<Integer>list){
        if(num>0 && check(count)){
            list.add((int)num);
        }
        if(num>1224444) return;
        for(int i=1;i<=7;i++){
            if(count[i]<i){
                count[i]++;
                generate(num*10+i,count,list);
                count[i]--;
            }
        }
    }
    public boolean check(int count[]){
        for(int i=1;i<=7;i++){
            if(count[i]!=0 && count[i]!=i) return false;
        }
        return true;
    }
}