public class Cube extends Shape3D{
    double side;
    public Cube (double givenSide)
    {
        this.side = givenSide;
        this.area = (this.side * this.side * 6);
        this.volume = (this.side * this.side * this.side);
        this.name = "cube";
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
