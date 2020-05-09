//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * @author yolo
// * @date 2020/3/26-19:09
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner input=new Scanner(System.in);
//        String num=input.nextLine();
//        String str=input.nextLine();
//        Map<Character,String>[]temp=new Map<Character,String>[num.length()];
//        Map<Character,String> map=new HashMap<>();
//        for (int i = 0; i <num.length() ; i++) {
//            map.put(num.charAt(i),"false");
//        }
//
//        String[] s = str.split(" ");
//        for(int i=1;i<=9;i++){
//
//        }
//    }
//}
//
////    public static void main(String[] args) {
////        Scanner input=new Scanner(System.in);
////        int n=input.nextInt();
////        int[]rs=new int[n];
////        for (int i = 0; i <n ; i++) {
////            rs[i]=input.nextInt();
////        }
////        Double area=0.0;
////        for (int i = n-1; i>=0 ; i--) {
////            area=area+Math.pow(-1,i)*Math.PI* Math.pow(rs[i],2);
////        }
////        System.out.printf("%.5f",area);
////    }
//
////    public static void main(String[] args) {
////        Scanner input=new Scanner(System.in);
////        int n=input.nextInt();
////        int[]rs=new int[n];
////        for (int i = 0; i <n ; i++) {
////            rs[i]=input.nextInt();
////        }
////        Double area=0.0;
////        if(n%2!=0){
////            for (int i = n-1; i>=0 ; i--) {
////                area=area+Math.pow(-1,i)*Math.PI* Math.pow(rs[i],2);
////            }
////            System.out.printf("%.5f",area);
////        }else {
////            for (int i = n-1; i>=0 ; i--) {
////                area=area+Math.pow(-1,i+1)*Math.PI* Math.pow(rs[i],2);
////            }
////            System.out.printf("%.5f",area);
////        }
////    }