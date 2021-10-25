package DateStructure.binaryTree.avlBinaryTree;

public class AvlBinaryTreeDemo {


    public static void main(String[] args) {

        int[] arr=new int[]{4,3,6,5,7,8};
        AvlBinaryTree avlBinaryTree=new AvlBinaryTree();
        for(int i=0;i< arr.length;i++){

            avlBinaryTree.addNode(new Node(arr[i]));
        }

        avlBinaryTree.infixOrdered();

        System.out.println(avlBinaryTree.rightHeight());
        System.out.println(avlBinaryTree.leftHeight());
        System.out.println(avlBinaryTree.height());
    }

}

class AvlBinaryTree{

    private Node root;

    public int height(){

        if (root==null) {
            return 0;
        }else {

            return root.height();
        }
    }

    public int rightHeight(){

        if(root!=null&&root.right!=null){

            return root.rightHeight();
        }else {
            return 0;
        }
    }

    public int leftHeight(){

        if(root!=null&&root.left!=null){

            return root.leftHeight();
        }else {

            return 0;
        }
    }

    public void addNode(Node node){

        if(root==null){
            root=node;
        }

        root.addNode(node);
    }

    public void infixOrdered(){

        if(root==null){
            return;
        }

        root.infixOrdered();

    }

    public Node search(int val){

        if(root==null)
            return null;

        return root.searchNode(val);
    }

    public Node searchParent(int val){

        if(root==null)
            return null;

        return root.searchParent(val);
    }

    /**
     * 返回的以node为根节点的二叉排序树的最小节点的值
     * 删除node为根节点的二叉排序树的最小节点
     * @param node
     * @return
     */
    public int delRightTreeNode(Node node){

        Node target=node;
        while(target.left!=null){
            target=target.left;
        }

        delNode(target.val);
        return target.val;
    }

    public void delNode(int val){

        if(root==null){
            return;
        }
        Node targetNode = search(val);
        if(targetNode==null){
            return;
        }else {

            if(root.left==null&&root.right==null){
                return;
            }

            Node parentNode = searchParent(val);
            //第一种情况，删除叶子节点
            if(targetNode.left==null&&targetNode.right==null){

                if(parentNode.left!=null&&parentNode.left.val== targetNode.val){
                    parentNode.left=null;
                }else if(parentNode.right!=null&&parentNode.right.val== targetNode.val){
                    parentNode.right=null;
                }

                //2.删除有两个节点的子树
            }else if(targetNode.left!=null&&targetNode.right!=null){

                int minVal = delRightTreeNode(targetNode.right);
                targetNode.val=minVal;

            }else {
                //3.删除有一个节点的子数
                if(parentNode.left.val==targetNode.val){
                    if(targetNode.left!=null){
                        parentNode.left=targetNode.left;
                    }else {
                        parentNode.left=targetNode.right;
                    }
                }else {
                    if(targetNode.left!=null){
                        parentNode.right=targetNode.left;
                    }else {
                        parentNode.right=targetNode.right;
                    }
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }

}

class Node{

    int val;
    Node left;
    Node right;

    public  Node(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public void leftRotate(){

        Node newNode=new Node(val);
        newNode.left=left;
        newNode.right=right.left;
        val=right.val;
        right=right.right;
        left=newNode;
    }

    public void rightRotate(){

        Node newNode=new Node(val);
        newNode.right=right;
        newNode.left=left.right;
        val=left.val;
        left=left.left;
        right=newNode;
    }

    public int leftHeight(){

        if(left!=null){

            return left.height();
        }else {
            return 0;
        }

    }

    public int rightHeight(){

        if(right!=null){

            return right.height();
        }else {
            return 0;
        }

    }

    public int height(){

        return Math.max(left==null?0: left.height(), right==null?0: right.height())+1;

    }

    /**
     * 查找需要删除的节点位置
     * @param val
     * @return
     */
    public Node searchNode(int val){

        if(this.val==val){
            return this;
        }else if(val<this.val){

            if(this.left==null){
                return null;
            }
            return this.left.searchNode(val);
        }else {

            if(this.right==null){
                return null;
            }
            return this.right.searchNode(val);
        }
    }

    /**
     * 找父节点
     * @param val
     * @return
     */
    public Node searchParent(int val){

        if(this.left!=null&&this.left.val==val||this.right!=null&&this.right.val==val){
            return this;
        }

        if(val<this.val){
            return this.left.searchParent(val);
        }else if(val>this.val){
            return this.right.searchParent(val);
        }else {
            return null;
        }
    }

    public void addNode(Node node){

        if(node==null)
            return;

        if(node.val<this.val){

            if(this.left==null){
                this.left=node;
            }else {
                this.left.addNode(node);
            }
        }else {

            if(node.val>this.val){

                if(this.right==null){
                    this.right=node;
                }else {
                    this.right.addNode(node);
                }
            }
        }
        //左旋转
        if(leftHeight()-rightHeight()>0){
            //如果左子节点的右子树高度大于左子树的高度，则先对右子树进行左旋转再右旋
            if(left!=null&&left.rightHeight()>left.leftHeight()){

                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }

            //必须要return,平衡后则不需要往下继续判断
            return;
        //右旋转
        }else if(rightHeight()-leftHeight()>0){

            //如果右子节点的左子树的高度大于右子树的高度，则先对右子树进行右旋转再左旋转
            if(right!=null&&right.leftHeight()>right.rightHeight()){

                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
        }

    }

    public void infixOrdered(){

        if(this.left!=null){
            this.left.infixOrdered();
        }

        System.out.println(this);

        if(this.right!=null){
            this.right.infixOrdered();
        }
    }
}
