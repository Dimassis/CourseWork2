package sky.pro.CourseWork2.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.impl.JavaQuestionServiceImpl;
import java.util.Collection;

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

    @PostMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.addQuestion(question, answer);
    }

    @DeleteMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question newQuestion = new Question(question, answer);
        return javaQuestionService.removeQuestion(newQuestion);
    }
}


