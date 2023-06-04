package presentation;

import java.awt.Color;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection extends JPanel {
	private CIndex cIndex;
	private CLecture CLecture;
	
	JLabel label;
	
	public PLectureSelection() {
		this.cIndex = new CIndex();
		this.CLecture = new CLecture();
		this.setSize(600, 400);
		this.setBackground(Color.GRAY);
		label = new JLabel("강좌 선택 페이지입니다");
		this.add(label);
	}
	
	private String selectIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message);
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector("data/"+fileName+".txt");
		for(VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName());	
		}
		if((vIndexVector.get(0).getCode() % 10) == 0) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			String selectedFileName = vIndexVector.get(selection % 10).getFileName();
			return selectedFileName;
		} else if ((vIndexVector.get(0).getCode() % 10) == 1) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			String selectedFileName = vIndexVector.get((selection % 10) - 1).getFileName();
			return selectedFileName;
		}
		return null;

	}

	private VLecture terminal(String message, String fileName, Scanner keyboard) {
		System.out.println(message);
		Vector<VLecture> vLectureVector = CLecture.getTerminal("data/"+fileName+".txt");
		for(int i = 0; i < vLectureVector.size(); i++) { 
			System.out.print(vLectureVector.get(i).getCode() + " ");
			System.out.print(vLectureVector.get(i).getName() + " ");
			System.out.print(vLectureVector.get(i).getCredit() + " ");
			System.out.print(vLectureVector.get(i).getTime() + " ");
			System.out.print(vLectureVector.get(i).getProfessor() + "\n");
		}
		if((vLectureVector.get(0).getCode() % 10) == 0) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			VLecture vLecture = vLectureVector.get(selection % 10);
			return vLecture;
		} else if ((vLectureVector.get(0).getCode() % 10) == 1) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			VLecture vLecture = vLectureVector.get((selection % 10) - 1);
			return vLecture;
		}
		return null;
	}
	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard) {
		String campusFileName =selectIndex("캠퍼스 코드를 선택하세요", "root", keyboard);
		String collegeFileName = selectIndex("대학 코드를 선택하세요", campusFileName, keyboard);
		String departmentFileName = selectIndex("과목 코드를 선택하세요", collegeFileName, keyboard);
		
		VLecture vLecture = terminal("강좌 코드를 선택하세요", departmentFileName, keyboard);
		return vLecture;
		}
}
