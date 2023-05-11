package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {
	private PLectureSelection pLectureSelection;
	private PBasket pBasket;
	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pBasket = new PBasket();
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
		System.out.println(vLecture.getName());
		
		PBasket.add();
	}
}


