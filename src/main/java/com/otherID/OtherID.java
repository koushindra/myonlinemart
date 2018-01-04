package com.otherID;

import java.util.Random;

public class OtherID 
{
	public String genID1() 
	{
		Random random = new Random();
		int length = 8;
		StringBuffer captchaStringBuffer = new StringBuffer();
		
		for (int i = 0; i < length; i++) 
		{
			int captchaNumber = Math.abs(random.nextInt()) % 60;
			int charNumber = 0;
			if (captchaNumber < 26) 
			{
				charNumber = 65 + captchaNumber;
			}
			else if (captchaNumber < 52)
			{
				charNumber = 97 + (captchaNumber - 26);
			}
			else 
			{
				charNumber = 48 + (captchaNumber - 52);
			}
				captchaStringBuffer.append((char)charNumber);
		  }
		 
		  return captchaStringBuffer.toString();
		 } 

	
	
	
		private static final String CHAR_LIST =
	        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    private static final int RANDOM_STRING_LENGTH =8;

	    public String genID2(){
	         
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }
	  
	  
	  private int getRandomNumber() 
	  {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
		  
	  public String genratedID()
	  {
		  String genrate = genID1()+2*8*11/9%24+genID2()+2/33+11;
		  return genrate;
	  }
}
