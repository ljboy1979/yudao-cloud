package cn.acsm.module.service.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author smile
 */
public class StringUtils {

    private static String string = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }
    
    /**
     * 生成随机字符串
     * @param length 字符串位数
     * @return
     */
    public static String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }


    /**
     * java生成随机数字和字母组合10位数
     * @param length[生成随机数的长度]
     * @return
     */
    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }


    /**
     * 生成随机身份码
     * @return
     */
    public static String getRandomString() {
        char[] cs = new char[10];
        String pool="";
        for ( short i= '0';i<='9';i++){
            pool=pool+(char)i;
        }
        for(short i='A';i<='Z';i++){
            pool=pool+(char)i;
        }
        for(short i='a';i<='z';i++){
            pool=pool+(char)i;
        }
        System.out.println(pool);

        for(int h=0;h<cs.length;h++){
            int index=(int)(Math.random()*pool.length());
            cs[h]=pool.charAt(index);
        }
        String str = new String(cs);
        return  str;
    }

    /**
     * 姓名信息过滤
     * @return
     */
    public static String replaceName(String name){
        StringBuilder nickName = new StringBuilder(name);
        StringBuilder replace = nickName.replace(0, 1, "*");
        return replace.toString();
    }

    /**
     * 号码信息过滤
     * @return
     */
    public static String replacePhone(String phone){
        StringBuilder phone1 = new StringBuilder(phone);
        StringBuilder phoneReplace = phone1.replace(3, 7, "****");
        return phoneReplace.toString();
    }

    /**
     * 身份证信息过滤
     * @return
     */
    public static String replaceIdNumber(String idNumber){
        StringBuilder phone1 = new StringBuilder(idNumber);
        StringBuilder phoneReplace = phone1.replace(1, 17, "****************");
        return phoneReplace.toString();
    }

    /**
     * 过滤非数字字符串
     * @return
     */
    public static String filterNoNumber(String str) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
         //替换与模式匹配的所有字符(即非数字的字符将被""替换)
        return m.replaceAll("").trim();
    }

    public static String getStringNoBlank(String str) {
        if (str != null && !"".equals(str)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            String strNoBlank = m.replaceAll("");
            return strNoBlank;
        } else {
            return str;
        }
    }

    public static String getPhoneNoBlank(String number) {
        String regEx="[^0-9|-]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(number);
        return m.replaceAll("").trim();
    }

    /**
     * 判断字符串是不是double型
     * @param str
     * @return
     */
    public static boolean isDouble(String str) {
        Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
