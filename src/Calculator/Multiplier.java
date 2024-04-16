package Calculator;

public class Multiplier implements Operation{
    @Override
    public double getResult(double a, double b){
        return a*b;
    }
    @Override
    public String getResultDescription(double a, double b) {
        return "умножения a и b";
    }
}
