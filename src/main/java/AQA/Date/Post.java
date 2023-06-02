package AQA.Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

public class Post {
    private LocalDateTime postDT;  //Дата и время публикации
    private String msg;     //Текст поста
    private static int idCount;         //Общий счётчик постов
    private int id;         //id поста
    private String user;    //Имя пользователя, который создал пост

    public Post(String msg, String user) {
        //Генератор дат постов:
        Random r = new Random();
//        postDT = LocalDateTime.now().minusDays(r.nextInt(0, 3)).minusHours(r.nextInt(0, 2)).minusMinutes(r.nextInt(0, 100));

        //Тест изменения минут:
//        postDT = LocalDateTime.now().minusDays(0).minusHours(0).minusMinutes(idCount + 1);
        //Тест изменения часов:
//        postDT = LocalDateTime.now().minusDays(0).minusHours(idCount + 1).minusMinutes(0);
        //Тест изменения дней:
        postDT = LocalDateTime.now().minusDays(0).minusHours(0).minusMinutes(11);
        this.msg = msg;
        this.user = user;
        this.id = idCount++;
    }

    public LocalDateTime getPostDT() {
        return postDT;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Дата создания = " + postDT.format(DateTimeFormatter.ofPattern("dd-MM-yy/hh-mm-ss")) +
                ", Сообщение ='" + msg + '\'' +
                ", id=" + id +
                ", Пользователь='" + user + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(postDT, post.postDT) && Objects.equals(msg, post.msg) && Objects.equals(user, post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postDT, msg, id, user);
    }
}
