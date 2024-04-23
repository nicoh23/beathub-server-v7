package nocountry.beathub.util;

public class WordsConverter implements IWordsConverter{
    @Override
    public String capitalizeWords(String phrase) {

        if (phrase == null) {
            return "";
        }
        String[] words = phrase.toLowerCase().split(" ");
        var result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                String converted = word.substring(0, 1).toUpperCase() + word.substring(1);
                result.append(converted).append(" ");
            }
        }
        return result.toString().trim();
    }
}
