package org.example;


import org.example.model.Category;
import org.example.model.Film;
import org.example.model.Platform;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //----------------------------Sample data entered-----------------------------------------------------------

        List<Category> categories = new ArrayList<>();
        List<Platform> platforms = new ArrayList<>();
        List<Film> films = new ArrayList<>();
        List<String> sessions = new ArrayList<>();

        Category category1 = new Category();
        category1.setCategoryName("Comedy");
        Category category2 = new Category();
        category2.setCategoryName("Action");
        Category category3 = new Category();
        category3.setCategoryName("Science-Fiction");

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        Platform platform1 = new Platform();
        platform1.setPlatformName("Netflix");
        Platform platform2 = new Platform();
        platform2.setPlatformName("Disney");
        Platform platform3 = new Platform();
        platform3.setPlatformName("Exxen");

        platforms.add(platform1);
        platforms.add(platform2);
        platforms.add(platform3);

        sessions.add("09:00");
        sessions.add("12:00");
        sessions.add("15:00");

        List<Category> categoriesToAdd = new ArrayList<>();
        categoriesToAdd.add(category2);
        categoriesToAdd.add(category3);

        Film film1 = new Film();
        film1.setFilmName("Inception");
        film1.setDirector("Christopher Nolan");
        film1.setYear(2010);
        film1.setImdb(8.8);
        film1.setDuration("2 saat 28 dk");
        film1.setSessions(sessions);
        film1.setPlatforms(platforms);
        film1.setCategories(categoriesToAdd);
        films.add(film1);


        for (Category categoryFilmCount : categories) {
            int filmCount = 0;
            for (Film filmToCheck : films) {
                if (filmToCheck.getCategories().contains(categoryFilmCount)) {
                    filmCount++;
                }
            }
            categoryFilmCount.setFilmCount(filmCount);
        }

        //----------------------------Sample data entry completed--------------------------------------------------

    }
}