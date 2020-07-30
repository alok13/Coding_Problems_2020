package Mar_7;

import java.util.Arrays;

public class FrequencyOfNumberinSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 4, 8, 8, 8, 15, 16, 23, 23, 42};
        int target = 8;
        int result = getFrequnecy(arr, target);
        int first = firstOccurence(arr, target);
        System.out.println(result);
        System.out.println(first);

        int [][] arr1={{1,1,},{2,2,},{3,3}};
        Arrays.sort(arr1,(o1,o2)->(o1[0]*o1[1])-o2[1]);
    }

    private static int firstOccurence(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>target){
                end=mid;
            }else if(arr[mid]<target){
                start=mid+1;
            }else{
                end--;
            }
        }
        return start;
    }

    private static int getFrequnecy(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end && arr[end]!=arr[start]) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                if (arr[start] < target)
                    start++;
                if (arr[end] > target)
                    end--;
            }
        }
        return end-start+1;

    }
}


