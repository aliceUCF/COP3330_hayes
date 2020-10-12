public class Circle extends Shape2D{
    double radius;
    public Circle (double givenRadius)
    {
        this.radius = givenRadius;
        this.area = (radius * radius * Math.PI);
        this.name = "circle";
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
