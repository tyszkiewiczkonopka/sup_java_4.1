package MovieLibrary;

import MovieLibrary.services.MenuService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuService menu = new MenuService();
        menu.showMenu();
    }
}