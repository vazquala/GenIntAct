import java.util.Objects;

public class IntToStringTransformer implements Transformer<Integer, String> {


    @Override
    public String transform(Integer input) {
        return String.valueOf(Objects.requireNonNullElse(input, 0));
    }
}
