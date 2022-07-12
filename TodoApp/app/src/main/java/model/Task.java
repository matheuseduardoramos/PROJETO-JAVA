package model;

import java.util.Date;

public class Task {

    private int TaskId;
    private int ProjectId;
    private String Name;
    private String Description;
    private String Notes;
    private boolean isCompleted;
    private Date Deadline;
    private Date CreateDate;
    private Date UpdateDate;
   

    public Task(int TaskId, int ProjectId, String Name, String Description, String Notes, boolean isCompleted, Date Deadline, Date CreateDate, Date UpdateDate) {
        this.TaskId = TaskId;
        this.ProjectId = ProjectId;
        this.Name = Name;
        this.Description = Description;
        this.Notes = Notes;
        this.isCompleted = isCompleted;
        this.Deadline = Deadline;
        this.CreateDate = CreateDate;
        this.UpdateDate = UpdateDate;
    }

    public Task() {
        this.CreateDate = new Date();
        this.UpdateDate = new Date();
        
        
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int TaskId) {
        this.TaskId = TaskId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int ProjectId) {
        this.ProjectId = ProjectId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getDeadline() {
        return Deadline;
    }

    public void setDeadline(Date Deadline) {
        this.Deadline = Deadline;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date UpdateDate) {
        this.UpdateDate = UpdateDate;
    }

    @Override
    public String toString() {
        return "Task{" + "TaskId=" + TaskId + ", ProjectId=" + ProjectId + ", Name=" + Name + ", Description=" + Description + ", Notes=" + Notes + ", isCompleted=" + isCompleted + ", Deadline=" + Deadline + ", CreateDate=" + CreateDate + ", UpdateDate=" + UpdateDate + '}';
    }


}
