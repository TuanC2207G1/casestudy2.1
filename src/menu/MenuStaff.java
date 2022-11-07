//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package menu;

import manager.ManagerFoodAndDrink;
import manager.ManagerOder;
import java.util.Scanner;

public class MenuStaff {
    public MenuStaff() {
    }

    public void menuStaff(Scanner scanner, ManagerFoodAndDrink managerFoodAndDrink, ManagerOder managerOder) {
        int choice = -1;
        do {
            managerFoodAndDrink.displayMenuFoodAndDrink();
            System.out.println("Nhập 1 để thêm món ăn vào Menu.");
            System.out.println("Nhập 2 để cập nhật món ăn theo id.");
            System.out.println("Nhập 3 để xóa món ăn theo id.");
            System.out.println("Nhập 4 để xem danh sách bàn oder.");
            System.out.println("Nhập 5 chọn bàn thanh toán!");
            System.out.println("Ấn 0 để quay lại");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerFoodAndDrink.addFoodAndDrink(scanner);
                    break;
                case 2:
                    managerFoodAndDrink.updateFoodAndDrink(scanner);
                    break;
                case 3:
                    managerFoodAndDrink.deleteFoodAndDrink(scanner);
                    break;
                case 4:
                    managerOder.displayOderlist();
                    break;
                case 5:
                    managerOder.payBillAndRemoveTable(scanner);
                    break;
                case 0:
                    choice = 0;
                    break;
            }
        } while(choice != 0);

    }
}
