


public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;


    public BankAccount() {
        this.accountNumber = "0000-0000-0000";
        this.ownerName = "No name";
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        if (accountNumber == null || accountNumber.isEmpty())
            throw new IllegalArgumentException("Số tài khoản không được để trống");
        if (ownerName == null || ownerName.isEmpty())
            throw new IllegalArgumentException("Tên chủ sở hữu không được để trống");
        if (balance < 0)
            throw new IllegalArgumentException("Số dư phải lớn hơn hoặc bằng 0");

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Số tiền phải lớn hơn 0");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException("Số tiền phải lớn hơn 0 và nhỏ hơn hoặc bằng số dư");
        balance -= amount;
    }

    public void transfer(BankAccount other, double amount) {
        if (other == null) throw new IllegalArgumentException("Tài khoản chuyển không được để giá trị null");
        this.withdraw(amount);
        other.deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty())
            throw new IllegalArgumentException("Số tài khoản không được để trống");
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isEmpty())
            throw new IllegalArgumentException("Tên chủ sở hữu không được để trống");
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
