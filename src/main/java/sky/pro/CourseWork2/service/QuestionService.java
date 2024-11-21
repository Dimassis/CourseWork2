package sky.pro.CourseWork2.service;

import sky.pro.CourseWork2.model.Question;

import java.util.Collection;
import java.util.Optional;

public interface QuestionService {
    Collection<Question> getQuestions();
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(Question question);
    Question getRandomQuestions();
}
