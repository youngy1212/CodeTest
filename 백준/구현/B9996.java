import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


public class B9996 {
    
    //입력 : 1:  파일의 개수 N개 
    // 2 : 패턴 (알파벳 소문자와 별포(아스키키값42)) 별표는 중간에 있다. 
    // N개의 줄에는 파일 이름. (알파벳 소문자)

    //로직 * 을 기준으로 앞쪽 뒤쪽 분리하여 앞에 체크 뒤에 체크 
    //자바 패턴 Pattern을 사용 ".*" 이 안에는 무슨단어든 다 들어갈 수 있음 


    //출력 : N개의 줄에 걸쳐서, 입력으로 주어진 i번째 파일 이름이 패턴과 일치하면 DA 아니면 NE 출력

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputPattern = br.readLine().split("\\*"); 

        Pattern pattern = Pattern.compile(inputPattern[0] +".*" +inputPattern[1] );

        for(int i = 0; i< N; i++){
            String doc = br.readLine();
            Matcher matcher = pattern.matcher(doc);

            if(matcher.matches()){
                bw.write("DA\n");
            }else{
                bw.write("NE\n");
            }

        }


        br.close();;
        bw.flush();
        bw.close();


    }
    
}
