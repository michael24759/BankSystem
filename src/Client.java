
public class Client {
    
	private String name;
	private String address;
	private String phone;
	private Account account;
	
	//Constructor
    public Client(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    //Setter Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    //Method Account.view();
    public void view() {
        System.out.println("Account Name : " + name);
        System.out.println("Account Address : " + address);
        System.out.println("Account Phone : " + phone);
    }
    
}