package praktikum;

public class BinarySearchProblem {
    public static void main(String[] args) {
        int[] arrayAsc = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};

        int[] arrayDesc = {32, 30, 24, 22, 20, 13, 12,  8,  5,  2, 1};

        System.out.println("Индекс искомого элемента: " + searchBinaryAscending(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinaryDescending(arrayDesc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayDesc, 30));
    }

    private static int searchBinary(int[] array, int elem) {
        int sort = getSortRecursive(array, 0, 0);
        if(sort > 0){
            return  searchBinaryAscending(array, elem);
        } else if (sort < 0){
            return searchBinaryDescending(array, elem);
        } else {
            return -1;
        }
    }

    private static int getSortRecursive(int[] array, int sort, int next) {
        if(array.length - 1 == next)  return sort;

        if(array[next] < array[next+1]){
            if(sort==-1) return 0;
            return getSortRecursive(array, 1, next+1);
        } else {
            if(sort==1) return 0;
            return getSortRecursive(array, -1, next+1);
        }
    }

    private static int searchBinaryAscending(int[] array, int elem) {
        return searchBinaryRecursive(array, elem, 0, array.length - 1);
    }

    private static int searchBinaryRecursive(int[] array, int elem, int low, int high) {
        if(high <= low) return -1;

        int mid = low + ((high - low) / 2);

        if(array[mid] == elem){
            return mid;
        } else if(elem < array[mid]) {
            return searchBinaryRecursive(array, elem, low, mid);
        } else {
            return searchBinaryRecursive(array, elem, mid+1, high);
        }
    }

    private static int searchBinaryDescending(int[] array, int elem) {
        return searchBinaryRecursiveDescending(array, elem, 0, array.length - 1);
    }

    private static int searchBinaryRecursiveDescending(int[] array, int elem, int low, int high) {
        if(high <= low) return -1;

        int mid = low + ((high - low) / 2);

        if(array[mid] == elem){
            return mid;
        } else if(elem < array[mid]) {
            return searchBinaryRecursiveDescending(array, elem, mid+1, high);
        } else {
            return searchBinaryRecursiveDescending(array, elem, low, mid);
        }
    }
}