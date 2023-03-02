import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Random;

import com.formdev.flatlaf.FlatDarculaLaf;


public class FileReading {


    static void view(){
        try{
            FileReader fr = new FileReader("arrays.txt");
            BufferedReader br = new BufferedReader(fr);
            String read = "", txt;
            while((txt = br.readLine()) != null)
                read += txt+"\n";
            br.close();
            JOptionPane.showMessageDialog(null, read, "Text", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println("Error, "+e);}

    }
    static void save(int[] array){

        try{
            FileWriter fw = new FileWriter("arrays.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            for(int num : array)
                pw.print(num+" ");
            pw.println("\n");
            pw.close();


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"File not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    static void create(){
        Random rand = new Random();
        LinkedList<Integer> values = readInstructions();

        if(values.get(0)<1){
            JOptionPane.showMessageDialog(null, "Wrong array size!");
            return;
        }

        int[] array = new int[values.get(0)];

        //if the num in 4th line is smaller than the number in the 3rd line then swap them
        if(values.get(2)>values.get(3)){
            int temp = values.get(2);
            values.set(2, values.get(3));
            values.set(3, temp);

        }

        //fill the array the amount of times specified in instructions.txt

        for(int i = 1; i<= values.get(1); i++){
            //perform the filling of array with random nums
            for(int j = 0; j<array.length; j++)
                array[j] = rand.nextInt(values.get(3)-values.get(2)+1)+values.get(2);
            save(array);
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
        FlatDarculaLaf.setup();
        UIManager.put( "Button.arc", 999 );

        String choice = "";

        do{

            choice = JOptionPane.showInputDialog("1 - Create an array | 2 - View file | x - Stop");

            switch(choice){
                case "1":
                    create();
                    System.out.println("A");
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
