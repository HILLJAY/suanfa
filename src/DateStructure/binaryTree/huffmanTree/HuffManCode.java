package DateStructure.binaryTree.huffmanTree;

import java.io.*;
import java.util.*;

public class HuffManCode {

    public static void main(String[] args) {

        String str="i like like like java do you like a java";
        byte[] bytes = str.getBytes();
//        System.out.println(bytes.length);
//        //获取字符对应的节点集合
//        List nodes = getNodes(bytes);
//        DataNode root = createHuffManTree(nodes);
//        //遍历生成的哈夫曼树
//        preOrdered(root);
//
//        getCode(root,"",stringBuilder);
//        System.out.println("哈夫曼编码表"+codeMap);
//
//        //得到的就是赫夫曼编码的字节数组
//        byte[] huffmanCodeBytes = zip(bytes, codeMap);
//        System.out.println(Arrays.toString(huffmanCodeBytes));

        System.out.println(Arrays.toString(huffmanZip(bytes)));

    }

    /**
     * 压缩文件
     * @param strFile 源文件
     * @param dstFile 目标路径
     */
    public static void zipFile(String strFile,String dstFile){

        FileInputStream is=null;
        OutputStream os=null;
        ObjectOutputStream oss=null;
        try {
            is=new FileInputStream(strFile);
            //获取一个和文件相同大小的字节数组
            byte[] b=new byte[is.available()];
            //将文件读入到字节数组中
            is.read(b);
            //进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建一个文件输出流存放压缩文件
            os=new FileOutputStream(dstFile);
            //创建一个对象流封装关联文件输出流
            oss=new ObjectOutputStream(os);
            //将压缩完的字节码文件写入
            oss.write(huffmanBytes);
            //将哈夫曼编码也写入
            oss.write(huffmanCode.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
                oss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 将一个byte[] 转换为二进制字符串
     * @param flag
     * @param b
     * @return
     */
    public static String byteToBitString(boolean flag,byte b){

        int temp=b;
        if(flag){

            temp |=256;
        }

        String str=Integer.toBinaryString(temp);

        if(flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    /**
     * 整合哈夫曼编码
     * @param bytes
     * @return
     */
    public static byte[] huffmanZip(byte[] bytes){
        //创建节点
        List nodes = getNodes(bytes);
        //创建哈夫曼树
        DataNode root = createHuffManTree(nodes);
        //获取编码的字符串
        huffmanCode=getCode(root,"",stringBuilder);
        //返回哈夫曼编码
        byte[] huffmanCodeBytes = zip(bytes, codeMap);

        return huffmanCodeBytes;
    }

    /**
     *
     * @param bytes 字符串转换为的字节码
     * @param huffmanTreeCode 哈夫曼编码的map集合
     */
    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanTreeCode){

        StringBuilder stringBuilder=new StringBuilder();

        for(byte b:bytes){

            stringBuilder.append(huffmanTreeCode.get(b));
        }

        //哈夫曼编码字符串
        //System.out.println(stringBuilder.toString());

        int len;
        if(stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else {
            len=stringBuilder.length()/8+1;
        }

        int index=0;
        byte[] huffmanTreeCodeBytes=new byte[len];
        for(int i=0;i<stringBuilder.length();i=i+8){

            String byteStr;
            if(i+8>stringBuilder.length()){
                byteStr=stringBuilder.substring(i);
            }else {
                byteStr=stringBuilder.substring(i,i+8);
            }

            huffmanTreeCodeBytes[index]= (byte) Integer.parseInt(byteStr,2);
            index++;
        }

        return huffmanTreeCodeBytes;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrdered(DataNode root){

        if(root!=null){
            root.preOrdered();
        }else {
            throw new NullPointerException("树为空");
        }

    }

    //用来存每一个字符对应的编码
    static Map<Byte,String>codeMap=new HashMap<>();
    //用来拼接完整的编码
    static StringBuilder stringBuilder=new StringBuilder();
    static String huffmanCode="";

    /**
     *
     * @param node 传入的根节点
     * @param code 路径：左0右1
     * @param stringBuilder 拼接编码
     *
     */
    public static String getCode(DataNode node,String code,StringBuilder stringBuilder){

       StringBuilder stringBuilder2=new StringBuilder(stringBuilder);
       stringBuilder2.append(code);

        if (node != null) {
            if (node.date == null) {//非叶子节点,叶子节点的data域是存在值的
                //递归处理
                //向左递归
                getCode(node.left, "0", stringBuilder2);
                //向右递归
                getCode(node.right, "1", stringBuilder2);
            } else {
                //说明找到一个叶子节点
                //就表示找到某个叶子节点的最后
                codeMap.put(node.date, stringBuilder2.toString());
            }
        }

        return stringBuilder2.toString();
    }
    /**
     * 接受一个字节数组，放的是一个一个字符，返回List
     * @param bytes
     * @return
     */
    public static List<DataNode> getNodes(byte[] bytes) {
        //1. 创建一个arraylist
        ArrayList<DataNode> nodeCodes = new ArrayList<>();
        //2. 遍历byte中每个字符出现的次数,使用map来进行存储
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte by : bytes) {
            Integer count = map.get(by);
            if (count == null) {
                //说明map中没有这个字符，我们将其加入到map中
                map.put(by, 1);
            } else {
                //说明这个字符已经存在，我们让其进行总数加1
                map.put(by, ++count);
            }
        }

        //将把每一个键值对转换成一个node对象，并将其加入到nodes集合中
        //遍历map,这里是遍历map使用entrySet方法，我怎么这么笨？？？
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            //使用new关键字是没都去创建一个新的对象，值就不会被覆盖了
            nodeCodes.add(new DataNode(entry.getKey(), entry.getValue()));
        }
        return nodeCodes;
    }


    /**
     * 搭建赫夫曼树
     * @param list
     * @return
     */
    public static DataNode createHuffManTree(List<DataNode> list){

        while(list.size()>1){
            Collections.sort(list);

            DataNode leftNode = list.get(0);
            DataNode rightNode = list.get(1);
            DataNode parent=new DataNode(null, leftNode.weight+ rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;

            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
        }

        return list.get(0);
    }
}

class DataNode implements Comparable<DataNode>{
    //存放数据本身：'a'==97
    Byte date;
    //权值:表示字符出现的次数
    int weight;
    DataNode left;
    DataNode right;

    public DataNode(Byte date, int weight) {
        this.date = date;
        this.weight = weight;
    }

    @Override
    public int compareTo(DataNode o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "DataNode{" +
                "date=" + date +
                ", weight=" + weight +
                '}';
    }

    public void preOrdered(){

        System.out.println(this);

        if(this.left!=null){
            this.left.preOrdered();
        }

        if(this.right!=null){
            this.right.preOrdered();
        }

    }

}
