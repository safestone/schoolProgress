package control;

import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.VIndex;

public class CIndex {

	private MIndex mIndex;
	
	public CIndex() {
		this.mIndex = new MIndex();
	}
	
	public Vector<VIndex> getVIndexVector(String parentFileName) {
		Vector<VIndex> vIndexVector = this.mIndex.nextIndex(parentFileName);
		return vIndexVector;
	}

}
