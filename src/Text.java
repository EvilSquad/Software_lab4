import java.util.ArrayList;
import java.util.List;

/**
 * Клас, який відповідає за текст. Розбиває отриманий
 * текст на екземпляри класу "Sentence".
 * Відповідно проводить обробку речення, заміняючи
 * табуляцію та пробіли на одинарний пробіл.
 */
class Text {
    private final List<Sentence> sentences;

    // Конструктор. Оброблює речення, замінюючи табуляцію
    // та пробіли, які повторюються на одинарний пробіл.
    // Після цього ділимо текст на екземпляри
    // класу речення (по розділовим знакам).
    public Text(String text) {
        sentences = new ArrayList<>();
        text = text.replaceAll("[\t\s]+", " ").trim(); // Замінюємо послідовність пробілів і табуляцій одним пробілом
        String[] splitSentences = text.split("(?<=[.!?])\s*"); // Ділимо текст на речення по розділовим знакам

        for (String sentence : splitSentences) {
            sentences.add(new Sentence(sentence));
        }
    }

    // Викликає метод видалення слова заданої довжини із
    // Sentences та збирає отримані після обробки
    // речення в один суцільний текст.
    public Text removeWords(int wordLength) {
        List<Sentence> filteredSentences = new ArrayList<>();

        for (Sentence sentence : sentences) {
            filteredSentences.add(sentence.removeWords(wordLength));
        }

        Text result = new Text("");
        result.sentences.clear();
        result.sentences.addAll(filteredSentences);
        return result;
    }

    // Перевизначення для збірки та виведення
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence).append(" ");
        }
        return result.toString().trim();
    }
}