import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Lottery {
    private List<Toy> toys;

    public Lottery() {
        this(new ArrayList<>());
    }

    public Lottery(List<Toy> toys) {
        this.toys = toys;
    }

    public Double getSumFrequency() {
        double res = 0;
        for (Toy toy : toys) {
            res += toy.getFrequency();
        }
        return res;
    }

    public Toy setRandomToy() {
        Random r = ThreadLocalRandom.current();
        int range = (int) (getSumFrequency() * 100);
        double x = r.nextInt(range) / 100;
        double limit = 0;
        for (Toy toy : toys) {
            limit += toy.getFrequency();
            if (limit > x) return toy;
        }
        return null;
    }

    public void play(int gameCount) {
        System.out.println("Итоги розыгрыша:");
        for (int i = 1; i <= gameCount; i++) {
            Toy toy = setRandomToy();
            System.out.print(i + " ");
            System.out.println(toy);
            saveResultLottery(toy);
        }
    }

    public void saveResultLottery(Toy toy) {
        try (FileWriter writer = new FileWriter("src/result.txt", true)) {
            String f = "id = " + toy.getId() + ", name = " + toy.getName() + ", frequency = " + toy.getFrequency() + "\n";
            writer.write(f);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Ошибка записи файла. " +e.getMessage());
        }
        if (toys.equals(toy)) toys.remove(toy);
    }

}
