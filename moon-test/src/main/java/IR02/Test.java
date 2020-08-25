package IR02;

/***
 * Excerpted from "Language Implementation Patterns",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book information.
 *
 * 模式10：异类树。主要解决了同型树添加一个属性，所以节点都必须有这个属性的缺点
***/
public class Test {
    public static void main(String[] args) {
        Token plus = new Token(Token.PLUS,"+");
        Token one = new Token(Token.INT,"1");
        Token two = new Token(Token.INT,"2");
        ExprNode root = new AddNode(new IntNode(one), plus, new IntNode(two));
        System.out.println(root.toStringTree());
    }
}
