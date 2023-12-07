package Zadanie6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StarSystem {}

class Planet extends StarSystem {
    private List<String> addedPlanets;

    public Planet() {
        addedPlanets = new ArrayList<>();
    }

    void namePlanet(String nPlanet) {
        System.out.println(nPlanet);
    }

    void count(int countPlanet) {
        System.out.println("Количество планет: " + countPlanet);
    }

    public void addPlanetFromConsole() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите название планеты, которую вы хотите добавить: ");
            String planetName = scanner.nextLine();
            addPlanet(planetName);
            count(addedPlanets.size());
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении планеты: " + e.getMessage());
        }
    }

    private void addPlanet(String newPlanet) {
        addedPlanets.add(newPlanet);
    }

    public void showAddedPlanets() {
        System.out.println("Добавленные планеты: " + addedPlanets);
    }
}

class Star extends StarSystem {
    void name(String nameStar) {
        System.out.println("Название звезды: " + nameStar);
    }
}

class Moon extends StarSystem {}

class Main {
    public static void main(String[] args) {
        int choice = -1; // Инициализация переменной choice
        try {
            Star star = new Star();
            star.name("Солнце");
            Planet planet = new Planet();
            planet.count(8);

            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Добавить планету в систему");
                System.out.println("2. Показать добавленные планеты");
                System.out.println("0. Выход");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            planet.addPlanetFromConsole();
                            break;
                        case 2:
                            planet.showAddedPlanets();
                            break;
                        case 0:
                            System.out.println("Выход из программы.");
                            break;
                        default:
                            System.out.println("Некорректный ввод. Повторите попытку.");
                            break;
                    }
                } else {
                    System.out.println("Ошибка: Некорректный ввод. Пожалуйста, введите число.");
                    scanner.next(); // Очищаем буфер сканера
                }

            } while (choice != 0);
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}