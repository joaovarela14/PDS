import java.text.Normalizer;

public class NormalizationFilter extends Decorator {
    public NormalizationFilter(ReaderInt reader) {
        super(reader);
    }

    @Override
    public String next() {
        return Normalizer.normalize(super.next(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("\\p{Punct}", "");
    }
}
