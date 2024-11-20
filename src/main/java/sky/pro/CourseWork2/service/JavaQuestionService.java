package sky.pro.CourseWork2.service;

import sky.pro.CourseWork2.model.Question;

import java.util.Collection;
import java.util.Optional;

public interface JavaQuestionService {
    Collection<Question> getQuestions();
    Collection<Question> addQuestion(String question, String answer);
    Collection<Question> removeQuestion(String question);
    Optional<Question> findQuestions(String question);
}
