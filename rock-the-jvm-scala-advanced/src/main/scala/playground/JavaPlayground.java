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
                new MinutesSeconds(1,0),
                new MinutesSeconds(1,24),
                new MinutesSeconds(1,23),
                new MinutesSeconds(2,31),
                new MinutesSeconds(2,17),
                new MinutesSeconds(2,36),
                new MinutesSeconds(3,8),
                new MinutesSeconds(5,50),
                new MinutesSeconds(1,16)
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
