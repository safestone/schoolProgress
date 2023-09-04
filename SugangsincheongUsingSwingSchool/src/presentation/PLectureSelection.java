package presentation;

import java.awt.Color;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection extends JPanel {
	private CLecture CLecture;
	
	private class PSelection extends JTable {
		private CIndex cIndex;

		public PSelection(String titleName, String fileName) {

			String[] title = new String[1];
			title[0] = titleName;
			DefaultTableModel tableModel = new DefaultTableModel(title, 0);
			this.setModel(tableModel);
			
			RowSelectionListener select = new RowSelectionListener();
			this.getSelectionModel().addListSelectionListener(select);
			
			this.cIndex = new CIndex();
			
			Vector<VIndex> vIndexVector = cIndex.getVIndexVector("data/"+fileName+".txt");
			for(VIndex vIndex: vIndexVector) {
				System.out.println(vIndex.getCode() + " " + vIndex.getName());	
				String[] row = new String[1];
				row[0] = vIndex.getName();
				tableModel.addRow(row);
			}
			

		}
	}
	
	private class RowSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int FirstIndex = e.getFirstIndex();
			System.out.println(FirstIndex);
			int LastIndex = e.getLastIndex();
			System.out.println(LastIndex);
		}
		
	}
	
	public PLectureSelection() {

		

		PSelection pCampus = new PSelection("캠퍼스", "Root");
		JScrollPane scrollPane = new JScrollPane(pCampus);
		this.add(scrollPane); 
		
		PSelection PCollege = new PSelection("대학", "Root");
		scrollPane = new JScrollPane(PCollege);
		this.add(scrollPane);
		
		PSelection PDepartment = new PSelection("학과", "Root");
		scrollPane = new JScrollPane(PDepartment);
		this.add(scrollPane); 
		
		CLecture = new CLecture();
		this.setBackground(Color.GRAY);
		
	}
	
	private String selectIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message);
		
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
