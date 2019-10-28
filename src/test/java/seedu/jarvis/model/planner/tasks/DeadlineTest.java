package seedu.jarvis.model.planner.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.jarvis.testutil.planner.TypicalTasks.DEADLINE;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.jarvis.commons.core.tag.Tag;
import seedu.jarvis.model.planner.TaskDescription;
import seedu.jarvis.model.planner.enums.Frequency;
import seedu.jarvis.model.planner.enums.Priority;
import seedu.jarvis.model.planner.enums.Status;


class DeadlineTest {

    @Test
    void addPriority_validInput_success() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);
        d.setPriority(Priority.HIGH);
        assertNotNull(d.priority);
    }

    @Test
    void addFrequency_validInput_success() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);
        d.setFrequency(Frequency.MONTHLY);
        assertNotNull(d.frequency);
    }

    @Test
    void addTag_validInput_success() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);
        Tag t = new Tag("school");
        d.addTag(t);
        assertNotNull(d.tags);
    }

    @Test
    void getTags_validInput_success() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);
        Tag t = new Tag("school");
        d.addTag(t);
        assertTrue(d.getTags().contains(t));
    }

    @Test
    void equals_validInput_true() {
        LocalDate deadlineOneCal = LocalDate.parse("10/10/2019", Task.getDateFormat());
        LocalDate deadlineTwoCal = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline deadlineOne = new Deadline(new TaskDescription("borrow book"), deadlineOneCal);
        Deadline deadlineTwo = new Deadline(new TaskDescription("borrow book"), deadlineTwoCal);
        assertTrue(deadlineOne.equals(deadlineTwo));
    }

    @Test
    void equals_validInput_false() {
        LocalDate deadlineOneCal = LocalDate.parse("10/10/2019", Task.getDateFormat());
        LocalDate deadlineTwoCal = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline deadlineOne = new Deadline(new TaskDescription("borrow hello"), deadlineOneCal);
        Deadline deadlineTwo = new Deadline(new TaskDescription("borrow book"), deadlineTwoCal);
        assertFalse(deadlineOne.equals(deadlineTwo));
    }

    @Test
    void getDueDate() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);
        assertEquals(due, d.getDueDate());
    }

    @Test
    void toString_withAllAttributesPresent() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);
        d.setPriority(Priority.LOW);
        d.setFrequency(Frequency.MONTHLY);
        d.addTag(new Tag("school"));
        d.addTag(new Tag("cs"));

        String expected = "Deadline: homework by 2019-10-10\nPriority: LOW\nFrequency: MONTHLY"
                            + "\nTags: [[cs], [school]]";

        assertEquals(expected, d.toString());
    }

    @Test
    void toString_withNoAttributesPresent() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);

        String expected = "Deadline: homework by 2019-10-10";

        assertEquals(expected, d.toString());
    }

    @Test
    void getTaskDes_success() {
        TaskDescription expected = new TaskDescription("homework");
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);

        assertEquals(expected, d.getTaskDes());
    }

    @Test
    public void adaptToJsonAdaptedDeadline() throws Exception {
        assertEquals(DEADLINE, DEADLINE.adaptToJsonAdaptedTask().toModelType());
    }

    @Test
    void markAsDone() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);

        d.markAsDone();

        assertEquals(Status.DONE, d.getStatus());
    }

    @Test
    void markAsNotDone() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);

        d.markAsDone();
        assertEquals(Status.DONE, d.getStatus());

        d.markAsNotDone();
        assertEquals(Status.NOT_DONE, d.getStatus());
    }

    @Test
    void getStatus() {
        LocalDate due = LocalDate.parse("10/10/2019", Task.getDateFormat());
        Deadline d = new Deadline(new TaskDescription("homework"), due);

        assertEquals(Status.NOT_DONE, d.getStatus());
    }
}
