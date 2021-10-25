package sort.eightSort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class heapSort {

    public static void main(String[] args) {

        int[] arr=new int[]{4,6,8,5,9};

        heapSort(arr);
    }

    public static void heapSort(int[] arr){

        for(int i=arr.length/2-1;i>=0;i--){

            adjustHeap(arr,i,arr.length);

        }

        for(int i=1;i<arr.length;i++){
            int temp=arr[0];
            arr[0]=arr[arr.length-i];
            arr[arr.length-i]=temp;
            adjustHeap(arr,0,arr.length-i);

        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr 传入的数组
     * @param i 最后一个叶子节点对应数组中的位置
     * @param length 有效数据的长度
     */
    public static void adjustHeap(int[] arr,int i,int length){

        int temp=arr[i];

        for(int k=2*i+1;k<length;k=2*i+1){

            if(k+1<length&&arr[k+1]>arr[k]){
                k++;
            }

            if(temp<arr[k]){

                arr[i]=arr[k];
                //换父节点，继续遍历
                i=k;
                arr[k]=temp;

            }else {
                break;
            }

        }

    }
}
