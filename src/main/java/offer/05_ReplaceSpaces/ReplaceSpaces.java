/**
 * TODO
 *
 * @author lisong@cestc.cn
 * @date 2021/7/7
 */
public class ReplaceSpaces {

    public String replaceSpace(String s){
        if (s == null || "".equals(s)){
            return s;
        }
        return s.replaceAll(" ","%20");
    }


    public String replaceSpaceLocal(String s){
        if (s == null || "".equals(s)){
            return s;
        }
        int length = s.length();
        char[] array = new char[length*3];
        int size = 0;
        for (int i = 0;i<length;i++){
            char c = s.charAt(i);
            if (c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = c;
            }
        }
        return new String(array,0,size);
    }


    public static void main(String[] args) {
        ReplaceSpaces replaceSpaces = new ReplaceSpaces();
        System.out.println(replaceSpaces.replaceSpace("We are happy"));
        System.out.println(replaceSpaces.replaceSpace(null));
    }
}
