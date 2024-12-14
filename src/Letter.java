/**
 * Клас, який відповідає за літеру. Відповідно
 * тут реалізована перевірка на те, чи
 * є літера приголосною.
 */
class Letter {
    private final char value;

    // Конструктор
    public Letter(char value) {
        this.value = value;
    }

    // Геттер
    public char getValue() {
        return value;
    }

    // Перевірка на приголосну.
    // Для зручності ще в другій лабі реалізував це
    // через голосні (їх в списку менше виходить)
    public boolean isConsonant() {
        String vowels = "aeiouAEIOUаеєиіїоуюяАЕЄИІЇОУЮЯ";
        return Character.isLetter(value) && vowels.indexOf(value) == -1;
    }
}