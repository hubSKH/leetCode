package leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        long start =System.currentTimeMillis ();
        String s ="LEETCODEISHIRINGLEETCODEISHIRINGLEETCODEISHIRINGLEETCODEISHIRINGLEETCODEISHIRING";
        int rows = 10;
        System.out.println (convert (s,rows));
        long end =System.currentTimeMillis ();
        System.out.println ("耗时："+(end-start));
    }

    /**
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时
     *
     *      L   C   I   R
     *      E T O E S I I G
     *      E   D   H   N
     *
     * L    D    R      L     S
     * E  O E  I I      E   I H
     * E C  I H  N      E  E  I  G
     * T    S    G      T O   R N
     *                  C     I
     * 输出 LCIRETOESIIGEDHN
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows<2 ||s.length ()<numRows){
            return s;
        }
        char[] chars =s.toCharArray ();
        int length =chars.length;
        int column =length-numRows+1;
        Character[][] a =new Character[numRows][column];
        int p =0,q=0;
        boolean add =true;
        int down=-1;//偶数向下保存，技术向上保存
        for (int i=0;i<length;i++){
            a[p][q] = chars[i];
            //计算下个字符存放位置
            if(p==0){
                add =true;
                down ++;
            }
            if(p==numRows-1){
                add=false;
                down ++;
            }
            if(add){
                p++;
            }else {
                p--;
            }
            if(down%2==0){
                //向下q不变
            }else {
                q++;
            }
        }
        StringBuilder sb =new StringBuilder ();
        for (int i=0;i<numRows;i++){
            for(int j=0;j<column;j++){
                Character c =a[i][j];
                if(c!=null){
                    sb.append (c);
                }
            }
        }
        return sb.toString ();
    }
}
