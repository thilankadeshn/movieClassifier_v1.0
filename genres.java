import java.io.File;
import java.io.IOException;

import org.apache.commons.io.*;

/**
 * Created by Thilanka on 12/10/2014.
 */
public class genres {

    public static void writeAction(){
        File folder=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/Dataset/training/action");
        File [] listOfFiles= folder.listFiles();
        File newfile=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/InJDataset/action.txt");

        for(int i=0; i<listOfFiles.length; i++){
            File file=listOfFiles[i];

            if(file.isFile() && file.getName().endsWith(".txt")){
                try {
                    String content=FileUtils.readFileToString(file);            //reading files one by one
                    FileUtils.writeStringToFile(newfile,content,"UTF-8",true);  //appending text to new text
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void writeRomance(){
        File folder=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/Dataset/training/romance");
        File [] listOfFiles= folder.listFiles();
        File newfile=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/InJDataset/romance.txt");

        for(int i=0; i<listOfFiles.length; i++){
            File file=listOfFiles[i];

            if(file.isFile() && file.getName().endsWith(".txt")){
                try {
                    String content=FileUtils.readFileToString(file);            //reading files one by one
                    FileUtils.writeStringToFile(newfile,content,"UTF-8",true);  //appending text to new text
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void writeComedy(){
        File folder=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/Dataset/training/comedy");
        File [] listOfFiles= folder.listFiles();
        File newfile=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/InJDataset/comedy.txt");

        for(int i=0; i<listOfFiles.length; i++){
            File file=listOfFiles[i];

            if(file.isFile() && file.getName().endsWith(".txt")){
                try {
                    String content=FileUtils.readFileToString(file);            //reading files one by one
                    FileUtils.writeStringToFile(newfile,content,"UTF-8",true);  //appending text to new text
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void writeMusic(){
        File folder=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/Dataset/training/music");
        File [] listOfFiles= folder.listFiles();
        File newfile=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/InJDataset/music.txt");

        for(int i=0; i<listOfFiles.length; i++){
            File file=listOfFiles[i];

            if(file.isFile() && file.getName().endsWith(".txt")){
                try {
                    String content=FileUtils.readFileToString(file);            //reading files one by one
                    FileUtils.writeStringToFile(newfile,content,"UTF-8",true);  //appending text to new text
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void writeSport(){
        File folder=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/Dataset/training/sport");
        File [] listOfFiles= folder.listFiles();
        File newfile=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/InJDataset/sport.txt");

        for(int i=0; i<listOfFiles.length; i++){
            File file=listOfFiles[i];

            if(file.isFile() && file.getName().endsWith(".txt")){
                try {
                    String content=FileUtils.readFileToString(file);            //reading files one by one
                    FileUtils.writeStringToFile(newfile,content,"UTF-8",true);  //appending text to new text
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void writeCrime(){
        File folder=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/Dataset/training/crime");
        File [] listOfFiles= folder.listFiles();
        File newfile=new File("E:/EDucational/Acadamic/Com Eng/Short Sem/CO227/Projects/Our Project/Movie/InJDataset/crime.txt");

        for(int i=0; i<listOfFiles.length; i++){
            File file=listOfFiles[i];

            if(file.isFile() && file.getName().endsWith(".txt")){
                try {
                    String content=FileUtils.readFileToString(file);            //reading files one by one
                    FileUtils.writeStringToFile(newfile,content,"UTF-8",true);  //appending text to new text
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
