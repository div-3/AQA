package AQA.Date;

import java.time.LocalDateTime;

public interface HumanReadableTimestampStrategy {
    String getTimestamp(LocalDateTime eventTimestamp);
}
