abstract public class Shape3D extends Shape2D{
    double volume;
    public Shape3D ()
    {
        this.volume = 0;
    }

    abstract public double getVolume();
}
