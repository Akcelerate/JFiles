class j{
    static Scanner inp = new Scanner(System.in);
    static void jout(String s){
        System.out.print(s);
    }
    static void jout(int a){
        System.out.print(a);
    }
    static void jout(float a){
        System.out.print(a);
    }
    static void jout(double a){
        System.out.print(a);
    }
    static void blank(){
        System.out.print("");
    }
    static String jins(){
        return inp.next();
    }
    static int jini(){
        return inp.nextInt();
    }
    void jin(boolean a){
        a = inp.hasNext();
    }
}
