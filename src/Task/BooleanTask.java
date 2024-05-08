package Task;

import java.util.Date;

public class BooleanTask implements TaskInterface{
    private String taskName;

    private String taskDescription;

    private Date finalDate;

    private Priority priority;

    private Integer estimatedTime;

    private Boolean completed;

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String getTaskDescription() {
        return this.taskDescription;
    }

    @Override
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public Date getFinalDate() {
        return this.finalDate;
    }

    @Override
    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    @Override
    public Priority getPriority() {
        return this.priority;
    }

    @Override
    public Integer getEstimatedTime() {
        return this.estimatedTime;
    }

    @Override
    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @Override
    public Integer getProgress() {
        return null;
    }

    @Override
    public Boolean isCompleted() {
        return null;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
