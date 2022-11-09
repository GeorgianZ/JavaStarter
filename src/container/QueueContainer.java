package container;
import model.Task;
import utils.Constants;

public class QueueContainer extends ExtractSuperclass{


    @Override
    public Task remove() {
        if(!isEmpty()) {
            size--;
            Task task = tasks[0];
            System.arraycopy(tasks, 1, tasks, 0, size);
            return task;
        }
        return null;
    }




}
