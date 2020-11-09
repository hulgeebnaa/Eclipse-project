public class EncryptDecryptAlgo {
private String plaintext;
private String key;
char[][] alphabets = new char[26][2];
int[] keyInt = new int[key.replace(" ", "").length()]; // key-d hargalzah too-g


	public EncryptDecryptAlgo(String plaintext, String key){
		this.plaintext = plaintext;
		this.key = key;
	}
	public int keyToNumb() {
		int keyNumba = key.replace(" ", "").length();
		char isVowels = key.charAt(key.length()-1)  ;
		if( isVowels == 'a' || isVowels == 'e' || isVowels == 'i' || isVowels == 'o' || isVowels == 'u') {
			return keyNumba;
		}
		return -keyNumba;
	}
	
	
	public void alphabetNumeric() {
		String strB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String strS = "abcdefghijklmnopqrstuvwxyz";
		char[] chB  = strB.toCharArray();
		char[] chS  = strS.toCharArray();
		for(char b : chB){
		for(int i=0; i< strB.length() ;i++) {
					alphabets[i][0] = b;
			}
		}
		for(char s : chS){
			for(int i=0; i< strS.length() ;i++) {
						alphabets[i][1] = s;
				}
			}
	}
	
	
	public void keyToNumbaKey() {
		alphabetNumeric();
		char[] keyChar = key.replace(" ", "").toCharArray(); //key-iin useg salgana	
		for(int j=0;j< keyInt.length; j++) {
		for(int i=0;i<alphabets.length;i++) {
               if((keyChar[j]==alphabets[i][0])||(keyChar[j]==alphabets[i][1])) {
            	   keyInt[j] = i+1;
               }
		} 
	}
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
	public String EncceaserCipherDisplay() { // 3dahi uildeliin ur dun
        String msg = Encrailfence();
        int key = keyToNumb();
		return EncceaserCipher(msg,key);
	}
	
	
	public void encryption(){
		
		char[] lastChar = EncceaserCipherDisplay().toCharArray();
		char[] cipherChar = new char[lastChar.length];
		for(int j=0;j<lastChar.length;j++) {
        for(int i=0;i< key.replace(" ", "").length();i++) {
        	cipherChar[j] = EncceaserCipher(String.valueOf(lastChar[j]),keyInt[i]).charAt(0);
        }
		}
		System.out.println(cipherChar.toString());
	}
	
	
	
    public void decryption(){
		
	}
	
}