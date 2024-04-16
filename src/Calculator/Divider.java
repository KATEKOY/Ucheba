package Calculator;

public class Divider implements Operation {
    @Override
    public double getResult(double a, double b) {
        if (b == 0) {
            System.out.println("На ноль делить нельзя!");
            return 0;
        }
        return a / b;
    }

    @Override
    public String getResultDescription(double a, double b) {
        return "деления a и b";
    }
}
