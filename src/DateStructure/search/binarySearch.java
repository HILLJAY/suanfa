package DateStructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找：数组必须是有序的
 */
public class binarySearch {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,55,55,79,128,243};

//        int result = binarySearchIm(arr, 0, arr.length - 1, 2);
//
//        System.out.println("result:"+result);

        List<Integer> integers = binarySearchIm2(arr, 0, arr.length - 1, 55);

        System.out.println(integers);
    }

    public static int binarySearchIm(int[] arr,int left,int right,int findVal){

        int mid=(left+right)/2;

        int midVal=arr[mid];

        if(left>right){
            return -1;
        }

        if(findVal<midVal){
            return binarySearchIm(arr, left, mid-1, findVal);
        }else if(findVal>midVal){
            return binarySearchIm(arr, mid+1, right, findVal);
        }else{
            return mid;
        }

    }

    /**
     * 扩展：当有相同数的时候，需返回相同数的所有索引位置
     */
    public static List<Integer> binarySearchIm2(int[] arr, int left, int right, int findVal){

        int mid=(left+right)/2;

        int midVal=arr[mid];

        if(left>right){
            return new ArrayList<>();
        }

        if(findVal<midVal){
            return binarySearchIm2(arr, left, mid-1, findVal);
        }else if(findVal>midVal){
            return binarySearchIm2(arr, mid+1, right, findVal);
        }else{
            //用一个集合去接收满足的结果并返回
            List<Integer> arrList=new ArrayList<>();
            //先从左边开始找相同值
            int temp=mid-1;
            while(true){

                if(temp<0||arr[temp]!=findVal){
                    break;
                }

                arrList.add(temp);
                temp--;
            }

            arrList.add(mid);

            temp=mid+1;
            while(true){

                if(temp>arr.length-1||arr[temp]!=findVal){
                    break;
                }

                arrList.add(temp);
                temp++;
            }

            return arrList;
        }

    }
}
