package com.hendisantika.springboothibernate.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hibernate
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-11
 * Time: 05:39
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Audited
public class University extends BaseEntity {
    String name;
    String city;

    @OneToMany(mappedBy = "university")
    Set<Student> students = new HashSet<>();
}
