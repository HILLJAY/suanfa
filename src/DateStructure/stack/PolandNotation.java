package DateStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        PolandNotation polandNotatio=new PolandNotation();

        String meg="34+(3+4)*5-6";

        List<String> list = polandNotatio.toList(meg);

        System.out.println(list);

        System.out.println(polandNotatio.toSufixExpressionList(list));

//        String str="3 4 + 5 * 6 -";
//        List<String> list = polandNotatio.getList(str);
//        System.out.println(polandNotatio.calculator(list));

    }

    public List<String> toList(String str){

        List<String> strList=new ArrayList();

        int i=0;
        char c;
        String tr;

        do{

           if((c=str.charAt(i))>=48&&(c=str.charAt(i))<=57){
               tr="";
               while(i<str.length()&&(c=str.charAt(i))>=48&&(c=str.charAt(i))<=57){
                   tr += c;
                   i++;
               }
               strList.add(tr);
           } else {
               strList.add(c+"");
               i++;
           }

        }while (i<str.length());

        return strList;
    }

    public List<String> getList(String str){

        String[] strs = str.split(" ");

        List<String> strList=new ArrayList<>();

        for(String ele:strs){

            strList.add(ele);
        }

        return strList;

    }

    public List<String> toSufixExpressionList(List<String> list){

        Stack<String> stack=new Stack();
        List<String> sufixList=new ArrayList<>();

        for(String item:list){

            if(item.matches("\\d+")){
                sufixList.add(item);
            }else if(item.equals("(")){
                stack.push(item);
            }else if(item.equals(")")){

                while(!(stack.peek().equals(")"))){

                    sufixList.add(stack.pop());
                }
                stack.pop();//弹出左括号

            }else {

                while(stack.size()!=0&&Operation.getValue(stack.peek())>=Operation.getValue(item)){
                    sufixList.add(stack.pop());
                }
                stack.push(item);
            }
        }

        /**
         * 将剩余栈中的元素加入到List中
         */
        while(stack.size()!=0){
            sufixList.add(stack.pop());
        }

        return sufixList;
    }

    /**
     * 针对后缀表达式的计算方法
     * @param stringList
     * @return
     */
    public int calculator(List<String> stringList){

        Stack<String> stack=new Stack();

        for(String ele:stringList){

            if(ele.matches("\\d+")){
                stack.push(ele);
            }else {
                int number1= Integer.parseInt(stack.pop());
                int number2=Integer.parseInt(stack.pop());
                int res=0;
                if(ele.equals("+")){
                    res=number1+number2;
                }else if(ele.equals("-")){
                    res=number2-number1;
                }else if(ele.equals("*")){
                    res=number1*number2;
                }else if(ele.equals("/")){
                    res=number2/number1;
                }else {
                    throw new RuntimeException("符号不匹配");
                }

                stack.push(String.valueOf(res));
            }

        }

        return Integer.parseInt(stack.pop());
    }

}

class Operation{

    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;

    public static int getValue(String operation){

        int result=0;

        switch (operation){

            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
        }

        return 0;

    }

}