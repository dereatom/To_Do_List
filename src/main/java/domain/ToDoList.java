package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    private List<Task> toDo = new ArrayList<>();

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate finishedDate;

    public ToDoList(List<Task> toDo, String name, String description, LocalDate startDate, LocalDate finishedDate) {
        this.toDo = toDo;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finishedDate = finishedDate;
    }

    public List<Task> getToDo() {
        return toDo;
    }

    public void setToDo(List<Task> toDo) {
        this.toDo = toDo;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "toDo=" + toDo +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", finishedDate=" + finishedDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(LocalDate finishedDate) {
        this.finishedDate = finishedDate;
    }


}
