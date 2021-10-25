package algorithm;

public class BinarySearchNoRecur {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6};
        System.out.println(binarySearch(arr, 1));

        System.out.println(binarySearch2(arr, 0, arr.length - 1, 1));

    }

    public static Integer binarySearch(int[] arr,int target){

        int left=0;
        int right=arr.length-1;

        while(left!=right){

            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target<arr[mid]){

                right=mid-1;
            }else {

                left=mid+1;
            }

        }

        return -1;
    }

    public static int binarySearch2(int[] arr,int left,int right,int target){

        int mid=(left+right)/2;

        if(arr[mid]==target){

            return mid;
        }else if(target<arr[mid]){

            return binarySearch2(arr, left, mid-1, target);
        }else {

            return binarySearch2(arr, mid+1, right, target);
        }

    }

}
