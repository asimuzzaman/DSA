public class Main {
    public static void main(String[] args) {
        MyStack<String> st = new MyStack<>();

        st.push("Hello");
        st.push("World");
        st.push("I am a stack");

        System.out.println(st.top());
    }
}
