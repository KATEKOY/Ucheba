package Calculator;

public class Subtractor implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a - b;
    }
    @Override
    public String getResultDescription(double a, double b) {
        return "вычитания a и b";
    }
}
