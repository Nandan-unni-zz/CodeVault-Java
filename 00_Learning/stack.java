class Stack {
    private int max;
    private int[] arr;
    private int top;

    public Stack(int s) {
        max = s;
        arr = new int[max];
        top = -1;
    }

    public void push(int item) {
        top++;
        arr[top] = item;
        // or --> arr[++top] = item
    }

    public int pop() {
        int item = arr[top];
        top--;
        return item;
        // or --> return arr[top--]
    }

    public int peek() {
        return arr[top];
    }

    public boolean isFull() {
        return top == max - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
