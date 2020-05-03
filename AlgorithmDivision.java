package com.company;

import java.math.BigInteger;
import java.util.ArrayList;


public class AlgorithmDivision {
    public BigInteger calculate_d(BigInteger n, BigInteger e){
        ArrayList<BigInteger> arrayList0 = new ArrayList<>();
        ArrayList<BigInteger> arrayList1 = new ArrayList<>();
        arrayList0.add(e); //e = temp1
        arrayList1.add(n); //n = temp2
        while (!e.equals(BigInteger.valueOf(1))) {
            n = n.mod(e);
            arrayList0.add(e);
            arrayList1.add(n);
            e = e.mod(n);
            arrayList0.add(e);
            arrayList1.add(n);
        }
        BigInteger k = BigInteger.valueOf(0);
        BigInteger d = BigInteger.valueOf(0);
        int count = 1;
        for (int i=arrayList0.size(); i>0;i--){
            if (count%2==1){
                d = arrayList1.get(i-1).multiply(k).add(BigInteger.valueOf(1)).divide(arrayList0.get(i-1));
            }
            else {
                k = BigInteger.valueOf(1).subtract(arrayList0.get(i-1).multiply(d)).divide(arrayList1.get(i-1)).multiply(BigInteger.valueOf(-1));
            }
            count ++;
        }
        return d;
    }
}
