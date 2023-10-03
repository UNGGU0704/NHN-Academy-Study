import java.util.ArrayList;
import java.util.Random;


public class GamePrepare {

    public static ArrayList<Unit> getUnits(int race) {

        switch(race){
            case 0:
                return generateTERRAN(5);
            case 1:
                return generateProtos(4);
            case 2:
                return generateZerg(8);
            default:
                return null;
        }
    }

    private static ArrayList<Unit> generateTERRAN(int unitCount){
        ArrayList<Unit> playerUnits = new ArrayList<>();
        TERRAN[] terrans = TERRAN.values();
        Random random = new Random();

        for (int i = 0; i < unitCount; i++) {
            int randomNumber = random.nextInt(4);
            String unitName = terrans[randomNumber].getName();
            String unitRace = "Terran";
            int unitPower = terrans[randomNumber].getPoewer();
            int unitDefense = terrans[randomNumber].getDefense();
            boolean unitFlyable = terrans[randomNumber].getFlyable();
            boolean unitAttackToFly = terrans[randomNumber].getAttackToFly();
          
            playerUnits.add(new Unit(unitName, unitRace, unitPower, unitDefense, unitFlyable, unitAttackToFly));
        }

        return playerUnits;
    }

    private static ArrayList<Unit> generateProtos(int unitCount){
        ArrayList<Unit> playerUnits = new ArrayList<>();
        PROTOS[] protos = PROTOS.values();
        Random random = new Random();

        for (int i = 0; i < unitCount; i++) {
            int randomNumber = random.nextInt(4);
            String unitName = protos[randomNumber].getName();
            String unitRace = "PROTOS";
            int unitPower = protos[randomNumber].getPoewer();
            int unitDefense = protos[randomNumber].getDefense();
            boolean unitFlyable = protos[randomNumber].getFlyable();
            boolean unitAttackToFly = protos[randomNumber].getAttackToFly();
          
            playerUnits.add(new Unit(unitName, unitRace, unitPower, unitDefense, unitFlyable, unitAttackToFly));
        }

        return playerUnits;
    }

    
    private static ArrayList<Unit> generateZerg(int unitCount){
        ArrayList<Unit> playerUnits = new ArrayList<>();
        ZERG[] zergs = ZERG.values();
        Random random = new Random();

        for (int i = 0; i < unitCount; i++) {
            int randomNumber = random.nextInt(4);
            String unitName = zergs[randomNumber].getName();
            String unitRace = "PROTOS";
            int unitPower = zergs[randomNumber].getPoewer();
            int unitDefense = zergs[randomNumber].getDefense();
            boolean unitFlyable = zergs[randomNumber].getFlyable();
            boolean unitAttackToFly = zergs[randomNumber].getAttackToFly();
          
            playerUnits.add(new Unit(unitName, unitRace, unitPower, unitDefense, unitFlyable, unitAttackToFly));
        }

        return playerUnits;
    }
}
