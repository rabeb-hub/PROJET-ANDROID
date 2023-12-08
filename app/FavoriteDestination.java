public class FavoriteDestination {
    private String destinationName;
    private double latitude;
    private double longitude;

    public FavoriteDestination(String destinationName, double latitude, double longitude) {
        this.destinationName = destinationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
