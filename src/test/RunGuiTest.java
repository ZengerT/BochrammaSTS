package test;

import java.awt.EventQueue;
import control.Controller;

public class RunGuiTest {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					new Controller();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
