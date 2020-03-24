package pers.fp.study.bigdata.JavaSE.ForCases;

/**
 * @author fengpeng
 * @date 2020/3/24 10:18
 */

public class ForCases {

    public static void main(String[] args) {

        char ch = '*';
        int high = 5;

        PrintRightTriangle(ch,high);
        PrintIsoscelesTriangle(ch,high);
        PrintHollowIsoscelesTriangles(ch,high);

        /**
         *
         *  我 做了修改
         *
         */

    }

    public static void PrintRightTriangle ( char ch, int high ){  //打印直角三角形

        if (high <= 0){
            System.out.println("高度必须是正整数");
        }

        //正方向
        System.out.println("正方向：");
        for(int i=1; i<=high; i++){
            for( int j=i; j>=1; j--){
                System.out.print(ch);
            }
            System.out.println();
        }

        //反方向
        System.out.println("反方向：");
        for (int  i=high; i>=1; i--){
            for (int j=1; j<=i; j++){
                System.out.print(ch);
            }
            System.out.println();
        }


    }

    public static void PrintIsoscelesTriangle ( char ch, int high ){  //打印等腰三角形

        if (high <= 0){
            System.out.println("高度必须是正整数");
        }

        //正方向
        System.out.println("正方向：");
        for(int i=0; i<high; i++){
            for(int j=0; j<high-1-i; j++){
                System.out.print(" ");
            }
            for(int k=0; k<2*i+1; k++){
                System.out.print(ch);
            }
            System.out.println();
        }

        //反方向
        System.out.println("反方向：");
        for(int i=high; i>=1; i--){
            for(int j=1; j<=high-i; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=2*i-1; k++){
                System.out.print(ch);
            }
            System.out.println();
        }

    }

    public static void PrintHollowIsoscelesTriangles ( char ch, int high ){  //打印空心等腰三角形
        if (high <= 0){
            System.out.println("高度必须是正整数");
        }

        //正方向
        System.out.println("正方向：");
        for(int i=0; i<high; i++){
            if(i==0){
                for(int j=0; j<high-1; j++){
                    System.out.print(" ");
                }
                System.out.print(ch);
                System.out.println();
                continue;
            }
            if (i == high-1){
                for (int j=0; j<2*high-1; j++ ){
                    System.out.print(ch);
                }
                System.out.println();
                continue;
            }

            for(int j=0; j<high-1-i; j++){
                System.out.print(" ");
            }
            for(int k=0; k<2*i+1; k++){
                if(k==0 || k==2*i){
                    System.out.print(ch);
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

        //反方向
        System.out.println("反方向：");
        //待开发

    }

    public static void PrintRhombus (){  //打印菱形
        //待开发
    }

    public static void PrintHollowRhombus (){  //打印空心菱形
        //待开发
    }
}
