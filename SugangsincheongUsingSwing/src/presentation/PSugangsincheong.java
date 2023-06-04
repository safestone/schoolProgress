package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong extends JPanel {
	private PLectureSelection pLectureSelection;
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBaskt;

	JButton btn1, btn2, btn3, btn4;
	
	public PSugangsincheong() {
		this.setBackground(Color.black);
		this.setBounds(0, 0 ,600, 400);
		this.setLayout(new FlowLayout());
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.pSincheongBaskt = new PLectureBasket();
		
		pLectureSelection.setVisible(false);
		pMiridamgiBasket.setVisible(false);
		pSincheongBaskt.setVisible(false);

		this.add(pLectureSelection);
		this.add(pMiridamgiBasket);
		this.add(pSincheongBaskt);
		
		btn1 = new JButton("강좌 선택");
		btn2 = new JButton("미리담기");
		btn3 = new JButton("수강신청");
		btn4 = new JButton("종료");

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pLectureSelection.setVisible(true);
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pMiridamgiBasket.setVisible(true);				
			}
			
		});
		
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pSincheongBaskt.setVisible(true);				
			}
			
		});
		
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean bRunning = true;
		while(bRunning) {
			System.out.println("0.강좌 선택 1.미리담기 2.수강신청 9.종료");
			
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			switch (selection) {
			case 0:
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				break;
			case 1:
				pMiridamgiBasket.add(vLecture);
				pMiridamgiBasket.show();
				break;
			case 2:
				pSincheongBaskt.add(vLecture);
				pSincheongBaskt.show();
				break;
			case 9:
				bRunning = false;
				System.out.println("종료되었습니다.");
				break;
			default:
				break;
			}
		}

	}
}


