package seedu.jarvis.model.planner;

/**
 * Represents a description of a {@code Task}
 */
public class TaskDescription {

    private String taskDescription;

    public TaskDescription(String taskDes) {
        taskDescription = taskDes;
    }

    @Override
    public String toString() {
        return taskDescription;
    }

}
