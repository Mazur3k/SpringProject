package org.edu.mazurek.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Service
@Access(AccessType.FIELD)
public class UserCourseID  implements Serializable{

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Course course;


}
