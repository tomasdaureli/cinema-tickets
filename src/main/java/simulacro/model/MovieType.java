package simulacro.model;

public enum MovieType {

    DOS_D("2D", 1000),
    TRES_D("3D", 2000),
    IMAX("IMAX", 3000),
    IMAX3D("IMAX 3D", 3500),
    CUATRO_D("4D", 4500);

    private final String description;
    private final double price;

    MovieType(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

}
