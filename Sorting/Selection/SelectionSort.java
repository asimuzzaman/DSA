package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {-3,6,-5,2,16,1};

        selectionSort(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+ " ");
    }

    static void selectionSort(int arr[]) {
        int minIndex, temp;

        for(int i=0;i<arr.length;i++) {
            minIndex= i;

            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }

            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
