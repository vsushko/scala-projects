package playground;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author vsushko
 */
public class JavaPlayground {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        MinutesSeconds[] minutesSeconds = new MinutesSeconds[]{
                new MinutesSeconds(5,26),
                new MinutesSeconds(4,8),
                new MinutesSeconds(2,10),
                new MinutesSeconds(6,35),
                new MinutesSeconds(9,33),
                new MinutesSeconds(6,5),
                new MinutesSeconds(4,8),
                new MinutesSeconds(9,10),
                new MinutesSeconds(2,38)

        };

        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime lt = LocalTime.parse("00:00");
        for (MinutesSeconds ms : minutesSeconds) {
            lt = lt.plusMinutes(ms.minutes);
            lt = lt.plusSeconds(ms.seconds);
        }

        System.out.println(df.format(lt));
    }

    static class MinutesSeconds {
        int minutes;
        int seconds;

        MinutesSeconds(int minutes, int seconds) {
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public int getMinutes() {
            return minutes;
        }

        public int getSeconds() {
            return seconds;
        }
    }
}
