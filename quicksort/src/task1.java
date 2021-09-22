import java.util.Scanner;


public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Array's length:");
        int n = sc.nextInt();

        System.out.println("Enter number's of array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Unsorted");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        quicksort(arr,0,arr.length-1);
        System.out.println("Sorted:");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    static void quicksort(int arr[], int from, int to) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);
            quicksort(arr, from, divideIndex - 1);
            quicksort(arr, divideIndex, to);

        }

    }
    static int partition(int arr[], int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from];
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }

        }
        return leftIndex;
    }
        static void swap(int arr[], int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

    }