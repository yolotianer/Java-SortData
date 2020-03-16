

/**
 * @author yolo
 * @date 2020/3/14-13:48
 * 八皇后
 */
public class Main {
    public static void main(String[] args) {
        int count=0;
        for (int i1 = 0; i1 < 8; i1++) {
            for (int i2 = 0; i2 <8 ; i2++) {
                if(i1==i2||i1-1==i2||i1+1==i2)
                { continue; }
                for (int i3 = 0; i3 <3 ; i3++) {
                    if(i1==i3||i1-2==i3||i1+2==i3
                    ||i2==i3||i2-1==i3||i2+1==i3)
                    { continue; }
                    for (int i4 = 0; i4 <8 ; i4++) {
                        if(i1==i4||i1-3==i4||i1+3==i4
                        ||i2==i4||i2-2==i4||i2+2==i4
                        ||i3==i4||i3-1==i4||i3+1==i4)
                        { continue; }
                        for (int i5 = 0; i5 < 8; i5++) {
                            if(i1==i5||i1-4==i5||i1+4==i5
                            ||i2==i5||i2-3==i5||i2+3==i5
                            ||i3==i5||i3-2==i5||i3+2==i5
                            ||i4==i5||i4-1==i5||i4+1==i5)
                            { continue; }
                            for (int i6 = 0; i6 <8 ; i6++) {
                                if(i1==i6||i1-5==i6||i1+5==i6
                                ||i2==i6||i2-4==i6||i2+4==i6
                                ||i3==i6||i3-3==i6||i3+3==i6
                                ||i4==i6||i4-2==i6||i4+2==i6
                                ||i5==i6||i5-1==i6||i5+1==i6)
                                { continue; }
                                for (int i7 = 0; i7 < 8; i7++) {
                                    if(i1==i7||i1-6==i7||i1+6==i7
                                    ||i2==i7||i2-5==i7||i2+5==i7
                                    ||i3==i7||i3-4==i7||i3+4==i7
                                    ||i4==i7||i4-3==i7||i4+3==i7
                                    ||i5==i7||i5-2==i7||i5+2==i7
                                    ||i6==i7||i6-1==i7||i6+1==i7)
                                    { continue; }
                                    for (int i8 = 0; i8 <8 ; i8++) {
                                        if(i1==i8||i1-7==i8||i1+7==i8
                                        ||i2==i8||i2-6==i8||i2+6==i8
                                        ||i3==i8||i3-5==i8||i3+5==i8
                                        ||i4==i8||i4-4==i8||i4+4==i8
                                        ||i5==i8||i5-3==i8||i5+3==i8
                                        ||i6==i8||i6-2==i8||i6+2==i8
                                        ||i7==i8||i7-1==i8||i7+1==i8)
                                        { continue; }
                                        count++;
                                        System.out.println("[0,"+i1+"]"
                                        +"  [1,"+i2+"]"
                                        +"  [2,"+i3+"]"
                                        +"  [3,"+i4+"]"
                                        +"  [4,"+i5+"]"
                                        +"  [5,"+i6+"]"
                                        +"  [6,"+i7+"]"
                                        +"  [7,"+i8+"]");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("共有"+count+"种可能");
    }
}
