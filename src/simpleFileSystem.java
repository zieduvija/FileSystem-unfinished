import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class simpleFileSystem {
    static File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
    static String desktopLocation = desktop.getAbsolutePath();
    public static void main(String[] args) {
        String[] options = {"Create directory", "Create file","Browse directory","Read file","Delete file","Delete directory","Exit"};
        String choice;

        do{
            choice = (String) JOptionPane.showInputDialog(null, "Choose an action", "Choice", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch(choice){
                case "Create directory":
                    CreateDirectory(JOptionPane.showInputDialog("Directory name: "));
                    break;
                case "Create file":
                    CreateFile(JOptionPane.showInputDialog("Enter the file location: "),JOptionPane.showInputDialog("File name: "), JOptionPane.showInputDialog("Enter text: "));
                    break;
                case "Browse directory":
                    DirectoryContents(JOptionPane.showInputDialog("Directory name:"));
                    break;
                case "Read file":
                    ReadFile(JOptionPane.showInputDialog("File location:"),JOptionPane.showInputDialog("File name:"));
                    break;
                case "Delete file":
                    DeleteFile(JOptionPane.showInputDialog("File location:"),JOptionPane.showInputDialog("File name:"));
                    break;
                case "Delete directory":
                    DeleteDirectory(JOptionPane.showInputDialog("Directory name:"));
                    break;

            }


        }while(!choice.equalsIgnoreCase("Exit"));
    }

    private static void CreateDirectory(String name){
        try {
            File directory = new File(desktopLocation + "\\" + name);

            if (directory.exists())
                JOptionPane.showMessageDialog(null, "Directory already exists!");
            else
                directory.mkdir();
        }catch(Exception e){
            System.out.println("Error, "+e);
        }
    }
    private static void CreateFile(String directoryName, String name, String text){
        try{
            File directory = new File(desktopLocation + "\\" + directoryName);
            // true - append, no true - rewrite
            if(directory.exists()){
                FileWriter fw = new FileWriter(new File(directory, name+".txt"), true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(text);
                pw.close();
                JOptionPane.showMessageDialog(null, "File successfully created!");
            }else
                JOptionPane.showMessageDialog(null, "Directory doesn't exist!");
        }catch (Exception e){
            System.out.println("Error, "+e);
        }
    }
    private static void DirectoryContents(String directoryName){
        File directory = new File(desktopLocation + "\\" + directoryName);

        if(directory.exists()){
            File[] fileList = directory.listFiles();
            String str = "";

            for (File file : fileList)
                str += file.getName() + "\n";

            JOptionPane.showMessageDialog(null, str, "File list", JOptionPane.INFORMATION_MESSAGE);

        }else JOptionPane.showMessageDialog(null, "Directory doesn't exist!");
    }

    private static void ReadFile(String directoryName, String fileName){
        try{
            FileReader fr = new FileReader(desktopLocation+"\\"+directoryName+"\\"+fileName+".txt");
            BufferedReader br = new BufferedReader(fr);
            String read = "", txt;
            while((txt = br.readLine()) != null)
                read += txt+"\n";
            br.close();
            JOptionPane.showMessageDialog(null, read, "Text", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){System.out.println("Error, "+e);}
    }

    private static void DeleteFile(String directoryName, String fileName){
        File file = new File(desktopLocation + "\\ "+directoryName+"\\"+fileName+".txt");

        if(file.exists()){
            file.delete();
            JOptionPane.showMessageDialog(null,"File deleted successfully!");
        }else JOptionPane.showMessageDialog(null, "File doesn't exist!");

    }

    private static void DeleteDirectory(String directoryName){


    }
}
