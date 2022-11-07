package menu;

import manager.ManagerFoodAndDrink;
import manager.ManagerOder;
import java.util.Scanner;

public class MenuGuest {
    public MenuGuest() {
    }

    public void menuGuest(Scanner scanner, ManagerFoodAndDrink managerFoodAndDrink, ManagerOder managerOder) {
        managerFoodAndDrink.displayMenuFoodAndDrink();
        int choice = -1;
        do {
            System.out.println("Nhập 1 để chọn bàn và gọi món.");
            System.out.println("Nhập 0 để thoát.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerOder.addOder(scanner, managerFoodAndDrink);
                    break;
                case 0:
                    choice = 0;
                    break;
            }
        } while(choice != 0);
    }
}