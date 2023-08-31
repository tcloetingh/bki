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
        cocktail.setPreparation(rs.getString("preparation"));
        cocktail.setGarnish(rs.getString("garnish"));
        cocktail.setGlassware(rs.getString("glassware"));
        cocktail.setBartender(rs.getString("bartender"));
        cocktail.setCompany(rs.getString("company"));
        cocktail.setOrigin(rs.getString("origin"));

        return cocktail;
    }
}
