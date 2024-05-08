package Task;

import java.util.Date;

public interface TaskInterface {
    public String getTaskName();

    public void setTaskName(String taskName);

    public String getTaskDescription();

    public void setTaskDescription(String taskDescription);

    public Date getFinalDate();

    public void setFinalDate(Date finalDate);

    public Priority getPriority();

    public void setPriority(Priority priority);

    public Integer getEstimatedTime();

    public void setEstimatedTime(int estimatedTime);

    public Integer getProgress();

    public Boolean isCompleted();
}
