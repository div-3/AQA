package AQA.Date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class News {
    private List<Post> posts = new ArrayList<>();
    public void doPost(Post post) {
        posts.add(post);
    }
    public List<Post> getPosts() {
        return posts;
    }
    HumanReadableTimestampStrategy strategy;

    public String getPostToString(Post post) {
        return post.toString() + "\n" + getTimestamp(post);
    }

    //Определение врени публикации поста относительно даты вызова в виде "Опубликовано X Y назад",
    // где X - рассчитанный период, а Y – единица времени (минуты|часы|дни)
    //На основе "Стратегии"
    public String getTimestamp(Post post) {
        Duration d = Duration.between(post.getPostDT(), LocalDateTime.now());
        long l = 0;
        if (d.toMinutes() < 60) {
            strategy = new MinutesStrategy();
            return strategy.getTimestamp(post.getPostDT());
        }
        if ((l = d.toHours()) < 24 && l > 0) {
            strategy = new HoursStrategy();
            return strategy.getTimestamp(post.getPostDT());
        }
        if (d.toDays() > 0) {
            strategy = new DaysStrategy();
            return strategy.getTimestamp(post.getPostDT());
        }
        return "";
    }

    //    ОПТИМИЗИРОВАННЫЙ ВАРИАНТ
//    -------------------------------------------------------------
//    @Override
////    public String getTimestamp() {
//    public String getTimestamp(LocalDateTime eventTimestamp) {
//        Duration d = Duration.between(this.postDT, LocalDateTime.now());
//        long l = 0;
//        String str = "";
//        if ((l = d.toMinutes()) < 60) {
//            switch ((int) l) {
//                case 1, 21, 31, 41, 51 -> str = l + " минуту";
//                case 2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> str = l + " минуты";
//                default -> str = l + " минут";
//            }
//        } else if ((l = d.toHours()) < 24) {
//            switch ((int) l) {
//                case 1, 21 -> str = l + " час";
//                case 2, 3, 4, 22, 23 -> str = l + " часа";
//                default -> str = l + " часов";
//            }
//        } else {
//            switch ((int) (l = d.toDays()) % 10) {
//                case 1 -> {
//                    if (l == 1) return "Опубликовано вчера";
//                    if ((int) l % 100 == 11) {
//                        str = l + " дней";
//                        break;
//                    }
//                    str = l + " день";
//                }
//                case 2, 3, 4 -> {
//                    if ((int) l % 100 > 10 && (int) l % 100 < 20) {
//                        str = l + " дней";
//                        break;
//                    }
//                    str = l + " дня";
//                }
//                default -> str = l + " дней";
//            }
//        }
//        return "Опубликовано " + str + " назад";
//    }


//      НЕОПТИМИЗИРОВАННЫЙ ВАРИАНТ
//    ----------------------------------------------------------------------------
//    @Override
//    public String getTimestamp() {
//        Duration d = Duration.between(this.postDT, LocalDateTime.now());
//        if (d.toMinutes() < 60) {
//            switch ((int) d.toMinutes()) {
//                case 1, 21, 31, 41, 51 -> {return "Опубликовано " + d.toMinutes() + " минуту назад";}
//                case 2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> {return "Опубликовано " + d.toMinutes() + " минуты назад";}
//                default -> {return "Опубликовано " + d.toMinutes() + " минут назад";}
//            }
//        }else
//            if (d.toHours() < 24) {
//                switch ((int) d.toHours()) {
//                    case 1, 21 -> {return "Опубликовано " + d.toHours() + " час назад";}
//                    case 2, 3, 4, 22, 23 -> {return "Опубликовано " + d.toHours() + " часа назад";}
//                    default -> {return "Опубликовано " + d.toHours() + " часов назад";}
//                }
//            } else {
//                switch ((int) d.toDays()  % 10) {
//                    case 1 -> {
//                        if (d.toDays() == 1) return "Опубликовано вчера";
//                        if ((int)d.toDays() % 100 == 11) return "Опубликовано " +  d.toDays() +" дней назад";
//                        return "Опубликовано " + d.toDays() + " день назад";
//                    }
//                    case 2, 3, 4 -> {
//                        if ((int)d.toDays() % 100 > 10 && (int)d.toDays() % 100 < 20) return "Опубликовано " + d.toDays() + " дней назад";
//                        return "Опубликовано " +d.toDays() + " дня назад";}
//                    default -> {return "Опубликовано " +d.toDays() + " дней назад";}
//                }
//            }
//    }
}
