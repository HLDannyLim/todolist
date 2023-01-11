package sg.edu.nuss.iss.app.workshoptodo.module;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class ToDo {
    private int id = 0;
    @NotNull
    private String task ;
    private LocalDate taskdate ;
    private boolean completed ;

    public ToDo(){}

    

    public ToDo(int id, String task, LocalDate taskdate, boolean completed) {
        this.id = id;
        this.task = task;
        this.taskdate = taskdate;
        this.completed = completed;
    }

    public ToDo(String task, LocalDate taskdate, boolean completed) {
        
        this.task = task;
        this.taskdate = taskdate;
        this.completed = completed;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(LocalDate taskdate) {
        this.taskdate = taskdate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    
    
}
