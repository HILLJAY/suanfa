package DateStructure.search;

/**
 * 插值查找算法:算法也要求数组是有序的,只会查找一次，非常高效，通过改变mid值的方式int mid=left+(right-left)*(findVla-arr[left])/(arr[right]-arr[left]);
 */
public class InsertSearch {

    public static void main(String[] args) {

        int[] arr=new int[100];

        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }

        int result = insertSearch(arr, 0, arr.length - 1, 99);

        System.out.println(result);

    }

    public static int insertSearch(int[] arr,int left,int right,int findVla){

        //findVla<arr[0]||findVla>arr[arr.length-1]这个条件是必须的，要不然可能会造成溢出
        if(left>right||findVla<arr[0]||findVla>arr[arr.length-1]){

            return -1;
        }

        int mid=left+(right-left)*(findVla-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];

        if(findVla>midVal){
            return insertSearch(arr, mid+1, right, findVla);
        }else if(findVla<midVal){
            return insertSearch(arr, left, mid+1, findVla);
        }else {
            return mid;
        }
    }

}
