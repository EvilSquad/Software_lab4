import java.util.ArrayList;
import java.util.List;

/**
 * Клас, який відповідає за речення. Розбиває отримане
 * на вхід речення по розділовим знакам на елементи
 * класу "Word". Саме цей клас відповідає за видалення
 * слів заданої довжини.
 */
class Sentence {
    private final List<Object> components; // Слова та розділові знаки

    // Конструктор. Виконуємо розбиття речення на "компоненти" - екземпляр класу "Word"
    public Sentence(String sentence) {
        components = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();

        // В циклі перебирається весь текст по літерах і
        // на основі того, чи є символ літерою чи цифрою
        // ми записуємо його в буфер, і коли наступним
        // символом є знак чи пробіл - утворюємо екземпляр
        // класу "Word"
        for (char c : sentence.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                buffer.append(c);
            } else {
                if (buffer.length() > 0) {
                    components.add(new Word(buffer.toString()));
                    buffer.setLength(0);
                }
                components.add(c); // Додаємо розділовий знак
            }
        }

        if (buffer.length() > 0) {
            components.add(new Word(buffer.toString()));
        }
    }

    // Перевизначення toString для "зборки" та виведення слова
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object component : components) {
            result.append(component);
        }
        return result.toString();
    }

    // Метод, який відповідає за видалення слів заданої довжини,
    // що починаються з приголосної
    public Sentence removeWords(int wordLength) {
        List<Object> filteredComponents = new ArrayList<>();

        // Цикл, в якому прибираємо слова заданої довжини
        for (Object component : components) {
            if (component instanceof Word) {
                Word word = (Word) component;
                if (word.length() != wordLength || !word.startsWithConsonant()) {
                    filteredComponents.add(word);
                }
            } else {
                filteredComponents.add(component); // Додаємо розділові знаки
            }
        }

        // Створюємо рядок з "очищенними" елементами
        StringBuilder cleanedSentence = new StringBuilder();
        for (Object component : filteredComponents) {
            if (component instanceof Word) {
                if (cleanedSentence.length() > 0 &&
                        cleanedSentence.charAt(cleanedSentence.length() - 1) != ' ') {
                    cleanedSentence.append(' '); // Додаю пробіл перед словом
                }
                cleanedSentence.append(component);
            } else if (component instanceof Character) {
                if (cleanedSentence.length() > 0 &&
                        cleanedSentence.charAt(cleanedSentence.length() - 1) == ' ') {
                    cleanedSentence.deleteCharAt(cleanedSentence.length() - 1); // Видаляємо пробіли перед знаками
                }
                cleanedSentence.append(component);
            }
        }

        // Це необхідно для того, щоб не було пробілів на початку і в кінці речення.
        String resultString = cleanedSentence.toString().trim();

        // В результаті створюється нове речення без пробілів і слів заданої довжини
        return new Sentence(resultString);
    }
}
