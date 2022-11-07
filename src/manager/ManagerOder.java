package manager;

import model.FoodAndDrinkOder;
import model.Oder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ManagerOder {
    ArrayList<Oder> oders = new ArrayList();

    public ManagerOder() {
    }

    private boolean readyTable(int numberTable) {
        boolean check = false;
        for(int i = 0; i < this.oders.size(); ++i) {
            if (oders.get(i).getNumberTable() == numberTable) {
                check = true;
                break;
            }
        }
        return check;
    }

    public ArrayList<Oder> addOder(Scanner scanner, ManagerFoodAndDrink managerFoodAndDrink) {
        System.out.println("Nhập bàn bạn đang ngồi:");
        int numberTable = Integer.parseInt(scanner.nextLine());

        while(readyTable(numberTable)) {
            if (readyTable(numberTable)) {
                System.out.println("Bạn bạn chọn đã có người ngồi.");
                System.out.println("Xin hãy chọn lại!");
                numberTable = Integer.parseInt(scanner.nextLine());
            }
        }
        ManagerSelectItems managerSelectItems = new ManagerSelectItems();
        int choice = -1;
        do {
            System.out.println("Ấn 1 để thêm món.");
            System.out.println("Ấn 2 để sửa xóa món đã gọi");
            System.out.println("Nhấn 0 để kết thúc chọn món.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    choice = 0;
                    break;
                case 1:
                    managerSelectItems.addFoodAndDrinkOderToArrayList(scanner, managerFoodAndDrink);
                    managerSelectItems.displayFoodAndDrinkOderList();
                    break;
                case 2:
                    managerSelectItems.updateFoodAndDrinkOderArrayList(scanner);
            }
        } while(choice != 0);

        Oder oder = new Oder(numberTable, managerSelectItems);
        oders.add(oder);
        return oders;
    }

    private int findIndexOder(int numberTable) {
        int index = -1;
        for(int i = 0; i < oders.size(); ++i) {
            if (oders.get(i).getNumberTable() == numberTable) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void displayOderlist() {
       for(Oder p: oders){
           if(oders.isEmpty()){
               System.out.println("Chưa có bàn nào gọi món!");
           }else {
               System.out.println(p);
           }
       }
    }

    public void payBillAndRemoveTable(Scanner scanner) {
        System.out.println("Nhập id bàn cần thanh toán:");
        int numberTable = Integer.parseInt(scanner.nextLine());
        double sumMoney=0;
        if (checkTable(numberTable)) {
            System.out.println("Bàn thanh toán trống!");
        } else {
            int indexOder = findIndexOder(numberTable);
            if (oders.get(indexOder).getManagerSelectItems().foodAndDrinkOderArrayList.isEmpty()){
                System.out.println("Bàn thanh toán không gọi món");
                int choice=-1;
                System.out.println("Ấn 1 để làm trống bàn!");
                System.out.println("Ấn 0 để quay lại.");
                switch (choice){
                    case 1:
                        oders.remove(indexOder);
                        break;
                    case 0:
                        break;
                }
            }else {
                sumMoney= oders.get(indexOder).getManagerSelectItems().bill();
                System.out.println("Bàn "+numberTable+" phải thanh toán số tiền: "+sumMoney);
                oders.remove(indexOder);
            }
        }
    }

    private boolean checkTable(int numberTable) {
        boolean check = true;
        for(Oder p:oders){
            if (p.getNumberTable() == numberTable) {
                check = false;
                break;
            }
        }
        return check;
    }
}