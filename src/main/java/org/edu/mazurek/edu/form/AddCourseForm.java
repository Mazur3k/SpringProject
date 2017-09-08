package org.edu.mazurek.edu.form;

import lombok.*;
import org.edu.mazurek.edu.model.UserCourse;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AddCourseForm {

    @NotEmpty
    private String name;

    List<UserCourse> userCourseList;
}
