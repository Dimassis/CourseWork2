package sky.pro.CourseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.impl.JavaQuestionServiceImpl;

import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
public class TestJavaQuestion {
    private JavaQuestionServiceImpl javaQuestionService;
    public static final String WRONG_AMOUNT_QUESTION = "Wrong amount question";

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionServiceImpl();
        javaQuestionService.getQuestions().clear();
    }

    @Test
    public void testShouldAddedQuestion() {
        Assertions.assertEquals(0, javaQuestionService.getQuestions().size());
        javaQuestionService.addQuestion("Вопрос 1", "Ответ 1");
        Assertions.assertEquals(1, javaQuestionService.getQuestions().size());
    }

    @Test
    public void testShouldRemoveQuestion() {
        Assertions.assertEquals(0, javaQuestionService.getQuestions().size());
        javaQuestionService.addQuestion("Вопрос 1", "Ответ 1");
        Assertions.assertEquals(1, javaQuestionService.getQuestions().size());
        javaQuestionService.removeQuestion("Вопрос 1");
        Assertions.assertEquals(0, javaQuestionService.getQuestions().size());
    }

    @Test
    public void testShouldFindQuestions() {
        Assertions.assertEquals(0, javaQuestionService.getQuestions().size());
        javaQuestionService.addQuestion("Вопрос 1", "Ответ 1");
        Assertions.assertEquals(1, javaQuestionService.getQuestions().size());
        Optional<Question> value = javaQuestionService.findQuestions("Вопрос 1");
        Optional<Question> value2 = javaQuestionService.findQuestions("Вопрос 2");
        Assertions.assertTrue(value.isPresent());
        Assertions.assertFalse(value2.isPresent());
    }

}
