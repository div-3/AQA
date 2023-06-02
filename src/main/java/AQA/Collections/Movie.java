package AQA.Collections;

public class Movie {
    private String name;
    private int rate;
    private String genre;
    private String country;
    private boolean isOscar;

    public Movie(String name, int rate, String genre, String country, boolean isOscar) {
        this.name = name;
        this.rate = rate;
        this.genre = genre;
        this.country = country;
        this.isOscar = isOscar;
    }

    @Override
    public String toString() {
        return  "Название = '" + name + '\'' +
                ", рейтинг = " + rate +
                ", жанр = '" + genre + '\'' +
                ", страна = '" + country + '\'' +
                (isOscar ? ", оскар есть!" : ", оскара нет") +
                '}';
    }
}
