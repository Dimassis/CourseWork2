package sky.pro.CourseWork2.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.CourseWork2.exception.WrongAmountQuestionException;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.ExamJavaService;
import sky.pro.CourseWork2.service.JavaQuestionService;

import java.util.*;

@Service
public class ExamJavaServiceImpl implements ExamJavaService {
    private final JavaQuestionService javaQuestionService;

    public ExamJavaServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getRandomQuestions(int amount) {
        try {
            Collection<Question> questions = javaQuestionService.getQuestions();
            if (amount > questions.size() || amount < 0) {
                throw new WrongAmountQuestionException("Wrong amount of questions");
            }
            if (amount == questions.size()) {
                return questions;
            }
            List<Question> randomQuestions = new ArrayList<>(questions);
            Collections.shuffle(randomQuestions);
            return randomQuestions.subList(0, amount);
        } catch (WrongAmountQuestionException e) {
            throw new WrongAmountQuestionException("Wrong amount of questions");
        }
    }
}
