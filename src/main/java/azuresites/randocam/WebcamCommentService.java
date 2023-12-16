package azuresites.randocam;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebcamCommentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(WebcamComment comment) {
        String sql = "INSERT INTO webcams (id, title, comment) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, comment.getId(), comment.getTitle(), comment.getComment());
    }

    // Additional methods...
}