package factory;

import container.Container;
import container.QueueContainer;
import container.StackContainer;
import container.Strategy;

// instanta unica sa fie thread-safe
public class TaskContainerFactory implements Factory{

    //public TaskContainerFactory() {}

    private static TaskContainerFactory containerFactory;

    public static TaskContainerFactory getInstance(){

        if(containerFactory == null)
            containerFactory = new TaskContainerFactory();

        return containerFactory;
    }

    @Override
    public Container createContainer(Strategy strategy) {
        if(strategy == Strategy.LIFO) {
            return new StackContainer();
        }

        if(strategy == Strategy.FIFO){
            return new QueueContainer();
        }
        return null;
    }
}
