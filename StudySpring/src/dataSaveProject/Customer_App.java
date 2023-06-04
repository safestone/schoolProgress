package dataSaveProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JTextField ID;
	private JPasswordField PassWord;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer customer = new Customer();
		
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 984, 607);
		tablePanel.setVisible(false);
		String[][] data = customer.getCustomers();
		String[] headers =  new String[] {"Name", "Phone", "Gender", "Age", "Note"};
		tablePanel.setLayout(null);
		JTable table = new JTable(data,headers);
		table.setRowHeight(30);
		table.setFont(new Font("Arial", Font.BOLD, 15));
		table.setSize(800, 400);
		table.setPreferredScrollableViewportSize(new Dimension(800, 400));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(91, 51, 802, 428);
		tablePanel.add(scrollPane);
		frame.getContentPane().add(tablePanel);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBounds(0, 0, 984, 630);
		frame.getContentPane().add(mainPanel);
		mainPanel.setVisible(false);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Main Panel");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_2.setBounds(357, 44, 263, 62);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel_3.setBounds(31, 116, 240, 48);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Age");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel_3_1.setBounds(31, 219, 240, 48);
		mainPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Gender");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel_3_1_1.setBounds(41, 331, 240, 48);
		mainPanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Phone");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel_3_1_2.setBounds(486, 116, 240, 48);
		mainPanel.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Birthday");
		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel_3_1_2_1.setBounds(486, 219, 240, 48);
		mainPanel.add(lblNewLabel_3_1_2_1);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("Note");
		lblNewLabel_3_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1_1.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel_3_1_2_1_1.setBounds(486, 331, 240, 48);
		mainPanel.add(lblNewLabel_3_1_2_1_1);
		
		name = new JTextField();
		name.setFont(new Font("굴림", Font.BOLD, 20));
		name.setBounds(217, 116, 257, 48);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("굴림", Font.BOLD, 20));
		age.setColumns(10);
		age.setBounds(217, 219, 257, 48);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setFont(new Font("굴림", Font.BOLD, 20));
		phone.setColumns(10);
		phone.setBounds(673, 116, 257, 48);
		mainPanel.add(phone);
		
		birthday = new JTextField();
		birthday.setFont(new Font("굴림", Font.BOLD, 20));
		birthday.setColumns(10);
		birthday.setBounds(673, 219, 257, 48);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male", "Female"});
		gender.setBackground(new Color(255, 255, 255));
		gender.setFont(new Font("굴림", Font.BOLD, 20));
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gender.setBounds(217, 331, 263, 48);
		mainPanel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setLineWrap(true);
		note.setFont(new Font("굴림", Font.BOLD, 20));
		note.setBounds(673, 331, 257, 206);
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(note);
		
		JButton btnNewButton1 = new JButton("Submit");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String textAreaTxt = note.getText();
				
				customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, textAreaTxt);
				JOptionPane.showMessageDialog(null, "데이터 저장 완료");
				mainPanel.setVisible(false);
				tablePanel.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablePanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(203, 507, 453, 68);
		tablePanel.add(btnNewButton_1);
		
		search = new JTextField();
		search.setText("검색\r\n");
		search.setFont(new Font("굴림", Font.PLAIN, 17));
		search.setBounds(91, 10, 802, 31);
		tablePanel.add(search);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(100);
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(50);

		
		btnNewButton1.setBackground(new Color(255, 255, 255));
		btnNewButton1.setForeground(new Color(0, 0, 0));
		btnNewButton1.setIcon(new ImageIcon("C:\\Users\\pc\\git\\schoolProgress\\StudySpring\\image\\30492b0eb225427f966bf63d1dbfb017617ea012db208c18f6e83b1a90a7baa7.png"));
		btnNewButton1.setBounds(229, 414, 220, 97);
		mainPanel.add(btnNewButton1);
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/pc/git/schoolProgress/StudySpring/image/Welcome.jpg").getImage());
		welcomePanel.setBounds(0, 0, 984, 630);
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setBounds(376, 197, 120, 36);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		welcomePanel.add(lblNewLabel);
		
		ID = new JTextField();
		ID.setBounds(376, 241, 283, 36);
		ID.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		ID.setToolTipText("Enter ID");
		welcomePanel.add(ID);
		ID.setColumns(10);
		
		PassWord = new JPasswordField();
		PassWord.setBounds(376, 287, 283, 36);
		PassWord.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		welcomePanel.add(PassWord);
		
		JLabel lblNewLabel_1 = new JLabel("ID :\r\n");
		lblNewLabel_1.setBounds(320, 240, 53, 36);
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PW :");
		lblNewLabel_1_1.setBounds(320, 287, 53, 36);
		lblNewLabel_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(330, 333, 342, 221);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pc\\git\\schoolProgress\\StudySpring\\image\\soksang1.png"));
		btnNewButton.setPressedIcon(new ImageIcon("C:\\Users\\pc\\git\\schoolProgress\\StudySpring\\image\\soksang2.png"));
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("속상해!!!!!!!");
				if(ID.getText().equals("lee") && Arrays.equals(PassWord.getPassword(), "lee".toCharArray())) {
					System.out.println("이철수님 안녕하세요");
					JOptionPane.showMessageDialog(null, "속상해!!");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다.");
				}
			}
		});
		welcomePanel.add(btnNewButton);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");		
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});

		return bar;
	}
}

class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
}