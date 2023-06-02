package AQA.Date;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinutesStrategy implements HumanReadableTimestampStrategy{
    @Override
    public String getTimestamp(LocalDateTime eventTimestamp) {
        Duration d = Duration.between(eventTimestamp, LocalDateTime.now());
        long l = d.toMinutes();
        String str = "";
        switch ((int) l) {
            case 1, 21, 31, 41, 51 -> str = l + " минуту";
            case 2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> str = l + " минуты";
            default -> str = l + " минут";
        }
        return "Опубликовано " + str + " назад";
    }
}
