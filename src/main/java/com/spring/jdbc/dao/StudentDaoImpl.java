package com.spring.jdbc.dao;

import core.spring.jdbc.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int insert(Student student) {
        // Inert Query
        String insertQuery="insert into student(id, name, city) values(?,?,?)";

        //fire query
        int result=this.template.update(insertQuery,student.getId(),student.getName(),student.getCity());

        return  result;
    }

    @Override
    public int change(Student student) {
        // updating data
        String updateQuery="update student set name=?, city=? where id=?";
        int result=this.template.update(updateQuery, student.getName(),student.getCity(), student.getId());
        return result;
    }

    @Override
    public int delete(Student student) {
        //delete operation
        String deleteQuery="delete from student where id=?";
        int result=this.template.update(deleteQuery, student.getId());
        return  result;
    }

    @Override
    public Student getStudent(int studentId) {
        // Select Query
        String selectQuery="select * from student where id=?";
        RowMapper<Student> rowMapper=new RowMapperImpl();
        return this.template.queryForObject(selectQuery,rowMapper,studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        // Select multiple object
        String selectMultipleQuery="select * from student";
        List<Student> students=this.template.query(selectMultipleQuery, new RowMapperImpl());
        return students;
    }
}
