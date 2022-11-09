import container.Strategy;
import model.MessageTask;
import model.SortingTask;
import runner.DelayTaskRunner;
import runner.PrinterTaskRunner;
import runner.StrategyTaskRunner;

import java.time.LocalDateTime;

public class TestRunner {

    private static MessageTask[] createMessageTasks(){
        MessageTask m1 = new MessageTask("1", "teme laborator",
                "ai primit o tema de laborator", "George", "Iulia",
                LocalDateTime.now());
        MessageTask m2 = new MessageTask("2", "teme laborator",
                "ai o tema de seminar", "Mihai", "Iulia",
                LocalDateTime.now());
        MessageTask m3 = new MessageTask("3", "teme seminar",
                "ai primit o tema de seminar", "George", "Andrei",
                LocalDateTime.now());
        return new MessageTask[]{m1, m2, m3};
    }

    private static SortingTask[] createSortingTasks(){
        int[] vec = {5, 7, 10, 2, 5, 4};
        int i;
        for(i=0;i<vec.length;i++)
            System.out.println(vec[i]);
        SortingTask s1 = new SortingTask("1", "sortare 1", vec, "bubble");
        SortingTask s2 = new SortingTask("2", "sortare 2", vec, "quick");
        return new SortingTask[]{s1, s2};
    }

    public static void runStrategy(Strategy strategy) {
        MessageTask[] lista = createMessageTasks();
        StrategyTaskRunner runner = new StrategyTaskRunner(strategy);
        for(MessageTask task : lista) {
            runner.addTask(task);
        }

        runner.executeAll();
    }

    public static void runPrinter(Strategy strategy) {
        MessageTask[] lista = createMessageTasks();
        StrategyTaskRunner strategyTaskRunner = new StrategyTaskRunner(strategy);

        DelayTaskRunner delayTaskRunner = new DelayTaskRunner(strategyTaskRunner);
        PrinterTaskRunner printerTaskRunner = new PrinterTaskRunner(delayTaskRunner);

        for(MessageTask task : lista) {
            printerTaskRunner.addTask(task);
            //delayTaskRunner.addTask(task);
        }

        printerTaskRunner.executeAll();
        //delayTaskRunner.executeAll();
    }

    public static void run(){
        MessageTask[] lista = createMessageTasks();
        for(MessageTask messageTask : lista)
        {
            messageTask.execute();
        }
        SortingTask[] lista_sortare = createSortingTasks();
        for(SortingTask sortingTask : lista_sortare){
            sortingTask.execute();
        }
    }
}
