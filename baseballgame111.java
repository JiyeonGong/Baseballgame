import java.util.Random;
import java.util.Scanner;

public class baseballgame111 {

    public static int[] setNum()
    {
        int[] crd = new int[3]; // Computer Random Number : 컴퓨터가 생성할 난수 배열
        Random r = new Random(); // 난수 생성
        crd[0] = r.nextInt(9) + 1;
        crd[1] = r.nextInt(9) + 1;
        crd[2] = r.nextInt(9) + 1;
        while(true)
        {
            if (crd[0] == crd[1])
                crd[1] = r.nextInt(9) + 1;
            else if (crd[0] == crd[2] | crd[1] == crd[2] )
                crd[2] = r.nextInt(9) + 1;
            else
                return crd;
        }
    }

    public static int[] userInput()
    {
        int[] user = new int[3];
        Scanner scanner = new Scanner(System.in); // Scanner 정의
        while (true) {

            for (int i = 0; i < 3; i++)
                user[i] = scanner.nextInt();

            if (user[0] != user[1] && user[0] != user[2] && user[1] != user[2]) return user;

            else System.out.println("중복된 값입니다. 다시 입력하세요!");

        }
    }

    public static int[] checkStrikeBall(int[] crd, int[] user)
    {
        int[] strike_ball = {0,0}; //스트라이크 , 볼 판단
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (crd[i] == user[j])
                {
                    if (i == j)
                        strike_ball[0]++;
                    else
                        strike_ball[1]++;
                }
            }
        }
        return strike_ball;
    }

    public static void main(String[] args) {
        int count = 0; // Count : 사용자가 시행한 게임의 횟수

        int[] crd = setNum();
        System.out.printf("%d %d %d \n",crd[0],crd[1],crd[2]);
        System.out.println("☆ Start Baseball Game ! ☆"); // 야구 게임 시작 코멘트

        while (true) {
            System.out.println("3가지 숫자를 입력하세요. (단, 숫자는 중복되지 않습니다.) : "); //숫자 입력 받을 코멘트

            int[] user = userInput(); // User : 사용자가 입력할 배열

            int strike = checkStrikeBall(crd,user)[0];
            int ball = checkStrikeBall(crd,user)[1];
            count++;
            // 정답일 경우
            if (strike == 3) {
                System.out.println("Correct! 정답입니다! 게임을 종료합니다. ");
                System.out.println("당신은 " + count + "번째 시도 끝에 성공했습니다.");
                break;
            } else { // 아닐경우 ( 스트라이크, 볼 print)
                System.out.println(strike + " Strike " + ball + " Ball");
            }

        }
    }
}

