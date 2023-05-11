package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {
	
	private CIndex cIndex;
	private CLecture CLecture;
	
	
	public PSugangsincheong() {
		this.cIndex = new CIndex();
		this.CLecture = new CLecture();
	}
	
	private String selectIndex(String message, String fileName, Scanner sc) {
		System.out.println(message);
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector("data/"+fileName+".txt");
		for(VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName());	
		}
		if((vIndexVector.get(0).getCode() % 10) == 0) {
			String command = sc.next();
			int selection = Integer.parseInt(command);
			String selectedFileName = vIndexVector.get(selection % 10).getFileName();
			return selectedFileName;
		} else if ((vIndexVector.get(0).getCode() % 10) == 1) {
			String command = sc.next();
			int selection = Integer.parseInt(command);
			String selectedFileName = vIndexVector.get((selection % 10) - 1).getFileName();
			return selectedFileName;
		}
		return null;

	}

//	private String terminal(String message, String fileName, Scanner sc) {
//		System.out.println(message);
//		Vector<VIndex> vIndexVector = cIndex.getTerminal("data/"+fileName+".txt");
//		for(int i = 0; i < vIndexVector.size(); i++) { 
//			System.out.print(vIndexVector.get(i).getCode() + " ");
//			System.out.print(vIndexVector.get(i).getName() + " ");
//			System.out.print(vIndexVector.get(i).getCredit() + " ");
//			System.out.print(vIndexVector.get(i).getTime() + " ");
//			System.out.print(vIndexVector.get(i).getProfessor() + "\n");
//		}
//		if((vIndexVector.get(0).getCode() % 10) == 0) {
//			String command = sc.next();
//			int selection = Integer.parseInt(command);
//			String selectedFileName = vIndexVector.get(selection % 10).getName();
//			return selectedFileName;
//		} else if ((vIndexVector.get(0).getCode() % 10) == 1) {
//			String command = sc.next();
//			int selection = Integer.parseInt(command);
//			String selectedFileName = vIndexVector.get((selection % 10) - 1).getName();
//			return selectedFileName;
//		}
//		return null;
//	}
	private String terminal(String message, String fileName, Scanner sc) {
		System.out.println(message);
		Vector<VIndex> vLectureVector = CLecture.getTerminal("data/"+fileName+".txt");
		for(int i = 0; i < vLectureVector.size(); i++) { 
			System.out.print(vLectureVector.get(i).getCode() + " ");
			System.out.print(vLectureVector.get(i).getName() + " ");
			System.out.print(vLectureVector.get(i).getCredit() + " ");
			System.out.print(vLectureVector.get(i).getTime() + " ");
			System.out.print(vLectureVector.get(i).getProfessor() + "\n");
		}
		if((vLectureVector.get(0).getCode() % 10) == 0) {
			String command = sc.next();
			int selection = Integer.parseInt(command);
			String selectedFileName = vLectureVector.get(selection % 10).getName();
			return selectedFileName;
		} else if ((vLectureVector.get(0).getCode() % 10) == 1) {
			String command = sc.next();
			int selection = Integer.parseInt(command);
			String selectedFileName = vLectureVector.get((selection % 10) - 1).getName();
			return selectedFileName;
		}
		return null;
	}
	public void run(VUserInfo vUserInfo, Scanner sc) {
		String selectedFileName =selectIndex("캠퍼스 코드를 선택하세요", "root", sc);
		selectedFileName = selectIndex("대학 코드를 선택하세요", selectedFileName, sc);
		selectedFileName = selectIndex("과목 코드를 선택하세요", selectedFileName, sc);
		selectedFileName = terminal("강좌 코드를 선택하세요", selectedFileName, sc);
		System.out.println(selectedFileName + "를 선택하셨습니다.");
		}
	}


