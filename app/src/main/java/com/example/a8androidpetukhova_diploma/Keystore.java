package com.example.a8androidpetukhova_diploma;

public interface Keystore {

    boolean hasPin();

    boolean checkPin(String pin);

    void saveNew(String pin);


//    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//    keyStore.load(null,null);
//    String alias = "EntityAlias";
//    java.security.cert.Certificate[] chain = {certificate};
//        keyStore.setKeyEntry(alias,keyPair.getPrivate(),"keyPassword".
//
//    toCharArray(),chain);
//    // Загрузка содержимого (Private Key + Certificate)
//    Key key = keyStore.getKey(alias, "keyPassword".toCharArray());
//    Certificate[] certificateChain = keyStore.getCertificateChain(alias);
//    // Сохранение KeyStore на диск
//    File file = File.createTempFile("security_", ".ks");
//        System.out.println(file.getAbsolutePath());
//        try(
//    FileOutputStream fos = new FileOutputStream(file))
//
//    {
//        keyStore.store(fos, "keyStorePassword".toCharArray());
//    }
}