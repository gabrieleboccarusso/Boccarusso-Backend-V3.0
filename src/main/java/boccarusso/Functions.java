package boccarusso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Functions {
  public static String sanitize(String s) {
    return s
        .replaceAll(" ", "-")
        .replaceAll("&", "and");
  }

  public static String getCurrentDate() {
    return LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
  }
}
