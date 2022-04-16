package de.fantasypixel.warp.utils;

public class Constants {

    public final String prefix;
    public final String noPerms;
    public final String noMoney;
    public final String wrongArgs;
    public final String playerCMD;
    public final String consoleCMD;
    public final String playerOffline;
    public final String internError;
    public final String errorConsole;
    public final String cooldown;

    public Constants() {
        prefix = "§5§lRPG §8» ";
        noPerms = prefix + "§cDu hast nicht die nötigen Berechtigungen!";
        noMoney = prefix + "§cDu kannst dir das nicht leisten!";
        wrongArgs = prefix + "§cDie angegebenen Argumente sind nicht gültig!";
        playerCMD = prefix + "§cDieser Befehl ist nur für Spieler zugänglich!";
        consoleCMD = prefix + "§cDieser Befehl ist nicht für Spieler zugänglich!";
        playerOffline = prefix + "§cDieser Spieler ist nicht auf dem Server!";
        internError = prefix + "§4Es gab einen internen Fehler im System!\n" + prefix + "§4Bitte verständige das Team!";
        errorConsole = "ERROR | Ein Fehler ist aufgetreten! | FehlerSource: ";
        cooldown = prefix + "§7Bitte warte einen Moment!";
    }

}
