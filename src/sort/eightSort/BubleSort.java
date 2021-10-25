package sort.eightSort;

/**
 * 冒泡排序
 */
public class BubleSort {

    public static void main(String[] args) {

        int[] arr=new int[]{4,6,8,1,5};
        int temp;

        for(int i=0;i< arr.length-1;i++){
            for(int j=0;j< arr.length-1-i;j++){

                if(arr[j]>arr[j+1]){

                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}