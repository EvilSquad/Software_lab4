import java.util.Scanner;

/**
 * Лабораторна робота №4 (модифікація Лабораторної роботи №2)
 *
 * Виконав: Овер'янов Богдан, ст. групи ІК-24, ФІОТ
 *
 * Варіант №11
 *
 * Модифікація полягає в тому, що для літер, слів, речень та тексту було створено
 * окремі класи, і відповідно операції по видаленню слова було реалізовано через
 * зв'язки цих класів між собою. Також було додано очищення тексту від табуляцій,
 * повторювальних пробілів.
 *
 * В другій роботі умовою було використання тільки StringBuffer, але в цій
 * лабі цієї умови я не дотримувався (можливо і не треба було, але краще зазначу).
 */

public class TextOperations {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in); // Ініціалізація сканеру для вводу з консолі
            String inputText; // Змінна для тексту, що отримаємо з консолі
            int wordLength; // Довжина слів, які будем видалять

            // Оскільки в завданні проситься "Всі змінні повинні бути
            // описані та значення їх задані у виконавчому методі.", то я
            // реалізував вибір, чи вводити дані вручну, чи використати задані.

            // Вибираємо тип даних (задати вручну чи використати заготовані)
            while (true) {
                System.out.println("Оберіть опцію:");
                System.out.println("1. Задати дані вручну");
                System.out.println("2. Використати заздалегідь заготовані дані");

                String choice = scanner.nextLine();

                // Якщо вибираємо задати дані вручну, перевіряємо
                // щоб введений текст не був порожнім
                if (choice.equals("1")) {
                    while (true) {
                        System.out.println("Введіть текст для обробки (україською або англійською):");
                        inputText = scanner.nextLine();
                        if (inputText.isEmpty()) {
                            System.out.println("Текст не може бути порожнім. Спробуйте ще раз.");
                        } else {
                            break;
                        }
                    }

                    // Отримуємо значення довжини для перевірки слів та
                    // перевіряємо, чи є число цілим додатнім значенням
                    while (true) {
                        System.out.println("Введіть довжину слова для видалення:");
                        String lengthInput = scanner.nextLine();
                        try {
                            wordLength = Integer.parseInt(lengthInput);
                            if (wordLength > 0) {
                                break;
                            } else {
                                System.out.println("Довжина слова повинна бути додатнім цілим числом. Спробуйте ще раз.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Будь ласка, введіть коректне додатнє ціле число.");
                        }
                    }
                    break;

                    // Якщо обрано використання заданих значень, то записуємо в змінні готовий текст
                } else if (choice.equals("2")) {
                    inputText = "Серед    безкінечних теплих зелених     обіймів    літнього дня, коли     сонце ніжно       " +
                            "торкається золотого поля, а     вітер тихо     нашіптує     секрети древніх дубів, природа сплітає своїм     " +
                            "чарівним      пензлем   мозаїку спокою і         гармонії, залишаючи     нам лише загадку, що            захована " +
                            "у кожному  шелестінні    листя та ніжності     пелюсток   квітів. Сонячне  сяйво ніжно зігріває моє обличчя.       " +
                            "Легкий морський бриз робив     день не таким       спекотним.";
                    wordLength = 5;
                    System.out.println("Використано заздалегідь задані дані: (довжина слова = " + wordLength + ", текст = " + inputText + "\n");
                    break;

                } else {
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
                }
            }

            // Створення екземпляра класу Текст і відповідно обробка тексту
            Text text = new Text(inputText);
            Text processedText = text.removeWords(wordLength);

            System.out.println("Оброблений текст:");
            System.out.println(processedText);

            // Запитуєм, чи користувач хоче повторити виконання, чи завершити програму
            while (true) {
                System.out.println("Бажаєте повторити програму? (так/ні):");
                String userChoice = scanner.nextLine().toLowerCase();
                if (userChoice.equals("ні")) {
                    scanner.close();
                    return;
                } else if (userChoice.equals("так")) {
                    break;
                } else {
                    System.out.println("Некоректний вибір. Введіть 'так' або 'ні'.");
                }
            }
        }
    }
}
