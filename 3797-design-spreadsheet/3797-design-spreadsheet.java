class Spreadsheet {
Map<String,Integer> cells=new HashMap<>();
    public Spreadsheet(int rows) {
        
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell,value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        int i=formula.indexOf('+');
        String l=formula.substring(1,i);
        String r=formula.substring(i+1);
        int lval=Character.isLetter(l.charAt(0))?cells.getOrDefault(l,0):Integer.parseInt(l);
        int rval=Character.isLetter(r.charAt(0))?cells.getOrDefault(r,0):Integer.parseInt(r);
        return lval+rval;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */