package services;

import domain.Task;

import java.util.Comparator;

public class TaskComparatorStartDate implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}
