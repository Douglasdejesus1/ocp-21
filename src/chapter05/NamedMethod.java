package chapter05;

class NamedMethod {
    public void
    jog1() {
    }

    // public void 2jog() {}   // DOES NOT COMPILE BECAUSE METHOD NAME CANNOT START WITH A NUMBER
    //public void void() {}   // DOES NOT COMPILE BECAUSE VOID IS A KEYWORD
    public void Jog_$() {
    }
    // public _() {}           // DOES NOT COMPILE BECAUSE METHOD NAME CANNOT BE A UNDERSCORE
    // public void() {}        // DOES NOT COMPILE BECAUSE METHOD NAME CANNOT BE EMPTY
   /*public static void main(String[] args) {
       NamedMethodException namedMethodException = new NamedMethodException(); // This is a valid statement, but it does not cause a compilation error because it is not a method declaration. It is an instance variable decl
       namedMethodException.main(new String[]{"car"});
   }*/

}
