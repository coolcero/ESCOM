/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradogrosnfel2;


public class Gronsfel {
    String text;
    String keyword;
    String matrix[] = { "CDEFGHIJKLMNOPQRSTUVWXYZAB",
                        "DEFGHIJKLMNOPQRSTUVWXYZABC",
                        "FGHIJKLMNOPQRSTUVWXYZABCDE",
                        "HIJKLMNOPQRSTUVWXYZABCDEFG",
                        "LMNOPQRSTUVWXYZABCDEFGHIJK",
                        "NOPQRSTUVWXYZABCDEFGHIJKLM",
                        "RSTUVWXYZABCDEFGHIJKLMNOPQ",
                        "TUVWXYZABCDEFGHIJKLMNOPQRS",
                        "XYZABCDEFGHIJKLMNOPQRSTUVW",
                        "CDEFGHIJKLMNOPQRSTUVWXYZAB",
                        };
    String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //Constructor
    public Gronsfel(String text, String keyword){
        this.text = text;
        this.keyword = keyword;
    }
    //Constructor vacio
    public Gronsfel(){
    }
    //set el texto a cifrar/descifrar
    public void setText(String text){
        this.text = text;
    }
    //set la clave
    public void setKey(String key){
        this.keyword = key;
    }
    //limpia el texto riginal de espacios en blanco y las convierte en mayÃƒÂºsculas
    public String cleanText(){
        return this.text.toUpperCase().replace(" ", "");
    }
    //crea el array de tamaÃƒÂ±o del texto con la clave ingresada
    private int[] fillKey(String newText, String Keyword){
        int newkey[] = new int[newText.length()];
        int times = newText.length()/this.keyword.length();
        int module = newText.length()%this.keyword.length();
        int index = 0;
        //crea la nueva clave con el tamaÃƒÂ±o del texto a cifrar.
        for (int i=0; i < times; i++){
            for(int j = 0; j < this.keyword.length(); j++){
                newkey[index] = Character.getNumericValue(this.keyword.charAt(j));
                index += 1;
            }            
        }
        for (int i=0 ; i < module; i++){
            newkey[index] = Character.getNumericValue(this.keyword.charAt(i));
            index += 1;
        }
        return newkey;
    }

    //Regresa el caracter descifrado
    private char getDecryptChar(char characterTo, int key){
        int indexChar = matrix[key].indexOf(characterTo); 
        return abecedario.charAt(indexChar);        
    }

    //Regresa el mensaje descifrado
    public String decrypt(){
        String newText =  cleanText();
        int newkey[] = new int[newText.length()];
        newkey = fillKey(newText, this.keyword);
        char[] decryptChar= new char[newText.length()];

        for( int i=0; i<newText.length(); i++){
            decryptChar[i] = getDecryptChar(newText.charAt(i), newkey[i]);
        }

        String str = String.valueOf(decryptChar);

        return str;
    }

    //regresa el caracter cifrado
    private char getEncryptChar(char characterTo, int key){
        int indexChar = abecedario.indexOf(characterTo); 
        return matrix[key].charAt(indexChar);
    }

    //regresa el mensaje cifrado
    public String encrypt(){
        
        if( this.text.length() < this.keyword.length()){
            return "La clave es mÃƒÂ¡s grande que el texto, por favor ingrese una clave menor o igual al tamaÃƒÂ±o del texto a cifrar.";
        }
        //limpia el texto riginal de espacios en blanco y las convierte en mayÃƒÂºsculas
        String newText =  cleanText();
        
        int newkey[] = new int[newText.length()];
        newkey = fillKey(newText, this.keyword);
        char[] encriptedChar= new char[newText.length()];

        for( int i=0; i<newText.length(); i++){
            encriptedChar[i] = getEncryptChar(newText.charAt(i), newkey[i]);
        }

        Bitacora bit = new Bitacora();
        String descripcion ="El mesaje Encriptado es:";
        bit.enviarBitacora("Encritar", descripcion);
        String str = String.valueOf(encriptedChar);
        

        return str;
    }
}