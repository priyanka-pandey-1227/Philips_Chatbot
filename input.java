import java.util.*;

public class input {
	String features[] = new String[8];

	public input() {
		// System.out.println("Hello");
		DefaultMessages dm = new DefaultMessages();
		Scanner sc = new Scanner(System.in);

		int choice[] = new int[8];

		for (int i = 3; i < 8; i++) {
			features[i] = "No";
		}

		// String greet = sc.next();

		SelectClassification: for (int i = 0; i < 1; i++) {
			{

				System.out.println(
						"What should be the classification of monitor? \n 1. Modular \n 2. Semi-modular \n 3. Preconfigured");
				choice[2] = sc.nextInt();
				switch (choice[2]) {
				case 1:
					features[2] = "Modular";
					
					break;
				case 2:
					features[2] = "Semi-modular";
					break;
				case 3:
					features[2] = "Preconfigured";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select the screen classification again.");
					continue SelectClassification;
				}

			}
		}

		SelectType: for (int i = 0; i < 1; i++) {
			System.out.println("What type of a monitor do you want?\n 1. Touchscreen 2. Non-touchscreen");
			choice[0] = sc.nextInt();
			switch (choice[0]) {
			case 1:
				features[0] = "Touchscreen";
				break;
			case 2:
				features[0] = "Non-touchscreen";
				break;
			default:
				i = -1;
				System.out.println("Invalid input. Please select the screen type again.");
				continue SelectType;
			}

		}

		SelectSize: for (int i = 0; i < 1; i++) {
			{
				System.out.println("What is the screen size?\n 1. 10 inches \n 2. 12 inches \n 3. 15 inches \n 4. 17 inches \n 5. 19 inches \n");

				choice[1] = sc.nextInt();
				switch (choice[1]) {
				case 1:
					features[1] = "10";
					break;
				case 2:
					features[1] = "12";
					break;
				case 3:
					features[1] = "15";
					break;
				case 4:
					features[1] = "17";
					break;
				case 5:
					features[1] = "19";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select the screen size again.");
					continue SelectSize;
				}

			}
		}

		if (choice[2] == 1) {

			SelectECG: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the ECG module?\n 1. Yes \n 2. No\n");
				choice[3] = sc.nextInt();
				switch (choice[3]) {
				case 1:
					features[3] = "Yes";
					break;
				case 2:
					features[3] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectECG;
				}

			}

			SelectSPO2: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the SPO2 module?\n 1. Yes \n 2. No\n");
				choice[4] = sc.nextInt();
				switch (choice[4]) {
				case 1:
					features[4] = "Yes";
					break;
				case 2:
					features[4] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectSPO2;
				}

			}

			SelectNIBP: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the NIBP module?\n 1. Yes \n 2. No\n");
				choice[5] = sc.nextInt();
				switch (choice[5]) {
				case 1:
					features[5] = "Yes";
					break;
				case 2:
					features[5] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectNIBP;
				}

			}

			SelectResp: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the Respiration module?\n 1. Yes \n 2. No\n");
				choice[6] = sc.nextInt();
				switch (choice[6]) {
				case 1:
					features[6] = "Yes";
					break;
				case 2:
					features[6] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectResp;
				}

			}

			SelectTemperature: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the Temperature module?\n 1. Yes \n 2. No\n");
				choice[7] = sc.nextInt();
				switch (choice[7]) {
				case 1:
					features[7] = "Yes";
					break;
				case 2:
					features[7] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectTemperature;
				}

			}

		}

		if (choice[2] == 2) {
			SelectECG: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the ECG module?\n 1. Yes \n 2. No\n");
				choice[3] = sc.nextInt();
				switch (choice[3]) {
				case 1:
					features[3] = "Yes";
					break;
				case 2:
					features[3] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectECG;
				}

			}

			SelectSPO2: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the SPO2 module?\n 1. Yes \n 2. No\n");
				choice[4] = sc.nextInt();
				switch (choice[4]) {
				case 1:
					features[4] = "Yes";
					break;
				case 2:
					features[4] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectSPO2;
				}

			}

			SelectNIBP: for (int i = 0; i < 1; i++) {
				System.out.println("Do you want to have the NIBP module?\n 1. Yes \n 2. No\n");
				choice[5] = sc.nextInt();
				switch (choice[5]) {
				case 1:
					features[5] = "Yes";
					break;
				case 2:
					features[5] = "No";
					break;
				default:
					i = -1;
					System.out.println("Invalid input. Please select your choice again.");
					continue SelectNIBP;
				}

			}

		}
	}

}
