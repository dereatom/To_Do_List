package domain;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        int dueDateComparator = o1.getDueDate().compareTo(o2.getDueDate());
        int startDateComparator = o1.getStartDate().compareTo(o2.getStartDate());

        return (dueDateComparator != 0) ? dueDateComparator : startDateComparator;
    }
}
