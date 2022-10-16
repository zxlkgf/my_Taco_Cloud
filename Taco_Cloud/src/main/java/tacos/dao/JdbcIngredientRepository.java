package tacos.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.mappers.IngredientRepository;
import tacos.pojo.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredient> findAll() {
        String sql="select * from Ingredient";
        return jdbcTemplate.query(sql,this::mapRowToIngredient);
    }

    @Override
    public Ingredient findById(String id) {
        String sql = "select id,name,type from Ingredient";
        return jdbcTemplate.queryForObject(sql,this::mapRowToIngredient,id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        String sql = "insert into Ingredient(id,name,type)values(?,?,?)";
        jdbcTemplate.update(sql,ingredient.getId(),ingredient.getName(),ingredient.getType());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getInt("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
}
