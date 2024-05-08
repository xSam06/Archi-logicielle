package Task;

import java.util.*;

public class ComplexTask  implements TaskInterface{
    private String taskName;

    private String taskDescription;

    private int progress;

    private List<TaskInterface> subTasks;

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
        Date maxFinalDate = null;
        for (TaskInterface subTask : subTasks) {
            Date finalDate = subTask.getFinalDate();
            if (finalDate != null && (maxFinalDate == null || finalDate.after(maxFinalDate))) {
                maxFinalDate = finalDate;
            }
        }
        return maxFinalDate;
    }

    @Override
    public void setFinalDate(Date finalDate) {
    }

    @Override
    public Priority getPriority() {
        return null;
    }

    @Override
    public Integer getEstimatedTime() {
        return subTasks.stream().mapToInt(TaskInterface::getEstimatedTime).sum();
    }

    @Override
    public void setEstimatedTime(int estimatedTime) {
    }

    @Override
    public Integer getProgress() {
        int totalDuration = getEstimatedTime();
        return totalDuration == 0 ? 0 :
                subTasks.stream().mapToInt(task -> task.getProgress() * task.getEstimatedTime()).sum() / totalDuration;
    }


    public void setProgress(int progress) {
    }

    @Override
    public Boolean isCompleted() {
        return subTasks.stream().allMatch(TaskInterface::isCompleted);
    }

    @Override
    public void setPriority(Priority priority) {
    }

    public void removeSubTask(String taskName) {
        subTasks.removeIf(task -> task.getTaskName().equals(taskName));
    }

    public List<TaskInterface> getSubTasks() {
        return this.subTasks;
    }

    public void addSubTask(TaskInterface subTask) {
        subTasks.add(subTask);
    }
}
