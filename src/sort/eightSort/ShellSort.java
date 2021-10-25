package sort.eightSort;

import org.junit.Test;

/**
 * 希尔排序:
 */
public class ShellSort {

    /**
     * 交换法：
     */
    @Test
    public void shellSort(){

        int[] arr=new int[]{4,2,5,7,1,9,3,10};

//        int h=1;
//        while(h<=arr.length/3){
//            h=h*3+1;
//        }

        for(int gap=arr.length/2;gap>0;gap=gap/2){

            for(int i=gap;i<arr.length;i++){

                for(int j=i-gap;j>=0;j=j-gap){

                    if(arr[j]>arr[j+gap]){

                        int temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * 移动法：对交换式希尔排序进行一个改进
     */
    @Test
    public void test02(){

        int[] arr=new int[]{4,2,5,7,1,9,3,10};

        for(int gap=arr.length/2;gap>0;gap/=2){

            for(int i=gap;i<arr.length;i++){

                int j=i;
                int temp=arr[j];

                if(temp<arr[j-gap]){

                    while (j-gap>=0&&temp<arr[j-gap]) {
                        arr[j]=arr[j-gap];
                        j -=gap;
                    }
                }

                arr[j]=temp;

            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
