package com.kovalivlesia.lab3.battle;

import com.kovalivlesia.lab3.models.Droid;
import com.kovalivlesia.lab3.models.interfaces.Health;
import com.kovalivlesia.lab3.models.interfaces.Kill;
import com.kovalivlesia.lab3.models.interfaces.Regenerate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BattleArena {
    public static BattleStyle battleStyle1;
    public static BattleStyle battleStyle2;

    public static void fight(Droid droid1, Droid droid2) {
        while (droid1.isAlive() && droid2.isAlive()) {
            Action action = selectAction(droid1);
            if (action == Action.Health) {
                doAction(droid1, droid1, Action.Health);
            } else {
                doAction(droid1, droid2, action);
            }
            action = selectAction(droid2);
            if (action == Action.Health) {
                doAction(droid2, droid2, Action.Health);
            } else {
                doAction(droid2, droid1, action);
            }
        }

        System.out.println("**************************   Winner - " + (droid1.isAlive() ? droid1.toString() : droid2.toString()) + "   **************************");
        System.out.println("**************************   Loser  - " + (droid2.isAlive() ? droid1.toString() : droid2.toString()) + "   **************************");
    }

    public static void fight(List<Droid> droids1, List<Droid> droids2) {
        while (teamIsAlive(droids1) && teamIsAlive(droids2)) {
            Action action;
            for (Droid droid : droids1) {
                if (droid.isAlive()) {

                    action = selectAction(droid);
                    if (action == Action.Health) {
                        doAction(droid, selectDroid(droids1, battleStyle1), Action.Health);
                    } else {
                        doAction(droid, selectDroid(droids2, battleStyle1), action);
                    }
                }
            }
            for (Droid droid : droids2) {
                if (droid.isAlive()) {
                    action = selectAction(droid);
                    if (action == Action.Health) {
                        doAction(droid, selectDroid(droids2, battleStyle2), Action.Health);
                    } else {
                        doAction(droid, selectDroid(droids1, battleStyle2), action);
                    }
                }
            }
        }

        System.out.println("**************************   Winners - " + (teamIsAlive(droids1) ? droids1.toString() : droids2.toString()));
        System.out.println("**************************   Losers  - " + (!teamIsAlive(droids1) ? droids1.toString() : droids2.toString()));
    }

    private static Droid selectDroid(List<Droid> droids, BattleStyle battleStyle) {
        droids = droids.stream()
                .filter(Droid::isAlive)
                .collect(Collectors.toList());
        switch (battleStyle) {
            case Random:
                Random rand = new Random();
                return droids.size() > 0 ? droids.get(rand.nextInt(droids.size())) : null;
            case SmallestHealth:
                if (droids.isEmpty()) {
                    Droid result = droids.get(0);
                    for (Droid droid : droids) {
                        if (droid.getHealth() < result.getHealth()) {
                            result = droid;
                        }
                    }
                    return result;
                }
                return null;
        }
        return droids.get(0);
    }

    private static boolean teamIsAlive(List<Droid> droids) {
        for (Droid droid : droids) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private static void doAction(Droid droid, Droid droid2, Action action) {
        if (droid2 == null) {
            return;
        }
        switch (action) {
            case Battle:
                droid.battle(droid2);
                return;
            case Health:
                Health health = (Health) droid;
                health.health(droid2);
                return;
            case Kill:
                Kill kill = (Kill) droid;
                kill.kill(droid2);
                return;
            case Regenerate:
                Regenerate regenerate = (Regenerate) droid;
                regenerate.regenerate(droid2);
        }
    }

    private static Action selectAction(Droid droid) {
        System.out.println("Please select action for droid - " + droid.toString());
        System.out.println("1 - battle");
        if (droid.getEnergy() > 0) {
            if (droid instanceof Health) {
                System.out.println("2 - health");
            }
            if (droid instanceof Kill) {
                System.out.println("3 - kill");
            }
            if (droid instanceof Regenerate) {
                System.out.println("4 - regenerate");
            }
        }

        System.out.print("Input number of action: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int input = Integer.parseInt(bufferedReader.readLine());
            switch (input) {
                case 1:
                    return Action.Battle;
                case 2:
                    return Action.Health;
                case 3:
                    return Action.Kill;
                case 4:
                    return Action.Regenerate;
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect Input");
            return selectAction(droid);
        }
    }

    public static void setBattleStyle1(BattleStyle battleStyle1) {
        BattleArena.battleStyle1 = battleStyle1;
    }

    public static void setBattleStyle2(BattleStyle battleStyle2) {
        BattleArena.battleStyle2 = battleStyle2;
    }
}