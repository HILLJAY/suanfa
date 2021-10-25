package DateStructure.recursion;

/**
 * 八皇后问题
 */
public class Queen {

    int max=8;

    //对于这个数组来说，角标代表行，数据代表列
    int[] arr=new int[max];

    int count=0;

    public static void main(String[] args) {

        Queen queen = new Queen();

        queen.check(0);

    }

    public boolean judge(int n){

        for(int i=0;i<n;i++){

            //arr[i]==arr[n]同列，(n-i)==Math.abs(arr[n]-arr[i])同对角线
            if(arr[i]==arr[n]||(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }

        }

        return true;

    }

    public void check(int n){

        if(n==max){
            print();
            return;
        }

        for(int i=0;i<max;i++){

            arr[n]=i;

            if(judge(n)){
                check(n+1);
            }

        }

    }

    public void print(){

        count++;

        for(int i=0;i<max;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(count);
    }

}
