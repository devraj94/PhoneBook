*/Author: K.Maharshi Devaraj
Date : 12-11-2013
/*
import java.io.*;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class phonebook {
	static String nameselected;
	 static JFrame frame;
	 static JButton Delete;
	 static JButton Search;
	 static JButton addcontact;
	 static JTextArea text;
	static JButton addcancel;
	static  JButton addconfirm;
	static  JLabel address;
	static  JTextArea addressfield;
	static   JLabel number;
	static   JLabel name;
	  static  JTextField namefield;
	  static  JTextField numberfield;
	  static JScrollPane pane;
	  static ArrayList<pbook> list;
	  static JButton Back;
	    static JButton Select;
	    static JButton menu;
	    static JButton Confirm;
   public static void main(String[] args){
	   phonebook a=new phonebook();
	   Delete=new JButton();
	   frame=new JFrame();
	   Search=new JButton();
	   addcontact=new JButton();
	   a.display();
	   
	  Delete.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  Search();
		  }
	  });
	  Search.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  Search();
		  }
	  });
	 
	  addcontact.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  addcontact();
		  }
	  });
	  
   }
   
   public static  void display(){
	  
	   File file=new File("phonebook.txt");
	    text=new JTextArea();
	    text.setEditable(false);
	    pane = new javax.swing.JScrollPane(text);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Search.setText("Search");

        addcontact.setText("Add Contact");

        Delete.setText("Delete contact");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search)
                    .addComponent(addcontact)
                    .addComponent(Delete)))
        );
        frame.setSize(325, 420);
        frame.setVisible(true);
        Font font=new Font("Engravers MT",Font.ITALIC,18);
        text.setFont(font);
        list=new ArrayList<pbook>();
	   try{
		   if(!file.exists()){
			   file.createNewFile();
		   }
		   BufferedReader brr=new BufferedReader(new FileReader(new File("phonebook.txt")));
		   String line;
		   while((line=brr.readLine())!=null){
			   if(line.isEmpty()){
				   continue;
			   }else{
				   String h[]=line.split(" ");
				   pbook gh=new pbook();
				   gh.name=h[0];
				   gh.number=h[1];
				   gh.address=h[2];
				   list.add(gh);
				  
			   }
			  
		   }
		   Collections.sort(list, new Comparator<pbook>(){
			     public int compare(pbook o1, pbook o2){
			         if((o1.name).compareTo(o2.name)==0)
			             return 0;
			         return (o1.name).compareTo(o2.name) < 0 ? -1 : 1;
			     }
			});
		   
		   for(int i=0;i<list.size();i++){
			   text.append("\n");
			   pbook d=list.get(i);
			   text.append(d.name+"   ---   "+d.number);
		   }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
   
  
   
 public static void Search(){
	 frame.remove(Delete);
	 frame.remove(Search);
	 frame.remove(addcontact);
	 frame.remove(text);
	 frame.remove(pane);
	 pane.removeAll();
	 final AutoSuggest s=new AutoSuggest(list);
	 pane=new JScrollPane(s);
     Select = new javax.swing.JButton();
     Back = new javax.swing.JButton();
     frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

     Select.setText("Select");

     Back.setText("Back");
     Back.setActionCommand("Back");

     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
     frame.getContentPane().setLayout(layout);
     layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addContainerGap()
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addComponent(pane)
                     .addContainerGap())
                 .addGroup(layout.createSequentialGroup()
                     .addGap(10, 10, 10)
                     .addComponent(Back)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                     .addComponent(Select)
                     .addGap(50, 50, 50))))
     );
     layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addContainerGap()
             .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(Select)
                 .addComponent(Back)))
     );
     
     Back.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  frame.remove(Select);
			  frame.remove(pane);
			  frame.remove(Back);
			  display();
		  }
	  });
     
     Select.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  frame.remove(Select);
			  frame.remove(pane);
			  frame.remove(Back);
			  nameselected=s.tf.getText();
			  Delete();
		  }
	  });
   }
 
 public static void addconfirmed(){
	   String number=numberfield.getText();
	   String name=namefield.getText();
	   String address=addressfield.getText();
	   int flag=0;
	   for(int y=0;y<list.size();y++){
		   pbook pd=new pbook();
		   pd=list.get(y);
		   if(pd.number.compareTo(number)==0){
			   flag=1;
		   }
	   }
	   if(flag==0 && number.length()>=10 && number.length()<=13 && number.compareTo("")!=0 && address.compareTo("")!=0 && name.compareTo("")!=0){
		   String j[]=address.split("\n");
		   address=j[0];
		   for(int i=1;i<j.length;i++){
			   address=address+","+j[i];
		   }
		   try{
			  BufferedWriter brw=(new BufferedWriter(new FileWriter("phonebook.txt",true)));
			  brw.flush();
			  brw.append("\n");
			  brw.flush();
			   brw.append(name+" "+number+" "+address);
			   brw.close();
			   
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   
		   addcancelled();
	   }
	  
 }
 
 
 public static void Delete(){
	 final JTextArea area=new JTextArea();
     area.setEditable(false);
	 pane = new javax.swing.JScrollPane(area);
     menu = new javax.swing.JButton();
     Confirm = new javax.swing.JButton();
     String line="";
     try{
    	 BufferedReader brr=new BufferedReader(new FileReader(new File("phonebook.txt")));
  	  
  	   while((line=brr.readLine())!=null){
  		   if(line.isEmpty()){
  			   continue;
  		   }else{
  			   String h[]=line.split(" ");
  			   if(h[0].compareTo(nameselected)==0){
  				   break;
  			   }
  			  
  		   }
  		  
  	   }
     }catch(Exception e){
    	 e.printStackTrace();
     }
     if(line!=null){
    	 String h[]=line.split(" ");
         area.append("Name  :"+" "+h[0]);
         area.append("\n");
         area.append("Number  :"+" "+h[1]);
         area.append("\n");
         area.append("Address  :"+" "+h[2]);
     }
     
      
     frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

     menu.setText("menu");

     Confirm.setText("Delete");

     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
     frame.getContentPane().setLayout(layout);
     layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addContainerGap()
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addComponent(pane)
                     .addContainerGap())
                 .addGroup(layout.createSequentialGroup()
                     .addGap(10, 10, 10)
                     .addComponent(menu)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                     .addComponent(Confirm)
                     .addGap(32, 32, 32))))
     );
     layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addContainerGap()
             .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(menu)
                 .addComponent(Confirm))
             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
     );
     
     menu.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  frame.remove(area);
			  frame.remove(Confirm);
			  frame.remove(pane);
			  frame.remove(menu);
			  display();
		  }
	  });
     
     Confirm.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			  frame.remove(area);
			  frame.remove(pane);
			  frame.remove(Confirm);
			  frame.remove(menu);
			  for(int i=0;i<list.size();i++){
				  pbook jk=new pbook();
				  jk=list.get(i);
				  if(jk.name.compareTo(nameselected)==0){
					  list.remove(i);
					  break;
				  }
			  }

			  try{
				 FileWriter flw=new FileWriter("phonebook.txt");
				 flw.write("");
				 flw.close();
				  BufferedWriter brw=(new BufferedWriter(new FileWriter("phonebook.txt",true)));
				  brw.flush();
				  brw.write("");
				  for(int y=0;y<list.size();y++){
					  pbook jk=new pbook();
					  jk=list.get(y);
					  brw.flush();
					   brw.append(jk.name+" "+jk.number+" "+jk.address+"\n");
				  }
				   brw.close();
				   
			   }catch(Exception e1){
				   e1.printStackTrace();
			   }
			  list.clear();
			  display();
		  }
	  });
 }
 
 
 public static void addcancelled(){
	 frame.remove(addconfirm);
	 frame.remove(addcancel);
	 frame.remove(address);
	 frame.remove(addressfield);
	 frame.remove(pane);
	 frame.remove(name);
	 frame.remove(namefield);
	 frame.remove(number);
	 frame.remove(numberfield);
	   display();
 }
 
 public static void addcontact(){
	 frame.remove(Delete);
	 frame.remove(Search);
	 frame.remove(addcontact);
	 frame.remove(text);
	 frame.remove(pane);
	
	     name = new javax.swing.JLabel();
	        number = new javax.swing.JLabel();
	        address = new javax.swing.JLabel();
	        namefield = new javax.swing.JTextField();
	        numberfield = new javax.swing.JTextField();
	        addressfield = new javax.swing.JTextArea();
	        pane.removeAll();
	       pane=new JScrollPane(addressfield);
	        addconfirm = new javax.swing.JButton();
	        addcancel = new javax.swing.JButton();

	        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        name.setText("Name        :");

	        number.setText("Number    :");

	        address.setText("Address    :");

	        addconfirm.setText("Add");

	        addcancel.setText("Cancel");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
	        frame.getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(31, 31, 31)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(addconfirm)
	                        .addGap(64, 64, 64)
	                        .addComponent(addcancel))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(namefield)
	                            .addComponent(numberfield)
	                            .addComponent(pane, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
	                .addContainerGap(57, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(24, 24, 24)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(namefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(numberfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(addconfirm)
	                    .addComponent(addcancel))
	                .addGap(20, 20, 20))
	        );
	        
	        
	        addcancel.addActionListener(new ActionListener(){
	  		  public void actionPerformed(ActionEvent e){
	  			  addcancelled();
	  		  }
	  	  });
	        
	        addconfirm.addActionListener(new ActionListener(){
		  		  public void actionPerformed(ActionEvent e){
		  			  addconfirmed();
		  		  }
		  	  });
	        
 }
   
   
}

class pbook{
	String name=null;
	String number=null;
	String address=null;
}

class AutoSuggest extends JPanel{
	static String name;
    public final JTextField tf;
    private final JComboBox combo = new JComboBox();
    private final Vector<String> v = new Vector<String>();
    public AutoSuggest(ArrayList<pbook> list) {
        super(new BorderLayout());
        combo.setEditable(true);
        tf = (JTextField) combo.getEditor().getEditorComponent();
        tf.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
               EventQueue.invokeLater(new Runnable() {
            public void run() {
                String text = tf.getText();
                        if(text.length()==0) {
                    combo.hidePopup();
                    setModel(new DefaultComboBoxModel(v), "");
                }else{
                    DefaultComboBoxModel m = getSuggestedModel(v, text);
                    if(m.getSize()==0 || hide_flag) {
                          combo.hidePopup();
                        hide_flag = false;
                    }else{
                        setModel(m, text);
                        combo.showPopup();
                    }
                }
            }
        });
            }
                public void keyPressed(KeyEvent e) {
               String text = tf.getText();
         int code = e.getKeyCode();
             if(code==KeyEvent.VK_ENTER) {
            if(!v.contains(text)) {
                v.addElement(text);
                setModel(getSuggestedModel(v, text), text);
            }
            hide_flag = true; 
        }else if(code==KeyEvent.VK_ESCAPE) {
            hide_flag = true; 
        }else if(code==KeyEvent.VK_RIGHT) {
            for(int i=0;i<v.size();i++) {
                String str = v.elementAt(i);
                if(str.startsWith(text)) {
                    combo.setSelectedIndex(-1);
                    tf.setText(str);
                    return;
                }
            }
        }
            }
      });
        String[] countries=new String[list.size()];
        for(int l=0;l<list.size();l++){
        	pbook jk=new pbook();
        	jk=list.get(l);
        	countries[l]=jk.name;
        }
       
          for(int i=0;i<countries.length;i++){
                  v.addElement(countries[i]);
          }
        setModel(new DefaultComboBoxModel(v), "");
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder("AutoSuggestion Box"));
        p.add(combo, BorderLayout.NORTH);
        add(p);
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setPreferredSize(new Dimension(300, 150));
    }
    private boolean hide_flag = false;
       private void setModel(DefaultComboBoxModel mdl, String str) {
        combo.setModel(mdl);
        combo.setSelectedIndex(-1);
        tf.setText(str);
        
    }
private static DefaultComboBoxModel getSuggestedModel(java.util.List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for(String s: list) {
            if(s.startsWith(text)) m.addElement(s);
            else if(s.contains(text)) m.addElement(s);
        }
        return m;
    }
    
    }
