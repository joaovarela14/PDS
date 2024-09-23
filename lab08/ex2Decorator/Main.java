import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "Texto.txt";
        
        // Testar cada um dos filtros
        System.out.println("Original text:");
        ReaderInt reader = new TextReader(fileName);
        while (reader.hasNext()) {
            System.out.print(reader.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("TermFilter text:");
        reader = new TermFilter(new TextReader(fileName));
        while (reader.hasNext()) {
            System.out.print(reader.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("NormalizationFilter text:");
        reader = new NormalizationFilter(new TermFilter(new TextReader(fileName)));
        while (reader.hasNext()) {
            System.out.print(reader.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("VowelFilter text:");
        reader = new VowelFilter(new NormalizationFilter(new TermFilter(new TextReader(fileName))));
        while (reader.hasNext()) {
            System.out.print(reader.next() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("CapitalizationFilter text:");
        reader = new CapitalizationFilter(new VowelFilter(new NormalizationFilter(new TermFilter(new TextReader(fileName)))));
        while (reader.hasNext()) {
            System.out.print(reader.next() + " ");
        }
        System.out.println();
    }
}