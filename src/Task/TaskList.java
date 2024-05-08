package Task;

import Printer.TaskListPrinter;

import java.util.Iterator;
import java.util.List;

public class TaskList {
    private List<TaskInterface> taskList;

    private List<TaskListPrinter> printerList;

    private void printList() {
        for (TaskListPrinter printer : printerList) {
            printer.print(this);
        }
    }

    public TaskInterface getTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            return taskList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    public void addTask(TaskInterface task) {
        taskList.add(task);
        printList();
    }

    public void removeTask(String taskName) {
        // Suppression de la tâche correspondante de la liste des tâches
        boolean removed = taskList.removeIf(task -> task.getTaskName().equals(taskName));

        if (!removed) {
            throw new IllegalArgumentException("Cette tâche n'existe pas dans la liste.");
        }

        // Vérification et suppression des sous-tâches si la tâche supprimée est une tâche complexe
        Iterator<TaskInterface> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            TaskInterface task = iterator.next();
            if (task instanceof ComplexTask) {
                ComplexTask complexTask = (ComplexTask) task;
                List<TaskInterface> subTasks = complexTask.getSubTasks();
                boolean subTaskRemoved = subTasks.removeIf(subTask -> subTask.getTaskName().equals(taskName));
                // Si toutes les sous-tâches ont été supprimées, supprimer également la tâche complexe
                if (subTaskRemoved && subTasks.isEmpty()) {
                    iterator.remove();
                }
            }
        }
        printList();
    }

    public void modifyTask(TaskInterface modifiedTask) {
        int index = taskList.indexOf(modifiedTask);
        if (index != -1) {
            taskList.set(index, modifiedTask);
            printList();
        } else {
            throw new IllegalArgumentException("Cette tâche n'existe pas dans la liste.");
        }
    }

    public List<TaskInterface> getTaskList() {
        return taskList;
    }

    public void removeSubTask(int rowIndex, String taskName) {
        // Vérifie si l'indice de ligne est valide
        if (rowIndex >= 0 && rowIndex < taskList.size()) {
            TaskInterface task = taskList.get(rowIndex);
            if (task instanceof ComplexTask) {
                ((ComplexTask) task).removeSubTask(taskName);
                printList();
            } else {
                throw new IllegalArgumentException("Cette tâche à l'indice spécifié n'est complexe.");
            }
        } else {
            throw new IndexOutOfBoundsException("Indice invalid : " + rowIndex);
        }
    }
}
