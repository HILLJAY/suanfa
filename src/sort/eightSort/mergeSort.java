package sort.eightSort;

import java.util.Arrays;
/**
 * 归并排序：
 */
public class mergeSort {

    public static void main(String[] args) {

        int[] arr ={1,5,2,8,3,6};
        int[] temp=new int[arr.length];

        mergeSort(arr,0,arr.length-1,temp);

        System.out.println(Arrays.toString(arr));

    }

    //合并方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){

        if(left<right){

            int mid=(left+right)/2;

            mergeSort(arr, left, mid, temp);

            mergeSort(arr, mid+1, right, temp);

            merge(arr,left,mid,right,temp);

        }

    }

    /**
     * 合并的方法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param right 中间索引
     * @param mid 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[]arr,int left,int mid,int right,int[] temp){

        int i=left;
        int j=mid+1;
        //temp[]索引
        int t=0;

        while(i<=mid&&j<=right){

            if(arr[i]<arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }

        }

        while(i<=mid){
            temp[t++]=arr[i++];
        }

        while(j<=right){
            temp[t++]=arr[j++];
        }

        for(int k=0;k<t;k++){
            arr[left++]=temp[k];
        }

    }
}
