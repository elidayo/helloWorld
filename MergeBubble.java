import java.util.ArrayList;

public class MergeBubble {
    
    public static void mergeSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1) {
            return;
        }
        
        int middle = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(middle, arr.size()));
        
        mergeSort(left);
        mergeSort(right);
        
        merge(arr, left, right);
    }
    
    private static void merge(ArrayList<Integer> arr, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                arr.set(k, left.get(i));
                i++;
            } else {
                arr.set(k, right.get(j));
                j++;
            }
            k++;
        }
        
        while (i < left.size()) {
            arr.set(k, left.get(i));
            i++;
            k++;
        }
        
        while (j < right.size()) {
            arr.set(k, right.get(j));
            j++;
            k++;
        }
    }
    
    // BubbleSort
    public static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                // If no two elements were swapped in the inner loop, the array is already sorted.
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(64);
        arr.add(34);
        arr.add(25);
        arr.add(12);
        arr.add(22);
        arr.add(11);
        
        System.out.println("Original Array: " + arr);
        
        // MergeSort
        ArrayList<Integer> mergeSortedArr = new ArrayList<>(arr);
        mergeSort(mergeSortedArr);
        System.out.println("MergeSorted Array: " + mergeSortedArr);
        
        // BubbleSort
        ArrayList<Integer> bubbleSortedArr = new ArrayList<>(arr);
        bubbleSort(bubbleSortedArr);
        System.out.println("BubbleSorted Array: " + bubbleSortedArr);
    }
}
