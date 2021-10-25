package algorithm;

public class HanoiTower {

    public static void main(String[] args) {

        hanoiTower(2,'A','B','C');

    }

    public static void hanoiTower(int num,char a,char b,char c){

        if(num==1){

            System.out.println("第1个盘由 "+a+"==>" +c);
        }else {
            //将最后一个盘之前的盘加入到b中
            hanoiTower(num-1, a, c, b);
            //将最后一个盘加入到c中
            System.out.println("第"+num+"个盘由 "+a+"==>"+c);
            //将b中的盘移到c中
            hanoiTower(num-1, b, a, c);
        }

    }
}
