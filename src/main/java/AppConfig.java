import com.spring.jdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//@ComponentScan({"core.spring.jdbc", "org.springframework.jdbc"})
public class AppConfig {
    @Bean("studentdaoimpl")
    public StudentDaoImpl getStudentDaoImpl() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setTemplate(getJdbcTemplate());
        return studentDao;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDriverManagerDataSource());
        return jdbcTemplate;
    }

    @Bean("datasource")
    public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true");
        driverManagerDataSource.setUsername("bipinshan");
        driverManagerDataSource.setPassword("Admin@2023");

        return driverManagerDataSource;
    }
}
