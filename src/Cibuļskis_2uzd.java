import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Cibuļskis_2uzd {

    public static void main(String[] args) {
        int izvele = 0;
        char[][] masivs = null;

        do
        {
            izvele = Integer.parseInt(JOptionPane.showInputDialog("1 - Izveidot | 2 - Aizpildīt | 3 - Izvade | 4 - Kārtot " +
                    "| 5 - Saglabāt | 6 - Nolasīt | 777 - Beigt"));
            switch(izvele){
                case 1:
                    masivs = Izveidot();
                    Izvade(masivs);
                    break;
                case 2:
                    if(masivs != null)
                    masivs = Aizpildit(masivs);
                    else
                        JOptionPane.showMessageDialog(null, "Masīvs nav izveidots!");
                    break;
                case 3:
                    if(masivs != null)
                    Izvade(masivs);
                    else
                        JOptionPane.showMessageDialog(null, "Masīvs nav izveidots!");
                    break;
                case 4:
                    if(masivs != null)
                    masivs = Kartot(masivs);
                    else
                        JOptionPane.showMessageDialog(null, "Masīvs nav izveidots!");
                    break;
                case 5:
                    if(masivs != null)
                    Saglabat(masivs);
                    else
                        JOptionPane.showMessageDialog(null, "Masīvs nav izveidots!");
                    break;
                case 6:
                    Nolasit();
                    break;
                case 777:
                    JOptionPane.showMessageDialog(null,"Darbs beidzies", "Uz redzēšanos.",JOptionPane.PLAIN_MESSAGE);
                    break;
            }
        }while(izvele != 777);

    }

    static char[][] Izveidot(){
        int rindas = 0 , kollonas = 0;

        do{
            rindas = Integer.parseInt(JOptionPane.showInputDialog("Ievadi rindu skaitu [2-50]: "));
        }while(rindas<2 || rindas>50);

        do{
            kollonas = Integer.parseInt(JOptionPane.showInputDialog("Ievadi kollonu skaitu [2-50]: "));
        }while(kollonas<2 || kollonas>50);


        char[][] masivs = new char[rindas][kollonas];

        for(int i = 0;  i < masivs.length; i++)
            for(int j = 0; j< masivs[i].length; j++)
                masivs[i][j] = 'x';


        JOptionPane.showMessageDialog(null, "Masīvs veiksmīgi izveidots!");
        return masivs;

    }

    static void Izvade(char[][] masivs){
        String izvade = "";
        for(int i = 0;  i < masivs.length; i++){
            for(int j = 0; j< masivs[i].length; j++)
                izvade += masivs[i][j]+"\t";
            izvade += "\n";
        }
        JOptionPane.showMessageDialog(null,"Jūsu masīvs: \n"+izvade);
    }

    static char[][] Aizpildit(char[][] masivs){
        Random rand = new Random();
        for(int i = 0;  i < masivs.length; i++)
            for(int j = 0; j< masivs[i].length; j++)
                masivs[i][j] = (char) (65 + rand.nextInt(26));

        JOptionPane.showMessageDialog(null,"Masīvs veiksmīgi aizpildīts!");
        return masivs;
    }

    static char[][] Kartot(char[][] masivs){

        Character[] pagMasivs = new Character[masivs.length*masivs[0].length];
        int k = 0;

        for(int i = 0;  i < masivs.length; i++)
            for(int j = 0; j< masivs[i].length; j++)
            {
                pagMasivs[k] = masivs[i][j];
                k++;
            }

        k = 0;


        Arrays.sort(pagMasivs, Collections.reverseOrder());

        for(int i = 0;  i < masivs.length; i++)
            for(int j = 0; j< masivs[i].length; j++)
            {
                masivs[i][j] = pagMasivs[k];
                k++;
            }

        JOptionPane.showMessageDialog(null,"Masīvs veiksmīgi sakārtots dilstošā secībā!");

        return masivs;
    }

    static void Saglabat(char[][] masivs){
        try{
            FileWriter fw = new FileWriter("Cibuļskis.txt");
            PrintWriter pw = new PrintWriter(fw);
            for(int i = 0;  i < masivs.length; i++){
                for(int j = 0; j< masivs[i].length; j++)
                    pw.print(String.valueOf(masivs[i][j])+"\t");
                pw.print("\n");
            }
            pw.close();
            JOptionPane.showMessageDialog(null, "Fails veiksīgi saglabāts!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"File nav atrasts!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    static void Nolasit(){
        try{
            FileReader fr = new FileReader("Cibuļskis.txt");
            BufferedReader br = new BufferedReader(fr);
            String read = "", txt;
            while((txt = br.readLine()) != null)
                read += txt+"\n";
            br.close();
            JOptionPane.showMessageDialog(null, read, "Fails", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println("Error, "+e);}

    }



}
