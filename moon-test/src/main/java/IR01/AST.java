package IR01; /***
 * Excerpted from "Language Implementation Patterns",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book information.
 ***/

import java.util.*;

public class AST {      // Homogeneous AST node type
    //节点来自于哪个词法单元
    Token token;        // From which token did we create node?
    List<AST> children; // normalized list of children

    public AST() {
        ;
    } // for making nil-rooted nodes

    public AST(Token token) {
        this.token = token;
    }

    /**
     * Create node from token type; used mainly for imaginary tokens
     */
    public AST(int tokenType) {
        this.token = new Token(tokenType);
    }

    /**
     * External visitors execute the same action for all nodes
     * with same node type while walking01.
     */
    public int getNodeType() {
        return token.type;
    }

    public void addChild(AST t) {
        if (children == null) {
            children = new ArrayList<AST>();
        }
        children.add(t);
    }

    public boolean isNil() {
        return token == null;
    }

    /**
     * Compute string for single node
     */
    @Override
    public String toString() {
        return token != null ? token.toString() : "nil";
    }

    /**
     * Compute string for a whole tree not just a node
     */
    public String toStringTree() {
        if (children == null || children.size() == 0) {
            return this.toString();
        }
        StringBuilder buf = new StringBuilder();
        if (!isNil()) {
            buf.append("(");
            buf.append(this.toString());
            buf.append(' ');
        }
        for (int i = 0; i < children.size(); i++) {
            AST t = (AST) children.get(i); // normalized (unnamed) children
            if (i > 0) {
                buf.append(' ');
            }
            buf.append(t.toStringTree());
        }
        if (!isNil()) {
            buf.append(")");
        }
        return buf.toString();
    }
}
