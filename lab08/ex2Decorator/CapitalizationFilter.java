public class CapitalizationFilter extends Decorator {
    public CapitalizationFilter(ReaderInt reader) {
        super(reader);
    }

    @Override
    public String next() {
        String word = super.next();
        if (word.length() <= 2) {
            return word.toUpperCase();
        } else {
            String firstLetter = word.substring(0, 1).toUpperCase();
            String lastLetter = word.substring(word.length() - 1).toUpperCase();
            String middleLetters = word.substring(1, word.length() - 1);
            return firstLetter + middleLetters + lastLetter;
        }
    }
}
