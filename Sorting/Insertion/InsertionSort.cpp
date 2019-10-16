#include<iostream>

using namespace std;

void insertionSort(int arr[], int length) {
    int current;

    for(int i=1; i<length; i++) {
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

int main() {
    int arr[] = {-3,6,-5,2,16,1};
    int length = 6;

    insertionSort(arr, length);

    for(int i=0;i<length;i++)
        cout << arr[i] << " ";

    return 0;
}