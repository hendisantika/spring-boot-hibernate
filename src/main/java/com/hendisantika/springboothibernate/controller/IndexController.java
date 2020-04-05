package com.hendisantika.springboothibernate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendisantika.springboothibernate.entity.Student;
import com.hendisantika.springboothibernate.entity.University;
import com.hendisantika.springboothibernate.repository.StudentRepository;
import com.hendisantika.springboothibernate.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hibernate
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-11
 * Time: 05:44
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class IndexController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    @GetMapping(value = "/students")
    public Flux<Student> getStudents() {
        return Flux.defer(() -> {
            List<Student> all = studentRepository.findAll();
            return Flux.fromIterable(all);
        }).subscribeOn(Schedulers.elastic());
    }

    @Transactional
    @GetMapping(value = "/universities")
    public Flux<University> getUniversities() {

        List<University> all = universityRepository.findAll();
        return Flux.defer(() -> Flux.fromIterable(all))
                .subscribeOn(Schedulers.elastic());
    }

    @Transactional
    @PostMapping(value = "/universities")
    public Mono<ServerResponse> saveUniversity(Mono<University> universityMono) {
        return universityMono
                .publishOn(Schedulers.parallel())
                .doOnNext(universityRepository::save)
                .flatMap(a -> ServerResponse.ok().build());
    }

    @PostMapping(value = "/universities/{id}/student")
    public Mono<ServerResponse> saveStudent(@PathVariable Long id, @RequestBody Mono<Student> studentMono) {
        return studentMono
                .publishOn(Schedulers.parallel())
                .doOnNext(student -> {
                    University one = universityRepository.getOne(id);
                    student.setUniversity(one);
                    studentRepository.save(student);
                })
                .flatMap(a -> ServerResponse.ok().build());
    }
}
