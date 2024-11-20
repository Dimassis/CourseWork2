package sky.pro.CourseWork2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.impl.JavaQuestionServiceImpl;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQuestionServiceImpl javaQuestionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return javaQuestionService.getQuestions();
    }

    @GetMapping("/add")
    public Collection<Question> addQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.addQuestion(question, answer);
    }
    @GetMapping("/remove")
    public Collection<Question> removeQuestion(@RequestParam String question) {
        return javaQuestionService.removeQuestion(question);
    }
    @GetMapping("/find")
    public Optional<Question> findQuestion(@RequestParam String question) {
        return javaQuestionService.findQuestions(question);
    }
}


