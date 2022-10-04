public class Retangulo2 implements FormaGeral {
    
    protected double comprimento;
    protected double altura;

    public Retangulo2(double comprimento, double lado) {
        super();
        this.comprimento = comprimento;
        this.lado = lado;
    }
    @Override
    public double area() {
        return comprimento * altura;
    }
}
