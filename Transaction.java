import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateProvider {
    private static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    private static DateProvider instance = null;

    private DateProvider() {
    }

    public static DateProvider getInstance() {
        if (instance == null) {
            instance = new DateProvider();
        }
        return instance;
    }

    public Date now() {
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime = instant.atZone(DEFAULT_ZONE);
        return Date.from(zonedDateTime.toInstant());
    }
}
