
import java.util.*;
import java.util.Scanner;
import java.util.stream.Stream;



public class Hash {
	public static int[] getSliceOfArray(int[] arr,int start, int end) { 
			int[] slice = new int[end - start]; 
			for (int i = 0; i < slice.length; i++) { 
			slice[i] = arr[start + i]; 
			} 
			return slice; 
}  
	public static int[] nemeh(int[] arr, int[] mod) {
		int[] finalArr = new int[arr.length];
		int lalar=0;
		for(int i=0;i<arr.length;i++) {
			if(lalar>=mod.length) {
				lalar=0;
			}
			finalArr[i] = arr[i] + mod[lalar];
			lalar++;
		}
 		return finalArr;
	}

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int i;
        String name = "ADMINs";
        name = name.replaceAll("\\s+","");
        //		Scanner input = new Scanner(System. in );
        //		name=input.toString();
        int array1[] = new int[name.length()];
        int array2[] = new int[name.length()*name.length()];
        int array3[][] = new int[name.length()][name.length()];
        int module[]=new int [name.length()];
        int module2[]=new int [name.length()];
        
        int[] array1and2 = new int[100];
        for (int i1 = 0; i1 < name.length(); i1++) {
            array1[i1] = name.toCharArray()[i1];
            module[i1]=array1[i1]%name.length();
        }
        for(int q=1;q<name.length();q++) {
        for (int k = 0; k < name.length(); k++) {
            array3[q-1][k]=array1[k] + q;
        }
        
        }
        int s=0;
        for(int q=0;q<array1.length;q++) {
            for (int k = 0; k < name.length(); k++) {
            //if(q<name.length().)
            	array2[s]=array3[q][k];
            s++;
            }
        }
            System.arraycopy(array1, 0, array1and2, 0, array1.length);
            System.arraycopy(array2, 0, array1and2, array1.length, array2.length);
        
       int[] slice = getSliceOfArray(array1and2, 0, 32); 
        for (int k: slice) {
            System.out.print(k);
            System.out.print(" ");
        }
        System.out.print("\n");
        for (int k: module) {
            System.out.print(k);
            System.out.print(" ");
        }
        for (int ikc: module2) {
            System.out.print(ikc);
            System.out.print(" ");
        }
        String all = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int ascii1[] = new int[62];
        for (int p = 0; p < 62; p++) {
          ascii1[p] = all.toCharArray()[p];
        }
        System.out.print("\n");
        for (int ikc: ascii1) {
            System.out.print(ikc);
            System.out.print(" ");
        }
        
        int n, j = 0, k = 0;
        int odd[] = new int[31];
        int even[] = new int[31];
        for(int i1 = 0; i1 < 62; i1++)
        {
            if(ascii1[i1] % 2 != 0)
            {
                odd[j] = ascii1[i1];
                j++;
            }
            else
            {
                even[k] = ascii1[i1];
                k++;
            }
        }
        System.out.println("");
        System.out.print("Odd:");
            for(int i1 = 0;i1 < (j-1); i1++)
            {
                System.out.print(odd[i1]+" ");
            }
            System.out.print(odd[j-1]);
        System.out.println("");
        System.out.print("Even:");
            for(int i1 = 0; i1 < (k-1); i1++)
            {
                System.out.print(even[i1]+" ");
            }
        System.out.print(even[k-1]);
        
        module2 = nemeh(slice,module);
        char[] pizda= new char[module2.length];
        int a;
        for(int t=0;t<module2.length;t++) {
        	if(module2[t]%2==0) {
        		pizda[t]=(char) module2[t];
        	}
        	else {
        		a=module2[t]%10;
        		pizda[t]=(char)(a+48);
        	}
        }
        System.out.print("\n");
        for (char ikc: pizda) {
            System.out.print(ikc);
            System.out.print("");
        }
        System.out.print("\n");
        
        
    }
    
}