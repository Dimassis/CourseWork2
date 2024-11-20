package sky.pro.CourseWork2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.ExamJavaService;

import java.util.Collection;

@RequestMapping("/java/exam")
@RestController
public class JavaExamController {
    private final ExamJavaService examJavaService;

    public JavaExamController(ExamJavaService examJavaService) {
        this.examJavaService = examJavaService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examJavaService.getRandomQuestions(amount);
    }
}