package businessLogic.authentication;

import dataBase.Data;

public abstract class Check {
      static void inputData() {
            Data.Encryption.encryptionPassword();
            Data.Encryption.encryptionGmail();
      }
}
