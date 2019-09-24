package vn.topica.itlab4;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;

/**
 * This class contains methods to access to DB and insert records into it
 *
 * @author AnhLT14(anhlt14@topica.edu.vn)
 */
public class PeopleDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    /**
     * This method is to connect to DB
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * This method is to insert records into DB
     *
     * @param id
     * @param name
     * @param dateOfBirth
     * @param gender
     */
    public void create(int id, String name, Date dateOfBirth, int gender) {
        String SQL = "insert into People (ID, Name, DateOfBirth, Gender) values (?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, id, name, dateOfBirth, gender);
        System.out.println("Created Record ID = " + id + " Name = " + name);
        return;
    }
}
