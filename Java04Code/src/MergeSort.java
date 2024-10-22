import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void mergeSort(int[] arr,int l,int r) {//将这个数组的l到r的元素排序
        if(r-l<=0){
            return;
        }
        int mid = l+(int)((r-l)/2);
        //二分法，将数组不断地一分为二，最后将最小块的数组按顺序合并，
        mergeSort(arr,l,mid);//先排左半边
        mergeSort(arr,mid+1,r);//再排右半边
        gather(arr,l,mid,r);//将左半边和右半边合并


    }
    public static void gather(int []arr,int l,int mid,int r){
        if(r-l == 1 && arr[r] >= arr[l])return ;
        if (r-l==1 && arr[l] >= arr[r]){
            int tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            return ;
        }
        //调试的时候发现只有两个数的时候无法排序，于是将这种情况特殊处理

        int i;
        int a[] = new int[100000];
        int b[] = new int[100000];
        for(i=0;i<=mid-l;i++){
            a[i] = arr[l+i];
            //System.out.print(a[i]+" ");
        }
        a[i] = 100000;//在最后加一个非常大的数可以让a读完后继续读取b的剩下的数字
        int alength = mid-l+1;
        for(i=0;i<r-mid;i++){
            b[i] = arr[mid+1+i];
           // System.out.print(b[i]+" ");
        }
        b[i] = 100000;
        int blength = r-mid;
        List<Integer> list = new ArrayList<Integer>();//因为列表添加数字方便，所以弄一个列表
        int n=0,m=0;
        while(!(n==alength&&m==blength)){//如果a,b都没有读入完成

            if(a[n]<b[m]){
                list.add(a[n++]);//加入a[n]同时n这个指针（类似）向后移动
            }
            else{
                list.add(b[m++]);
            }
        }
        int k=0;
        for(i=l;i<=r;i++){
            arr[i] = list.get(k++);
            //将排序好的列表替换掉原来数组没有排序的部分
        }

    }
}
