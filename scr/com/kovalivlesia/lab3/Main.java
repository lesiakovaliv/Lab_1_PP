package com.kovalivlesia.lab3;

import com.kovalivlesia.lab3.battle.BattleArena;
import com.kovalivlesia.lab3.battle.BattleStyle;
import com.kovalivlesia.lab3.models.Droid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final DroidRepository droidRepository = new DroidRepository();

    public static void main(String[] args) {
        MainAction mainAction = selectAction();
        while (mainAction != MainAction.Exit) {
            switch (mainAction) {
                case Add:
                    droidRepository.addDroid();
                    break;
                case Show:
                    droidRepository.printDroids();
                    break;
                case Fight_1_1:
                    System.out.println("Select first droid: ");
                    Droid droid1 = droidRepository.selectDroid();

                    System.out.println("Select second droid: ");
                    Droid droid2 = droidRepository.selectDroid();

                    BattleArena.fight(droid1, droid2);
                    break;
                case Fight_team_team:
                    List<Droid> droids1 = selectTeam("first");
                    System.out.println("Select battle style for first team");
                    BattleArena.setBattleStyle1(selectBattleStyle());

                    List<Droid> droids2 = selectTeam("second");
                    System.out.println("Select battle style for second team");
                    BattleArena.setBattleStyle2(selectBattleStyle());

                    BattleArena.fight(droids1, droids2);
                    break;
            }
            mainAction = selectAction();
        }
    }

    private static MainAction selectAction() {
        System.out.println("1 - Add");
        System.out.println("2 - Show");
        System.out.println("3 - Fight 1 * 1");
        System.out.println("4 - Fight Team * Team");
        System.out.println("5 - Exit");

        System.out.print("Select number of action: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int index = Integer.parseInt(bufferedReader.readLine());
            switch (index) {
                case 1:
                    return MainAction.Add;
                case 2:
                    return MainAction.Show;
                case 3:
                    return MainAction.Fight_1_1;
                case 4:
                    return MainAction.Fight_team_team;
                case 5:
                    return MainAction.Exit;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
            return selectAction();
        }
    }

    private static List<Droid> selectTeam(String teamName) {
        List<Droid> droids = new ArrayList<>();

        System.out.println("Select droid to " + teamName + " command (0 - exit)");
        Droid droid = droidRepository.selectDroid();
        while (droid != null) {
            droids.add(droid);
            System.out.println("Select droid to " + teamName + " command (0 - exit)");
            droid = droidRepository.selectDroid();
        }

        return droids;
    }

    private static BattleStyle selectBattleStyle() {
        System.out.println("1 - Smallest health");
        System.out.println("2 - Random");

        System.out.print("Select number of battle style: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int index = Integer.parseInt(bufferedReader.readLine());
            switch (index) {
                case 1:
                    return BattleStyle.SmallestHealth;
                case 2:
                    return BattleStyle.Random;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect input");
            return selectBattleStyle();
        }
    }
}
