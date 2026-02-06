import java.util.Objects;

public class AddPrefixTransformer implements Transformer<String, String> {

    private final String prefix;

    public AddPrefixTransformer(final String prefix) {
        this.prefix = Objects.requireNonNullElse(prefix, "");
    }

    @Override
    public String transform(String input) {
        return prefix + input;
    }
}
