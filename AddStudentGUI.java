package addStudentGUI;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.EventHandler;
import java.awt.*;
import java.util.*;


@SuppressWarnings("serial")
public class AddStudentGUI extends JFrame implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;

	ArrayList<StudentList>list;

	JPanel panelNewStudent = new JPanel(new BorderLayout()); 
	JPanel panelButtons = new JPanel();
	JPanel panelAddStudent = new JPanel(); 
	JPanel panelShowStudent = new JPanel(); 
	JPanel panelModules = new JPanel();

	public AddStudentGUI() {
		super("Student Information System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(panelNewStudent, BorderLayout.CENTER);//added to centre of frame
		add(panelButtons, BorderLayout.SOUTH);//added to the bottom of frame

		panelNewStudent.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "New Student"));

		panelNewStudent.add(panelAddStudent, BorderLayout.NORTH);
		panelNewStudent.add(panelShowStudent, BorderLayout.CENTER);
		panelNewStudent.add(panelModules, BorderLayout.EAST);

		list = new ArrayList<StudentList>(); //Creating a blank ArrayList
		
		//---------------------------------------------------------------------
		/*PANELADDSTUDENT*/
		//---------------------------------------------------------------------

		/**PanelAddStudent has a label saying "Name"*/
		JLabel lblName;
		lblName = new JLabel("Name:");
		panelAddStudent.add(lblName);
		/**PanelAddStudent has a textField default name "Peter Smith"*/
		JTextField tfName;
		tfName = new JTextField("Peter Smith", 10);
		panelAddStudent.add(tfName);

		/**PanelAddStudent has a label saying "Address:"*/
		JLabel lblAddress;
		lblAddress = new JLabel("Address:");
		panelAddStudent.add(lblAddress);
		/**PanelAddStudent has a textField default address "35 Liffey Street, Dublin 2"*/
		JTextField tfAddress;
		tfAddress = new JTextField("35 Liffey Street, Dublin 2", 15);
		panelAddStudent.add(tfAddress);

		/**PanelAddStudent has a Button "Submit" & "Clear" */
		JButton btnSubmit; 
		btnSubmit = new JButton("Submit");
		panelAddStudent.add(btnSubmit);
		/**When submit is clicked a name written in the TF & an address written in the TF add to list "studentlist" 
		 * & should be printed below*/

		//SHOWSTUDENT TEXTAREA
		JTextArea txtrShowStudent;
		txtrShowStudent = new JTextArea();
		txtrShowStudent.setEditable(false);
		//The lines will wrap if they don’t fit
		txtrShowStudent.setLineWrap(true); 
		//Wrapped lines will be separated between words
		txtrShowStudent.setWrapStyleWord(true);

		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if(btnSubmit.getText().equals("Submit")) {

					String name = tfName.getText();
					String address = tfAddress.getText();
					if(name.equals("") || address.equals("")) {
						//Message displayed if atleast one of the text areas is empty
						JOptionPane.showMessageDialog(null, "Atleast one of the textfield is empty\nPlease fill both textfields");
					}
					else
					{
						//Add to ArrayList
						StudentList sl = new StudentList();
						sl.setName(name);
						sl.setAddress(address);
						list.add(sl);

						//Display first element of ArrayList if the size is zero
						if (list.size() == 0) {
							StudentList first = list.get(0);
							txtrShowStudent.append(first + "");
						}
						else //Display last element added to ArrayList
							if (list.size() != 0) {
								StudentList last = list.get(list.size() - 1);
								txtrShowStudent.append(last + "");
							}
					}				

				}}});

		JButton btnClear;
		btnClear = new JButton("Clear");
		panelAddStudent.add(btnClear);

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField & textArea set to null
				tfName.setText(null);
				tfAddress.setText(null);
			}
		});

		//------------------------------------------------------------------
		/*PANELSHOWSTUDENT*/
		//------------------------------------------------------------------

		/**panelShowStudent has a border layout*/
		panelShowStudent.setLayout(new BorderLayout());
		/**label StudentList north of border*/
		JLabel studentList;
		studentList = new JLabel("Student List:");
		panelShowStudent.add(studentList,  BorderLayout.NORTH);

		/**showStudent textArea created above*/
		panelShowStudent.add(txtrShowStudent, BorderLayout.CENTER);

		//------------------------------------------------------------------
		/*PANELMODULES - holds check boxes & text area*/
		//------------------------------------------------------------------
		JPanel panelCheckBoxes = new JPanel();

		/**TEXTAREA*/
		JTextArea showModules;
		showModules = new JTextArea(3,15);
		showModules.setEditable(false);

		/**CHECKBOXES*/

		/**panelModules has a grid layout of 1 column & 2 rows*/
		//Create a gap between the 2 textareas
		panelModules.setBorder(BorderFactory.createEmptyBorder(0,5,0,2));
		panelModules.setLayout(new GridLayout(2,1)); //rows, column
		panelCheckBoxes.setLayout(new GridLayout(0,1));

		JCheckBox chbxDatabase;
		chbxDatabase = new JCheckBox("Databases");
		panelCheckBoxes.add(chbxDatabase);
		String data = chbxDatabase.getText();
		
		JCheckBox chbxJava;
		chbxJava = new JCheckBox("Java");;
		panelCheckBoxes.add(chbxJava);
		String java = chbxJava.getText();
		
		JCheckBox chbxAccounting;
		chbxAccounting = new JCheckBox("Accountancy");;
		panelCheckBoxes.add(chbxAccounting);
		String acc = chbxAccounting.getText();
		
		
		chbxDatabase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String data; 
				if (chbxDatabase.isSelected()) {
					data = chbxDatabase.getText();
					showModules.append(data + "\n");
				}	

			}	
		});
		chbxDatabase.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange()== ItemEvent.DESELECTED) {
					showModules.setText("");
					if (chbxAccounting.isSelected()) {
						showModules.append(acc + "\n");
					}
					if (chbxJava.isSelected()) {
						showModules.append(java + "\n");
					}
				}
			}	
		});
		
		
		chbxJava.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String java; 
				if (chbxJava.isSelected()) {
					java = chbxJava.getText();
					showModules.append(java + "\n");
				}	
			}	
		});
		chbxJava.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()== ItemEvent.DESELECTED) {
					showModules.setText("");
					if (chbxAccounting.isSelected()) {
						showModules.append(acc + "\n");
					}
					if (chbxDatabase.isSelected()) {
						showModules.append(data + "\n");
					}
				}

			}
		});


		
		chbxAccounting.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (chbxAccounting.isSelected()) {
					showModules.append(acc + "\n");
				}	
			}	
		});
		chbxAccounting.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
			
				if (e.getStateChange()== ItemEvent.DESELECTED) {
					showModules.setText("");
					if (chbxJava.isSelected()) {
						showModules.append(java + "\n");
					}
					if (chbxDatabase.isSelected()) {
						showModules.append(data + "\n");
					}
				}

			}

		});


		panelModules.add(panelCheckBoxes);
		panelModules.add(showModules);

		//------------------------------------------------------------------
		/*PANELBUTTONS - finish and clear buttons*/
		//------------------------------------------------------------------
		JButton btnFinish;
		btnFinish = new JButton("Finish");
		panelButtons.add(btnFinish);
		/**Finish button should close the window*/
		btnFinish.addActionListener(e -> {
			dispose();
		});

		JButton btnClearAll;
		btnClearAll = new JButton("Clear All");
		panelButtons.add(btnClearAll);
		/**Clear button should clear textFields & textAreasw*/
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField & textArea set to null
				tfName.setText(null);
				tfAddress.setText(null);
				txtrShowStudent.setText(null);
				showModules.setText(null);
				//Uncheck all checkboxes
				chbxDatabase.setSelected(false);
				chbxJava.setSelected(false);
				chbxAccounting.setSelected(false);	
				list.clear();//clears ArrayList
			}
		});

		pack();
		setVisible(true);		

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new AddStudentGUI();
	}
}
