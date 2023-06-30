package com.driver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    private static double minbalance=5000;
    public CurrentAccount(String name, double balance,String tradeLicenseId) throws Exception {
        super(name,balance,minbalance);
        if(super.getBalance()<minbalance){
            throw new RuntimeException("Account cant be created");
        }
        this.tradeLicenseId=tradeLicenseId;
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

   }
  public static boolean  checkValid(String id){
        for(int i=0;i<id.length()-1;i++){
            if(id.charAt(i)==id.charAt(i+1)){
                return false;
            }
        }
        return true;
  }


    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(checkValid(this.tradeLicenseId)){
            return;
        }
        Map<Character,Integer> freq=new HashMap<>();
        boolean isvalid=true;
        boolean isodd=true;
        String idtoValidate=this.tradeLicenseId;
        int len=idtoValidate.length();
        if(idtoValidate.length()%2==0){
            isodd=false;
        }
        for(int i=0;i<idtoValidate.length();i++){
            freq.put(idtoValidate.charAt(i),freq.getOrDefault(idtoValidate.charAt(i),0));
            if((isodd && freq.get(idtoValidate.charAt(i))>((len+1)/2)) ||(isodd==false&& freq.get(idtoValidate.charAt(i))>(len/2))){
                throw new RuntimeException("Valid License can not be generated");
            }
        }
        char arr[]=new char[len];
        Arrays.fill(arr,'@');
        for(char key:freq.keySet()){
            char toinsert=key;
            int point=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]!='@'){
                    point=i;
                    break;
                }
            }
            for(int i=point;i<len;i+=2){
                arr[i]=key;
            }
        }
        this.tradeLicenseId=new String(arr);
    }

}
