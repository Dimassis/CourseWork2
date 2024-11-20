package sky.pro.CourseWork2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.CourseWork2.exception.WrongAmountQuestionException;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.impl.ExamJavaServiceImpl;
import sky.pro.CourseWork2.service.impl.JavaQuestionServiceImpl;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExamServiceImplTest {



    @Mock
    JavaQuestionServiceImpl javaQuestionService;

    @InjectMocks
    ExamJavaServiceImpl examJavaService;

    @BeforeEach
    public void setUp() {
        javaQuestionService.getQuestions().clear();

        when(javaQuestionService.getQuestions()).thenReturn(
                List.of(
                        new Question("Q1", "A1"),
                        new Question("Q2", "A2"),
                        new Question("Q3", "A3")
                )
        );
    }

    @Test
    public void testExamJavaService() {
        Collection<Question> questions = examJavaService.getRandomQuestions(2);

        Assertions.assertEquals(2, questions.size());
    }

    @Test
    public void testThrowsException() {
        Assertions.assertThrows(WrongAmountQuestionException.class, () -> examJavaService.getRandomQuestions(4));
    }
}
