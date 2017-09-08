package org.edu.mazurek.edu.controllers;

import org.edu.mazurek.edu.form.AddCourseForm;
import org.edu.mazurek.edu.model.Course;
import org.edu.mazurek.edu.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("course")
public class CourseController {

    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    @RequestMapping("add")
    public ModelAndView addCourse(@Valid AddCourseForm addCourseForm)
    {
        Map<String, String> map = new HashMap<>();
        Course course = new Course(0l,addCourseForm.getName(),addCourseForm.getUserCourseList());
        map.put("successCourse","");
        courseRepository.save(course);
        return new ModelAndView("panel", map);
    }

    @RequestMapping("show_add")
    public ModelAndView showAdd()
    {
        Map<String, String> map = new HashMap<>();
        map.put("addCourse","");
        return new ModelAndView("panel",map);
    }

    @RequestMapping("show_courses")
    public ModelAndView showCourses(@ModelAttribute("course") Course course)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("showCourses","");
        map.put("courseList", courseRepository.findAll());
        return new ModelAndView("panel",map);
    }

    @RequestMapping(method = RequestMethod.GET, path="delete/{id}")
    public ModelAndView deleteCourse(@PathVariable("id") Long id)
    {
        Map<String,String> map = new HashMap<>();
        courseRepository.delete(id);
        map.put("courseDeleted","");
        return new ModelAndView("panel",map);

    }
}
