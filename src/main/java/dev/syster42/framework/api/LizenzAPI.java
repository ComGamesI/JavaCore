package dev.syster42.framework.api;

public class LizenzAPI {


    String licencekey;
    int length = 23;
    String[] key = new String[length];

    public LizenzAPI(){}

    public LizenzAPI(String lizenz){
        this.licencekey = lizenz;
    }

    public LizenzAPI(LizenzAPI lizenz){
        this.key = lizenz.key;
    }

    public String createKey(int lengthKey, int sign, String smallLetters, String bigLetters, String specialssigns){
        String[] key = new String[lengthKey];
        String whole = smallLetters.toLowerCase() + bigLetters.toUpperCase() + specialssigns;
        this.setLicencekey("");
        System.out.print("Erstellter Key: ");
        for (int i = 0; i < lengthKey; i++) {
            int rest = i%sign;
            if (rest == 0) {
                if (i != 0) {
                    key[i] = "-";
                } else {
                    int random = (int) Math.floor((Math.random() * (whole.length() - 1) + 1));
                    key[i] = String.valueOf(whole.charAt(random));
                }
            } else {
                int random = (int) Math.floor((Math.random() * (whole.length() - 1) + 1));
                key[i] = String.valueOf(whole.charAt(random));
            }
            this.licencekey = this.licencekey + key[i];
            System.out.print(key[i]);
        }

        System.out.println("\nErstellter Key: " + this.getLicenceKey());
        return licencekey;
    }

    public void setLicencekey(String licencekey) {
        this.licencekey = licencekey;
    }

    public String getLicenceKey(){
        return this.licencekey;
    }

    public void changeLicenceKey(){}

    public void deleteLicenceKey(){}

}
