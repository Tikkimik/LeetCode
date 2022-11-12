package praktikum;

public class SearchBinaryRecursive {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};
        System.out.println("Индекс искомого элемента: " + searchBinary(array, 13));
    }

    private static int searchBinary(int[] array, int elem) {// изначально мы запускаем двоичный поиск на всей длине массива
        return searchBinaryRecursive(array, elem, 0, array.length - 1);
    }

    private static int searchBinaryRecursive(int[] array, int elem, int low, int high) {
        if(high <= low) { // промежуток пуст
            return -1;
        }
        // промежуток не пуст
        int mid = low  + ((high - low) / 2);
        if (array[mid] == elem) { // центральный элемент — искомый
            return mid;
        } else if(elem < array[mid]){ // искомый элемент меньше центрального — значит, следует искать в левой половине
            return searchBinaryRecursive(array, elem, low, mid);
        } else { // иначе следует искать в правой половине
            return searchBinaryRecursive(array, elem, mid + 1, high);
        }
    }
}
