package MyProject.eluosi.model;

public class GameData {
    public int x;
    public int y;

    public GameData() {
        x = 4;
        y = 0;
    }

    public void move(boolean isH, int step) {
        if (isH) {
            x += step;
        } else {
            y += step;
        }
    }
}
