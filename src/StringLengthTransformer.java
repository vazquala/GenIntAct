public class StringLengthTransformer implements Transformer<String, Integer> {

    @Override
    public Integer transform(String input) {
        if (input == null) {
            return 0;
        } else {
            return input.length();
        }
    }
}
