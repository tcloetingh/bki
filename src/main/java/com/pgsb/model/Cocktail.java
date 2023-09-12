package com.pgsb.model;

public class Cocktail {
    private String name;
    private String ingredients;
    private String recipe;
    private String instructions;
    private String description;
    private String about;
    private String garnish;
    private String glassware;
    private String nutrition;
    private String img_url;
    private String diffords_url;


    public Cocktail() {
    }


    public Cocktail(String name, String ingredients, String recipe, String instructions, String description, String about, String garnish, String glassware, String nutrition, String img_url, String diffords_url) {
        this.name = name;
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.instructions = instructions;
        this.description = description;
        this.about = about;
        this.garnish = garnish;
        this.glassware = glassware;
        this.nutrition = nutrition;
        this.img_url = img_url;
        this.diffords_url = diffords_url;
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

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGarnish() {
        return garnish;
    }

    public void setGarnish(String garnish) {
        this.garnish = garnish;
    }

    public String getGlassware() {
        return glassware;
    }

    public void setGlassware(String glassware) {
        this.glassware = glassware;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDiffords_url() {
        return diffords_url;
    }

    public void setDiffords_url(String diffords_url) {
        this.diffords_url = diffords_url;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", recipe='" + recipe + '\'' +
                ", instructions='" + instructions + '\'' +
                ", description='" + description + '\'' +
                ", about='" + about + '\'' +
                ", garnish='" + garnish + '\'' +
                ", glassware='" + glassware + '\'' +
                ", nutrition='" + nutrition + '\'' +
                ", img_url='" + img_url + '\'' +
                ", diffords_url='" + diffords_url + '\'' +
                '}';
    }
}

