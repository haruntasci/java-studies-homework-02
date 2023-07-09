package org.example;


import org.example.model.Category;
import org.example.model.Film;
import org.example.model.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //----------------------------Sample data entered-----------------------------------------------------------
        boolean flag = true;
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
        //Main programme

        while (flag) {
            Scanner input = new Scanner(System.in);
            System.out.println("Yapmak istediğiniz işlemi seçiniz");
            System.out.println("1 - Admin Girişi\n2 - Kullanıcı Girişi\n0 - Çıkış");
            int userType = input.nextInt();
            input.nextLine();
            switch (userType) {
                case 1:
                    System.out.println("1 - Kategori ekle\n2 - Platform ekle\n3 - Film ekle");
                    int addInput = input.nextInt();
                    input.nextLine();
                    switch (addInput) {

                        case 1:
                            System.out.println("Eklemek istediğiniz kategori ismini giriniz : ");
                            Category newCategory = new Category();
                            String categoryName = input.nextLine();
                            newCategory.setCategoryName(categoryName);
                            categories.add(newCategory);
                            System.out.println("Kategori ekleme işlemi başarılı !\n");
                            break;

                        case 2:
                            System.out.println("Eklemek istediğiniz platform ismini giriniz : ");
                            Platform newPlatform = new Platform();
                            String platformName = input.nextLine();
                            newPlatform.setPlatformName(platformName);
                            platforms.add(newPlatform);
                            System.out.println("Platform ekleme işlemi başarılı !\n");
                            break;

                        case 3:
                            System.out.println("Film adını giriniz : ");
                            String filmName = input.nextLine();

                            System.out.println("Filmin yönetmenini giriniz : ");
                            String directorName = input.nextLine();

                            System.out.println("Film süresini giriniz : ");
                            String duration = input.nextLine();

                            System.out.println("IMDB puanını giriniz : (8,7 gibi)");
                            double imdb = input.nextDouble();
                            input.nextLine();

                            System.out.println("Yayınlanma yılını giriniz : ");
                            int year = input.nextInt();
                            input.nextLine();

                            System.out.println("Günlük seans sayısını giriniz : ");
                            int sessionNumber = input.nextInt();
                            input.nextLine();


                            List<String> filmSessions = new ArrayList<>();
                            System.out.println("Seansları giriniz (09:00 gibi)");
                            for (int i = 0; i < sessionNumber; i++) {
                                System.out.println((i + 1) + ". seans : ");
                                String fSession = input.nextLine();
                                filmSessions.add(fSession);
                            }
                            List<Category> filmCategories = new ArrayList<>();

                            System.out.println("Filme kaç kategori eklemek istiyorsunuz ? (En fazla " + categories.size() + " tane)");
                            int categoryCount = input.nextInt();
                            input.nextLine();
                            System.out.println("Filmin kategorilerini seçiniz : ");
                            for (int i = 0; i < categories.size(); i++) {
                                System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
                            }
                            for (int j = 0; j < categoryCount; j++) {
                                System.out.println((j + 1) + ". kategori : ");
                                int categoryId = input.nextInt();
                                input.nextLine();
                                filmCategories.add(categories.get(categoryId - 1));
                            }

                            List<Platform> filmPlatforms = new ArrayList<>();
                            System.out.println("Filme kaç platform eklemek istiyorsunuz ? (En fazla " + platforms.size() + " tane)");
                            int platformCount = input.nextInt();
                            input.nextLine();
                            System.out.println("Filmin platformlarını seçiniz : ");
                            for (int i = 0; i < platforms.size(); i++) {
                                System.out.println((i + 1) + ". " + platforms.get(i).getPlatformName());
                            }
                            for (int j = 0; j < platformCount; j++) {

                                System.out.println((j + 1) + ". platform : ");
                                int platformId = input.nextInt();
                                input.nextLine();
                                filmPlatforms.add(platforms.get(platformId - 1));
                            }

                            Film film = new Film(filmName, directorName, duration, imdb, year, filmSessions, filmCategories, filmPlatforms);
                            films.add(film);

                            System.out.println("Film ekleme işlemi başarılı !\n");

                    }
                    break;
                case 2:

                    System.out.println("Kategori seçiniz");
                    for (int i = 0; i < categories.size(); i++) {
                        System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
                    }
                    int selectedCategoryIndex = input.nextInt();
                    Category selectedCategory = categories.get(selectedCategoryIndex - 1);
                    List<Film> filteredFilms = films.stream()
                            .filter(film -> film.getCategories().contains(selectedCategory))
                            .toList();
                    selectedCategory.setFilmCount(filteredFilms.size());
                    System.out.println("Kategori adı : " + selectedCategory.getCategoryName());
                    System.out.println("Bu kategoriye ait film sayısı : " + selectedCategory.getFilmCount());
                    System.out.println("Bu kategoriye ait filmler : ");
                    System.out.println("--------------------------------------------------------");
                    for (Film filmsToRead : filteredFilms) {
                        System.out.println("Film adı : " + filmsToRead.getFilmName() +
                                "\nYönetmen : " + filmsToRead.getDirector() +
                                "\nFilm süresi : " + filmsToRead.getDuration() +
                                "\nIMDB puanı : " + filmsToRead.getImdb() +
                                "\nYayınlanma Yılı : " + filmsToRead.getYear());
                        System.out.print("Seanslar : ");
                        filmsToRead.getSessions().forEach(session -> System.out.print(" " + session));
                        System.out.println();
                        System.out.print("Filmin Kategorileri : ");
                        filmsToRead.getCategories().forEach(category -> System.out.print(" " + category.getCategoryName()));
                        System.out.println();
                        System.out.print("Filmin Platformları : ");
                        filmsToRead.getPlatforms().forEach(platform -> System.out.print(" " + platform.getPlatformName()));
                        System.out.println();
                        System.out.println("--------------------------------------------------------");
                    }
                    break;

                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    flag = false;
                    input.close();
            }

        }
    }
}