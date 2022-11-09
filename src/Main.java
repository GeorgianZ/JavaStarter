import container.Strategy;

public class Main {
    private static Strategy strategyFromString(String arg) {
        return Strategy.valueOf(arg);
    }

    public static void main(String[] args) {
        TestRunner.runPrinter(strategyFromString(args[0]));
    }
}