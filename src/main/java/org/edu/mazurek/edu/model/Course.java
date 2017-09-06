package org.edu.mazurek.edu.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Access(AccessType.FIELD)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

    @OneToMany
    List<UserCourse> userCourseList;


}
