package Zad4;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();

        storage.addToStorage("mati","mati");
        storage.addToStorage("pawi", "agu");
        storage.addToStorage("mati", "agu");
        storage.printValues("mati");
        storage.findValues("agu");
        storage.findValues("as");
    }
}
