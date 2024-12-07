package ex1;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MasinaMapper implements RowMapper<Masina> {
    @Override
    public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Masina(rs.getString("numar_matricol"),rs.getString("marca"),rs.getInt("an_fabricatie"),
                rs.getString("culoare"),rs.getInt("nr_kilometrii"));
    }
}
