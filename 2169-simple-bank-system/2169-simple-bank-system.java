class Bank {
    public final long balance[];
    public final int n;
    public Bank(long[] balance) {
        this.balance=balance;
        this.n=balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!valid(account1)||!valid(account2)|| balance[account1-1]<money) return false;
        balance[account1-1]-=money;
        balance[account2-1]+=money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!valid(account)) return false;
        balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!valid(account)||balance[account-1]<money) return false;
        balance[account-1]-=money;
        return true;
    }
    public boolean valid(int account){
        return account>0 && account<=n;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */