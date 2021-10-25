package sort.eightSort;

import java.util.Arrays;

/**
 * 快速排序：
 */
public class quickSort {

    public static void main(String[] args) {

        int [] arr={-58,-79,36,35,79};

        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int left,int right){

        if(left>right)return;
        //以中间的为基准点
        int i=left,j=right;
        int key=arr[i];
        int temp=0;//用来交换的点。
        while (i!=j){
            //当队尾元素大于基准数据时候，向前挪动j指针
            while (j>i&&arr[j]>=key){
                j--;
            }
            //当队首元素小于temp时候，向前挪动。
            while (j>i&&arr[i]<=key){
                i++;
            }
            if(j>i){
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        //最后确定位置
        arr[left]=arr[j];
        arr[j]=key;
        quickSort(arr,left,j-1);
        quickSort(arr,j+1,right);

    }

}
