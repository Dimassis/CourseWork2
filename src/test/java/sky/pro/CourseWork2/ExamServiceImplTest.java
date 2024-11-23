package sky.pro.CourseWork2;

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
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ExamServiceImplTest {

    @Mock
    JavaQuestionServiceImpl javaQuestionService;

    @InjectMocks
    ExamJavaServiceImpl examJavaService;

    private List<Question> questions;
    @BeforeEach
    public void setUp() {
        questions = List.of(
                new Question("What is Java?", "A programming language"),
                new Question("What is JVM?", "Java Virtual Machine"),
                new Question("What is JRE?", "Java Runtime Environment")
        );
    }

    @Test
    void getRandomQuestions_ShouldReturnCorrectNumberOfQuestions() {

        when(javaQuestionService.getQuestions()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestions()).thenReturn(questions.get(0), questions.get(1), questions.get(2));

        Collection<Question> result = examJavaService.getRandomQuestions(2);

        assertThat(result).hasSize(2).allMatch(questions::contains);
    }

    @Test
    void getRandomQuestions_WhenAmountIsZero_ShouldThrowException() {
        when(javaQuestionService.getQuestions()).thenReturn(questions);

        assertEquals(javaQuestionService.getQuestions().size(), 3);

        assertThrows(WrongAmountQuestionException.class, () -> examJavaService.getRandomQuestions(0));
    }

    @Test
    void getRandomQuestions_WhenAmountExceedsTotal_ShouldThrowException() {
        when(javaQuestionService.getQuestions())
                .thenReturn(questions);

        assertEquals(javaQuestionService.getQuestions().size(), 3);

        assertThrows(WrongAmountQuestionException.class, () -> examJavaService.getRandomQuestions(5));
    }
}
