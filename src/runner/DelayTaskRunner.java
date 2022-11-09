package runner;

import utils.Constants;

import java.time.LocalDateTime;

public class DelayTaskRunner extends AbstractTaskRunner {
    public DelayTaskRunner(TaskRunner runner) {
        super(runner);
    }

    @Override
    public void executeOneTask() {
        this.runner.executeOneTask();
        this.decoratorExecuteOneTask();
    }

    private void decoratorExecuteOneTask() {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task executat la: " + LocalDateTime.now().format(Constants.DATE_TIME_FORMATTER));
    }
}
