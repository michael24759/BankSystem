
public class Account {
	
    protected int accountId;
    protected double balance;
    protected Client owner; //Dari Client
    protected static int ID = 1;
    
    //Constructor
    public Account() {   
        balance = 0;
        accountId = ID++;
    }
    
    public Account(double balance) {
        this.balance = balance;
        accountId = ID++;
    }
    
    //Setter & Getter
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Account.ID = ID;
    }
    
     public Client getOwner()
    {
        return owner;
    }

    public void setOwner(Client owner)
    {
        this.owner = owner;
    }
    
    //Method Withdraw
    public boolean withdraw(double amountOfMoney){
    
        if(amountOfMoney < 0){
            System.err.println("Invalid amount");
            return false;
        }
        if(amountOfMoney > balance){
            System.err.println("Insufficient balance");
            return false;
        }
        balance -= amountOfMoney;
        return true;
    }
    
    //Method Deposit
    public boolean deposit(double amount){
        if(amount <= 0){
            System.err.println("invalid amount");
            return false;
        }
        balance += amount;
        return true;
    }
    
    //Method view()
    public void view(){
        System.out.println("Account ID : " + accountId);
        System.out.println("Account Type : Basic");
        System.out.println("Account Balance : Rp" + balance);
        owner.view();
    }
}