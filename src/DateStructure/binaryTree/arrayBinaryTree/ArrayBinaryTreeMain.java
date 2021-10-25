package DateStructure.binaryTree.arrayBinaryTree;

public class ArrayBinaryTreeMain {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6,7};

        ArrayBinaryTree arrayBinaryTree=new ArrayBinaryTree(arr);

        arrayBinaryTree.preOrder(0);
    }

}

class ArrayBinaryTree{

    int[] arr;

    public ArrayBinaryTree(int[] arr){

        this.arr=arr;

    }

    public void preOrder(int index){

        if(arr==null||arr.length==0){

            System.out.println("This arr is empty");
        }


        System.out.println(arr[index]);

        //等同于left节点不为空则左遍历
        if((index*2+1)<arr.length){

            preOrder(index*2+1);
        }

        //等同于right节点不为空则右遍历
        if((index*2+2)<arr.length){

            preOrder(index*2+2);

        }

    }

}
