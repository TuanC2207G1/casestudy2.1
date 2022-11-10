//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package manager;

import model.FoodAndDrink;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerFoodAndDrink implements Serializable {
    private ArrayList<FoodAndDrink> foodAndDrinkArraylist=new ArrayList<>();
    public final String path = "src/data/listFoodAndDrink";

//    public ManagerFoodAndDrink() {
//        foodAndDrinkArraylist = new ArrayList<>();
//    }

    public static void writeToFile(String path, ArrayList<FoodAndDrink> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<FoodAndDrink> readDataFromFile(String path){
        ArrayList<FoodAndDrink> foodAndDrinkArrayList = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            foodAndDrinkArrayList = (ArrayList<FoodAndDrink>)  ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return foodAndDrinkArrayList;
    }

    public ArrayList<FoodAndDrink> getFoodAndDrinkArraylist() {
        return foodAndDrinkArraylist;
    }

    public void setFoodAndDrinkArraylist(ArrayList<FoodAndDrink> foodAndDrinkArraylist) {
        this.foodAndDrinkArraylist = foodAndDrinkArraylist;
    }

    int id = readDataFromFile(path).get(readDataFromFile(path).size()-1).getId()+1;
    public ArrayList<FoodAndDrink> addFoodAndDrink(Scanner scanner) {
        System.err.println("ADD FOOD AND DRINK!");
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá:");
        double price = Double.parseDouble(scanner.nextLine());
        FoodAndDrink foodAndDrink = new FoodAndDrink(id, name, price);
        foodAndDrinkArraylist.add(foodAndDrink);
        id++;
        writeToFile(path,foodAndDrinkArraylist);
        return foodAndDrinkArraylist;
    }

    public int findIndex(int id) {
        int index = -1;
        for (int i = 0; i < foodAndDrinkArraylist.size(); ++i) {
            if (foodAndDrinkArraylist.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean checkId(int id) {
        boolean check = true;
        for (FoodAndDrink p : foodAndDrinkArraylist) {
            if (p.getId() == id) {
                check = false;
                break;
            }
        }
        return check;
    }

    public int getId(Scanner scanner) {
        int id = Integer.parseInt(scanner.nextLine());
        while (checkId(id)) {
            System.out.println("Chưa có id này!");
            System.out.println("Nhập lại chính xác id:");
            id = Integer.parseInt(scanner.nextLine());
        }
        return id;
    }

    public ArrayList<FoodAndDrink> updateFoodAndDrink(Scanner scanner) {
        System.out.println("Nhập id của món ăn cần sửa.");
        int id = getId(scanner);
        int index = findIndex(id);
        System.out.println("Cập nhật tên mới:");
        String name = scanner.nextLine();
        foodAndDrinkArraylist.get(index).setName(name);
        System.out.println("Cập nhật giá mới:");
        double price = Double.parseDouble(scanner.nextLine());
        foodAndDrinkArraylist.get(index).setPrice(price);
        writeToFile(path,foodAndDrinkArraylist);
        return foodAndDrinkArraylist;
    }

    public ArrayList<FoodAndDrink> deleteFoodAndDrink(Scanner scanner) {
        System.out.println("Nhập id món cần xóa!");
        int id = getId(scanner);
        int index = findIndex(id);
        this.foodAndDrinkArraylist.remove(index);
        writeToFile(path,foodAndDrinkArraylist);
        return foodAndDrinkArraylist;
    }

    public void displayMenuFoodAndDrink() {
        System.err.println("Menu FOOD AND DRINK");
        if (foodAndDrinkArraylist.isEmpty()) {
            System.out.println("Menu trống!");
        } else {
            for (FoodAndDrink p : foodAndDrinkArraylist) {
                System.out.println(p);
            }
        }
    }

}
