package manager;
import model.Account;
import model.FoodAndDrink;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerAccount {
    ArrayList<Account> listUser;
    public ManagerAccount() {
        listUser = new ArrayList<>();
    }

    private static final String USERNAME_REGEX="^[_a-z0-9]{6,}$";
    public boolean checkUsername(String regex) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public ArrayList<Account> register(Scanner scanner){
        System.out.println("Nhập tên đăng nhập (chỉ chưa kí tự viết thường , tối thiếu 6 kí tự và số từ 0 đến 9):");
        String username=scanner.nextLine();
            for (Account p: listUser){
                if(p.getUsername().equals(username)){
                    System.out.println("Tài khoản đã tồn tại!");
                    System.out.println("Nhập lại:");
                    username=scanner.nextLine();
                }
            }
        while (checkUsername(username)==false){
            System.out.println("Nhập lại tài khoản theo đúng định dạng!");
            username=scanner.nextLine();
        }
        System.out.println("Nhập mật khẩu của bạn:");
        String password=scanner.nextLine();
            String role="User";
        Account account=new Account(username,password,role);
        listUser.add(account);
        return listUser;
    }
    public int logIn(Scanner scanner,String username){
            while (checkUsernameInList(username) == false) {
                System.out.println("Tài khoản không tồn tại trong hệ thống!");
                System.out.println("Nhập lại tài khoản");
                username=scanner.nextLine();
            }
        return indexAccout(username);
    }
    public boolean checkPasswordToLogIn(Scanner scanner,String username){
        System.out.println("Nhập mật khẩu của bạn:");
        String password=scanner.nextLine();
        while (!listUser.get(logIn(scanner,username)).getPassword().equals(password)){
            System.out.println("Mật khẩu của bạn không đúng! Xin hãy thử lại!");
            password=scanner.nextLine();
        }
        return true;
    }
    public boolean checkAdmin(Scanner scanner,String username){
        boolean check=false;
        if (username.equals("admin")){
            System.out.println("Nhập mật khẩu quản trị!");
            String password=scanner.nextLine();
            while (!password.equals("doanngonqua")){
                System.out.println("Sai mật khẩu quản lí! Nhập lại");
                password=scanner.nextLine();
            }
            check= true;
        }
        return check;
    }
    private boolean checkUsernameInList(String username){
        boolean check =false;
        for(Account p:listUser){
            if (p.getUsername().equals(username)){
                check =true;
                break;
            }
        }
        return check;
    }
    public int indexAccout(String username){
        int index =-1;
        for(int i=0;i<listUser.size();i++){
            if(listUser.get(i).getUsername().equals(username)){
                index=i;
                break;
            }
        }
        return index;
    }
    public boolean checkEmpty(){
        return  listUser.isEmpty();
    }
    public  void display(){
        for (Account p: listUser){
            System.out.println(p);
        }
    }
}

