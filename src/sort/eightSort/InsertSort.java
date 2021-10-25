package sort.eightSort;
/**
 * 插入排序：
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr=new int[]{4,2,7,8,3,1};
        int temp;

        for(int i=1;i< arr.length;i++){
            for(int j=i;j>0;j--){

                if(arr[j-1]>arr[j]){
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;

                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
