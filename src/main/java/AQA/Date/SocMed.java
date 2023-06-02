package AQA.Date;

public class SocMed {

    public static void main(String[] args) {

        //Создание ленты постов
        News news = new News();

        //Заполнение ленты постов
        for (int i = 0; i < 30; i++) {
            news.doPost(new Post("NVIDIA представляет ИИ-модель \"ACE\"", "div-3"));
        }

        //Вывод ленты постов
        for (Post p : news.getPosts()) {
            System.out.println(news.getPostToString(p));
        }
    }
}
