package AQA.Date;

import java.time.Duration;
import java.time.LocalDateTime;

public class HoursStrategy implements HumanReadableTimestampStrategy{
    @Override
    public String getTimestamp(LocalDateTime eventTimestamp) {
        Duration d = Duration.between(eventTimestamp, LocalDateTime.now());
        long l = d.toHours();
        String str = "";
        switch ((int) l) {
            case 1, 21 -> str = l + " час";
            case 2, 3, 4, 22, 23 -> str = l + " часа";
            default -> str = l + " часов";
        }
        return "Опубликовано " + str + " назад";
    }
}
