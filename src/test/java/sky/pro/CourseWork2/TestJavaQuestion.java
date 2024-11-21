package sky.pro.CourseWork2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.CourseWork2.exception.QuestionIsNotFoundException;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.impl.JavaQuestionServiceImpl;
import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaQuestionServiceImplTest {
    private JavaQuestionServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionServiceImpl();
    }

    @Test
    void getQuestions_ShouldReturnAllQuestions() {
        Collection<Question> questions = service.getQuestions();

        assertEquals(6, questions.size());

        assertThat(questions).extracting(question -> question.getQuestion())
                .contains("What is Java?", "What is JVM?");
    }

    @Test
    void addQuestion_ShouldAddNewQuestion() {
        Question newQuestion = new Question("What is API?", "Application Programming Interface");

        service.addQuestion(newQuestion);

        assertThat(service.getQuestions()).contains(newQuestion);
    }

    @Test
    void addQuestion_WithStrings_ShouldAddNewQuestion() {
        String question = "What is Framework?";
        String answer = "A structure for software development";

        service.addQuestion(question, answer);

        assertThat(service.getQuestions())
                .anyMatch(q -> q.getQuestion().equals(question) && q.getAnswer().equals(answer));
    }

    @Test
    void removeQuestion_ShouldRemoveExistingQuestion() throws QuestionIsNotFoundException {
        Question question = new Question("What is Java?", "A programming language");

        service.removeQuestion(question);

        assertThat(service.getQuestions()).doesNotContain(question);
    }

    @Test
    void removeQuestion_WhenQuestionNotExists_ShouldThrowException() {
        Question testQuestion = new Question("What is API?", "Application Programming Interface");

        assertThrows(QuestionIsNotFoundException.class, () -> service.removeQuestion(testQuestion));
    }

    @Test
    void getRandomQuestions_ShouldReturnRandomQuestion() {
        Question randomQuestion = service.getRandomQuestions();

        assertThat(service.getQuestions()).contains(randomQuestion);
    }
}