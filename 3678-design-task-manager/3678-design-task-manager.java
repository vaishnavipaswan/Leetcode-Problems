class TaskManager {
public PriorityQueue<int[]> pq;
public Map<Integer,Integer> prior;
public Map<Integer,Integer> task;
    public TaskManager(List<List<Integer>> tasks) {
        pq=new PriorityQueue<>((a,b)->{
            if(b[0]!=a[0]) return b[0]-a[0];
            return b[1]-a[1];
        });
        prior=new HashMap<>();
        task=new HashMap<>();
        for(List<Integer> t: tasks) add(t.get(0),t.get(1),t.get(2));
    }
    
    public void add(int userId, int taskId, int priority) {
        pq.add(new int[]{priority,taskId});
        prior.put(taskId,priority);
        task.put(taskId,userId);
    }
    
    public void edit(int taskId, int newPriority) {
        pq.add(new int[]{newPriority,taskId});
        prior.put(taskId,newPriority);
    }
    
    public void rmv(int taskId) {
        prior.put(taskId,-1);
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            int t[]=pq.poll();
            int p=t[0];
            int id=t[1];
            if(prior.getOrDefault(id,-2)==p){
                prior.put(id,-1);
                return task.getOrDefault(id,-1);
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */