package UtilityPackage;
public class Utility{
    private String password;

    public static boolean isPasswordValid(String password){
        int firstConditional=0;
        int secondCondition=0;
        for( int i=0;i<password.length();i++) {
            char character=password.charAt(i);
            if (character>= '0' && character <= '9') {
                firstConditional=1;
                break;
            }}

        for(int j=0;j<password.length();j++) {
            char character1=password.charAt(j);
            if (Character.isLetter(character1)) {
                secondCondition=1;
                break;
            }}
        if(secondCondition==1&&firstConditional==1){
            return true;
        }
        else return false;
    }


      public boolean isEmailValid(String email){
                       if(Pattern.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", email)){
                        return true;
                       }
    else return false;

}
}
