public class Sphere extends Shape3D{
    double radius;
    public Sphere (double givenRadius)
    {
        this.radius = givenRadius;
        this.area = (4 * Math.PI * this.radius * this.radius);
        this.volume = (4 * Math.PI * ((this.radius * this.radius * this.radius) / 3));
        this.name = "sphere";
    }

    @Override
    public double getVolume() {
        return this.volume;
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
