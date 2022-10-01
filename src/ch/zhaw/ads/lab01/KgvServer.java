package ch.zhaw.ads.lab01;

import ch.zhaw.ads.CommandExecutor;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class KgvServer implements CommandExecutor {

    public int kgv(int a, int b) {
        return Math.abs(a * b) / ggt(a, b);
    }

    private int ggt(int a, int b) {
        if (a > b) return ggt(a-b, b);
        else if (a < b) return ggt(a, b-a);
        else return a;
    }

    public String execute(String s) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(s.getBytes()));
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        return Integer.toString(kgv(a,b));
    }
}
