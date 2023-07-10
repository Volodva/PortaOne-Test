
public class Main {

    public static void main(String[] args) {
        String text = parseArgs(args);

        UniqueCharFinder textFilter = new UniqueCharFinder();
        String result = textFilter.findFirstUniqueCharInText(text).map(String::valueOf).orElse("No unique character was found!");
        System.out.println("Unique character: " + result);

    }

    private static String parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-text")) {
                return args[i + 1];
            }
        }

        throw new IllegalArgumentException("No text was provided. Please provide argument with -text");
    }

}