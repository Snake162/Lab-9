package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {
    public static Surname[] loadCensusData(String fname) {
        int line = 0; // Keep track of line number in input file
        Surname[] namelist = new Surname[100];
        File file = new File("Surnames_2010Census.csv");
        Scanner input= null;
        boolean exit=false;
        try {
            input = new Scanner(file);
            while (input.hasNext() && line<100) {
                exit=false;
                String s = input.nextLine();
                if (s.contains(",")) {
                    //this makes sure the line contains a coma
                    String[] surnameArray=s.split(",");
                    if(surnameArray.length == 5){
                        //tis makes sure that the length of the aray is 5
                        int rank=0;
                        int count=0;
                        double propotion=0.0;
                        try {
                            rank=Integer.parseInt(surnameArray[1]);
                            count=Integer.parseInt(surnameArray[2]);
                            propotion=Double.parseDouble(surnameArray[3]);
                        } catch (NumberFormatException nfe) {
                            System.out.println("Format is incorrect.");
                            exit=true;
                            break;
                        }
                        if (rank>0 && count>0 && propotion>0.0) {
                            //this is to make sure it is not zero or negative;
                            namelist[line] = new Surname();
                            namelist[line].setRank(rank);
                            namelist[line].setName(surnameArray[0]);
                            namelist[line].setCount(count);
                            namelist[line].setProportion(propotion);
                        } else {
                            System.out.println("Format is incorrect. Contains invalid number value.");
                            exit=true;
                            break;
                        }
                    } else {
                        System.out.println("Format is incorrect. Wrong number of elements.");
                        exit=true;
                        break;
                    }
                } else {
                    System.out.println("Did not contain expected delimiter ','");
                    exit=true;
                    break;
                }
                line++;
            }
        }catch (FileNotFoundException ex){
            System.out.println("File not found: " + file.getAbsolutePath());
            exit=true;
        } finally {
            if (input != null) input.close();
        }
        if (exit) {
            namelist=null;
        }
        return namelist;
    }
}