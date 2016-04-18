package ir.ac.aut.ceit.ceit93bot;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Server server = new Server();
		while (true) {
			System.out.println(server.getUpdates());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
