package sort.eightSort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {

        int[] arr=new int[]{1,5,78,233,2};

        radixSort(arr);

    }

    public static void radixSort(int[] arr){

        int[][] buckets=new int[10][arr.length];

        int[] bucketAmount=new int[10];

        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        int maxLength=(max+"").length();

        //第一轮（针对每个元素的个位进行排序处理）
        for (int i=0,n=1;i<maxLength;i++,n*=10) {
            for(int j=0;j<arr.length;j++){

                int digitOfElement=arr[j]/n%10;

                buckets[digitOfElement][bucketAmount[digitOfElement]]=arr[j];
                bucketAmount[digitOfElement]++;
            }

            //按顺序放入原来的数组
            int index=0;

            for(int k=0;k<bucketAmount.length;k++){

                if(bucketAmount[k]!=0){

                    for(int l=0;l<bucketAmount[k];l++){

                        arr[index++]=buckets[k][l];
                    }
                }

                bucketAmount[k]=0;
            }

            System.out.println("第"+(i+1)+"轮，排序处理为："+ Arrays.toString(arr));
        }

    }

}
