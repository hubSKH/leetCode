package audition;

/**
 * 面试题13. 机器人的运动范围
 * @Description
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1]
 * 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * @auther SHENKAIHUAN
 * @create 2020-03-21 1:38
 */
public class MovingCount {
    public static void main(String[] args) {
        int m=2;
        int n=3;
        int k=1;
        long start=System.currentTimeMillis ();
        System.out.println (movingCount(m,n,k));
        long end=System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));

    }
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return dfs (m,n,k,0,0,0,0,visited);

    }

    private static int dfs(int m, int n, int k, int i, int j, int si, int sj, boolean[][] visited) {
        //下标越界||不符合k值|| 如果访问过
        if(i<0||i>=m||j<0||j>=n||k<si+sj||visited[i][j]) return 0;
        visited[i][j]=true;
        return 1+dfs (m,n,k,i+1,j,(i+1)%10!=0?si+1:si-8,sj,visited)+dfs (m,n,k,i,j+1,si,(j+1)%10!=0?sj+1:sj-8,visited);

    }
}
