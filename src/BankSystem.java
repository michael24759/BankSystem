import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

    static ArrayList<Client> Clients;
    static ArrayList<Account> Accounts;
    static Scanner input;
    
    //Method untuk menambahkan akun
    static void addAccount(){
    	//Data Client
        System.out.print("Enter client name: ");
        String name = input.nextLine();
        System.out.print("Enter client address: ");
        String address = input.nextLine();
        System.out.print("Enter client phone: ");
        String phone = input.nextLine();
        
        //Pembuatan class Client
        Client newClient = new Client(name, address, phone);
        
        //Memilih tipe akun
        System.out.println("Choose preferred account type");
        System.out.println("1. Basic type");
        System.out.println("2. Strict type");
        System.out.print(">>> ");
        
        int type = input.nextInt();
        if(type != 1 && type != 2){
            System.err.println("Invalid input");
            return;
        }
        
        //pembuatan akun
        Account newAccount = null;
        
        //memasukkan balance awal
        System.out.println("enter account balance");
        System.out.print(">>> ");
        double balance = input.nextDouble();
        
        //Mengecek tipe bank
        if(type == 1){
            newAccount = new Account(balance);
        }
        else if(type == 2) {
        	if(balance >= 1000000) {
        		newAccount = new StrictAccount(balance);
        	}
        	else {
        		System.out.println("This account require a minimum balance of Rp1000000");
	        	while(true) {
	        		System.out.println("enter account balance");
	                System.out.print(">>> ");
	                balance = input.nextDouble();
	                if(balance >= 1000000) {
	                	break;
	                }
	                else {
	                	System.out.println("Invalid amount");
	                }
	        	}
	        	newAccount = new StrictAccount(balance);
	        }
        }
        
        //Men-link Client dan Account
        newAccount.setOwner(newClient);
        newClient.setAccount(newAccount);
        
        //memasukkan Client dan Account ke dalam vector
        Accounts.add(newAccount);
        Clients.add(newClient);
        
        System.out.println("Account created successfully");
        System.out.println("Press Enter to Continue...");
        input.nextLine();
        input.nextLine();
    }
    
    //Method untuk display semua account
    static void ShowAccounts() {
    	if(Accounts.isEmpty()) {
    		System.err.println("There are no Accounts");
    		System.out.println("Press Enter to Continue...");
	        input.nextLine();
    	}
    	else {
	    	System.out.println("============================================================");
	        for(int i = 0; i < Accounts.size(); i++){
	            Accounts.get(i).view();
	            System.out.println("============================================================");
	        }
	        System.out.println("Press Enter to Continue...");
	        input.nextLine();
    	}
    	
    }
    
    //Method SearchAccount untuk mengambil data 1 account
    static Account search(int accountId){
        for(int i = 0; i < Accounts.size(); i++){
            if(accountId == Accounts.get(i).getAccountId()){
                return Accounts.get(i);
            }
        }
        return null;
    }
    
    //Method untuk mencari account menggunakan method search dan menampilkannya 
    static void searchForAccount(){
    	if(Accounts.isEmpty()) {
    		System.err.println("There are no Accounts");
    		System.out.println("Press Enter to Continue...");
	        input.nextLine();
    	}
    	else {
	    	System.out.print("Enter account ID: ");
	        int id = input.nextInt();
	        Account acc = search(id);
	        if(acc == null){
	            System.err.println("Account not found");
	            return;
	        }
	        System.out.println("============================================================");
	        acc.view();
	        System.out.println("============================================================");
	        System.out.println("Press Enter to Continue...");
	        input.nextLine();
	        input.nextLine();
    	}
        
    }
    
    //Method untuk mencari index account
    static int SearchID(int accountId){
        for(int i = 0; i < Accounts.size(); i++){
            if(accountId == Accounts.get(i).getAccountId()){
                return i;
            }
        }
        return -1;
    }
    
    //Method untuk menghapus account
    static void removeAccount(){
    	if(Accounts.isEmpty()) {
    		System.err.println("There are no Accounts");
    		System.out.println("Press Enter to Continue...");
	        input.nextLine();
    	}
    	else {
	    	System.out.print("Enter account ID: ");
	        int id = input.nextInt();   
	        int index = SearchID(id);
	        if(index==-1){
	            System.err.println("Account not found");
	            return;
	        } 
	        Clients.remove(Accounts.get(index).owner);
	        Accounts.remove(index);
	        System.out.println("Account successfully removed");
	        System.out.println("Press Enter to Continue...");
	        input.nextLine();
	        input.nextLine();
    	}
        
    }
    
    //Method untuk melakukan deposit pada account menggunakan ID
    static void deposit(){
    	if(Accounts.isEmpty()) {
    		System.err.println("There are no Accounts");
    		System.out.println("Press Enter to Continue...");
	        input.nextLine();
    	}
    	else {
	    	System.out.print("Enter account ID: ");
	        int id = input.nextInt();
	        int index = SearchID(id);
	        
	        if(index == -1){
	            System.err.println("Account not found");
	            return;
	        }
	        
	        System.out.print("Enter amount to deposit: ");
	        double amountOfMoney = input.nextDouble();
	        
	        if(Accounts.get(index).deposit(amountOfMoney)){
	            System.out.println("Balance have been updated");
	            System.out.println("Final balance: Rp" + Accounts.get(index).getBalance());
	        }
	        System.out.println("Press Enter to Continue...");
	        input.nextLine();
	        input.nextLine();
    	}
        
    }
    
    //Method untuk melakukan withdraw pada account menggunakan ID
    static void withdraw(){
    	if(Accounts.isEmpty()) {
    		System.err.println("There are no Accounts");
    		System.out.println("Press Enter to Continue...");
	        input.nextLine();
    	}
    	else {
	    	System.out.print("Enter account ID: ");
	        int id = input.nextInt();
	        int index = SearchID(id);
	        
	        if(index == -1){
	            System.err.println("Account not found");
	            return;
	        }   
	        
	        System.out.print("Enter amount to withdraw: ");
	        double amountOfMoney=input.nextDouble();
	        
	        if(Accounts.get(index).withdraw(amountOfMoney)){
	            System.out.println("Balance have been updated");
	            System.out.println("Final balance: Rp" + Accounts.get(index).getBalance());
	        }
	        System.out.println("Press Enter to Continue...");
	        input.nextLine();
	        input.nextLine();
    	}
        
    }
    
    //Main program
    public static void main(String[] args) {
        Accounts = new ArrayList<Account>();
        Clients = new ArrayList<Client>();
        input = new Scanner(System.in);
        int option = 0;
        while (option != 7){
        	System.out.println("Bank Menu");
            System.out.println("1. Add account");
            System.out.println("2. Display all Accounts");
            System.out.println("3. Search for an account");
            System.out.println("4. Remove an account");
            System.out.println("5. Deposit balance");
            System.out.println("6. Withdraw balance");
            System.out.println("7. Exit");
            System.out.print(">>> ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
            	case 1:
            		addAccount();
            		break;
            	case 2:
            		ShowAccounts();
            		break;
            	case 3:
            		searchForAccount();
            		break;
            	case 4:
            		removeAccount();
            		break;
            	case 5:
            		deposit();
            		break;
            	case 6:
            		withdraw();
            		break;
            	case 7:
            		System.out.println("Exiting...");
            		break;
            	default:
            		System.out.println("Input 1-7 only!");
            		break;
            }
        }

    }
    
}