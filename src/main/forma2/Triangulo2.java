public class Triangulo2 implements FormaGeral {
    
    protected double base;
    protected double altura;

    public Triangulo2 (double altura, double base) {
        super();
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }


}