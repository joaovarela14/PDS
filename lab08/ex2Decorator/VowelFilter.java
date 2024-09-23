public class VowelFilter extends Decorator {

  public VowelFilter(ReaderInt reader) {
      super(reader);
  }

  @Override
  public String next() {
      return super.next().replaceAll("[aeiouAEIOU]", "");
  }
}
