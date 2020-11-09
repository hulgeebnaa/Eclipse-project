package ZayaBagsh;

public class Mainn {
	String plaintext = "ATTACK AT DAWN ";
	String key = "HURLEE GUIA";
	String ciphertext;
	
	
	public int keyToNumb() {
		int keyNumba = key.replace(" ", "").length();
		char isVowels = key.charAt(key.length()-1)  ;
		if( isVowels == 'a' || isVowels == 'e' || isVowels == 'i' || isVowels == 'o' || isVowels == 'u') {
			return keyNumba;
		}
		return -keyNumba;
	}

	public String Encrailfence() {
		int railkey = 2 ;
        String encrypText = "";
		char[][] rail = new char[railkey][plaintext.length()];
		 for (int i=0; i < railkey; i++) {
			   for (int j = 0; j < plaintext.length(); j++) {
				   rail[i][j] = '.'; 
			   } 
		 }
		  int row = 0;
	        int check = 0;
	        for (int i = 0; i < plaintext.length(); i++) {
	            if (check == 0){
	                rail[row][i] = plaintext.charAt(i);
	                row++;
	                if (row == railkey){
	                    check = 1;
	                    row--;
	                }
	            } else if(check == 1){
	                row--;
	                rail[row][i] = plaintext.charAt(i);
	                if (row == 0){
	                    check = 0;
	                    row = 1;
	                }
	            } 
	        }
	        for (int i = 0; i < railkey; i++) {
	            for (int j = 0; j < plaintext.length(); j++) {
	                encrypText += rail[i][j];
	            }
	        }
	        encrypText = encrypText.replaceAll("\\.","");
		      	
		return encrypText;
	}
	public String EncceaserCipher(String msg,int key) {
        String encrypMsg = "";
        for (int i = 0; i < msg.length(); i++) {
            if ((int)msg.charAt(i) == 32){
                encrypMsg += (char)32; 

            } else if ((int)msg.charAt(i) + key  > 122){
                int temp = ((int)msg.charAt(i) + key) - 122;
                encrypMsg += (char)(96 + temp);

            } else if ((int)msg.charAt(i) + key > 90 && (int)msg.charAt(i) < 96){
                int temp = ((int)msg.charAt(i) + key) - 90;
                encrypMsg += (char)(64+temp);

            } else {
                encrypMsg += (char)((int)msg.charAt(i) + key);

            }
        } 
        return encrypMsg;
	}
	public String EncryptionDisplay() {
        String msg = Encrailfence();
        int key = keyToNumb();
		return EncceaserCipher(msg,key);
	}
	public String Decrailfence(String decText) {
		int charNumba = decText.length();
		char[] arr1;
		char[] arr2;
		char[] arrDec;
		if(charNumba%2==0) {
			arr1 = new char[charNumba/2];
			arr2 = new char[charNumba-(charNumba/2)];
			int x = 0;
			for(int i=0;i<charNumba/2;i++) {
				arr1[i] = decText.charAt(i);
				x++;
			}
			for(int j=0;j<charNumba-(charNumba/2);j++) {
				arr2[j] = decText.charAt(x);
				x++;
			}
		}
		else {
			arr1 = new char[(charNumba/2)+1];
			arr2 = new char[charNumba-((charNumba/2)+1)];
			int x = 0;
			for(int i=0;i<(charNumba/2)+1;i++) {
				arr1[i] = decText.charAt(i);
				x++;
			}
			for(int j=0;j<charNumba-((charNumba/2)+1);j++) {
				arr2[j] = decText.charAt(x);
				x++;
			}
		}
		
		arrDec = new char[charNumba];
		int x=0;
		int s=0;
		for(int i=0;i<arrDec.length;i++) {
			if(i%2==0) {
				x=i/2;
				arrDec[i] = arr1[x];
				s=x;
			}
			else {
				arrDec[i] = arr2[s];
			}
			}
		return toString(arrDec);
	}
	public static String toString(char[] a) 
    { 
        String string = new String(a); 
        return string; 
    } 
	
	
	
	public void encryption(){
        ciphertext = EncryptionDisplay();
        System.out.println("Plaintext : "+ plaintext);
        System.out.println("KEY : "+ key);
		System.out.println("Encrypted : -> Ciphertext : "+ ciphertext);
	}
	public void decryption(){
		int DecKey = keyToNumb()*(-1);
		String decCeaser = EncceaserCipher(ciphertext, DecKey);
		String DecryptedCipher = Decrailfence(decCeaser);
		System.out.println("KEY : "+ key);
		System.out.println("Decrypted : "+ DecryptedCipher);
	}
	public static void main(String[] args) {
		Mainn obj = new Mainn();
		obj.encryption();
		obj.decryption();
	}
}
