package org.edu.mazurek.edu.configuration;

import org.edu.mazurek.edu.model.Course;
import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.model.UserCourse;
import org.edu.mazurek.edu.model.UserCourseID;
import org.edu.mazurek.edu.repository.CourseRepository;
import org.edu.mazurek.edu.repository.UserCourseRepository;
import org.edu.mazurek.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AddTestData {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final UserCourseRepository userCourseRepository;

    @Autowired
    public AddTestData(UserRepository userRepository, CourseRepository courseRepository, UserCourseRepository userCourseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.userCourseRepository = userCourseRepository;
    }

    @PostConstruct
    public void addTestData() {
        LocalDate now = LocalDate.now();

        User userJan = new User(0l, "Jan", "Kowalski", "jan.kowalski@gmail.com", now, "123", new ArrayList<UserCourse>());
        User userAdam = new User(0l, "Adam", "Mazurkiewicz", "adam.mazurkiewicz92@gmail.com", now, "123", new ArrayList<UserCourse>());
        User userStefan = new User(0l, "Stefan", "Niesiolowski", "stefan.niesiolowski@gmail.com", now, "123", new ArrayList<UserCourse>());
        User userEugeniusz = new User(0l, "Eugeniusz", "Smolarek", "eugeniusz.smolarek@gmail.com", now, "123", new ArrayList<UserCourse>());

        userJan = userRepository.save(userJan); //po dodaniu do bazy id jest generowane i się zmienia, dlatego trzeba przypisac nowa wartosc (z nowa wartosc id)
        userAdam = userRepository.save(userJan);
        userStefan = userRepository.save(userJan);
        userEugeniusz = userRepository.save(userJan);



        Course math = new Course(0l, "Math", new ArrayList<>());
        Course biology = new Course(0l, "Biology", new ArrayList<>());
        Course polish = new Course(0l, "Polish", new ArrayList<>());
        Course it = new Course(0l, "IT", new ArrayList<>());

        math = courseRepository.save(math);
        biology = courseRepository.save(biology);
        polish = courseRepository.save(polish);
        it = courseRepository.save(it);

        List<UserCourse> userCourses = Arrays.asList(
                new UserCourse(new UserCourseID(userJan, math)),
                new UserCourse(new UserCourseID(userJan, biology)),
                new UserCourse(new UserCourseID(userJan, polish)),
                new UserCourse(new UserCourseID(userJan, it)),
                new UserCourse(new UserCourseID(userAdam, math)),
                new UserCourse(new UserCourseID(userAdam, biology))
        );

        userCourseRepository.save(userCourses);

    }


}
