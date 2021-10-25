package DateStructure.search;

import java.util.Arrays;

/**
 * 斐波那契数列：黄金分割法
 */
public class FibonacciSearch {

    private static int maxSize=20;

    public static void main(String[] args) {

        int[] arr={1,8,10,89,1000,1234};

        System.out.println(fibonacciSearch(arr,89));

    }

    /**
     * 把数组弄成一个斐波那契数组
     * @return
     */
    public static int[] toFibonacci(){

        int[] f=new int[maxSize];

        f[0]=1;
        f[1]=1;

        for(int i=2;i< f.length;i++){
            //对应斐波那契数组的数值大小思想
            f[i]=f[i-1]+f[i-2];
        }

        return f;
    }

    public static int fibonacciSearch(int[] arr,int key){

        int low=0;
        int high=arr.length-1;
        int k=0;//表示斐波那契分割数值的下标
        int mid=0;//存放mid值
        int[] f=toFibonacci();

        //获取到斐波那契数列的下标
        while(high>f[k]-1){
            k++;
        }

        //f[k]的值可能大于a的长度，所以需要新的数组指向temp[]
        int[] temp = Arrays.copyOf(arr, f[k]);

        //填充多出去的0
        for(int i=high+1;i< temp.length;i++){
            temp[i]=arr[high];
        }

        while(low<=high){
            mid=low+f[k-1]-1;

            if(key<temp[mid]){
                high=mid-1;
                k--;
            }else if(key>temp[mid]){
                low=mid+1;
                k-=2;
            }else {

                if(mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

}
