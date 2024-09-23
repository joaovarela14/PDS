
public class Main {

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.err.println("Input some args! Check them below!\n");
            usage();
            System.exit(0);
        }

        DirectoryVisitor visitor = new DirectoryVisitor();

        if (args.length == 1) {
            visitor.calculateDirectorySize(args[0], false);
        } else if (args.length == 2) {
            if (args[0].equals("-r")) {
                visitor.calculateDirectorySize(args[1], true);
            } else {
                usage();
            }
        } else {
            usage();
        }
    }

    private static void usage() {
        System.out.println("Usage:\n\tjava Main [-option] path\n\tOption:\n\t\t-r: Include the size of the directories inside");
    }
}
