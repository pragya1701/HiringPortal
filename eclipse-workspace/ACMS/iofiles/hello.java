import java.util.*;
import java.io.*;
import java.lang.*;
public class hello{
int absDiff(int a, int b){
    return a-b;
}public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int testcases = sc.nextInt(); hello h= new hello(); while(testcases!=0){ int a = sc.nextInt(); int b = sc.nextInt(); System.out.println(h.absDiff(a,b));testcases = testcases-1;}}}