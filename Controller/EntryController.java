package Controller;

import View.Menu;

public class EntryController {
    private Menu menu;

    public EntryController() {
        this.menu = new Menu();
    }

    public void mainMenuAdmin() {
        menu.indexMenuAdmin();
    }

    public void mainMenu() {
        menu.indexMenu();
    }

}
