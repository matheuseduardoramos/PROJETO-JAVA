
package model;

import java.util.Date;


public class Project {
    private int ProjectId;
    private String Name;
    private String Description;
    private Date CreateDate;
    private Date UpdateDate;

    public Project(int ProjectId, String Name, String Description, Date CreateDate, Date UpdateDate) {
        this.ProjectId = ProjectId;
        this.Name = Name;
        this.Description = Description;
        this.CreateDate = CreateDate;
        this.UpdateDate = UpdateDate;
    }

    public Project() {
        this.CreateDate = new Date();
        this.UpdateDate = new Date();
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
        return this.Name;
    }

    public void setUpdateDate(java.sql.Date date) {
      
    }


    
}
