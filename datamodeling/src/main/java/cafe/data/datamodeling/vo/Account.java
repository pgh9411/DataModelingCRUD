package cafe.data.datamodeling.vo;

public class Account extends User {
	private String accountNumber;
	private String accountName;
	private int accountdeposit;
	
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
	public int getAccountdeposit() {
		return accountdeposit;
	}
	public void setAccountdeposit(int accountdeposit) {
		this.accountdeposit = accountdeposit;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", accountdeposit="
				+ accountdeposit + "]";
	}
	
}
