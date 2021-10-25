package DateStructure.binaryTree.threadedBinaryTree;

public class ThreadedBinaryTreeMain {

    public static void main(String[] args) {

        Hero root = new Hero("hillhay", 1);

        ThreadedBinaryTree binaryTree=new ThreadedBinaryTree();

        binaryTree.setRoot(root);

        Hero node1 = new Hero("json", 2);
        Hero node2 = new Hero("jack", 3);
        Hero node3 = new Hero("bill", 4);
        Hero node4 = new Hero("hill", 5);
        Hero node5 = new Hero("jay",6);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        binaryTree.infixThreadedNodes(root);//4,2,5,1,6,3

        //System.out.println(node5.getLeft());

        binaryTree.listInfixThreadedTree();

    }

}

class ThreadedBinaryTree{

    //根节点
    private Hero root;

    //当前节点
    private Hero pre;

    public void setRoot(Hero root) {
        this.root = root;
    }

    /**
     * 中序线索化二叉树
     * @param node
     */
    public void infixThreadedNodes(Hero node){

        if(node==null){
            return;
        }

        //先线索化左子树
        infixThreadedNodes(node.getLeft());

        //再线索化当前节点
        //先处理前驱节点
        if(node.getLeft()==null){

            node.setLeft(pre);
            node.setLeftType(1);
        }
        //后处理后继节点
        if(pre!=null&&pre.getRight()==null){

            pre.setRight(node);
            pre.setRightType(1);
        }

        //没处理一个节点，将当前节点赋值给pre
        pre=node;

        //最后线索化右子树
        infixThreadedNodes(node.getRight());
    }

    /**
     * 中序线索化二叉树的方法
     */
    public void listInfixThreadedTree(){

        Hero node=root;

        while (node!=null) {
            while(node.getLeftType()==0){

                    node=node.getLeft();
                }

            System.out.println(node);

            while(node.getRightType()==1){

                node=node.getRight();
                System.out.println(node);
            }

            node=node.getRight();
        }
    }

}

class Hero {

    private String name;
    private int no;
    private Hero left;
    private Hero right;

    //用于记录左指针状态：0为指向左子树，1为指向前驱节点
    private int leftType;

    //用于记录右指针状态：0为指向右子树，1为指向后继节点
    private int rightType;

    public Hero(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Hero getLeft() {
        return left;
    }

    public void setLeft(Hero left) {
        this.left = left;
    }

    public Hero getRight() {
        return right;
    }

    public void setRight(Hero right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}