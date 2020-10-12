public class Square extends Shape2D {
    double side;
    public Square (double sideLength)
    {
        this.side = sideLength;
        this.area = (sideLength * sideLength);
        this.name = "square";
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
