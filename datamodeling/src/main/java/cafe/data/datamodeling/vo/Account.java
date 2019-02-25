package cafe.data.datamodeling.vo;

public class Account extends User{
	private String accountNumber;
	private String accountName;
	private int accountDeposit;
	private String agencyName;
	private String agencyUser;
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountDeposit() {
		return accountDeposit;
	}
	public void setAccountDeposit(int accountDeposit) {
		this.accountDeposit = accountDeposit;
	}
	
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAgencyUser() {
		return agencyUser;
	}
	public void setAgencyUser(String agencyUser) {
		this.agencyUser = agencyUser;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountDeposit="
				+ accountDeposit + ", agencyName=" + agencyName + ", agencyUser=" + agencyUser + "]";
	}
	
	
}
