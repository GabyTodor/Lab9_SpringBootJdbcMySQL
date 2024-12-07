package ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public class MasinaJdbcDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Masina m) {
        String sql="insert into masini values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,m.getNr_inmatriculare(),m.getMarca(),m.getAn_fabricatie(),
                m.getCuloare(),m.getNr_km());
    }

    public int deletebyNr_inmatriculare(String nr_inmatriculare) {
        String sql="delete from masini where numar_matricol=?";
        return jdbcTemplate.update(sql,nr_inmatriculare);
    }

    public Masina findbyNr_inmatriculare(String nr_inmatriculare) {
        String sql="select * from masini where numar_matricol=?";
        return jdbcTemplate.queryForObject(sql,new MasinaMapper(),nr_inmatriculare);
    }

    public List<Masina> findAll() {
        String sql = "select * from masini";
        return jdbcTemplate.query(sql,new MasinaMapper());
    }

    public int nr_masini_marca(String marca) {
        String sql="select count(*) from masini where marca=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,marca);
    }

    public int nr_masini_sub_100k(){
        String sql="select count(*) from masini where nr_kilometrii<100000";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public List<Masina> masini_noi(int an_curent) {
        String sql="select * from masini where an_fabricatie>=?";
        return jdbcTemplate.query(sql,new MasinaMapper(),an_curent-5);
    }
}
