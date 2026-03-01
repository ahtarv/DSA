import java.util.*;

class Solution{
    //function to merge two halves
    public void merge(int[] arr, int low, int mid, int high)
    {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        // merge both sorted parts
        while(left<= mid && right<= high)
        {
            if(arr[left] <= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(add[right++]);
        }
        //add remaining left elements
        while(left<= mid)
            temp.add(arr[left++]);
        //add remaining right elements
        while(right<= high)
            temp.add(arr[right++]);
        //copy back to the original array
        for(int i=low; i<=high; i++)
            arr[i] = temp.get(i-low);
    }

    //Recursive merge sort
    public void mergeSort(int arr[], int low, int high)
    {
        if(low>=high)
            return;
        //find mid index
        int mid = (low+high)/2;
        //sort left half
        mergeSort(arr, low, mid);
        //sort right half
        mergeSort(arr, mid+1, high);
        //merge both halves
        merge(arr, low, mid, high);
    }

    public class Main{
        public static void main(String[] args)
        {
            int[] arr = {5,2,8,4,1};
            Solution sol = new Solution();
            sol.mergeSort(arr, 0, arr.length - 1);
            for(int num : arr)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    
}