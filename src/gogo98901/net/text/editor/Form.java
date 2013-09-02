package gogo98901.net.text.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JInternalFrame;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.Box;
import javax.swing.JToggleButton;

public class Form extends JFrame {
	private static final long serialVersionUID = 1L;

	public static String ClipBoardData = "";

	private JPanel contentPane;
	private static JPanel jp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (Main.running) {

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					System.out.println("Running...");

				}
			});
		} else {
			System.out.println("Unable to run!");
			System.out.println("Run through (Main.java/Mian.class)");
			Main.exit();
		}
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Arial", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 500);
		Main.lookAndFeel();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmNew.setIcon(new ImageIcon(Main.NewImage));
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open...");
		mntmOpen.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmOpen.setIcon(new ImageIcon(Main.OpenImage));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmSave.setIcon(new ImageIcon(Main.SaveImage));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmSaveAs.setIcon(new ImageIcon(Main.SaveAsImage));
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnFile.add(mntmSaveAs);

		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Arial", Font.PLAIN, 13));
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnEdit);

		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmCut.setIcon(new ImageIcon(Main.CutImage));
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);

		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmCopy.setIcon(new ImageIcon(Main.CopyImage));
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);

		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmPaste.setIcon(new ImageIcon(Main.PasteImage));
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);

		JSeparator separator_4 = new JSeparator();
		mnEdit.add(separator_4);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmDelete.setIcon(new ImageIcon(Main.DeleteImage));
		mntmDelete
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		mnEdit.add(mntmDelete);

		JSeparator separator_3 = new JSeparator();
		mnEdit.add(separator_3);

		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mntmSelectAll.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmSelectAll.setIcon(new ImageIcon(Main.SelectAllImage));
		mntmSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmSelectAll);

		JMenu mnFormat = new JMenu("Format");
		mnFormat.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnFormat);

		final JMenuItem mntmWordWrap = new JMenuItem("Word Wrap");
		mntmWordWrap.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmWordWrap.setIcon(new ImageIcon(Main.TickImage));
		mnFormat.add(mntmWordWrap);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Arial", Font.PLAIN, 13));
		menuBar.add(mnHelp);

		JMenuItem mntmViewHelp = new JMenuItem("View Help");
		mntmViewHelp.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmViewHelp.setIcon(new ImageIcon(Main.HelpImage));
		mnHelp.add(mntmViewHelp);

		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);

		JMenuItem mntmAboutJtext = new JMenuItem("About " + Main.title);
		mntmAboutJtext.setFont(new Font("Arial", Font.PLAIN, 13));
		mntmAboutJtext.setIcon(new ImageIcon(Main.InternetImage));

		mnHelp.add(mntmAboutJtext);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		final JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		textArea.setFont(UIManager.getFont("ToolTip.font"));

		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClipBoardData = textArea.getSelectedText();
				StringSelection stringSelction = new StringSelection(
						ClipBoardData);
				Clipboard clipBoard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipBoard.setContents(stringSelction, null);
				textArea.replaceSelection("");
			}
		});
		mntmCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClipBoardData = textArea.getSelectedText();
				StringSelection stringSelction = new StringSelection(
						ClipBoardData);
				Clipboard clipBoard = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clipBoard.setContents(stringSelction, null);
			}
		});
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(ClipBoardData);
			}
		});
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.replaceSelection("");
			}
		});
		mntmSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmAboutJtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String htmlFilePath = "cfg/JText.html";
				File htmlFile = new File(htmlFilePath);
				try {
					Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		mntmExit.setIcon(new ImageIcon(Main.QuitImage));

		Component horizontalStrut = Box.createHorizontalStrut(356);
		menuBar.add(horizontalStrut);

		JProgressBar progressBar = new JProgressBar();
		menuBar.add(progressBar);

		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		menuBar.add(horizontalStrut_1);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.exit();
			}
		});
		mntmWordWrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File wrap = new File("msg/wordWrap.txt");
				if (wrap.exists()) {
					textArea.setLineWrap(true);
					mntmWordWrap.setIcon(new ImageIcon(Main.TickImage));
				} else {
					textArea.setLineWrap(false);
					mntmWordWrap.setIcon(new ImageIcon(Main.CrossImage));
				}
			}
		});
	}

}