/**
 * Created by Thilanka on 12/9/2014.
 */
import java.io.*;
import java.util.*;

public class Knn {

    static double [][] wordCount =generateMatrix.genWordCount("dtmFor5Gen.csv");          //training wordCount
    static String [] WordList=generateMatrix.genWordList("dtmFor5Gen.csv");               //training WordList

    //static String [] WordListTesting=generateMatrix.genWordList("badsides.csv");        //testing wordlist

   // static double [][] WordCountTesting=generateMatrix.genWordCount("dearJohn.csv");    //testing wordcount
    //static  double [] WordCountTesting1=WordCountTesting[0];

    static int size=WordList.length;
    static double [] NewDistance=new double[size];

    static int noOfGenres = 5, noOfGenresLess20;      //noOfGEnres->total no of Genres We consider,noOfGenresLess20->noOfGenres<20%
    static String [] ss=new String[noOfGenres];                                                    //number of Genres
    static String [] output = {"","",""};



    private static String findMajorityClass(String [] array) {
        //add the String array to a Hashset to get unique String values
        Set<String> h = new HashSet<String>(Arrays.asList(array));

        //convert the hashset back to a array
        String[] uniqueValues = h.toArray(new String[0]);
/*//////////////////////////////////
        System.out.println(" Unique Values");
        for(int i=0; i<uniqueValues.length; i++){

            System.out.println(uniqueValues[i]+" ");

        }
*////////////////////////////////////////////////////////
        //Counts for Unique values
        int[] counts = new int[uniqueValues.length];

        //counting how many times a particular genre appears
        for (int i = 0; i < uniqueValues.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].equals(uniqueValues[i])) {
                    counts[i]++;
                }
            }
        }

        System.out.println("------------------------");
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }

        System.out.println("------------------------");
        for (int i = 0; i < uniqueValues.length; i++) {
            System.out.println(uniqueValues.length);
        }

        int max = counts[0];

        for (int counter = 1; counter < counts.length; counter++) {
            if (counts[counter] > max) {
                max = counts[counter];
            }
        }

        int freq = 0;

        for (int counter = 0; counter < counts.length; counter++) {
            if (counts[counter] == max) {
                freq++;
            }
        }

        int index=-1;

        if (freq==1){
            for(int counter=0; counter<counts.length; counter++){
                if(counts[counter]==max){
                    index=counter;
                    break;
                }
            }
            return uniqueValues[index];
        }

        else{
            int [] ix=new int[freq];

            System.out.println("Multiple Majority Classes: "+freq+ " Classes");
            int ixi=0;

            for(int counter=0; counter<counts.length; counter++){
                if(counts[counter]==max){
                    ix[ixi]=counter;
                    ixi++;
                }
            }

            for(int counter=0; counter<ix.length; counter++) {
                System.out.println("Class index: " + ix[counter]);
            }
                Random generator=new Random();

                int rIndex=generator.nextInt(ix.length);

                int nIndex= ix[rIndex];


            return  uniqueValues[nIndex];
        }

    }

    private static double [] calDistMatrix(String [] plotString){

        for(int i=0; i<WordList.length ; i++){
            for(int j=0; j<plotString.length; j++){
                if( WordList[i].equals(plotString[j] )  ){

                        NewDistance[i]=NewDistance[i]+1;

                }
            }
        }

        return NewDistance;
    }


    ///main function
    public  static  void run (){

        genres.writeAction();
        genres.writeRomance();
        genres.writeComedy();
        genres.writeMusic();
        genres.writeSport();

        int k=3; //number of neighbours to be considered.in here this should equal or less than number of genres

        List <Genre> genreList = new ArrayList<Genre>();
        List <Result> resultList = new ArrayList<Result>();

        // recreating Wordcount as a percentage
        for(int i=0; i<wordCount.length; i++){
            wordCount[i]=generateMatrix.wordCountRefer(wordCount[i]);
        }

        //generating genre List

        genreList.add(new Genre(wordCount[0],"Action"));
        genreList.add(new Genre(wordCount[1],"Comedy"));
        genreList.add(new Genre(wordCount[2],"Music"));
        genreList.add(new Genre(wordCount[3],"Romance"));
        genreList.add(new Genre(wordCount[4],"Sport"));
        //genreList.add(new Genre(wordCount[5],"Sport"));

            String [] s;
        ////reading file ///////////////////////////new//////////////////////////////////////////////////////////
        String filename="testPlot.txt";
        try {
            FileReader fileRd = new FileReader(filename);
            BufferedReader bufferRd;
            bufferRd= new BufferedReader (fileRd);

            String line;

            while( (line=bufferRd.readLine()) != null ){
                s = line.split("\\s+");
                NewDistance = calDistMatrix(s) ;


            }
        }
        catch (FileNotFoundException ex){
            System.out.println(ex);
        }
        catch (IOException ex1){
            System.out.println(ex1);
        }


        ////////////////////////////////////////////new///////////////////////////////////////////////////////////
        //double [] NewDistance = calDistMatrix( ) ;
        NewDistance=generateMatrix.wordCountRefer(NewDistance);

        //calculating euclidean distances for each genres
        for (int i = 0; i < genreList.size(); i++) {
            Genre genre = genreList.get(i);
            double dist = 0.0;

            for (int j = 0; j < genre.genreAttributes.length; j++) {
                dist += Math.pow(genre.genreAttributes[j] - NewDistance[j], 2);
            }

            double distance = Math.sqrt(dist);
            resultList.add(new Result(distance,genre.genreName));


        }

        System.out.println("Before Sorting");
        for(int x=0; x< resultList.size(); x++){
            System.out.println(resultList.get(x).genreName+" -> "+resultList.get(x).distance);

        }
        System.out.println("--------------------------");
        Collections.sort(resultList,new DistanceComperator());

        //manually sorting result list

       /* double distan1;
        double distan2;
        double temp;

        for(int i=0; i<2 ; i++){
            distan1 = resultList.get(i).distance;
             distan2 = resultList.get(i+1).distance;

            if( distan1 > distan2){
                         temp=distan1;
                        resultList
            }
        } */



        //calculate genre percentage
        double totalDistance=0.0;
        double tempPercentage=0.0;
        double [] percentage=new double[noOfGenres];

        for(int i=0; i<noOfGenres; i++){

                 totalDistance= totalDistance+ (resultList.get(i).distance);
        }

        for(int x=0; x<noOfGenres; x++){

            tempPercentage=( (resultList.get(x).distance)/totalDistance )*100;
            percentage[x]=tempPercentage;
            System.out.println(resultList.get(x).genreName+" -> "+tempPercentage+"%");
                                     tempPercentage=0.0;
            ss[x]= resultList.get(x).genreName;
        }

        noOfGenresLess20=0;

        for(int i=0; i<noOfGenres; i++){
            if( percentage[i] < 20.0){
                noOfGenresLess20++;
            }
            else break;
        }

        for(int i=0; i<3; i++){
            output[i] = "";
        }

        for(int i=0; i<noOfGenresLess20; i++){
            output[i] = ss[i];
        }





       //System.out.println(noOfGenresLess20);

        //String majClass=findMajorityClass(ss);

        //System.out.println("Class of new Instance is: "+majClass);


    } //end of main

    static  class Genre{
        double [] genreAttributes;
        String genreName;

        public Genre(double [] genreAttributes,String genreName){
            this.genreName=genreName;
            this.genreAttributes=genreAttributes;
        }
    }

    static class  Result{
        double distance;
        String genreName;

        public Result(double distance,String genreName){
            this.genreName=genreName;
            this.distance=distance;
        }
    }

    static class DistanceComperator implements Comparator<Result>{

        @Override
        public  int compare(Result a,Result b){
            if (a.distance < b.distance) return -1;
            else if (a.distance == b.distance) return 0;
            else return 1;
        }
    }

}