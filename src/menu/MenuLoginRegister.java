//package menu;
//
//import manager.ManagerAccount;
//
//import java.util.Scanner;
//
//public class MenuLoginRegister {
//    public static void main(String[] args) {
//        ManagerAccount managerAccount=new ManagerAccount();
//        Scanner scanner=new Scanner(System.in);
//        int choice =-1;
//        do{
//            System.out.println("Ấn 1 để đăng kí;");
//            System.out.println("Ấn 2 để đăng nhập");
//            choice=Integer.parseInt(scanner.nextLine());
//            switch (choice){
//                case 1:
//                    managerAccount.register(scanner);
//                    break;
//                case 2:
//                    managerAccount.display();
//                    break;
//                case  0:
//                    choice=0;
//                    break;
//            }
//        } while(choice!=0);
//    }
//
//}