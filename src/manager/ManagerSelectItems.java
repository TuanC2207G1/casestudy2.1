//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package manager;

import model.FoodAndDrink;
import model.FoodAndDrinkOder;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerSelectItems {
    ArrayList<FoodAndDrinkOder> foodAndDrinkOderArrayList;

    public ManagerSelectItems() {
        foodAndDrinkOderArrayList = new ArrayList<>();
    }


    public ArrayList<FoodAndDrinkOder> addFoodAndDrinkOderToArrayList(Scanner scanner, ManagerFoodAndDrink managerFoodAndDrink) {
        System.out.println("Nhập id món bạn cần gọi:");
        int id = Integer.parseInt(scanner.nextLine());
        int index = managerFoodAndDrink.findIndex(id);
        if (index==-1){
            System.out.println("Quán chưa mở bán");
        }else {
            if (checkItems(id)) {
                System.out.println("Món đã được gọi!");

                updateFoodAndDrinkOderArrayList(scanner);
            } else {
                System.out.println("Nhập số lượng:");
                int quantity = Integer.parseInt(scanner.nextLine());
                FoodAndDrink foodAndDrink=managerFoodAndDrink.getFoodAndDrinkArraylist().get(index);
                FoodAndDrinkOder foodAndDrinkOder = new FoodAndDrinkOder(foodAndDrink, quantity);
                foodAndDrinkOderArrayList.add(foodAndDrinkOder);
            }
        }
        return foodAndDrinkOderArrayList;
    }

    private boolean checkItems(int id) {
        boolean check = false;
        for (FoodAndDrinkOder p : foodAndDrinkOderArrayList) {
            if (p.getFoodAndDrink().getId() == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    private int findIndexItem(int id) {
        int index = -1;
        for (int i = 0; i < foodAndDrinkOderArrayList.size(); ++i) {
            if (foodAndDrinkOderArrayList.get(i).getFoodAndDrink().getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public ArrayList<FoodAndDrinkOder> updateFoodAndDrinkOderArrayList(Scanner scanner) {
        System.out.println("Nhập id món ăn bạn muốn sửa xóa!");
        int id = Integer.parseInt(scanner.nextLine());
        int choice3=-1;
        do {
            if (!checkItems(id)) {
                System.out.println("Id món ăn này bạn chưa gọi!");
                System.out.println("Nhập lại id món ăn bạn muốn sửa xóa:");
                id = Integer.parseInt(scanner.nextLine());
            }
        } while (!checkItems(id));
        int indexItem = findIndexItem(id);

        do {
            System.out.println("Ấn 1 để sửa số lượng.");
            System.out.println("Ấn 2 để xóa món này khỏi danh sách.");
            System.out.println("Ấn 0 để quay lại.");
            choice3 = Integer.parseInt(scanner.nextLine());
            switch (choice3) {
                case 0:
                    choice3 = 0;
                    break;
                case 1:
                    int choiceCase1 = -1;
                    System.out.println("Nhập lại số lượng:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    do {
                        System.out.println("Ấn 1 để xác nhận.");
                        System.out.println("Ấn 2 để nhập lại số lượng.");
                        System.out.println("Ấn 0 để quay lại.");
                        choiceCase1=Integer.parseInt(scanner.nextLine());
                        switch (choiceCase1) {
                            case 0:
                                choiceCase1 = 0;
                                break;
                            case 1:
                                (foodAndDrinkOderArrayList.get(indexItem)).setQuantity(quantity);
                                System.out.println("Đã sửa số lượng!");
                                choiceCase1=0;
                                break;
                            case 2:
                                System.out.println("Nhập lại số lượng.");
                                quantity = Integer.parseInt(scanner.nextLine());
                                (foodAndDrinkOderArrayList.get(indexItem)).setQuantity(quantity);
                                System.out.println("Đã sửa số lượng!");
                                displayFoodAndDrinkOderList();
                                break;
                        }
                    } while (choiceCase1 !=0);
                            break;
                        case 2:
                            System.out.println("Ấn 1 xác nhận xóa.");
                            System.out.println("Ấn 0 để quay lại.");
                            int choiceCase2 = -1;
                            do {
                                choiceCase2 = Integer.parseInt(scanner.nextLine());
                                switch (choiceCase2) {
                                    case 0:
                                        choiceCase2 = 0;
                                        break;
                                    case 1:
                                        if (foodAndDrinkOderArrayList.isEmpty()) {
                                            System.out.println("Bạn đã xóa hết danh sách oder!");
                                            choice3=0;
                                            choiceCase2=0;
                                        } else {
                                            foodAndDrinkOderArrayList.remove(indexItem);
                                            System.out.println("Đã xóa thành công.");
                                            choiceCase2=0;
                                            choice3=0;
                                        }
                                        break;
                                }
                            } while (choiceCase2 != 0);

            }
        } while (choice3 != 0);
        displayFoodAndDrinkOderList();
        return foodAndDrinkOderArrayList;
    }

    public void displayFoodAndDrinkOderList() {
        for(FoodAndDrinkOder p: foodAndDrinkOderArrayList){
            System.out.println(p);
        }
    }

    public double bill() {
        double sumMoney = 0.0;
        for (FoodAndDrinkOder p:foodAndDrinkOderArrayList){
            sumMoney+=p.getFoodAndDrink().getPrice()*p.getQuantity();
        }
        return sumMoney;
    }
}
