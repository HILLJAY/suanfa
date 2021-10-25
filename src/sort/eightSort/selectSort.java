package sort.eightSort;

import org.junit.Test;

public class selectSort {
    /**
     * 选择排序：
     */
    @Test
    public void test() {

        int[] arr=new int[]{5,6,2,1,4};

        int min;
        int temp;

        for (int i=0;i<arr.length-1;i++){

            min=i;

            for(int j=i;j<arr.length;j++){

                if(arr[j]<arr[min]) {
                    min = j;
                }

            }

            temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;

        }

        for(int i=0;i<arr.length;i++){

            System.out.print(arr[i]);
        }
    }
}
