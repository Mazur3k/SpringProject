package org.edu.mazurek.edu.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Access(AccessType.FIELD)
@Getter
@Setter
@ToString
@Service
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    List<UserCourse> userCourseList;

}
