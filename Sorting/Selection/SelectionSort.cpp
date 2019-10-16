#include<iostream>

using namespace std;

void selectionSort(int arr[], int length) {
    int minIndex, temp;

    for(int i=0; i<length; i++) {
        minIndex= i;

        for(int j=i+1;j<length;j++) {
            if(arr[j] < arr[minIndex])
                minIndex = j;
        }

        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}

int main() {
    int arr[] = {-3,6,-5,2,16,1};
    int length = 6;

    selectionSort(arr, length);

    for(int i=0;i<length;i++)
        cout << arr[i] << " ";

    return 0;
}