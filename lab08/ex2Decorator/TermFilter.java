public class TermFilter extends Decorator {
    private String[] terms;
    private int index;

    // Construtor que recebe um objeto do tipo ReaderInterface
    public TermFilter(ReaderInt reader) {
        super(reader);
        this.terms = super.next().split(" ");
        this.index = 0;
    }

    // Métodos da interface ReaderInterface
    @Override
    // Verifica se ainda há palavras para serem lidas
    public boolean hasNext() {
        return this.index < this.terms.length;
    }

    @Override
    // Devolve a próxima palavra
    public String next() {
        String term = this.terms[this.index];
        this.index++;
        // Se já leu todas as palavras de uma linha, passa para a próxima
        if (this.index == this.terms.length) {
            if (super.hasNext()) {
                this.terms = super.next().split(" ");
                this.index = 0;
            }
        }
        return term;
    }
}