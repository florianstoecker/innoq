import java.util.concurrent.TimeUnit;
public class Animation {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void an_Gewinn()
    {
        for(int i = 0; i<50; i++)
        {

            int ran = an_random();
            an_leer(ran);
            System.out.printf(ANSI_RED + "  *\n");
            an_leer(ran);
            System.out.printf(ANSI_RED + "*   *\n");
            an_leer(ran);
            System.out.printf(ANSI_RED + "  *\n");
            System.out.println("");

            ran = an_random();
            an_leer(ran);
            System.out.printf(ANSI_YELLOW + "  *\n");
            an_leer(ran);
            System.out.printf(ANSI_YELLOW + "*   *\n");
            an_leer(ran);
            System.out.printf(ANSI_YELLOW + "  *\n");
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static int an_random()
    {
        int num_rand = (int)((Math.random()) * 100);
        return num_rand;
    }
    public static void an_leer(int num)
    {
        for(int i = 0; i < num; i ++)
        {
            System.out.printf(" ");
        }

    }
}
