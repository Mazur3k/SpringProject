package org.edu.mazurek.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Access(AccessType.FIELD)
public class UserCourseID {
    User user;
    Course course;
}
