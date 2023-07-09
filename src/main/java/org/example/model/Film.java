package org.example.model;

import java.util.List;

public class Film {
    private String filmName;
    private String director;
    private String duration;
    private double imdb;
    private int year;
    private List<String> sessions;
    private List<Category> categories;
    private List<Platform> platforms;

    public Film(){

    }

    public Film(String filmName, String director, String duration, double imdb, int year, List<String> sessions, List<Category> categories, List<Platform> platforms) {
        this.filmName = filmName;
        this.director = director;
        this.duration = duration;
        this.imdb = imdb;
        this.year = year;
        this.sessions = sessions;
        this.categories = categories;
        this.platforms = platforms;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getSessions() {
        return sessions;
    }

    public void setSessions(List<String> sessions) {
        this.sessions = sessions;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", director='" + director + '\'' +
                ", duration='" + duration + '\'' +
                ", imdb=" + imdb +
                ", year=" + year +
                ", sessions=" + sessions +
                ", categories=" + categories +
                ", platforms=" + platforms +
                '}';
    }
}