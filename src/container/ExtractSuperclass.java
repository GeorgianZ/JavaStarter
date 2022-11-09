package container;

import model.Task;
import utils.Constants;

public abstract class ExtractSuperclass implements Container {
    public Task[] tasks;
    public int size;

    public ExtractSuperclass() {
        size = 0;
        tasks = new Task[Constants.INITIAL_TASK_SIZE];
    }

    public void resize() {
        Task[] newTasks = new Task[tasks.length + 1];
        System.arraycopy(tasks, 0, newTasks, 0, size);
        tasks = newTasks;
    }

    @Override
    abstract public Task remove();

    @Override
    public void add(Task task) {
        if(size == tasks.length) {
            this.resize();
        }
        tasks[size] = task;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
