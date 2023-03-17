package com.company;
import java.util.*;

public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("enter no of process:");
        int n = sc.nextInt();
        int pd[] = new int[n];
        int at[] = new int[n];
        int brt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];
        int st=0, tot=0;
        float avgwt=0, avgta=0;

        for(int i=0;i<n;i++)
        {
            System.out.println ("enter process " + (i+1) + " arrival time:");
            at[i] = sc.nextInt();
            System.out.println ("enter process " + (i+1) + " brust time:");
            brt[i] = sc.nextInt();
            pd[i] = i+1;
            f[i] = 0;
        }
        boolean a = true;
        while(true)
        {
            int c=n, min=999;
            if (tot == n)
                break;
            for (int i=0; i<n; i++)
            {

                if ((at[i] <= st) && (f[i] == 0) && (brt[i]<min))
                {
                    min=brt[i];
                    c=i;
                }
            }

            if (c==n)
                st++;
            else
            {
                ct[c]=st+brt[c];
                st+=brt[c];
                tat[c]=ct[c]-at[c];
                wt[c]=tat[c]-brt[c];
                f[c]=1;
                tot++;
            }
        }
        System.out.println("\npid  arrival brust  complete turn waiting");
        for(int i=0;i<n;i++)
        {
            avgwt+= wt[i];
            avgta+= tat[i];
            System.out.println(pd[i]+"\t"+at[i]+"\t"+brt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }
        System.out.println ("\naverage tat is "+ (float)(avgta/n));
        System.out.println ("average wt is "+ (float)(avgwt/n));
        sc.close();
    }
}
