package Task;

import java.util.Date;

public class Task implements TaskInterface {
    private String taskName;

    private String taskDescription;

    private Date finalDate;

    private Priority priority;

    private Integer estimatedTime;

    private int progress;

    private Boolean completed;

    @Override
    public Boolean isCompleted() {
        return null;
    }

    public void setCompleted(boolean completed) {
    }

    @Override
    public String getTaskName() {
        return null;
    }

    @Override
    public void setTaskName(String taskName) {
    }

    @Override
    public String getTaskDescription() {
        return null;
    }

    @Override
    public void setTaskDescription(String taskDescription) {
    }

    @Override
    public Date getFinalDate() {
        return null;
    }

    @Override
    public void setFinalDate(Date finalDate) {
    }

    @Override
    public Priority getPriority() {
        return null;
    }

    @Override
    public void setPriority(Priority priority) {
    }

    @Override
    public Integer getEstimatedTime() {
        return null;
    }

    @Override
    public void setEstimatedTime(int estimatedTime) {
    }

    @Override
    public Integer getProgress() {
        return null;
    }

    public void setProgress(int progress) {
    }
}
