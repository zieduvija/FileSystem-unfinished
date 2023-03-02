import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class fairyTale {

    static void view(){
        try{
            FileReader fr = new FileReader("posoko.txt");
            BufferedReader br = new BufferedReader(fr);
            String read = "", txt;
            while((txt = br.readLine()) != null)
                read += txt+"\n";
            br.close();
            JOptionPane.showMessageDialog(null, read, "Text", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println("Error, "+e);}

    }


    static void save(String text){

        try{
            FileWriter fw = new FileWriter("posoko.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(text);
            pw.close();
            JOptionPane.showMessageDialog(null, "File saved successfully!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"File not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    static void encode(){
        String text = getText();
        String newText = "";

        for(int i = 0; i<text.length();i++){
            if(text.charAt(i) == 'a')
                newText += 'o';
            else if(text.charAt(i) == 'A')
                newText += 'O';
            else newText += text.charAt(i);
        }


            save(newText);

    }

    static String getText(){
        String read = "", txt;
        try{
            FileReader fr = new FileReader("fairytale.txt");
            BufferedReader br = new BufferedReader(fr);
            while((txt = br.readLine()) != null)
                read += txt+"\n";
            br.close();
            JOptionPane.showMessageDialog(null, read, "Text", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println("Error, "+e);}

        return read;

    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        UIManager.put( "Button.arc", 999 );

        String choice = "";

        do{

            choice = JOptionPane.showInputDialog("1 - Jumble fairytale | 2 - View the jumbled fairytale | x - Stop");

            switch(choice){
                case "1":
                    encode();
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
