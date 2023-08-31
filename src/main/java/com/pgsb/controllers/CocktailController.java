package com.pgsb.controllers;

import com.pgsb.config.CustomHttpResponse;
import com.pgsb.model.Cocktail;
import com.pgsb.service.CocktailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CocktailController {
    Logger logger = LoggerFactory.getLogger(CocktailController.class);

    @Autowired
    private CocktailService cocktailService;

    public CocktailController() {

    }

    @GetMapping("/")
    public String getIndex() {
       return "hello World";
   }


   @GetMapping("/count")
   public String getCount(){
        int count = this.cocktailService.cocktailCount();
        logger.debug("Returning total cocktail count " + count);
        return Integer.toString(count);
   }

   @GetMapping("/cocktails")
    public List<Cocktail> getAllCocktails(){
        List<Cocktail> cocktailList = this.cocktailService.getCocktailList();
        System.out.println(cocktailList);
        return cocktailList;
   }

    @GetMapping("/cocktails/search")
    public List<Cocktail> searchCocktails(@RequestParam("searchTerm") String searchTerm){
        List<Cocktail> cocktailList = this.cocktailService.searchCocktails(searchTerm);
        System.out.println(cocktailList);
        return cocktailList;
    }

   @PostMapping("/new-cocktail")
    public ResponseEntity<CustomHttpResponse> insertNewCocktail(@RequestParam("name") String name,
                                                            @RequestParam("ingredients") String ingredients,
                                                            @RequestParam("preparation") String preparation,
                                                            @RequestParam("glassware") String glassware,
                                                            @RequestParam("garnish") String garnish,
                                                            @RequestParam("bartender") String bartender,
                                                            @RequestParam("origin") String origin,
                                                            @RequestParam("company") String company) {

        logger.debug("new cocktail entered: \n" +  " \n name " + name + "\n ingredients " + ingredients + "\n preparation "
                + preparation + "\n garnish " + garnish + "\n glassware " + glassware +  "\n origin "
                + origin + "\n bartender " + bartender + "\n company " + company);

        Cocktail cocktail = new Cocktail(name, ingredients, preparation, garnish, glassware, origin,  bartender, company);

        boolean success = this.cocktailService.insertNewCocktail(cocktail);

       if (!success) {
           System.out.println("insert failed");
           return responseHelper(HttpStatus.INTERNAL_SERVER_ERROR, "Everything is not ok");
       } else {
           System.out.println("successful insert of cocktail");
           return responseHelper(HttpStatus.OK, "Everything is gonna be ok");

       }

    }

    private ResponseEntity<CustomHttpResponse> responseHelper(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new CustomHttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                message), httpStatus);
    }
}
