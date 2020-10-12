public class Triangle extends Shape2D{
    double base, height;
    public Triangle (double givenBase, double givenHeight)
    {
        this.base = givenBase;
        this.height = givenHeight;
        this.area = (0.5 * base * height);
        this.name = "triangle";
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
