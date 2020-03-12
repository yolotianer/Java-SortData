package 栈和队列;

import java.util.*;

/**
 * @author yolo
 * @date 2020/3/12-21:33
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class 括号匹配 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
    public static boolean isValid(String s) {
        Set<Character>set=new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');

        Map<Character,Character>map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character>stack=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(set.contains(c)){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                } else if (stack.pop().equals(map.get(c))){
                    continue;
                }else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
