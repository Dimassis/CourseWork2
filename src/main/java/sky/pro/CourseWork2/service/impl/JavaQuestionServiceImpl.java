package sky.pro.CourseWork2.service.impl;
import org.springframework.stereotype.Service;
import sky.pro.CourseWork2.exception.QuestionIsNotFoundException;
import sky.pro.CourseWork2.model.Question;
import sky.pro.CourseWork2.service.QuestionService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
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
    public Question addQuestion(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question addQuestion(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    @Override
    public Question removeQuestion(Question question) throws QuestionIsNotFoundException {
        if(!questions.contains(question)) {
            throw new QuestionIsNotFoundException("Question is not found");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Question getRandomQuestions() {
        Random random = new Random();
        List<Question> list = new ArrayList<>(questions);
        int value = random.nextInt(questions.size());
        return list.get(value);
    }
}
