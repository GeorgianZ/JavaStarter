package model;

import java.util.Arrays;
import java.util.Vector;


public class SortingTask extends AbstractSorterClass{

    private String metode;

    public SortingTask(String _taskID, String _descpription, int[] _vec, String _met){
        super(_taskID, _descpription,_vec);
        this.metode = _met;
    }


    @Override
    public void sort(int[] v) {
        if(metode == "bubble"){
            int c, d, swap;
            int n = v.length;
            for (c = 0; c < (n - 1); c++) {
                for (d = 0; d < n - c - 1; d++) {
                    if (v[d] > v[d+1]) {
                        swap = v[d];
                        v[d] = v[d+1];
                        v[d+1] = swap;
                    }
                }
            }
        }
        if(metode == "quick"){
            Arrays.sort(v);
        }
        for(int i=0;i<v.length;i++)
            System.out.println(v[i]);
    }

}
