class MovieRentingSystem {
    Map<Integer,TreeSet<int[]>> movies=new HashMap<>();
    Map<Integer,Set<String>> shops=new HashMap<>();
    Map<String,Integer> prices=new HashMap<>();
    TreeSet<int[]> reports=new TreeSet<>((a,b)->{
            if(a[2]!=b[2]) return a[2]-b[2];
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
    public MovieRentingSystem(int n, int[][] entries) {
        for(int i=0;i<entries.length;i++){
            int temp[]=entries[i];
            movies.putIfAbsent(temp[1],new TreeSet<>((a,b)->{
                if(a[2]==b[2]) return a[0]-b[0];
                return a[2]-b[2];
            }));
            movies.get(temp[1]).add(temp);
            shops.putIfAbsent(temp[0],new HashSet<>());
            shops.get(temp[0]).add(temp[1]+"");
            prices.put(temp[0]+"_"+temp[1],temp[2]);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res=new ArrayList<>();
        if(!movies.containsKey(movie)) return res;
        int count=0;
        for(int temp[]: movies.get(movie)){
            int shop=temp[0];
            int mov=temp[1];
            if(shops.get(shop).contains(mov+"")){
                count++;
                res.add(shop);
                if(count==5) break;
            }
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        shops.get(shop).remove(movie+"");
        int price =prices.get(shop+"_"+movie);
        reports.add(new int[]{shop,movie,price});
    }
    
    public void drop(int shop, int movie) {
        shops.get(shop).add(movie+"");
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> reportRes=new ArrayList<>();
        int count=0;
        for(int temp[]: reports){
            if(!shops.get(temp[0]).contains(temp[1]+"")){
                count++;
                List<Integer>list=Arrays.asList(temp[0],temp[1]);
                reportRes.add(list);
                if(count==5) break;
            }
        }
        return reportRes;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */