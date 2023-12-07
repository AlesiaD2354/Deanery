package Zadanie4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Catalog {
    private Map<String, BookHistory> booksMap;

    public Catalog() {
        this.booksMap = new HashMap<>();
    }

    // Внутренний класс для хранения информации об истории выдач книги читателям
    class BookHistory {
        private List<String> history;

        public BookHistory() {
            this.history = new ArrayList<>();
        }

        public void addEntry(String fullName, String date) {
            String entry = "Книга: " + fullName + "\nДата: " + date + "\n";
            history.add(entry);
        }

        public void displayHistory() {
            if (!history.isEmpty()) {
                System.out.println("История книги:");
                for (String entry : history) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("История этой книги недоступна.");
            }
        }
    }

    public void addBook(String bookName) {
        booksMap.put(bookName, new BookHistory());
    }

    public BookHistory getBookHistory(String bookName) {
        return booksMap.get(bookName);
    }
}

class Main {
    public static void main(String[] args) {
        // Создание экземпляра класса Catalog
        Catalog catalog = new Catalog();

        // Добавление книг в каталог
        catalog.addBook("Убийство по алфавиту");
        catalog.addBook("Маленькие женщины");
        catalog.addBook("Эмоциональные триггеры");

        // Добавление записей в историю выдач книги читателям
        Catalog.BookHistory bookHistoryOne = catalog.getBookHistory("Убийство по алфавиту");
        bookHistoryOne.addEntry("Кутузова Алиса Максимовна", "2023-11-01");

        Catalog.BookHistory bookHistoryTwo = catalog.getBookHistory("Маленькие женщины");
        bookHistoryTwo.addEntry("Соболь Александр Витальевич", "2023-11-10");

        Catalog.BookHistory bookHistoryThree = catalog.getBookHistory("Эмоциональные триггеры");
        bookHistoryThree.addEntry("Дубицкая Алеся Александровна", "2023-11-15");

        // Вывод истории выдачи книги читателям
        bookHistoryOne.displayHistory();
        bookHistoryTwo.displayHistory();
        bookHistoryThree.displayHistory();
    }
}

