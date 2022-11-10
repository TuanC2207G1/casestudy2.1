package main;

import menu.MainMenu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu(scanner);
    }
}
