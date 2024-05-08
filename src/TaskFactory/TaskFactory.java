package TaskFactory;

import Task.Priority;
import Task.TaskInterface;

import java.util.Date;

public interface TaskFactory {

    static TaskInterface createTask(String description, Date dueDate, Priority priority, int estimatedDuration, int progress, boolean completed) {
        return null;
    }


}
