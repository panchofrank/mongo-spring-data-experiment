package com.fgaudin.mongo;

import com.fgaudin.mongo.domain.Result;
import com.fgaudin.mongo.domain.Student;
import com.fgaudin.mongo.repositories.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void test() {
        studentRepository.findAll().forEach(s -> updateByRemovingLowestGrade(s));

    }

    private void updateByRemovingLowestGrade(Student student) {
        List<Result> results = student.getResultList();
        Result result = results.stream().filter(r -> r.getType().equals("homework")).min(Comparator.comparing(Result::getScore)).get();
        results.remove(result);
        studentRepository.save(student);
    }
}
