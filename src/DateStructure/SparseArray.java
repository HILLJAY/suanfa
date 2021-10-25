package DateStructure;

import java.io.*;

public class SparseArray {

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[11][11];

        arr[3][4] = 1;
        arr[5][8] = 1;

        int count=0;
        for (int[] i : arr) {
            for (int j : i) {
                if(j!=0){
                    count++;
                }
                System.out.print(j + "\t");
            }
            System.out.println();
        }

        System.out.println("创建稀疏数组并给稀疏数组赋值");

        int[][] sparseArray=new int[count+1][3];

        sparseArray[0][0]=arr.length;
        sparseArray[0][1]=arr[0].length;
        sparseArray[0][2]=count;

        int cou=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    cou++;
                    sparseArray[cou][0]=i;
                    sparseArray[cou][1]=j;
                    sparseArray[cou][2]=arr[i][j];
                }
            }
        }

        for(int[] i:sparseArray){
            for(int j:i){
                System.out.print(j+"\t");
            }
            System.out.println();
        }

        //将生成的稀疏数组存入到磁盘中
        File file=new File("E:\\data\\");

        FileWriter writer=new FileWriter(file);

        for(int []i:sparseArray){
            for(int temp:i){
                writer.write(temp+"\t");
            }
            writer.write("\n");
        }
        writer.close();
        //将硬盘中的文件读取到控制台上
        BufferedReader reader=new BufferedReader(new FileReader(file));
        String len="";
        int row=0;
        int[][] readerArr=null;

        while((len=reader.readLine())!=null){
            String []temp=len.split("\t");
            int[] tempArr=new int[temp.length];

            for(int i=0;i<tempArr.length;i++){
                tempArr[i]=Integer.parseInt(temp[i]);
            }
            row++;

            if(row==1){
                readerArr=new int[tempArr[0]][tempArr[1]];
            }else{
                readerArr[tempArr[0]][tempArr[1]]=tempArr[2];
            }
        }
        for (int[] i : readerArr) {
            for (int j : i) {
                if(j!=0){
                }
                System.out.print(j + "\t");
            }
            System.out.println();
        }
        reader.close();

    }
}
