/**
 * Created by panqingqing on 17/2/22.
 */
public class Test {

    public static void main(String[] args) {
        byte[] bytes = new byte[10 * 1024 * 1024];
        System.out.println(Runtime.getRuntime().maxMemory() / (1024.0 * 1024) + "M");
        System.out.println(Runtime.getRuntime().freeMemory() / (1024.0 * 1024) + "M");
        System.out.println(Runtime.getRuntime().totalMemory() / (1024.0 * 1024) + "M");
    }

    private static void g() {
    }
}
