package Calculator;

public class Adder implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a + b;
    }
    @Override
    public String getResultDescription(double a, double b) {
        return "сложения a и b";
    }
}
