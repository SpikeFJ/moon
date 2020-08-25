package org.fj;

import java.util.Stack;

/**
 * 中缀表达式-->后缀表达式
 *
 * @author spike
 */
public class InToPost {

    private Stack<Character> stack4Trans = new Stack<Character>();
    private StringBuilder transResult = new StringBuilder();

    /**
     * 转换
     *
     * @param data
     */
    public void transfer(String data) {
        for (int i = 0; i < data.length(); i++) {
            Character character = data.charAt(i);
            switch (character) {
                case '(':
                    stack4Trans.push(character);
                    break;
                case ')':
                    getParen();
                    break;
                case '+':
                case '-':
                case '*':
                case '/': {
                    if (stack4Trans.isEmpty()) {
                        stack4Trans.push(character);
                        break;
                    }


                }
                break;
                default:
                    break;
            }
        }
    }


    /**
     * 处理)，栈弹出直至遇到(
     */
    private void getParen() {
        while (!stack4Trans.isEmpty()) {
            Character top = stack4Trans.pop();
            if (top.equals("(")) {
                break;
            }
            transResult.append(top);
        }
    }
}
