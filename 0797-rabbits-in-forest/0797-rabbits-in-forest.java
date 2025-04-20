class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> r : map.entrySet()) {
            count += Math.ceil((double) r.getValue() / (r.getKey() + 1)) * (r.getKey() + 1);
        }
        return count;
    }
}