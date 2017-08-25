package com.fgaudin.mongo.repositories;

import com.fgaudin.mongo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
