package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {-3,6,-5,2,16,1};

        insertionSort(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+ " ");
    }

    static void insertionSort(int arr[]) {
        int current;

        for(int i=1;i<arr.length;i++) {
            current = arr[i];
            int j = i-1;

            while(j>=0) {
                if(arr[j] < current)
                    break;
                arr[j+1] = arr[j]; //right shifting to insert
                j--;
            }

            arr[j+1] = current;
        }
    }
}
