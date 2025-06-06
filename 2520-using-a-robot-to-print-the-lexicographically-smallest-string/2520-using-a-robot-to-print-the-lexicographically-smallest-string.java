class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack=new Stack<>();
        int f[]=new int[26];
        for(char c:s.toCharArray()) f[c-'a']++;
        StringBuilder t=new StringBuilder();
        for(char ch:s.toCharArray()){
            stack.push(ch);
            f[ch-'a']--;
            while(!stack.isEmpty() && stack.peek()<=small(f)) t.append(stack.pop());
        }
            while(!stack.isEmpty()) t.append(stack.pop());
        return t.toString();
    }
    public char small(int f[]){
        for(int i=0;i<26;i++){
            if(f[i]>0) return (char)('a'+i);
        }
        return 'a';
    }
}