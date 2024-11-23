package sky.pro.CourseWork2.service;

import sky.pro.CourseWork2.model.Question;

import java.util.Collection;

public interface ExamJavaService {
    Collection<Question> getRandomQuestions(int amount);
}
