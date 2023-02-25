package boccarusso;

import static java.time.LocalDate.now;
import static java.time.format.DateTimeFormatter.ofPattern;

public class Functions {
  public static String sanitize(String s) {
    return s
        .toLowerCase()
        .replaceAll(" ", "-")
        .replaceAll("&", "and")
        .replaceAll("\\+", "plus");

  }

  public static String getCurrentDate() {
    return now().format(ofPattern("dd MMM yyyy"));
  }
}
