import java.util.*;

public class Circulo2 implements FormaGeral {
    
    protected double raio;
    private double pi = Math.PI;
    public Circulo2(double raio) {
        super();
        this.raio = raio;
    }

    @Override
    public double area() {
        return pi * raio * raio;
    }
}
