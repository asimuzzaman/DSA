//tester class for Stack
public class Main {
    public static void main(String[] args) {
        Stack st = new Stack(10);

        st.push(35);
        st.push(6);
        st.push(21);
        st.push(13);

        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());

        st.print();
    }
}
