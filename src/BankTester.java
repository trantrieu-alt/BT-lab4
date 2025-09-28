import java.util.Scanner;

public class BankTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("MyBank", 10);

        while (true) {
            System.out.println("\nWelcome to iuh bank");
            System.out.println("1. Mở tài khoản mới");
            System.out.println("2. Nạp tiền");
            System.out.println("3. Rút tiền");
            System.out.println("4. Chuyển tiền");
            System.out.println("5. Xem số dư tài khoản");
            System.out.println("6. Tính tổng số dư ngân hàng");
            System.out.println("7. In tất cả tài khoản");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1: // mở tài khoản
                        System.out.print("Nhập số TK: ");
                        String accNum = sc.nextLine();
                        System.out.print("Nhập tên chủ TK: ");
                        String owner = sc.nextLine();
                        System.out.print("Nhập số dư ban đầu: ");
                        double bal = sc.nextDouble();
                        bank.addNew(accNum, owner, bal);
                        System.out.println("Đã mở tài khoản thành công!");
                        break;

                    case 2: // nạp tiền
                        System.out.print("Nhập số TK: ");
                        accNum = sc.nextLine();
                        BankAccount acc = bank.find(accNum);
                        if (acc != null) {
                            System.out.print("Nhập số tiền nạp: ");
                            double amt = sc.nextDouble();
                            acc.deposit(amt);
                            System.out.println("Đã nạp tiền. Số dư mới: " + acc.getBalance());
                        } else {
                            System.out.println(" Không tìm thấy tài khoản.");
                        }
                        break;

                    case 3: // rút tiền
                        System.out.print("Nhập số TK: ");
                        accNum = sc.nextLine();
                        acc = bank.find(accNum);
                        if (acc != null) {
                            System.out.print("Nhập số tiền rút: ");
                            double amt = sc.nextDouble();
                            acc.withdraw(amt);
                            System.out.println("Đã rút tiền. Số dư mới: " + acc.getBalance());
                        } else {
                            System.out.println("Không tìm thấy tài khoản.");
                        }
                        break;

                    case 4: // chuyển tiền
                        System.out.print("Nhập số TK gửi: ");
                        String from = sc.nextLine();
                        System.out.print("Nhập số TK nhận: ");
                        String to = sc.nextLine();
                        BankAccount accFrom = bank.find(from);
                        BankAccount accTo = bank.find(to);
                        if (accFrom != null && accTo != null) {
                            System.out.print("Nhập số tiền chuyển: ");
                            double amt = sc.nextDouble();
                            accFrom.transfer(accTo, amt);
                            System.out.println(" Chuyển thành công!");
                        } else {
                            System.out.println(" Không tìm thấy tài khoản.");
                        }
                        break;

                    case 5: // xem số dư
                        System.out.print("Nhập số TK: ");
                        accNum = sc.nextLine();
                        acc = bank.find(accNum);
                        if (acc != null) {
                            System.out.println(" Số dư = " + acc.getBalance());
                        } else {
                            System.out.println(" Không tìm thấy tài khoản.");
                        }
                        break;

                    case 6: // tổng số dư
                        System.out.println("Tổng số dư ngân hàng = " + bank.getTotalBalance());
                        break;

                    case 7: // in tất cả
                        for (BankAccount a : bank.getAccounts()) {
                            if (a != null) System.out.println(a);
                        }
                        break;

                    case 0:
                        System.out.println("Bye!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}
