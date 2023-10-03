import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("===================================");
        System.out.println("게임이 시작되었습니다.");
        System.out.println("종족을 골라주세요 \n" +
                             "Terran(1) \n" +
                             "Protos(2) \n" +
                             "Zerg(3)");

        int playNumber = scanner.nextInt() - 1;
        int computerNumber = random.nextInt(2);

        if (playNumber <= -1 || playNumber >= 3) {
            throw new IllegalArgumentException("잘못된 종족 선택입니다.");
        }


        ArrayList<Unit> playerUnits = GamePrepare.getUnits(playNumber);
        ArrayList<Unit> computerUnits = GamePrepare.getUnits(computerNumber);

    

        while (true) {

            System.out.println("아군: " + playerUnits.get(0).getRace() + "\n");
            printunits(playerUnits);
   
            System.out.println("적군: " + computerUnits.get(0).getRace());
            printunits(computerUnits);

            while(!playerAttack(playerUnits, computerUnits, scanner)) {}
           
            if (computerUnits.isEmpty()) {
                System.out.println("플레이어 승리!");
                break;
            } 

            while(!computerAttack(playerUnits, computerUnits, random)) {}
            
            if (playerUnits.isEmpty()) {
                System.out.println("플레이어 패배...");
                break;
            } 
        }

        scanner.close();
    }


    public static void printunits(ArrayList<Unit> Units) {
        for (int i = 0; i < Units.size(); i++) {
            System.out.println(i + ". " + Units.get(i).toString());
        }

    }

    public static boolean playerAttack(ArrayList<Unit> playerUnits, ArrayList<Unit> computerUnits, Scanner scanner) {

        System.out.println("공격을 수행할 아군 유닛: ");
        int attackerIndex = scanner.nextInt();
        System.out.println("공격할 적군 유닛: ");
        int defenderIndex = scanner.nextInt();

        Unit attacker = playerUnits.get(attackerIndex);
        Unit defender = computerUnits.get(defenderIndex);

        if (attacker.attack(defender)) {
            System.out.println(attacker.getName() + "가 공격! " + defender.toString());
            return true;
        } else {
            System.out.println("날고 있는 유닛을 공격할수 없습니다.");
            return false;
        }
    }

    public static boolean computerAttack(ArrayList<Unit> playerUnits, ArrayList<Unit> computerUnits, Random random) {

        System.out.println("컴퓨터의 턴!");
        int attackerIndex = random.nextInt(computerUnits.size());
        int defenderIndex = random.nextInt(playerUnits.size());

        Unit attacker = computerUnits.get(attackerIndex);
        Unit defender = playerUnits.get(defenderIndex);

        if (attacker.attack(defender)) {
            System.out.println(attacker.getName() + "가 " + defender.toString() + "를 공격!");
            return true;
        } else {
            return false;
        }
    }


}
