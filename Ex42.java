package loops;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Ex42 {

	public static void main(String[] args) {

		ArrayList<String> woman = new ArrayList<>();
		
		ArrayList<String> man = new ArrayList<>();
		
		ArrayList<Integer> yearExperienceMan = new ArrayList<>();
		
		ArrayList<Integer> yearExperienceWoman = new ArrayList<>();
		
		ArrayList<Integer> womanAge = new ArrayList<>();
		
		ArrayList<Integer> manAge = new ArrayList<>();

		String sex, userAnswer;
		
		int yearOfExperience, age, count = 0;
		
		Double arithmeticMeanMan = 0.0, arithmeticMeanWoman = 0.0;

		do {
			sex = JOptionPane.showInputDialog(null, "Input sex: ");

			sex = sex.toLowerCase().trim();

			if (sex.equals("man")) {

				man.add(sex);

				yearOfExperience = Integer.parseInt(JOptionPane.showInputDialog(null, "Input year's experience man: "));

				age = Integer.parseInt(JOptionPane.showInputDialog(null, "Input man age: "));

				if (age < 0) {

					JOptionPane.showMessageDialog(null, "Please input a positive value!!");
				} else {

					manAge.add(age);
				}

				if (yearOfExperience > 0) {

					yearExperienceMan.add(yearOfExperience);
				}

			} else if (sex.equals("woman")) {

				woman.add(sex);

				yearOfExperience = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Input year's experience woman: "));

				age = Integer.parseInt(JOptionPane.showInputDialog(null, "Input woman age: "));

				if (age < 0) {

					JOptionPane.showMessageDialog(null, "Please input a positive value!!");

				} else {

					womanAge.add(age);

					Collections.sort(womanAge);
				}

				if (yearOfExperience > 0) {

					yearExperienceWoman.add(yearOfExperience);
				}
			}

			userAnswer = JOptionPane.showInputDialog(null, "Do You Want To Continue??");

			userAnswer = userAnswer.toLowerCase().trim();

		} while (userAnswer.equals("yes"));

		for (int i = 0; i < yearExperienceMan.size(); i++) {

			arithmeticMeanMan += yearExperienceMan.get(i);
		}

		for (int i = 0; i < yearExperienceWoman.size(); i++) {

			arithmeticMeanWoman += yearExperienceWoman.get(i);
		}

		for (int i = 0; i < manAge.size(); i++) {

			if (manAge.get(i) >= 35 && manAge.get(i) <= 45) {

				count++;
			}
		}

		if (!yearExperienceMan.isEmpty()) {

			arithmeticMeanMan /= yearExperienceMan.size();

		}

		if (!yearExperienceWoman.isEmpty()) {

			arithmeticMeanWoman /= yearExperienceWoman.size();
		}

		JOptionPane.showMessageDialog(null,
				"Number of Man: " + man.size() + "\nArithmetic Mean for man experience: " + arithmeticMeanMan
						+ "\nPercentage of men between 35 and 45 years old: " + ((double) count / manAge.size()) * 100
						+ "%");

		if (!womanAge.isEmpty()) {

			JOptionPane.showMessageDialog(null,
					"Number of Woman: " + woman.size() + "\nArithmetic Mean for woman experience: "
							+ arithmeticMeanWoman + "\nThe youngest woman is aged: " + womanAge.get(0));
		} else {

			JOptionPane.showMessageDialog(null, "No women were registered.");
		}
	}
}
