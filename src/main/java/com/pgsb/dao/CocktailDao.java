package com.pgsb.dao;

import com.pgsb.model.Cocktail;
import com.pgsb.model.CocktailRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CocktailDao {

    Logger logger = LoggerFactory.getLogger(CocktailDao.class);

    private final JdbcTemplate jdbc;


    public CocktailDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;

    }

    public int totalCocktailCount() {
        int result = 0;
        result = jdbc.queryForObject("SELECT COUNT(*) FROM cocktail.cocktails_main", Integer.class);
        return result;
    }

    public List<Cocktail> getAllCocktails() {
        String sql = "SELECT * " +
                     "FROM cocktail.cocktails_main " +
                     "ORDER BY RANDOM() " +
                     "LIMIT 100;";
        CocktailRowMapper cocktailsMapped = new CocktailRowMapper();
        List<Cocktail> cocktails = jdbc.query(sql, cocktailsMapped);
        logger.debug("100 cocktails");
        return cocktails;
    }

    public List<Cocktail> searchCocktail(String searchTerm) {
        String sql = "SELECT * FROM cocktail.cocktails_main WHERE fts_combined @@ phraseto_tsquery('english', lower(?));";
        logger.debug("searchTerm: " + searchTerm);
        CocktailRowMapper cocktailsMapped = new CocktailRowMapper();
        List<Cocktail> cocktails = jdbc.query(sql, new Object[] {searchTerm}, cocktailsMapped);

        return cocktails;
    }

    public void insertNewCocktail(Cocktail cocktail) throws SQLException {
        String sql = "INSERT INTO cocktail.cocktails_main " +
                     "(name, ingredients, instructions, recipe, garnish, glassware, description, about, url, img)" +
                     " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbc.update(sql, cocktail.getName(), cocktail.getIngredients(), cocktail.getRecipe(),
                         cocktail.getInstructions(), cocktail.getGarnish(),
                         cocktail.getGlassware(), cocktail.getDescription(),
                         cocktail.getDiffords_url(), cocktail.getImg_url()
        );
        logger.debug("inserted new");

    }
}
