import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import core.spring.jdbc.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TestApp {
    public static void main(String[] args)
    {
        System.out.println("Hello World");

        ApplicationContext appContext= new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDao=appContext.getBean("studentdaoimpl", StudentDao.class);
        Student s1=new Student(1002, "Kawal","Gaya");

        //INSERT
        //System.out.println("number of record inserted:" +studentDao.insert(s1));

        Student s2=new Student(1002, "KL Rahul","Bangalore");
        //UPDATE
        //System.out.println("Data Changed: "+studentDao.change(s2));
        //DELETE
        //System.out.println("Student Deleted: "+studentDao.delete(s2));
        System.out.println(studentDao.getStudent(101));

        List<Student> studentList=studentDao.getAllStudent();
        for(Student s:studentList)
            System.out.println(s);
    }
}
