package org.edu.mazurek.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Access(AccessType.FIELD)
public class UserCourseID  implements Serializable{

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Course course;
}
