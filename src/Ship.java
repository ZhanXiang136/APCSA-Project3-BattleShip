import java.util.Arrays;
public class Ship {
    private String name;
    private String[] spotArr;
    private boolean[] spotIsUp;
    private boolean isFloat = true;

    public Ship(String name, String spots) {
        this.name = name;
        this.spotArr = spots.split(",");
        spotIsUp = new boolean[spotIsUp.length];
    }

    public void hit(String coordinate) {
        int idx = 0;
        for(int i = 0; i < spotArr.length; i++) {
            if(coordinate.equals(spotArr[i])) {
                idx = i;
            }
        }

    }

    private checkStatus
}
