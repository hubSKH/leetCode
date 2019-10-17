package leetcode.string;

/**
 * 12. 整数转罗马数字
 * @Description
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 输入: 3
 * 输出: "III"
 *
 * 输入: 4
 * 输出: "IV"
 * @auther SHENKAIHUAN
 * @create 2019-10-17 22:33
 */
public class IntegertoRoman {
    public static void main(String[] args) {

        int num = 1994;
        long start =System.currentTimeMillis ();
        System.out.println (intToRoman (num));
        long end = System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    public static String intToRoman(int num) {

        StringBuilder sb =new StringBuilder ();
        while (num>0){
            if(num>=1000){
                sb.append ("M");
                num-=1000;
            }else if(num>=900){
                sb.append ("CM");
                num-=900;
            }else if(num>=900){
                sb.append ("CM");
                num-=900;
            }else if(num>=500){
                sb.append ("D");
                num-=500;
            }else if(num>=400){
                sb.append ("CD");
                num-=400;
            }else if(num>=100){
                sb.append ("C");
                num-=100;
            }else if(num>=90){
                sb.append ("XC");
                num-=90;
            }else if(num>=50){
                sb.append ("L");
                num-=50;
            }else if(num>=40){
                sb.append ("XL");
                num-=40;
            }else if(num>=10){
                sb.append ("X");
                num-=10;
            }else if(num>=9){
                sb.append ("IX");
                num-=9;
            }else if(num>=5){
                sb.append ("V");
                num-=5;
            }else if(num>=4){
                sb.append ("IV");
                num-=4;
            }else if(num>=1){
                sb.append ("I");
                num-=1;
            }
        }

        return sb.toString ();
    }
}
