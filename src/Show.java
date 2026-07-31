import java.util.ArrayList;
import java.util.Objects;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    // Добавление актера с проверкой на дубликат
    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актёр " + actor + " уже есть в спектакле '" + title + "'");
        } else {
            listOfActors.add(actor);
        }
    }

    // Замена актера по фамилии
    public void replaceActor(Actor newActor, String surname) {
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor currentActor = listOfActors.get(i);
            if (currentActor.getSurname().equals(surname)) {
                listOfActors.set(i, newActor);
                System.out.println("Актёр " + currentActor + " заменён на " + newActor);
                return;
            }
        }
        System.out.println("(!) Актёр с фамилией '" + surname + "' не найден в спектакле '" + title + "'");
    }

    // Вывод списка актеров
    public void printActors() {
        System.out.println("Актёры в спектакле '" + title + "':");
        if (listOfActors.isEmpty()) {
            System.out.println("Список актёров пуст");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println("- " + actor);
            }
        }
        System.out.println();
    }

    // Переопределение toString для вывода информации о спектакле
    @Override
    public String toString() {
        return "Спектакль '" + title + "', режиссёр: " + director;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Show show = (Show) obj;
        return duration == show.duration &&
                Objects.equals(title, show.title) &&
                Objects.equals(director, show.director) &&
                Objects.equals(listOfActors, show.listOfActors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration, director, listOfActors);
    }
}