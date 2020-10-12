public class Pyramid extends Shape3D{
    double length, width, height;
    public Pyramid (double givenLength, double givenWidth, double givenHeight)
    {
        this.length = givenLength;
        this.width = givenWidth;
        this.height = givenHeight;
        this.area = (length * width) + (this.length * Math.sqrt(Math.pow((this.width / 2), 2) + (this.height * this.height)) + (this.width * Math.sqrt(Math.pow((this.length / 2), 2) + (this.height * this.height))));
        this.volume = (this.height / 3) * this.length * this.width;
        this.name = "pyramid";
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
