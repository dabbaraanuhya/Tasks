package day16task;

public class Bank {

	private long accountno;
	private String holdername ;
	private String bankname;
	private String ifsccode;
	private String accounttype;
	private String transaction;
	private double amount;
	
	
	public Bank() {
	
	}


	public Bank(long accountno, String holdername, String bankname, String ifsccode, String accounttype,
			String transaction, double amount) {

		this.accountno = accountno;
		this.holdername = holdername;
		this.bankname = bankname;
		this.ifsccode = ifsccode;
		this.accounttype = accounttype;
		this.transaction = transaction;
		this.amount = amount;
	}


	public long getAccountno() {
		return accountno;
	}


	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}


	public String getHoldername() {
		return holdername;
	}


	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}


	public String getBankname() {
		return bankname;
	}


	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


	public String getIfsccode() {
		return ifsccode;
	}


	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}


	public String getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}


	public String getTransaction() {
		return transaction;
	}


	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Bank [accountno=" + accountno + ", holdername=" + holdername + ", bankname=" + bankname + ", ifsccode="
				+ ifsccode + ", accounttype=" + accounttype + ", transaction=" + transaction + ", amount=" + amount
				+ "]";
	}
	
}
