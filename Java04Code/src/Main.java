public class Main {
    public static void main(String[] args) {
        LeapYear leapYear = new LeapYear();
        System.out.println(leapYear.isLeapYear(2024));
        Print p = new Print();
        p.print(11);
        Hanoi hanoi = new Hanoi();
        hanoi.move(3,"A","C","B");
        int [] sum = {1,4,2,7,8,5,6,3,9,0};
        //int [] sum = {2,1};
        MergeSort.mergeSort(sum,0,9);
        //MergeSort.gather(sum,0,1,1);
        for (int i = 0; i <= 9; i++) {
            System.out.print(sum[i]+" ");
        }
    }
}
