package com.pgsb.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CocktailRowMapper implements RowMapper<Cocktail> {

    @Override
    public Cocktail mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cocktail cocktail = new Cocktail();

        cocktail.setName(rs.getString("name"));
        cocktail.setIngredients(rs.getString("ingredients"));
        cocktail.setRecipe(rs.getString("recipe"));
        cocktail.setGarnish(rs.getString("garnish"));
        cocktail.setGlassware(rs.getString("glass"));
        cocktail.setAbout(rs.getString("about"));
        cocktail.setDescription(rs.getString("description"));
        cocktail.setDiffords_url(rs.getString("url"));
        cocktail.setImg_url(rs.getString("img"));
        cocktail.setNutrition(rs.getString("nutrition"));
        cocktail.setInstructions(rs.getString("instructions"));

        return cocktail;
    }
}
