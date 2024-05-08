package TaskFactory;

import Task.Priority;
import Task.Task;
import Task.TaskInterface;

import java.time.LocalDate;
import java.util.Date;

public class TaskFactoryImpl implements TaskFactory{

    public TaskInterface createTask(String description, Date dueDate, Priority priority, int estimatedDuration, int progress, boolean completed) {
        return null;
    }
}
