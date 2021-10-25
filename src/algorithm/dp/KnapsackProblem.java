package algorithm.dp;

import java.util.Arrays;

public class KnapsackProblem {

    public static void main(String[] args) {

        int[] w={1,4,3};//物品的重量
        int[] val={1500,3000,2000};//物品的价值 这里的val[i]就是前面讲的v[i]
        int m=4;//背包的容量
        int n=val.length;//物品的个树

        //v[i][j]表示可以装入容量为j的背包的最大价值
        int[][] v=new int[n+1][m+1];

        //根据公式动态规划处理
        for(int i=1;i< v.length;i++){
            for(int j=1;j<v[0].length;j++){
                //公式
                if(w[i-1]>j){//程序是从1开始的，因此原来公式中w[i]修改成w[i-1]
                    v[i][j]=v[i-1][j];
                } else {
                    //因为我们的i开始的，因此公式需要调整
                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                }
            }
        }

        for(int[] arr:v){
            System.out.println(Arrays.toString(arr));
        }

    }
}


