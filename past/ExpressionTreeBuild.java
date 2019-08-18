/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    
    private int index;

    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        
        if(expression == null || expression.length == 0) {
            return null;
        }

        index = 0;

        return helper(expression);
    }

    // build a stack, 
    //   full of Element Node, "+", "-"
    private ExpressionTreeNode helper(String[] expressions) {
        
        Stack<ExpressionTreeNode> elementStack
            = new Stack<ExpressionTreeNode>();
        Stack<ExpressionTreeNode> operatorStack
            = new Stack<ExpressionTreeNode>();

        for(; index < expressions.length; index++) {
            String exp = expressions[index];
            switch(exp) {
                case "(":
                    index++;
                    ExpressionTreeNode result = helper(expressions);
                    if(result != null) {
                        elementStack.push(result);
                    }
                    break;
                case ")":
                    eval(elementStack, operatorStack, operatorStack.size());
                    if(elementStack.isEmpty()) {
                        return null;
                    } else {
                        return elementStack.pop(); 
                    }
                case "*":
                case "/":
                    if(!operatorStack.isEmpty()) {
                        ExpressionTreeNode temp = operatorStack.peek();
                    
                        if(temp.symbol.equals("/") || temp.symbol.equals("*")) {
                            eval(elementStack, operatorStack, 1);
                        }
                    }
                    ExpressionTreeNode operator = new ExpressionTreeNode(exp);
                    operatorStack.push(operator);
                    break;
                case "+":
                case "-":
                    eval(elementStack, operatorStack, operatorStack.size());
                    operatorStack.push(new ExpressionTreeNode(exp));
                    break;
                default:
                    ExpressionTreeNode element 
                        = new ExpressionTreeNode(exp);
                    elementStack.push(element);
                    break;
            }
        }
        
        eval(elementStack, operatorStack, operatorStack.size());
        if(elementStack.isEmpty()) {
            return null;
        } else {
            return elementStack.pop(); 
        }
    } // end of helpler

    private void eval(
        Stack<ExpressionTreeNode> elementStack,
        Stack<ExpressionTreeNode> operatorStack,
        int times
    ) {
        for(int i = 1; i <= times; i++) {
            ExpressionTreeNode temp
                 = operatorStack.pop();
            temp.right = elementStack.pop();
            temp.left = elementStack.pop();
            elementStack.push(temp);
        }
    }

}