package CodeStudio;

public class MinToMaxHeap {
    public static int[] MinToMaxHeap(int n, int[] arr){
        // Write your code here
        // int n=arr.length;
        for(int i=(n/2)-1;i>=0;i--){
            downHeapify(arr, i, n);
        }
        return arr;
    }

    public static void downHeapify(int[] arr, int s, int e){
        int pi=s;
        int lci=(2*pi) +1;
        int rci=(2*pi)+2;
        while(lci<arr.length){
            int maxIndex=pi;
            if(arr[lci]>arr[pi]){
                maxIndex=lci;
            }
            if(rci<arr.length && arr[rci]>arr[maxIndex]){
                maxIndex=rci;
            }
            if(maxIndex==pi) break;
            int temp=arr[pi];
            arr[pi]=arr[maxIndex];
            arr[maxIndex]=temp;
            pi=maxIndex;
            lci=(2*pi)+1;
            rci=(2*pi)+2;
        }
    }
}
