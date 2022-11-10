package menu;

import manager.ManagerAccount;
import manager.ManagerFoodAndDrink;
import manager.ManagerOder;
import model.Account;

import java.util.Scanner;

public class MainMenu {
    ManagerFoodAndDrink managerFoodAndDrink = new ManagerFoodAndDrink();
    ManagerOder managerOder = new ManagerOder();
    ManagerAccount managerAccount = new ManagerAccount();
    MenuStaff menuStaff = new MenuStaff();
    MenuGuest menuGuest = new MenuGuest();

    public MainMenu() {
    }

    public void mainMenu(Scanner scanner) {
        managerFoodAndDrink.setFoodAndDrinkArraylist(ManagerFoodAndDrink.readDataFromFile(managerFoodAndDrink.path));
        int choice = -1;
        do {
            System.out.println("Ấn 1 để đăng kí.");
            System.out.println("ẤN 2 để đăng nhập.");
            System.out.println("Ấn 3 cho gọi món ngay.");
            System.out.println("Input 0 to exit.");
            System.err.println("Đăng kí thành viên giảm giá 10%.");
            do {
                try {
                     choice=Integer.parseInt(scanner.nextLine());
                        break;
                } catch (Exception e) {
                    System.out.println("Nhập sai định dạng!");
                }
            } while (true);
            switch (choice) {
                case 1:
                    managerAccount.register(scanner);
                    break;
                case 2:
                    System.out.println("Nhập tài khoản để đăng nhập:");
                    String username = scanner.nextLine();
                    if (managerAccount.checkAdmin(scanner, username)) {
                        menuStaff.menuStaff(scanner, managerFoodAndDrink, managerOder);
                        break;
                    } else if (managerAccount.checkEmpty()) {
                        System.out.println("Chưa có tài khoản khách hàng nào!");
                    }
                    while (managerAccount.indexAccout(username) == -1) {
                        System.out.println("Tài khoản không tồn tại trong hệ thống!");
                        System.out.println("Nhập lại tài khoản :");
                        username = scanner.nextLine();
                        if (managerAccount.checkAdmin(scanner, username)) {
                            menuStaff.menuStaff(scanner, managerFoodAndDrink, managerOder);
                            break;
                        }
                    }
                    if (managerAccount.indexAccout(username) != -1 && managerAccount.checkPasswordToLogIn(scanner, username)) {
                        menuGuest.menuGuest(scanner, managerFoodAndDrink, managerOder);
                    }
                    break;
                case 3:
                    menuGuest.menuGuest(scanner, managerFoodAndDrink, managerOder);

                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}
