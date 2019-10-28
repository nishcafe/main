package seedu.jarvis.model.planner;

import seedu.jarvis.model.planner.tasks.Task;

/**
 * Represents a description of a {@code Task}
 */
//TODO tests
public class TaskDescription {

    private String taskDescription;

    public TaskDescription(String taskDes) {
        taskDescription = taskDes;
    }

    @Override
    public boolean equals(Object other) {

        //short circuit if same object
        if (this == other) {
            return true;
        }

        //instanceof handles nulls
        if (!(other instanceof TaskDescription)) {
            return false;
        }

        //state check
        TaskDescription des = (TaskDescription) other;
        return taskDescription.equals(other.toString());
    }

    @Override
    public String toString() {
        return taskDescription;
    }

}
