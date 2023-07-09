package org.example.model;

public class Category {
    private String categoryName;
    private int filmCount;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }
    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", filmCount=" + filmCount +
                '}';
    }
}
