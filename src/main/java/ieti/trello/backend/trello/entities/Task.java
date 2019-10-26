package ieti.trello.backend.trello.entities;


import ieti.trello.backend.trello.entities.util.Label;
import ieti.trello.backend.trello.entities.util.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Task{

    @Id
    private ObjectId _id;
    private State state;
    private Label label;
    private Date expirationDate;
    private String name;
    private String description;
    private String id;
    private String responsible;
    private List<Comment> comments  = new ArrayList<>();
    private List<User> members = new ArrayList<>();


}
