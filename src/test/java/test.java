import org.springframework.web.util.HtmlUtils;

public class test {
    public static void main(String[] args) {
        String name = HtmlUtils.htmlEscape("hello <html> world");
        System.out.println(name);
    }
}
