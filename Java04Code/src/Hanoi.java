public class Hanoi {
    public void move(int n,String start,String end,String through){
        //该函数完成将n个盘子从start经过through移动到end的任务
        if(n==1){
            //退出条件：如果只有一个圆盘，就直接将它从start移动到end,并返回
            System.out.println(start + "->"+end);
            return;
        }
        //无论有多少个盘子，都可以将n-1个盘子当成整体
        //这样问题相当于就变成了移动两个盘子（假设从A移动到C经过B）
        //第一步将第一个盘子从A(start)移动到B(end)，经过C(through)
        //第二步将第二个盘子从A(start)移动到C(through)，经过B(end)
        //第三步再将第一个盘子从B(end)移动到C(through)，经过A(start)
        move(n-1,start,through,end);//要想移动n个盘子从start移动到end，就要先将n-1个盘子从
        //上一层函数传入的start移动到上一层函数传入的through

        System.out.println(start + "->"+end);//移动第n个盘子
        move(n-1,through,end,start);//将第n个盘子从上一层传入的through移动到上一层传入的end.

    }
}
