import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Random;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class FileReading {

    static void create(){
        Random rand = new Random();
        LinkedList<Integer> values = readInstructions();

        if(values.get(0)<1){
            JOptionPane.showMessageDialog(null, "Wrong array size!");
            return;
        }



    }

    static LinkedList<Integer>readInstructions(){
        int lines = 0;
        LinkedList<Integer> values = new LinkedList<Integer>();

        try{
            FileReader fr = new FileReader("instructions.txt");
            BufferedReader br = new BufferedReader(fr);
            String num;

            while((num = br.readLine()) != null && lines < 4){
                values.add(Integer.parseInt(num));
                lines++;
            }
            br.close();

        }catch(Exception e){
            System.out.println("Err");
        }

        return values;
    }
    public static void main(String[] args) {
        FlatLightLaf.setup();

        String choice;

        do{

            choice = JOptionPane.showInputDialog("1 - Create an array | 2 - View file | x - Stop").toLowerCase();

            switch(choice){
                case "1":
                    create();
                    break;
            }
        }while(!choice.equalsIgnoreCase("x"));
    }
}
