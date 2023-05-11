package control;

import java.util.Vector;

import model.MLecture;
import valueObject.VIndex;

public class CLecture {
	private MLecture mLecture;
	
	public CLecture() {
		this.mLecture = new MLecture();
	}
	public Vector<VIndex> getTerminal(String string) {
		Vector<VIndex> vLectureVector = this.mLecture.terminal(string);
		return vLectureVector;
	}

}
