package eci.cosw.data.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Todo {

     @Id
     private ObjectId _id;

     private String description;
     private int priority;
     private Date dueDate;

    @Override
    public String toString() {
        return "Todo{" +
                "_id=" + _id +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", responsible='" + responsible + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    private String responsible;
     private String status;

     public Todo(){}

    public Todo(String description, String responsible , String  status, Date dueDate , int priority) {
        this.description = description;
        this.responsible = responsible;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
