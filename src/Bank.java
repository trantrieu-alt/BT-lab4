



public class Bank {
    private String name;
    private BankAccount[] accounts;
    private int currentCount;

    public Bank() {
        this("Ngân hàng mặc định", 100);
    }

    public Bank(String name, int numberOfAccounts) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Tên ngân hàng không được để trống");
        if (numberOfAccounts <= 0)
            throw new IllegalArgumentException("Số lượng tài khoản phải lớn hơn 0");

        this.name = name;
        this.accounts = new BankAccount[numberOfAccounts];
        this.currentCount = 0;
    }

    public void addNew(String accountNumber, String accountName, double balance) {
        if (currentCount >= accounts.length)
            throw new IllegalArgumentException("Ngân hàng đã đầy");

        for (int i = 0; i < currentCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber))
                throw new IllegalArgumentException("Số tài khoản đã tồn tại");
        }
        accounts[currentCount++] = new BankAccount(accountNumber, accountName, balance);
    }

    public BankAccount find(String accountNumber) {
        for (int i = 0; i < currentCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber))
                return accounts[i];
        }
        return null;
    }

    public double getTotalBalance() {
        double total = 0;
        for (int i = 0; i < currentCount; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public int getNumberOfAccounts() {
        return currentCount;
    }

    public BankAccount[] getAccounts() {
        BankAccount[] result = new BankAccount[currentCount];
        for (int i = 0; i < currentCount; i++) {
            result[i] = accounts[i];
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Tên ngân hàng không được để trống");
        this.name = name;
    }
}
