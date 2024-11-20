package sky.pro.CourseWork2.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.JavaQuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {
    private final Set<Question> questions = new HashSet<>(
            List.of(new Question("What is Java?","A programming language"),
                    new Question("What is JVM?", "Java Virtual Machine"),
                    new Question("What is JRE?", "Java Runtime Environment"),
                    new Question("What is JDR?", "Java Runtime Development"),
                    new Question("What is OOP?", "Object Oriented Programming"),
                    new Question("What is IDE?", "Integrated Development Environment"))
    );


    @Override
    public Collection<Question> getQuestions() {
        return questions;
    }

    @Override
    public Collection<Question> addQuestion(String question, String answer) {
        questions.add(new Question(question, answer));
        return questions;
    }

    @Override
    public Collection<Question> removeQuestion(String question) {
        questions.removeIf(q -> q.getQuestion().equals(question));
        return questions;
    }

    @Override
    public Optional<Question> findQuestions(String question) {
        return questions.stream()
                .filter(q -> q.getQuestion().equals(question))
                .findFirst();
    }
}
