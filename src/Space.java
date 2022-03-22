public class Space {
    private String coord;
    private String status;

    public Space(String coord) {
        this.coord = coord;
        this.status = "empty";
    }

    public String getCoord() {
        return coord;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        status = newStatus;
    }
}
