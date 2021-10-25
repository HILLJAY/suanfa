package DateStructure.binaryTree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffManTree {

    public static void main(String[] args) {

        int[] arr=new int[]{2,1,6,4,7};

        Node root = createHuffManTree(arr);

        preOrdered(root);
    }

    public static void preOrdered(Node root){

        if(root!=null){
            root.PreOrdered();
        }else {
            throw new NullPointerException("树为空");
        }

    }

    //创建哈夫曼树
    public static Node createHuffManTree(int[] arr){

        //1.把数组中的数赋值为一个Node节点
        //2.将其放入一个List中并排序
        List<Node> list=new ArrayList();
        for(int value:arr){

            list.add(new Node(value));
        }

        while (list.size()!=1) {
            Collections.sort(list);

            //3.获取权最小的两个节点，构建新的二叉树
            Node left = list.get(0);
            Node right = list.get(1);
            Node root=new Node(left.value+ right.value);
            root.left=left;
            root.right=right;

            //4.搭建完了之后需要删除集合中的最小两个节点，并将新创建的root节点加入到集合中继续比较
            list.remove(left);
            list.remove(right);
            list.add(root);
        }

        return list.get(0);
    }

}

class Node implements Comparable<Node>{

    int value;
    Node left;
    Node right;

    public Node(int value){

        this.value=value;
    }

    public void PreOrdered(){

        System.out.println(this);

        if(this.left!=null){
            this.left.PreOrdered();
        }

        if(this.right!=null){
            this.right.PreOrdered();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {

        return this.value-o.value;
    }
}
