class Solution {
    public String clearStars(String s) {
        char[] nums=s.toCharArray();
        List<Integer>pos[]=new ArrayList[26];
        PriorityQueue<Character> q= new PriorityQueue<>();
        for(int i=0;i<26;i++) pos[i]=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            char c=nums[i];
            if(c=='*'){
                char small=q.peek();
                List<Integer>l=pos[small-'a'];
                int j=l.remove(l.size()-1);
                nums[j]='*';
                if(l.isEmpty()) q.poll();
            }
            else{
                int ci=c-'a';
                if(pos[ci].isEmpty()) q.add(c);
                pos[ci].add(i);
            }
        }
        StringBuilder res=new StringBuilder();
        for(char c:nums) if(c!='*') res.append(c);
        return res.toString();
    }
}