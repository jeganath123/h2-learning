package io.jegan.com.h2_database_learning;

import io.jegan.com.h2_database_learning.dao.StudentDAO;
import io.jegan.com.h2_database_learning.domain.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.annotation.PostConstruct;

@SpringBootApplication
public class H2DatabaseLearningApplication {
private JdbcTemplate template;
private StudentDAO dao;

    public H2DatabaseLearningApplication(JdbcTemplate template, StudentDAO dao) {
        this.template = template;
        this.dao = dao;
    }

    public static void main(String[] args) { SpringApplication.run(H2DatabaseLearningApplication.class, args); }
@Bean
CommandLineRunner commandLineRunner(){
        return arg->{
            init();
            dao.addStudent(new Student(1,"Jegan","java"));
            dao.addStudent(new Student(2,"Balaji","sql"));
            dao.addStudent(new Student(3,"Danya","devops"));
            dao.listAllStudent().forEach(System.out::println);
        };
}
    public void init(){
        System.out.println("Creating table");
        String sql="CREATE TABLE Student(id int, name VARCHAR(50), programCourse VARCHAR(50))";
        template.execute(sql);
    }

}
