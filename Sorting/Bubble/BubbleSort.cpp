#include<iostream>

using namespace std;

void bubbleSort(int arr[], int length) {
    int temp;

    for(int i=0; i<length-1; i++) {
        for(int j=0; j<length-1-i; j++) {
            if(arr[j+1] < arr[j]) {
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

int main() {
    int arr[] = {-3,6,-5,2,16,1};
    int length = 6;

    bubbleSort(arr, length);

    for(int i=0;i<length;i++)
        cout << arr[i] << " ";

    return 0;
}