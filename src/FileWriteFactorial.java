import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileWriteFactorial {


    static void view(){
        try{
            FileReader fr = new FileReader("factorialResult.txt");
            BufferedReader br = new BufferedReader(fr);
            String read = "", txt;
            while((txt = br.readLine()) != null)
                read += txt+"\n";
            br.close();
            JOptionPane.showMessageDialog(null, read, "Text", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println("Error, "+e);}

    }

    static void calculate(String calculateTheFactorialOf){

        int result = Integer.parseInt(calculateTheFactorialOf);
        for(int i = Integer.parseInt(calculateTheFactorialOf)-1; i>0; i--)
            result *= i;

        try{
            FileWriter fw = new FileWriter("factorialResult.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(calculateTheFactorialOf+"! = "+result);
            pw.close();


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"File not found","Error",JOptionPane.ERROR_MESSAGE);
        }


    }


    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        UIManager.put( "Button.arc", 999 );

        String choice = "";

        do{

            choice = JOptionPane.showInputDialog("1 - Calculate factorial | 2 - View previous calculations | x - Stop");

            switch(choice){
                case "1":
                    calculate(JOptionPane.showInputDialog("Calculate the factorial of"));
                    break;
                case "2":
                    view();
                    break;
                case "x":
                    JOptionPane.showMessageDialog(null,"Application stopped", "Goodbye.",JOptionPane.PLAIN_MESSAGE);
            }
        }while(!choice.equalsIgnoreCase("x"));
    }
}
