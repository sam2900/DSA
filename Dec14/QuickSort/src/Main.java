import java.util.Arrays;
//AB Rouf sir

public class Main {
    public static void quickSort(int[] arr, int l, int r){
        if(l==r) return;
        //means only 1 element is there so the array is already sorted
        if (l<=r){
            int pi=partition(arr,l,r);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,r);
        }
    }

    public static int partition(int[] arr, int l, int r){
        int pivot=arr[r];
        int i=l-1;
        for(int j=l;j<r;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[r];
        arr[r]=arr[i];
        arr[i]=temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
