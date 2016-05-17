package model;

/**
 * Created by rybatsky
 */

public class Task {

    private int taskId;
    private int ownerId;
    private int foresterId;
    private String plant;
    private String type;
    private String comments;
    private Boolean done;
    private Boolean confirmed;

    public Task(int taskId,
                int ownerId,
                int foresterId,
                String plant,
                String type,
                String comments,
                boolean done,
                boolean confirmed) {

        this.taskId = taskId;
        this.ownerId = ownerId;
        this.foresterId = foresterId;
        this.plant = plant;
        this.type = type;
        this.comments = comments;
        this.done = done;
        this.confirmed = confirmed;
    }

    public Task() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getForesterId() {
        return foresterId;
    }

    public void setForesterId(int foresterId) {
        this.foresterId = foresterId;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public static boolean getDoneStatic(String done) {

        boolean doneB;
        doneB = done.equals("Done");
        return doneB;
    }

    public static boolean getConfirmedStatic(String confirmed) {

        boolean confirmedB;
        confirmedB = confirmed.equals("Confirmed");
        return confirmedB;
    }

}
