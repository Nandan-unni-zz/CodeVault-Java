class StringStack {
    private int max;
    private String[] arr;
    private int top;

    public StringStack(int s) {
        max = s;
        arr = new String[max];
        top = -1;
    }

    public void push(String item) {
        top++;
        arr[top] = item;
        // or --> arr[++top] = item
    }

    public String pop() {
        String item = arr[top];
        top--;
        return item;
        // or --> return arr[top--]
    }

    public String peek() {
        if (top != -1)
            return arr[top];
        else
            return "Empty";
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class InfixToPostfix {

    public static int precedence(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }

    public static boolean isOperand(String ch) {
        return ch.matches("[A-Za-z0-9]+");
    }

    public static boolean isOperator(String ch) {
        // Pattern operators = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        // return operators.matcher(ch).find();
        return precedence(ch) > 0;
    }

    public static void main(String[] args) {
        StringStack stack = new StringStack(20);
        String infixString = new String("");
        String postfixString = new String("");
        String nextChar, poppedItem;
        // infixString = "(A+B)*(C$(D-E)+F)-G";
        infixString = "A+(B*C-(D/E$F)*G)*H";
        System.out.println("Infix : " + infixString);
        while (!infixString.isEmpty()) {
            nextChar = infixString.substring(0, 1);
            infixString = infixString.substring(1);
            if ("(".equals(nextChar))
                stack.push(nextChar);
            if (isOperand(nextChar))
                postfixString += nextChar;
            if (")".equals(nextChar)) {
                while (!stack.isEmpty()) {
                    poppedItem = stack.pop();
                    if ("(".equals(poppedItem))
                        break;
                    else
                        postfixString += poppedItem;
                } // while
            } // if
            if (isOperator(nextChar)) {
                if (stack.isEmpty())
                    stack.push(nextChar);
                else if (precedence(nextChar) > precedence(stack.peek()))
                    stack.push(nextChar);
                else {
                    postfixString += stack.pop();
                    stack.push(nextChar);
                } // else
            } // if
        } // while
        while (!stack.isEmpty()) {
            postfixString += stack.pop();
        } // while
        System.out.println("Postfix : " + postfixString);
    } // main
}
