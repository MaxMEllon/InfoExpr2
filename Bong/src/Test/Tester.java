package Test;

import java.lang.RuntimeException;

public class Tester
{
    public int result;

    public int notEq(boolean ope)
    {
        result = 0;
        try {
            testing(! ope);
        } catch (RuntimeException e) {
            this.result = 1;
        } finally {
            printResult();
            return result;
        }
    }

    public int eq(boolean ope)
    {
        result = 0;
        try {
            testing(ope);
        } catch (RuntimeException e) {
            this.result = 1;
        } finally {
            printResult();
            return result;
        }
    }

    public void it(String str) {
        System.out.print("\u001b[34m");
        System.out.print(str + "\t : ");
        System.out.print("\u001b[00m");
    }

    public void end() {
        String str = result == 0 ? "\t[OK]" : "[NG]";
        System.out.println(str);
    }

    private void printResult() {
        String str = result == 0 ? "\u001b[32m.\u001b[00m" : "\u001b[31mX\u001b[00m";
        System.out.print(str);
    }

    private boolean testing(boolean ope) throws RuntimeException
    {
        if ( ! ope ) { throw new RuntimeException("テストに失敗しました"); }
        return true;
    }
}
