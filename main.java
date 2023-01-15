// Objeto compartilhado
class SharedData {

    public synchronized static void display(String str) {
        for (char c : str.toCharArray())
            System.out.print(c);
        System.out.println();
    }
}

// Classe da primeira thread
class MyT1 implements Runnable {

    private String str = "Ola mundo!";

    @Override
    public void run() {
        SharedData.display(str);
    }
}

// Classe da segunda thread
class MyT2 implements Runnable {

    private String str = "Bem-vindos";

    @Override
    public void run() {
        SharedData.display(str);
    }
}

public class main {

    public static void main(String[] args) {

        // Criando threads
        Thread t1 = new Thread(new MyT1());
        Thread t2 = new Thread(new MyT2());

        // Rodando threads
        t1.start();
        t2.start();
    }
}