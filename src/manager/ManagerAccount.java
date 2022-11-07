package manager;
import model.Account;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerAccount {
    ArrayList<Account> listUser;
    public ManagerAccount() {
        listUser = new ArrayList<>();
    }

    public ArrayList<Account> getListUser() {
        return listUser;
    }
    private static final String USERNAME_REGEX="^[_a-z0-9]{6,}$";
    private static final String PASSWORD_REGEX="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    public boolean checkUsername(String regex) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean checkPassword(String regex) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
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
        System.out.println("Nhập mật khẩu(chứa các kí tự a-z, 0-9,A-Z, !@#&()–){},từ 8 đến 20 kí tự):");
        String password=scanner.nextLine();
        while (checkPassword(password)){
            System.out.println("Nhập lại mật khẩu theo đúng định dạng!");
            password=scanner.nextLine();
        }
            String role="User";
        Account account=new Account(username,password,role);
        listUser.add(account);
        return listUser;
    }
    public int logIn(Scanner scanner){
        System.out.println("Nhập tài khoản của bạn:");
        String username=scanner.nextLine();
        for (Account p:listUser) {
            while (checkUsernameInList(username) == false) {
                System.out.println("Tài khoản không tồn tại trong hệ thống!");
                System.out.println("Nhập lại tài khoản");
                username=scanner.nextLine();
            }
        }
        return indexAccout(username);
    }
    public boolean checkPasswordToLogIn(Scanner scanner){
        String password=scanner.nextLine();
        while (!listUser.get(logIn(scanner)).equals(password)){
            System.out.println("Mật khẩu của bạn không đúng! Xin hãy thử lại!");
            password=scanner.nextLine();
        }
        return true;
    }
    public boolean checkAdmin(Scanner scanner){
        System.out.println("Nhập tài khoản của bạn:");
        String username=scanner.nextLine();
        boolean check=false;
        if (username.equals("admin")){
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
    private int indexAccout(String username){
        int index =-1;
        for(int i=0;i<listUser.size();i++){
            if(listUser.get(i).equals(username)){
                index=i;
                break;
            }
        }
        return index;
    }
    public  void display(){
        for (Account p: listUser){
            System.out.println(p);
        }
    }
}
