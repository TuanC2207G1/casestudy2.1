package menu;

import manager.ManagerAccount;
import manager.ManagerFoodAndDrink;
import manager.ManagerOder;
import model.Account;

import java.util.Scanner;

public class MainMenu {
    ManagerFoodAndDrink managerFoodAndDrink = new ManagerFoodAndDrink();
    ManagerOder managerOder = new ManagerOder();
    ManagerAccount managerAccount=new ManagerAccount();
    MenuStaff menuStaff = new MenuStaff();
    MenuGuest menuGuest = new MenuGuest();

    public MainMenu() {
    }
    public void mainMenu(Scanner scanner) {
        int choice = -1;
        do {
            System.out.println("Ấn 1 để đăng kí.");
            System.out.println("ẤN 2 để đăng nhập.");
            System.out.println("Input 3 for Guest oder.");
            System.out.println("Input 0 to exit.");
            System.err.println("Warning! Discount 10% for Member.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerAccount.register(scanner);
                    break;
                case 2:
                    if (managerAccount.checkAdmin(scanner)){
                        menuStaff.menuStaff(scanner, this.managerFoodAndDrink, this.managerOder);
                    }else if(managerAccount.checkPasswordToLogIn(scanner)){
                        menuGuest.menuGuest(scanner, this.managerFoodAndDrink, this.managerOder);
                    }
                    break;
                case 3:
                    menuGuest.menuGuest(scanner, this.managerFoodAndDrink, this.managerOder);

                    break;
                case 0:
                    System.exit(0);
            }
        } while(choice != 0);
    }
}
