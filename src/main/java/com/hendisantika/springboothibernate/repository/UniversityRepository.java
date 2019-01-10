package com.hendisantika.springboothibernate.repository;

import com.hendisantika.springboothibernate.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hibernate
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-11
 * Time: 05:42
 * To change this template use File | Settings | File Templates.
 */
public interface UniversityRepository extends RevisionRepository<University, Long, Long>, JpaRepository<University, Long> {
}