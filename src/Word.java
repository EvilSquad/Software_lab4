import java.util.ArrayList;
import java.util.List;

/**
 * Клас, який відповідає за слово. Розбиває отримане
 * на вхід слово на елементи класу "Letter".
 * Відповідно тут реалізована перевірка на те,
 * чи починається слово з приголосної літери.
 */
class Word {
    private final List<Letter> letters;

    // Конструктор. Розбиває отримане слово на
    // елементи класу Letter (ну тобто літери)
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    // Отримання довжини
    public int length() {
        return letters.size();
    }

    // Отримання першої літери слова
    public char getFirstLetter() {
        return letters.get(0).getValue();
    }

    // Перевірка на те, чи починається слово з приголосної
    public boolean startsWithConsonant() {
        return !letters.isEmpty() && new Letter(getFirstLetter()).isConsonant();
    }

    // Перевизначення для "зборки" та виведення слів
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.getValue());
        }
        return result.toString();
    }
}