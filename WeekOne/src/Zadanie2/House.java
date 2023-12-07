package Zadanie2;

class House {
    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int numberOfRooms;
    private String street;
    private String buildingType;
    private int yearsOfUsage;

    public House(int id, int apartmentNumber, double area, int floor, int numberOfRooms, String street, String buildingType, int yearsOfUsage) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
        this.buildingType = buildingType;
        this.yearsOfUsage = yearsOfUsage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getYearsOfUsage() {
        return yearsOfUsage;
    }

    public void setYearsOfUsage(int yearsOfUsage) {
        this.yearsOfUsage = yearsOfUsage;
    }

    public String toString() {
        return "House{" +
                "id=" + id +
                ", apartmentNumber=" + apartmentNumber +
                ", area=" + area +
                ", floor=" + floor +
                ", numberOfRooms=" + numberOfRooms +
                ", street='" + street + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", yearsOfUsage=" + yearsOfUsage +
                '}';
    }
}

class HouseList {
    private House[] houses;

    public HouseList(int size) {
        houses = new House[size];
    }

    public void addHouse(int index, House house) {
        houses[index] = house;
    }

    public void filterByNumberOfRooms(int rooms) {
        System.out.println("Список квартир с " + rooms + " комнат(ой):");
        for (House house : houses) {
            if (house != null && house.getNumberOfRooms() == rooms) {
                System.out.println(house);
            }
        }
    }

    public void filterByRoomsAndFloor(int rooms, int minFloor, int maxFloor) {
        System.out.println("Список квартир с " + rooms + " комнат(ой) на этаже от " + minFloor + " до " + maxFloor + ":");
        for (House house : houses) {
            if (house != null && house.getNumberOfRooms() == rooms && house.getFloor() >= minFloor && house.getFloor() <= maxFloor) {
                System.out.println(house);
            }
        }
    }

    public void filterByArea(double minArea) {
        System.out.println("Список квартир с площадью больше " + minArea + ":");
        for (House house : houses) {
            if (house != null && house.getArea() > minArea) {
                System.out.println(house);
            }
        }
    }
}

 class Main {
    public static void main(String[] args) {
        HouseList houseList = new HouseList(5);

        houseList.addHouse(0, new House(1, 101, 80.0, 2, 3, "Улица 1", "Панельный", 5));
        houseList.addHouse(1, new House(2, 202, 100.0, 5, 4, "Улица 2", "Кирпичный", 10));
        houseList.addHouse(2, new House(3, 303, 120.0, 8, 3, "Улица 3", "Монолитный", 7));
        houseList.addHouse(3, new House(4, 404, 90.0, 4, 2, "Улица 4", "Панельный", 3));
        houseList.addHouse(4, new House(5, 505, 150.0, 10, 5, "Улица 5", "Кирпичный", 12));

        houseList.filterByNumberOfRooms(3);
        houseList.filterByRoomsAndFloor(4, 2, 6);
        houseList.filterByArea(100.0);
    }
}
