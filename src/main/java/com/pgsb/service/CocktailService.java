package com.pgsb.service;

import com.pgsb.dao.CocktailDao;
import com.pgsb.model.Cocktail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CocktailService {
    Logger logger = LoggerFactory.getLogger(CocktailService.class);

    @Autowired
    private CocktailDao cocktailDao;

    public CocktailService() {
    }

    public int cocktailCount() {
        return this.cocktailDao.totalCocktailCount();
    }

    public List<Cocktail> getCocktailList() {
       return this.cocktailDao.getAllCocktails();
    }

    public List<Cocktail> searchCocktails(String searchTerm) {
        List<Cocktail> cts = new ArrayList<>();
        try {
            cts = this.cocktailDao.searchCocktail(searchTerm);
        } catch (Exception e) {
            logger.error("SQL error caught when searching: " + e);
        }
        return cts;
    }

    public boolean insertNewCocktail(Cocktail cocktail) {
        try {
            this.cocktailDao.insertNewCocktail(cocktail);
        } catch (SQLException e) {
            System.out.println("Bad insert " + e);
            return false;
        }
        return true;
    }
}
