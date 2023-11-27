import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Main
{

    /**
     * 메인 함수입니다.
     * @param args
     * @throws Exception
     */
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
        int computerNumber = random.nextInt(3);

        if (playNumber <= -1 || playNumber >= 3) {
            throw new IllegalArgumentException("잘못된 종족 선택입니다.");
        }


        ArrayList<Unit> playerUnits = GamePrepare.getUnits(playNumber);
        ArrayList<Unit> computerUnits = GamePrepare.getUnits(computerNumber);

    
        /*
         * 게임이 시작되는 코드입니다.
         */

        while (true) {
            System.out.println("===================================");

            System.out.println("아군: " + playerUnits.get(0).getRace());
            printunits(playerUnits);
   
            System.out.println();
            System.out.println("적군: " + computerUnits.get(0).getRace());
            printunits(computerUnits);

            int findCount = 0;
            while(!playerAttack(playerUnits, computerUnits, scanner)) {
                findCount++;
                 if (findCount > 3) {
                    System.out.println("공격가능한 조합이 없습니다...");
                    break;
                }
            }
            
            if (checkList(computerUnits) && computerUnits.isEmpty()) {
                System.out.println("플레이어 승리!");
                break;
            } 
            System.out.println("===================================");

            /*
             * 컴퓨터가 공격을 시도하는 부분입니다.
             * 조합을 5번 찾고 더이상 없다면 공격가능 조합이 없다고 알리며 턴을 넘깁니다.
             */
            findCount = 0;
            while(!computerAttack (playerUnits, computerUnits, random)) {
                findCount++;
                if (findCount > 5) {
                    System.out.println("공격가능한 조합이 없습니다...");
                    break;
                }
            }
            
            if (checkList(playerUnits) && playerUnits.isEmpty()) {
                System.out.println("플레이어 패배...");
                break;
            } 
        }

        scanner.close();
    }


    /**
     * 리스트에 어떤 유닛이 있는지 보여줍니다.
     * 
     * @param Units 사용자에게 보여줄 리스트
     */
    public static void printunits(ArrayList<Unit> Units) {
        for (int i = 0; i < Units.size(); i++) {
            System.out.println(i + ". " + Units.get(i).toString());
        }

    }

    /**
     * 플레이어 턴에서 사용되는 공격 기능을 실행합니다.
     * 가변 리스트를 다루니 주의하세요
     * 
     * @param playerUnits 플레이어 유닛 리스트
     * @param computerUnits 컴퓨터 유닛 리스트
     * @param scanner 스캐너
     * @return 공격에 성공했다면 true를 실패 (공격 유형이 옳지 않음)시 false를 반환합니다.
     */
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

    /**
     * 
     * @param playerUnits 플레이어 유닛 리스트
     * @param computerUnits 컴퓨터 유닛 리스트
     * @param random 랜덤 인자
     * @return 공격에 성공했다면 true를 실패 (공격 유형이 옳지 않음)시 false를 반환합니다.
     */
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

    /**
     * 공격이 끝나고 죽은 유닛을 리스트에서 제거합니다
     * 이터레이터를 사용합니다.
     * @param Units 유닛 리스트입니다
     * @return 정상적으로 체크가 끝났다면 false를 반환합니다.
     */
    public static boolean checkList(ArrayList<Unit> Units) {
        Iterator<Unit> iterator = Units.iterator();

        while(iterator.hasNext()) {
            if (iterator.next().getDefense() < 1) 
                iterator.remove();;
        }
        return true;
    }
}
