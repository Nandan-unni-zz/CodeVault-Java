import java.io.*;

class HelloWorld {
    public static void main(String[] args) throws IOException {
        int a, b, sum;
        System.out.println("Hello World");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
    }
}
