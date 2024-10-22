import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Competition {
    public static void main(String[] args) {
        int N,R,Q;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //有2N名选手
        R = sc.nextInt();
        //R轮比赛
        Q = sc.nextInt();
        //关心的名词Q
        Player player[] = new Player[2*N+1];
        List<Player> players = new ArrayList<Player>();
        for(int i=0;i<2*N;i++){
            players.add(new Player(i,sc.nextInt()));
        }
        for(int i=0;i<2*N;i++){
             players.get(i).might = sc.nextInt();
        }
        for(int i=0;i<2*N;i++) {//模拟打比赛
            players.sort(new Comparator<Player>() {//自定义比较逻辑对列表进行排序
                public int compare(Player p1, Player p2) {
                    if (p1.score == p2.score) {//如果分数相同，编号小的在前
                        return p1.id - p2.id;
                    } else {
                        return p2.score - p1.score;//编号不同，分高的在前面
                    }
                }
            });

            for(int j=0;j<2*N;j+=2){
                if(players.get(j).might > players.get(j+1).might){
                    players.get(j).score++;
                }
                else{
                    players.get(j+1).score++;
                }
            }
        }
        //比赛结束后再排序一次
        players.sort(new Comparator<Player>() {//自定义比较逻辑对列表进行排序
            public int compare(Player p1, Player p2) {
                if (p1.score == p2.score) {//如果分数相同，编号小的在前
                    return p1.id - p2.id;
                } else {
                    return p2.score - p1.score;//编号不同，分高的在前面
                }
            }
        });
//        for(int i=0;i<2*N;i++){
//           System.out.println("id: "+players.get(i).id+"score: "+players.get(i).score+"might: "+players.get(i).might);
//        }打印结束后的信息用于检测对不对
        //}
        System.out.print(players.get(Q-1).id+1);//因为列表从0开始，id也从0开始，所以需要处理一下
    }
}
class Player{
    public int id;//编号
    //public int rank;//排名
    public int score;//分数
    public int might;//实力值
    public Player(int id,int score){
        this.id = id;
        this.score = score;
    }

}
