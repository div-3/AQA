package AQA.Date;

import java.time.Duration;
import java.time.LocalDateTime;

public class DaysStrategy implements HumanReadableTimestampStrategy{
    @Override
    public String getTimestamp(LocalDateTime eventTimestamp) {
        Duration d = Duration.between(eventTimestamp, LocalDateTime.now());
        long l = d.toDays();
        String str = "";
        switch ((int) l % 10) {
            case 1 -> {
                if (l == 1) return "Опубликовано вчера";
                if ((int) l % 100 == 11) {
                    str = l + " дней";
                    break;
                }
                str = l + " день";
            }
            case 2, 3, 4 -> {
                if ((int) l % 100 > 10 && (int) l % 100 < 20) {
                    str = l + " дней";
                    break;
                }
                str = l + " дня";
            }
            default -> str = l + " дней";
        }
        return "Опубликовано " + str + " назад";
    }
}
