import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

		public static String getNowDate() {
			LocalDateTime date = LocalDateTime.now();
			String regDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			return regDate;
		}
}
