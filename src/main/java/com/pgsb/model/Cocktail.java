package com.pgsb.model;

public class Cocktail {
    private String name;
    private String ingredients;
    private String preparation;
    private String garnish;
    private String origin;
    private String bartender;
    private String company;
    private String glassware;

    public Cocktail() {
    }

    public Cocktail(String name, String ingredients, String preparation, String garnish, String glassware, String origin, String bartender, String company) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.garnish = garnish;
        this.origin = origin;
        this.bartender = bartender;
        this.company = company;
        this.glassware = glassware;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getGarnish() {
        return garnish;
    }

    public void setGarnish(String garnish) {
        this.garnish = garnish;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getBartender() {
        return bartender;
    }

    public void setBartender(String bartender) {
        this.bartender = bartender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getGlassware() {
        return glassware;
    }

    public void setGlassware(String glassware) {
        this.glassware = glassware;
    }
}
