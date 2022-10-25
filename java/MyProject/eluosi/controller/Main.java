package MyProject.eluosi.controller;

import MyProject.eluosi.model.GameData;
import MyProject.eluosi.view.MainWin;

public class Main {
    public static void main(String[] args) {
        Opration opration = new Opration();
        GameData gameData = new GameData();

        MainWin mainWin = new MainWin(opration, gameData);
        opration.setwin(mainWin);
        opration.setDate(gameData);
        mainWin.setVisible(true);
    }
}
