package sky.pro.CourseWork2.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.CourseWork2.exception.WrongAmountQuestionException;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.ExamJavaService;
import sky.pro.CourseWork2.service.QuestionService;

import java.util.*;

@Service
public class ExamJavaServiceImpl implements ExamJavaService {
    private final QuestionService javaQuestionService;

    public ExamJavaServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getRandomQuestions(int amount) {
        int totalQuestions = javaQuestionService.getQuestions().size();
        if(amount <= 0 || amount > totalQuestions) {
            throw new WrongAmountQuestionException("Wrong amount of questions");
        }
        Set<Question> randomQuestion = new HashSet<>();
        while (randomQuestion.size() < amount) {
            randomQuestion.add(javaQuestionService.getRandomQuestions());
        }
        return randomQuestion;
    }
}
