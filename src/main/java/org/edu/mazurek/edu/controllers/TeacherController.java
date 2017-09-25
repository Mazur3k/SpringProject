package org.edu.mazurek.edu.controllers;

import org.edu.mazurek.edu.model.Course;
import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.model.UserCourse;
import org.edu.mazurek.edu.model.UserCourseID;
import org.edu.mazurek.edu.repository.CourseRepository;
import org.edu.mazurek.edu.repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {

    @Autowired
    User user;

    @Autowired
    Course course;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserCourseRepository userCourseRepository;

    @RequestMapping("/teacher")
    public ModelAndView showCourses() {

        Map<String, Object> map = new HashMap<>();

        Iterable<Course> courses = courseRepository.findAll();

        map.put("courses", courses);

        return new ModelAndView("teacherzone", map);
    }

    @RequestMapping(method = RequestMethod.POST, path="display")
    public ModelAndView showStudentFromCourse(@RequestParam Long courseID) {

        Map<String, Object> map = new HashMap<>();

        List<UserCourse> users = courseRepository.findOne(courseID).getUserCourseList();
        map.put("list", users);
        map.put("display","");

        return new ModelAndView("teacherzone", map);
    }

}
