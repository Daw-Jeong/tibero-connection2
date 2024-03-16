package dawoon.tiberoconnection2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseCheckController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/database-check")
    public String checkDatabaseConnection() {
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class);
            return "Database connection successful!";
        } catch (Exception e) {
            return "Failed to connect to the database: " + e.getMessage();
        }
    }
}