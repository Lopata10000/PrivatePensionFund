package businessLogic.authentication;

import dataBase.Data;

public abstract class Check {
      //для унаслідування хешування
      static void inputData() {
            Data.Encryption.encryptionPassword();
            Data.Encryption.encryptionGmail();
      }
}
