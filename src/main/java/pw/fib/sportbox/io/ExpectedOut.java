package pw.fib.sportbox.io;

/**
 * @author ayratgdl
 * @date 26.03.16
 */
public class ExpectedOut extends StringOut {
    private StringBuilder expected = new StringBuilder();

    public String expected() {
        return expected.toString();
    }

    public String actual() {
        return toString();
    }

    public ExpectedOut append(String str) {
        expected.append(str);
        return this;
    }

    public ExpectedOut appendLn(String str) {
        expected.append(str).append("\n");
        return this;
    }
}
