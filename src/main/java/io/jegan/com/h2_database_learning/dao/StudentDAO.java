package io.jegan.com.h2_database_learning.dao;

import io.jegan.com.h2_database_learning.domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class StudentDAO {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
   public void addStudent(Student student){
        String sql="INSERT into Student values(:id,:name,:programCourse)";
        namedParameterJdbcTemplate.update(sql,new BeanPropertySqlParameterSource(student));
   }
   public List<Student> listAllStudent(){
        String sql="SELECT * from Student";
        return namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
   }
}
