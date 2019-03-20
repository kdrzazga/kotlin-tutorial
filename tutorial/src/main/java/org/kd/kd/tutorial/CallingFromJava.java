package org.kd.kd.tutorial;

public class CallingFromJava {

    public static void main(String[] args) {
        var tomAraya = new TomAraya("Trash Metal");
        tomAraya.makeSound();

        FunctionsKt.printMessage("Ala ma kota");
    }
}
