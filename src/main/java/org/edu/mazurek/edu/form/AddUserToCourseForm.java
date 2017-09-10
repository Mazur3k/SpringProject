package org.edu.mazurek.edu.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddUserToCourseForm {

    private long userID;

    private long courseID;
}
