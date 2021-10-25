package DateStructure.recursion;

/**
 * 递归解决迷宫问题
 */
public class Maze {

    public static void main(String[] args) {

        int[][] map=new int[8][7];

        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }

        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }

        map[2][1]=1;
        map[2][2]=1;

        setWay(map,1,1);

        for(int i=0;i<8;i++){
            for(int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     *
     * @param map 传入一个迷宫
     * @param i 传入一个起始位置的行
     * @param j 传入一个起始位置的列
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){

        if (map[6][5]==2) {
            return true;

        }else {
            if(map[i][j]==0){

                map[i][j]=2;
                if(setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else {
                    //代表这个位置走不通
                    map[i][j]=3;
                    return false;
                }

            }else {
                return false;
            }
        }

    }

}
