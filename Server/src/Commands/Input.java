package Commands;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {

    public static void input() throws IOException {
    Scanner sc = new Scanner(System.in);
    InputStreamReader reader = new InputStreamReader(new FileInputStream(sc.nextLine()));
    int i;

    while((i=reader.read())!= -1){
            System.out.println((char)i);
        }
    }
}

