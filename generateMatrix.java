/**
 * Created by Thilanka on 12/10/2014.
 */

import java.io.*;
public class generateMatrix {

    //static String fileName = "dat3.csv";
    public static String [] word ;

    public static String[] genWordList(String fileName) {



        try {
            FileReader fileRd = new FileReader(fileName);
            BufferedReader bufferRd = new BufferedReader(fileRd);
            String line = bufferRd.readLine();

            String [] s = line.split(",");
            word = new String[s.length];
            word=s.clone();

            /*for (int i = 0; i < word.length; i++) {
                System.out.printf("%s " + word[i]);
            }*/

        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }
        return word;
    }

    public static double[][] genWordCount(String fileName) {

        String [] word1 = genWordList(fileName);
        int size=word1.length;
        //System.out.println(size);

        double [][] wordCount = new double [5][size];
        String [] wordCountString= new String[size];
        int time = 1;
        //int j=0;

        try {
            int i = 0;

            FileReader fileRd = new FileReader(fileName);
            BufferedReader bufferRd = new BufferedReader(fileRd);
            String line = null;
            double count;

            while( (line = bufferRd.readLine()) != null ) {
                if (time == 1) {
                    time++;
                }
                else {

                        wordCountString = line.trim().split(",");


                        for (int k = 0; k < wordCountString.length; k++) {
                            count = Double.parseDouble(wordCountString[k]);

                            wordCount[i][k]=count;
                        }
                        i++;


                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.exit(-1);
        }
        catch(NumberFormatException ex){
            System.out.println(ex);
            System.exit(-1);
        }

        return wordCount;
    }

    // recreating wordCount as a percentage of total wordCount in particular genre
    public static double [] wordCountRefer(double [] w){

        double total=0.0;

        for(int i=0; i<w.length; i++){
            total=total+w[i];
        }

        for(int i=0; i<w.length; i++){
            w[i]=(w[i]/total)*100;
        }

        return w;
    }

   /* public static void  main(String [] args){

        double [][] wordlist=genWordCount("dat3.csv");

        for(int i=0; i<wordlist.length; i++){
            for(int j=0; j<wordlist[0].length; j++) {
                System.out.printf("%f ", wordlist[i][j]);
            }
            System.out.println();
        }
    }*/

}



