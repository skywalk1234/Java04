public class Print {
    void print (int n){
        int mid = (n+1)/2;
        for (int i = 1; i <= mid; i++) {//处理前半部分
            for(int j=1;j<=mid-i;j++){
                System.out.print(" "); //先打印前面的空格
            }
            for (int j=1;j<=i*2-1;j++){//再处理新号并挖掉中间的
                if(j==1 || j == i*2-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = mid-1; i >=1; i--) {//处理后半部分
            for(int j=1;j<=mid-i;j++){
                System.out.print(" "); //先打印前面的空格
            }
            for (int j=1;j<=i*2-1;j++){//打印*并挖掉中间的
                if(j==1 || j == i*2-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
