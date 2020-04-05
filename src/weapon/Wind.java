package weapon;

/**
 * @author qanna
 */
public class Wind {

    private int windSpeed;
    private int windRange;

    public Wind(){
        this.windRange = 20;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindRange() {
        return windRange;
    }

    public void setWindRange(int windRange) {
        this.windRange = windRange;
    }
}
