package boccarusso;

public class Functions {
  public static String sanitize(String s) {
    return s
        .replaceAll(" ", "-")
        .replaceAll("&", "and");
  }
}
