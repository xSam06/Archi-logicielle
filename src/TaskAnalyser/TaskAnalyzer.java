package TaskAnalyser;

import Task.Task;
import Task.TaskInterface;
import TaskFactory.TaskFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskAnalyzer {

     public static void main(String[] args) {

    }

    public static void printNotFinishedTasks(List<TaskInterface> tasks) {
        List<TaskInterface> nonCompletedTasks = tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());

        if (nonCompletedTasks.isEmpty()) {
            System.out.println("Aucune tâche non complétée trouvée.");
            return;
        }

        nonCompletedTasks.sort(Comparator.comparingInt(task -> Math.abs(task.getEstimatedTime())));

        int numTasksToPrint = Math.min(5, nonCompletedTasks.size());
        System.out.println("Les 5 premières tâches non complétées :");
        for (int i = 0; i < numTasksToPrint; i++) {
            TaskInterface task = nonCompletedTasks.get(i);
            System.out.println((i + 1) + ". " + task.getTaskName() + " - Date d'échéance : " + task.getEstimatedTime());
        }
    }

    public static List<TaskInterface> loadTasksFromFile(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.FRENCH);

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            return lines.map(String::trim)
                    .filter(line -> line.startsWith("<task>"))
                    .map(line -> line.substring(6, line.length() - 7))
                    .map(line -> line.split("</?\\w+>"))
                    .map(tokens -> new Task())
                    .map(info -> TaskFactory.createTask(info.getTaskName(),info.getFinalDate(), info.getPriority(),info.getEstimatedTime(),info.getProgress(),info.isCompleted()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }



}
