

public class Main implements Runnable {
    private String message;

    public Main(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
                Thread.sleep(200); // Adjust the delay as needed
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] messages = {
                "Welcome To Cstad\n",
                "======================================\n",
                "Don't give up this opportunity, do your best!\n",
                "++++++++++++++++++++++++++++++++++++++\n",
                "Downloading...............100% Completed\n"};

        for (String message : messages) {
            Thread thread = new Thread(new Main(message));
            thread.start();
            try {
                thread.join(); // Wait for the thread to finish before starting the next one
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}