public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        if(expression == null || expression.length ==0) {
            return new ArrayList<String>();
        }
        
        return helper(expression);
    }

    private int index;

    private ArrayList<String> helper(String[] exps) {
        
        
        Stack<String> elementStack = new Stack<String>();
        Stack<String> operatorStack = new Stack<String>();        

        for(; index < exps.length; index++) {
            String exp = exps[index];
            switch(exp) {
                case "(":
                    index++;
                    elementStack.addAll(helper(exps));
                    break;
                case ")":
                    // if(elementStack.isEmpty()) {
                    //     return null;
                    // } else {
                        flush(elementStack, operatorStack, operatorStack.size());
                        ArrayList<String> result = new ArrayList<String>();
                        result.addAll(elementStack);
                        return result;
                    //}
                case "*":
                case "/":
                    if(!operatorStack.isEmpty()) {
                        String temp = operatorStack.peek();
                        if(temp.equals("*") || temp.equals("/")) {
                            flush(elementStack, operatorStack, 1);
                        }
                    }
                    operatorStack.push(exp);
                    break;
                case "+":
                case "-":
                    flush(elementStack, operatorStack, operatorStack.size());
                    operatorStack.push(exp);
                    break;
                default:
                    elementStack.push(exp);
                    break;
            }
        }// end of for

        flush(elementStack, operatorStack, operatorStack.size());
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(elementStack);
        return result;
    } // end of helper

    private void flush(
        Stack<String> elementStack,
        Stack<String> operatorStack,
        int times) {
        for(int i = 1; i <= times; i++) {
            elementStack.push(operatorStack.pop());
        }
    }
}
