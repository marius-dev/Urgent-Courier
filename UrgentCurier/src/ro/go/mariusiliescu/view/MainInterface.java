package ro.go.mariusiliescu.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import ro.go.mariusiliescu.Model;
import ro.go.mariusiliescu.entities.Pachet;
import ro.go.mariusiliescu.entities.persoane.Client;
import ro.go.mariusiliescu.view.adugare.client.FormularAdaugareClient;
import ro.go.mariusiliescu.view.adugare.comanda.FormularAdaugareComanda;
import ro.go.mariusiliescu.view.adugare.comanda.VizualizatePacheteTmp;
import ro.go.mariusiliescu.view.vizualizarecomenzi.VizualizareComenzi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane ;
	private JPanel addOrders;
	private JPanel panel1;
	private VizualizareComenzi manageOrders;
	
	private FormularAdaugareClient adaugareClient;
	private FormularAdaugareComanda adaugareComanda;
	private VizualizatePacheteTmp vizualizatePacheteTmp;
	
	private CardLayout cLayout;
	
	private JToolBar toolBar;
	
	private JButton next;
	private JButton back;
	
	
	public MainInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();
		setLayout();
		setNavButtonListener();
		this.setVisible(true);
	}
	
	private void initComponents(){
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		manageOrders = new VizualizareComenzi();
	}
	
	private void setLayout(){
		getContentPane().add(tabbedPane, BorderLayout.NORTH);		
		panel1 = new JPanel();
		addOrders = new JPanel();
		cLayout = new CardLayout();
		toolBar = new JToolBar();
		
		adaugareClient = new FormularAdaugareClient();
		adaugareComanda = new FormularAdaugareComanda();
		vizualizatePacheteTmp = new VizualizatePacheteTmp();
		
		back = new JButton("<--");
		back.setFont(new Font("Tahoma", Font.BOLD, 18));
		next = new JButton("-->");
		next.setFont(new Font("Tahoma", Font.BOLD, 18));
		MainInterface.this.back.setVisible(false);
		tabbedPane.addTab("Adaugare comanda", null, panel1, null);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(5)
					.addComponent(addOrders, GroupLayout.PREFERRED_SIZE, 801, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(18)
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(vizualizatePacheteTmp, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)))
					.addGap(165))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel1.createSequentialGroup()
					.addGap(5)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(vizualizatePacheteTmp, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(addOrders, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel1.setLayout(gl_panel1);
		tabbedPane.addTab("Lista de comenzi", null, manageOrders, null);
		manageOrders.setLayout(new BoxLayout(manageOrders, BoxLayout.X_AXIS));
		setTabAddLayout();
		setTabViewLayout();
		this.pack();
	}
	
	private void setTabAddLayout(){
		toolBar.add(back);
		toolBar.add(next);
		//addOrders.add(toolBar, BorderLayout.SOUTH);
		
		addOrders.setLayout(cLayout);
		addOrders.add(adaugareClient,"1");
		
		addOrders.add(adaugareComanda,"2");
		cLayout.show(addOrders, "1");
	}
	
	private void setTabViewLayout(){
		
	}
	
	private void setNavButtonListener(){
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cLayout.show(addOrders, "2");
				MainInterface.this.next.setVisible(false);
				MainInterface.this.back.setVisible(true);
			}
		});
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cLayout.show(addOrders, "1");
				MainInterface.this.back.setVisible(false);
				MainInterface.this.next.setVisible(true);
			}
		});
	}
	
	public void butonAdaugarePachetListener(ActionListener lis){
		adaugareComanda.butonAdaugarePachetListener(lis);
	}
	
	public void butonAdaugareComandaListener(ActionListener lis){
		vizualizatePacheteTmp.btnAdaugareComandaListener(lis);
	}
	
	public ArrayList<Pachet> getPackList(){
		return adaugareComanda.getPackList();
	}
	
	public Client getClient(){
		return adaugareClient.getClientData();
	}
	
	public void setModel(Model listP){
		vizualizatePacheteTmp.setModel(listP);
	}
	
	public void resetPackListPanelFields(){
		adaugareComanda.resetFields();
	}
	
	public boolean esteFormularulClientuluiCompletat(){
		return adaugareClient.esteFormularulClientuluiCompletat();
	}
	
	public void resetClientFields(){
		adaugareClient.resetFields();
	}
	public boolean esteFormularulDestinataruluiCompletat(){
		return adaugareComanda.esteFormularulDestinataruluiCompletat();
	}

}
