package DateStructure.search;

import java.util.Random;

public class RepeatSort {
    /**题目：在指定的数组中寻找重复的数字，假定当前数组中只有两个数字是相同的，并且不能借助其他容器*/
    /**思路：
     * 1、借助位运算可以实现
     * 2、使用 异或（^） 的特性，如果一个数字被异或2次，那么这个数字就会被抵消
     * 3、将数组中的数字全部使用异或运算两次，重复的数字必定会被异或3次，由此就可以得到重复的数据
     * 扩展：位运算效率是最高的，比其他方式更加效率
     * */
    public static void main(String[] args) {

        int[] array =  new int[11];

        /**初始化数组*/
        for (int i = 0; i < array.length-1; i++) {
            array[i] = i + 1;
        }

        /**生成随机数*/
        Random random = new Random();
        /**nextInt():方法的取值范围包含0-9（不包含10这个数字，左开右闭），此时我希望取值范围是1-10，所以+1*/
        int number = random.nextInt(10) + 1;

        /***将随机数随机插入到数组中的一个位置*/
        //1、获取以number为下标的元素的值
        int value = array[number];
        //2、将number为下标的元素的值替换为number
        array[number] = number;
        //3、将value调整到在数组最后的位置
        array[10]=value;

        /**插入随机数后的数据* */
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        /**寻找重复的数值
         * 思路：
         * 1、11个数字中，只包含1-10这几个数字，所以先使用getRepeat变量把从1-10这些数字全部异或运算一次
         * 2、然后在把数组array中的所有元素异或一次
         * 3、根据同一个数字被异或两次会抵消的特性，重复数字会被异或三次，由此可以获取到重复的数字
         * */
        //接受返回值
        int getRepeat = 0;
        //从1-10依次全部异或一次
        for (int i = 1; i <= array.length-1; i++) {
            getRepeat = getRepeat ^ i;
        }
        //根据异或特性，重复的数据会被异或三次，也就是说最后保留下来的只有重复的数据寻找到重复数据
        for (int i = 0; i < array.length; i++) {
            getRepeat = getRepeat ^ array[i];
        }
        System.out.println("重复的值为："+getRepeat);
    }
}
