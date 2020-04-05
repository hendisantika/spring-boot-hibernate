package com.hendisantika.springboothibernate.repository;

import com.hendisantika.springboothibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hibernate
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-11
 * Time: 05:41
 * To change this template use File | Settings | File Templates.
 */
public interface StudentRepository extends RevisionRepository<Student, Long, Long>, JpaRepository<Student, Long> {
}