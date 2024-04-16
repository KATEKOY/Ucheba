package Calculator;

public class Calculator {
    Operation operation;
    public Calculator(Operation operation) {
        this.operation = operation;
    }
    public void calc(double a, double b) {
        String operationDescription = operation.getResultDescription(a, b);
        System.out.println("Результат " + operationDescription + ": " + operation.getResult(a, b));
    }
}
