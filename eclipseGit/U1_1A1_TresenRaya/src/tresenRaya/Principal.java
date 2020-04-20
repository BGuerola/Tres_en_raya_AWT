package tresenRaya;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;

public class Principal {
	
	public Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
	boolean ganador=false; //determinará si se puede continuar marcando los botones
	boolean modohvm=true; //modo de juego humano contra máquina en true, humano contra humano en false
	String play="X";// para rellenar el boton con X o con O. Empieza con X.
	int turno=1; //Para modo humano contra humano, turnos de juego
	
	public Label label1;
	public Panel panel2;
	
	
	//clase cierre del programa
	public class WindowListenerTest extends WindowAdapter{
		public void windowClosing(WindowEvent ev) {
			System.exit(0);
		}
	}

	//diseño de la interfaz
public void diseño() {
	Frame frame = new Frame();
	frame.setTitle("TRES EN RAYA");
	frame.setSize(400, 250);
	frame.setLayout(new BorderLayout());
	frame.setLocationRelativeTo(null);
	
	Panel panel1 = new Panel();
	panel1.setLayout(new GridLayout (3,3));
	b1 = new Button("");
	b1.addActionListener(new ActionListenerTest());
	panel1.add(b1);
	b2 = new Button("");
	b2.addActionListener(new ActionListenerTest());
	panel1.add(b2);
	b3 = new Button("");

	b3.addActionListener(new ActionListenerTest());
	panel1.add(b3);
	b4 = new Button("");

	b4.addActionListener(new ActionListenerTest());
	panel1.add(b4);
	b5 = new Button("");

	b5.addActionListener(new ActionListenerTest());
	panel1.add(b5);
	b6 = new Button("");

	b6.addActionListener(new ActionListenerTest());
	panel1.add(b6);
	b7 = new Button("");

	b7.addActionListener(new ActionListenerTest());
	panel1.add(b7);
	b8 = new Button("");

	b8.addActionListener(new ActionListenerTest());
	panel1.add(b8);
	b9 = new Button("");

	b9.addActionListener(new ActionListenerTest());
	panel1.add(b9);
	
    panel2 = new Panel();
    panel2.setLayout((LayoutManager) new BoxLayout(panel2, BoxLayout.Y_AXIS));
			
    CheckboxGroup cbg = new CheckboxGroup();
    
    Checkbox c1 = new Checkbox("Humano vs Computadora", cbg, true);
    c1.addItemListener(new ItemListener(){//listener integrado para escoger modo de juego
		public void itemStateChanged(ItemEvent arg0) {
	        modohvm=true; //con esta variable se notifica el modo de juego
		}
	});
    

    Checkbox c2 = new Checkbox("Humano vs Humano", cbg, false);
    c2.addItemListener(new ItemListener(){
    	@Override
    	public void itemStateChanged(ItemEvent arg0) {
    	    modohvm=false;
    		}
    	});

	panel2.add(c1);
	panel2.add(c2);
	
		label1 = new Label();
		label1.setText(" ");
		Font font = new Font("Calibri", Font.BOLD, 16);
		label1.setFont(font);
		label1.setForeground(Color.red);
		label1.setVisible(true);
		panel2.add(label1);
	
    
    Button boton = new Button("REINICIAR");
    boton.setBackground(Color.LIGHT_GRAY);
    boton.addActionListener(new ActionListener() {//listener integrado de borrado texto de los botones
    	public void actionPerformed(ActionEvent arg0) {
				b1.setLabel("");
				b2.setLabel("");
				b3.setLabel("");
				b4.setLabel("");
				b5.setLabel("");
				b6.setLabel("");
				b7.setLabel("");
				b8.setLabel("");
				b9.setLabel("");
				ganador=false;
				label1.setText(" ");
    	}
    });
	
    panel2.add(boton);
    frame.add(panel1,BorderLayout.CENTER);
	frame.add(panel2,BorderLayout.EAST);
	frame.setVisible(true);
	
	frame.addWindowListener(new WindowListenerTest());
}

//listener para los botones
public class ActionListenerTest implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (modohvm==false){
    		if (turno==1) {//se entra en turnos si se juega mhumano contra humano
    			play="X";
    			turno=2;
    		} else {
    			play="O";
    			turno=1;
    		}
    	} else {play="X";}
    	if (ganador==false) {//solo mueve si no hay ganador
	    	Object source = e.getSource();//pinta si está en blanco, si se intenta pintar uno pintado se mantiene turno
	        if (source==b1) {if (b1.getLabel()=="") {b1.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b2) {if (b2.getLabel()=="") {b2.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b3) {if (b3.getLabel()=="") {b3.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b4) {if (b4.getLabel()=="") {b4.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b5) {if (b5.getLabel()=="") {b5.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b6) {if (b6.getLabel()=="") {b6.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b7) {if (b7.getLabel()=="") {b7.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b8) {if (b8.getLabel()=="") {b8.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        if (source==b9) {if (b9.getLabel()=="") {b9.setLabel(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
	        ganador=compruebaganador(ganador, play);        
	        }
    	if (modohvm==true) {
	        if (ganador == false) {
	        	play="O";
	        	movmaq();
	        	ganador=compruebaganador(ganador, play);
	        }
    	}
	        }
	        
    	} 
    
public void movmaq() {//mueve automaticamente
	int numero = (int) (Math.random() * 9)+1; //genera número al azar del 1 al 9
	switch(numero) {//si un boton no está en blanco salta al siguiente
	case 1: if (b1.getLabel()=="") {b1.setLabel("O");break;} else {numero = 2;};
	case 2:	if (b2.getLabel()=="") {b2.setLabel("O");break;} else {numero = 3;};
	case 3: if (b3.getLabel()=="") {b3.setLabel("O");break;} else {numero = 4;};
	case 4: if (b4.getLabel()=="") {b4.setLabel("O");break;} else {numero = 5;};
	case 5: if (b5.getLabel()=="") {b5.setLabel("O");break;} else {numero = 6;};
	case 6: if (b6.getLabel()=="") {b6.setLabel("O");break;} else {numero = 7;};
	case 7: if (b7.getLabel()=="") {b7.setLabel("O");break;} else {numero = 8;};
	case 8: if (b8.getLabel()=="") {b8.setLabel("O");break;} else {numero = 9;};
	case 9: if (b9.getLabel()=="") {b9.setLabel("O");break;} else {numero = 1;};
	default: break;
	}
}
public boolean compruebaganador(boolean g, String s) {//comprueba ganador
    if (((b1.getLabel()==s) & (b2.getLabel()==s)&(b3.getLabel()==s))||
	    ((b4.getLabel()==s) & (b5.getLabel()==s)&(b6.getLabel()==s))||
	    ((b7.getLabel()==s) & (b8.getLabel()==s)&(b9.getLabel()==s))||
	    ((b1.getLabel()==s) & (b4.getLabel()==s)&(b7.getLabel()==s))||
	    ((b2.getLabel()==s) & (b5.getLabel()==s)&(b8.getLabel()==s))||
	    ((b3.getLabel()==s) & (b6.getLabel()==s)&(b9.getLabel()==s))||
	    ((b1.getLabel()==s) & (b5.getLabel()==s)&(b9.getLabel()==s))||
	    ((b7.getLabel()==s) & (b5.getLabel()==s)&(b3.getLabel()==s))){  
    	g = true; 
    	if (play=="X") {
    	label1.setText("¡GANA JUGADOR 1!");
    	} else {label1.setText("¡GANA JUGADOR 2!");}
    }	else {
    	g=false;
    }
   
	return g; //devuelve un valor true o false que dirà si ya hay ganador impidiendo que se pinten más botones
}

public static void main(String args[]) {
	
Principal prueba=new Principal();
prueba.diseño();


}
}