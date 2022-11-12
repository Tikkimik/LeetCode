package praktikum;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

class Dog implements Comparable<Dog>{

    private final String nickname;

    public Dog(String nickname){
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public int compareTo(Dog o) {
        return this.nickname.toLowerCase().compareTo(o.nickname.toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(nickname, dog.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    /* Вам предстоит реализовать метод compareTo и, возможно, equals —
    подумайте, какая между ними связь. */
}

public class DogFinder {

    public static void main(String[] args) {
        List<Dog> unsortedDogs = Stream.of(
                        "Дружок", "Пушок", "Тузик", "Ромео",
                        "Белка", "Стрелка", "Бобик", "Афоня",
                        "Волчок")
                .map(Dog::new)
                .collect(Collectors.toList());

        // найдите Белку
        Dog dog = new Dog("Бобик");
        String result = search(unsortedDogs, dog)
                .map(d -> "А вот и собака по кличке " + d + " нашлась")
                .orElseGet(() -> "Нет собаки по кличке " + dog + " :(");

        System.out.println(result);
    }

    private static <T extends Comparable<T>> Optional<T> search(List<T> unsortedList, T searchObject) {
        List<T> sortedList = unsortedList.stream().sorted(Comparable::compareTo).collect(Collectors.toList());
        // искать легче по упорядоченному списку — вам поможет алгоритм сортировки
     //   System.out.println("Ищем: " + searchObject + " в списке" + sortedList);
        return Optional.ofNullable(sortedList.get(searchBinaryRecursive(sortedList, searchObject, 0, sortedList.size() - 1)));
    }

    private static <T extends Comparable<T>> int searchBinaryRecursive(List<T> sortedList, T searchObject, int low, int high) {
        if(high <= low) {
            return -1;
        }

        int mid = low  + ((high - low) / 2);

        if (sortedList.get(mid).equals(searchObject)) { // центральный элемент — искомый
            return mid;
        } else if(searchObject.compareTo(sortedList.get(mid)) < 0){ // искомый элемент меньше центрального — значит, следует искать в левой половине
            return searchBinaryRecursive(sortedList, searchObject, low, mid);
        } else { // иначе следует искать в правой половине
            return searchBinaryRecursive(sortedList, searchObject, mid + 1, high);
        }
    }
}
