package AQA.Collections;

import java.util.List;

public class Company {
    private String name;
    private int year;
    private List<Movie> movies;

    public Company(String name, int year, List<Movie> movies) {
        this.name = name;
        this.year = year;
        this.movies = movies.stream().toList();
    }

    @Override
    public String toString() {
        return  "Название '" + name + '\'' +
                ", год основания " + year +
                ", фильмы: " + movies.toString();
    }
}
