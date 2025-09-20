class Router {
    final int size;
    final Map<Integer,List<Integer>> counts;
    final Map<Long,int[]> packets;
    final Queue<Long> queue;
    public Router(int memoryLimit) {
        this.size=memoryLimit;
        this.packets=new HashMap<>();
        this.counts=new HashMap<>();
        this.queue=new LinkedList<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        final long key=encode(source,destination,timestamp);
        if(packets.containsKey(key)) return false;
        if(packets.size()>=size) forwardPacket();
        packets.put(key,new int[]{source,destination,timestamp});
        queue.offer(key);
        counts.putIfAbsent(destination,new ArrayList<>());
        counts.get(destination).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(packets.isEmpty()) return new int[]{};
        final long key=queue.poll();
        int packet []=packets.remove(key);
        if(packet==null) return new int[]{};
        final int destination=packet[1];
        final List<Integer> list=counts.get(destination);
        list.remove(0);
        return packet;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        final List<Integer> list=counts.get(destination);
        if(list==null || list.isEmpty()) return 0;
        final int l=lowerBound(list,startTime);
        final int r=upperBound(list,endTime);
        return r-l;
    }
    long encode(int source,int destination,int timestamp){
        return ((long) source<<40 ) | ((long)destination<<20)| timestamp;
    }
    int lowerBound(List<Integer>list,int target){
        int low=0;
        int high=list.size();
        while(low<high){
            int mid=(low+high)>>>1;
            if(list.get(mid)<target) low=mid+1;
            else high=mid;
        }
        return low;
    }
    int upperBound(List<Integer> list,int target){
        int low=0;
        int high=list.size();
        while(low<high){
            int mid=(low+high)>>>1;
            if(list.get(mid)<=target) low=mid+1;
            else high=mid;
        }
        return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */