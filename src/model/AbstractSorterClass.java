package model;

import java.util.Vector;

public abstract class AbstractSorterClass extends Task {
    public int[] vec;
    public AbstractSorterClass(String _taskID, String _description, int[] _vec) {
        super(_taskID, _description);
        vec = _vec;
    }

    public abstract void sort(int[] vec);

    public void execute(){
        sort(vec);
    }
}
