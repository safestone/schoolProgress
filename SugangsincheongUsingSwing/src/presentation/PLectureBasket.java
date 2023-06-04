package presentation;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JPanel;

import valueObject.VLecture;

public class PLectureBasket extends JPanel{
	private Vector<VLecture> vLectureVector;

	public PLectureBasket() {
		this.vLectureVector = new Vector<VLecture>();
		this.setSize(600, 400);
		this.setBackground(Color.GREEN);
	}
	public void add(VLecture vLecture) {
		this.vLectureVector.add(vLecture);
	}

	public void show() {
		for(VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
	}

}
