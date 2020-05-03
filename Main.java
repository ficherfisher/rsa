package com.company;

import java.io.*;
import java.math.BigInteger;


public class Main {

    public static void main(String[] args) throws IOException {

        String pathname = "G:\\RSA.txt";
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line1 = br.readLine();
        String line2 = br.readLine();
        Main main = new Main();
        main.produce_pub_prikey(line1, line2);
    }
    public void produce_pub_prikey(String line1, String line2) throws IOException {
        AlgorithmDivision algorithmDivision = new AlgorithmDivision();
        while (true){
            BigInteger p = new BigInteger(line1);
            BigInteger q = new BigInteger(line2);
            BigInteger n = p.multiply(q);
            BigInteger e = new BigInteger("65537");
            BigInteger fn = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
            BigInteger d = algorithmDivision.calculate_d(fn, e);
            String temp = "111111111111111111111111111111111111111111111111111111111111" +
                    "1111111111111111111111111111111111111111111111111111111111111111111";
            if (!d.equals(BigInteger.valueOf(1))){
                BigInteger plaintext = new BigInteger(temp);
                System.out.println("------------<!>------------");
                System.out.println("加解密：");
                long startTime=System.nanoTime();   //获取开始时间
                System.out.println(plaintext);
                BigInteger cipher = plaintext.modPow(e, n);
                BigInteger plaintext1 = cipher.modPow(d, n);
                System.out.println(cipher);
                System.out.println(plaintext1);
                long endTime=System.nanoTime(); //获取结束时间
                System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
                System.out.println("------------<!>------------");
                System.out.println("签名：");
                System.out.println(plaintext);
                BigInteger result = plaintext.modPow(d, n);
                System.out.println(result);
                System.out.println(result.modPow(e, n));
                break;
            }
        }
    }
}
