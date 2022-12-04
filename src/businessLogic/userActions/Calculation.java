package businessLogic.userActions;

import dataBase.Data;

import static intarface.Menu.dividingLine;
import static java.lang.System.out;

public abstract class Calculation extends Data {
    public static double compoundInterest(double initialContribution) {
        int regularcontribution = Integer.parseInt(getRegularСontributions());
        int age = Integer.parseInt(getAge());
        int pensionAge = (getRetirementAge() - age);
        for (int i = 1; i < pensionAge; i++) {
            initialContribution = initialContribution + regularcontribution;
            initialContribution = (initialContribution * (1.1));
            out.println(dividingLine + "\n" +
                    "|За " + i + " рік|" + "\n" +
                    dividingLine + "\n" +
                    "|" + Math.round(initialContribution) + "|");
        }
        return initialContribution;
    }
}
