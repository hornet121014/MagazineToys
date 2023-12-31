import java.util.ArrayList;
import java.util.List;

public class Magazine {
    private List<Toy> toys;

    public Magazine() {
        this(new ArrayList<>());
    }

    public Magazine(List<Toy> toys) {
        this.toys = toys;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void add(Toy toy) {
        if (toys.isEmpty() || !idExist(toy)) {
            toys.add(toy);
        } else {
            System.err.println("Ошибка. Игрушка с id = " + toy.getId() + " уже существует. Введите другой id.");
        }
    }

    public boolean idExist(Toy toy) {
        for (Toy value : toys) {
            if (value.getId() == toy.getId()) {
                return true;
            }
        }
        return false;
    }

    public Toy getById(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public void getData() {
        System.out.printf("В магазине находится %d игрушек.%n", toys.size());
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %-4s | %-15s | %17s |%n", "id", "название", "частота выпадения");
        System.out.printf("----------------------------------------------%n");
        for (Toy toy : toys) {
            System.out.println(toy);
        }
        System.out.printf("----------------------------------------------%n%n");
    }
}
