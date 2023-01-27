package duke.tasktypes;

import duke.DukeExceptions;

public class Events extends Task {
    protected String fromDetails;
    protected String toDetails;

    public Events(String taskName) throws DukeExceptions{
        super(taskName.split("/from ")[0]);
        if (taskName.length() <= 0 || taskName.isBlank()) {
            throw new DukeExceptions("event");
        }
        String[] initialSplit = taskName.split("/from ");
        String[] nextSplit = initialSplit[1].split("/to ");
        this.fromDetails = nextSplit[0];
        this.toDetails = nextSplit[1];
    }

    @Override
    public String toString() {
        String toReturn = "";
        if (this.done) {
            toReturn = "[E][X]" + this.name + "(from: " + this.fromDetails + "to: " + this.toDetails + ")";
        } else {
            toReturn = "[E][ ]" + this.name + "(from: " + this.fromDetails + "to: " + this.toDetails + ")";
        }
        return toReturn;
    }
}
