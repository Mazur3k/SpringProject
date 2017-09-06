package org.edu.mazurek.edu.repository;

import org.edu.mazurek.edu.model.UserCourse;
import org.edu.mazurek.edu.model.UserCourseID;
import org.springframework.data.repository.CrudRepository;

public interface UserCourseRepository extends CrudRepository<UserCourse, UserCourseID> {

}
