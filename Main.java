package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\ASUS PC\\Desktop\\Triangle.txt");
        if(file.exists()) {
            System.out.println("There is a file");
        } else {
            System.out.println("There is no file");

        }

        FileReader oku=new FileReader(file);
        FileReader oku1 =new FileReader(file);
        String line;
        int count = 0;
        BufferedReader br=new BufferedReader(oku);
        BufferedReader br1=new BufferedReader(oku1);

        while((line=br.readLine())!=null){      //for length of file
            System.out.println(line);
            count++;
        }
        br.close();

        String[] datas = new String[count];

        String  line1;
        int counter = 0;
        while((line1=br1.readLine())!=null){  //we put every line to array
        datas[counter] = line1;
        counter++;
        }
        br1.close();

        System.out.println();
        int [][] triangle = new int[count][count];
        for (int i = 0; i <datas.length ; i++) {       // split lines
            String [] temp = datas[i].split(" ");
            for (int j = 0; j <count ; j++) {
                if (j<temp.length){
                    triangle[i][j] = Integer.parseInt(temp[j]);
                    if (isPrime(triangle[i][j])==true){     //check number if it's prime
                        triangle[i][j]=0;                   //if it is prime,  we write zero instead of it
                    }
                }
                else {
                    triangle[i][j] = 0; //and we put zeros in the spaces in matrix
                }
            }
        }
        for (int i = 0; i <count ; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(triangle[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = count-1; i >0 ; i--) {
            for (int j = 0; j <=i-1 ; j++) {        //we control the rules

                if (triangle[i][j]>triangle[i][j+1]&&triangle[i-1][j]!=0){
                    triangle[i-1][j] +=triangle[i][j];
                }
                if (triangle[i][j]<=triangle[i][j+1]&&triangle[i-1][j]!=0){
                    triangle[i-1][j] +=triangle[i][j+1];
                }




            }
            for (int a = 0; a <count ; a++) {
                for (int k = 0; k < count; k++) {
                    System.out.print(triangle[a][k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Maximum sum is : " +triangle[0][0]);

    }
















    }

