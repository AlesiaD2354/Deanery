package Zadanie3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StarSystem {
}

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
        System.out.print("Введите название планеты, которую вы хотите добавить: ");
        String planetName = scanner.nextLine();
        addPlanet(planetName);
        count(addedPlanets.size());
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

class Moon extends StarSystem {
}

class Main {
    public static void main(String[] args) {
        Star star = new Star();
        star.name("Солнце");
        Planet planet = new Planet();
        planet.count(8);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить планету в систему");
            System.out.println("2. Показать добавленные планеты");
            System.out.println("0. Выход");

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
        } while (choice != 0);
    }
}
