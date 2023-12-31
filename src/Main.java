
public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy(1,"конструктор", 20);
        Toy toy2 = new Toy(2,"робот", 20);
        Toy toy3 = new Toy(3,"кукла", 60);
//        Toy toy4 = new Toy(4,"пазл", 10);
//        Toy toy5 = new Toy(5,"инструмент", 5);

        Magazine magazine = new Magazine();
        magazine.add(toy1);
        magazine.add(toy2);
        magazine.add(toy3);
//        magazine.add(toy4);
//        magazine.add(toy5);

        magazine.getData();

        Lottery lottery = new Lottery(magazine.getToys());

        lottery.play(10);
    }
}