public class StrictAccount extends Account
{
    private double MinimumBalance;
    
    //Constructor
    public StrictAccount(double balance){
        super(balance);
        MinimumBalance = 1000000;
    }
    
    //Setter & Getter
    public double getMinimumBalance() {
        return MinimumBalance;
    }

    public void setMinimumBalance(double MinimumBalance) {
        this.MinimumBalance = MinimumBalance;
    }
    
    //Override method withdraw dari Account
    @Override
    public boolean withdraw(double Amount) {
        if(balance - Amount >= MinimumBalance){
            balance -= Amount;
            return true;
        }
        System.err.println("Invalid amount");
        return false;
    }
    
    //Override method deposit dari Account
    @Override
    public boolean deposit(double Amount) {
        if(Amount < 100000){
            System.err.println("Invalid amount | Minimum amount: Rp100.000");
            return false;
        }
        balance += Amount;
        return true;
    }
    
    //Override method view dari Account
    @Override
    public void view(){
        System.out.println("Account ID : " + accountId);
        System.out.println("Account Type : Strict");
        System.out.println("Account Balance : Rp" + balance);
        owner.view();
    }
}