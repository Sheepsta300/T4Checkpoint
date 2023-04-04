
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {
	
	
    private JTextField name = new JTextField(20);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField where = new JTextField(10);
    private JTextField tempo = new JTextField(4);
    private JTextField terrain = new JTextField(6);
    private JTextField recovery = new JTextField(2);
    private JTextField repetitions = new JTextField(2);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labtemp = new JLabel(" Tempo:");
    private JLabel labter = new JLabel(" Terrain:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labwhere = new JLabel(" Where:");
    private JLabel labrec = new JLabel(" Recovery:");
    private JLabel labrep = new JLabel(" Repetitions:");
    private JButton SwimEntry = new JButton("SwimEntry");
    private JButton CycleEntry = new JButton("CycleEntry");
    private JButton SprintEntry = new JButton("SprintEntry");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("FindAllByDate");
    private JButton AddSwimEntry = new JButton("AddSwimEntry");
    private JButton AddCycleEntry = new JButton("AddCycleEntry");
    private JButton AddSprintEntry = new JButton("AddSprintEntry");
    private JButton FindByName = new JButton("FindByName");
    private JButton RemoveEntry = new JButton("RemoveEntry");
    private JButton WeeklyDistance = new JButton("WeeklyDistance?");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
    	TrainingRecordGUI applic = new TrainingRecordGUI();
    	applic.DisableButtons();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
    	super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        
        add(labwhere);
        add(where);
        where.setEditable(true);
        
        add(labrec);
        labrec.setVisible(false);
        add(recovery);
        recovery.setVisible(false);
        recovery.setEditable(true);
        
        add(labrep);
        labrep.setVisible(false);
        add(repetitions);
        repetitions.setVisible(false);
        repetitions.setEditable(true);
        
        add(labtemp);
        labtemp.setVisible(false);
        add(tempo);
        tempo.setVisible(false);
        tempo.setEditable(true);
        
        add(labter);
        labter.setVisible(false);
        add(terrain);
        terrain.setEditable(true);
        terrain.setVisible(false);
        
        AddSwimEntry.addActionListener(this);
        add(AddSwimEntry);
        SwimEntry.setVisible(false);
        
        AddSprintEntry.addActionListener(this);
        add(AddSprintEntry);
        AddSprintEntry.setVisible(false);
        SprintEntry.addActionListener(this);
        add(SprintEntry);
        
        CycleEntry.addActionListener(this);
        add(CycleEntry);
        CycleEntry.setVisible(false);
        AddCycleEntry.addActionListener(this);
        add(AddCycleEntry);
        AddCycleEntry.setVisible(false);
        
        SwimEntry.addActionListener(this);
        add(SwimEntry);
        
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        FindByName.addActionListener(this);
        add(FindByName);
        RemoveEntry.addActionListener(this);
        add(RemoveEntry);
        WeeklyDistance.addActionListener(this);
        add(WeeklyDistance);
        
        add(outputArea);
        outputArea.setEditable(false);
        setSize(1050, 200);
        setVisible(true);
        blankDisplay();

    } // constructor
    public void switchType(String type) {
    	switch (type) {
    	case "swim entry":
    		AddCycleEntry.setVisible(false);
    		AddSwimEntry.setVisible(true);
    		SwimEntry.setVisible(false);
    		SprintEntry.setVisible(true);
    		labwhere.setVisible(true);
    		where.setVisible(true);
    		labter.setVisible(false);
    		terrain.setVisible(false);
    		labtemp.setVisible(false);
    		tempo.setVisible(false);
    	break;
    	case "sprint entry":
    		AddSwimEntry.setVisible(false);
    		AddSprintEntry.setVisible(true);
    		SprintEntry.setVisible(false);
    		CycleEntry.setVisible(true);
    		labrec.setVisible(true);
    		recovery.setVisible(true);
    		labrep.setVisible(true);
    		repetitions.setVisible(true);
    		labwhere.setVisible(false);
    		where.setVisible(false);
    	break;
    	case "cycle entry":
    		AddCycleEntry.setVisible(true);
    		AddSprintEntry.setVisible(false);
    		CycleEntry.setVisible(false);
    		SwimEntry.setVisible(true);
    		labrec.setVisible(false);
    		recovery.setVisible(false);		
    		labrep.setVisible(false);
    		repetitions.setVisible(false);
    		labter.setVisible(true);
    		terrain.setVisible(true);
    		labtemp.setVisible(true);
    		tempo.setVisible(true);
    	break;
    	}
    }

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == SwimEntry) {
        	switchType("swim entry");
        }
        if (event.getSource() == SprintEntry) {
        	switchType("sprint entry");
        }
        if (event.getSource() == CycleEntry) {
        	switchType("cycle entry");
        }
        if (event.getSource() == AddSwimEntry) {
        	message = addEntry("swim entry");
        }
        if (event.getSource() == AddSprintEntry) {
        	message = addEntry("sprint entry");
        }
        if (event.getSource() == AddCycleEntry) {
        	message = addEntry("cycle entry");
        }
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
            message = FindAllByDate();
        }
        if (event.getSource() == FindByName) {
            message = FindByName();
        }
        if (event.getSource() == RemoveEntry) {
            message = RemoveEntry();
        }
        if (event.getSource() == WeeklyDistance) {
            message = WeeklyDistance();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed
   
    public String addEntry(String what) {
        String message = "Record added\n";
        String n = name.getText();
        
        if (n.equals("")) {
        	return "Name cannot be blank";
        }
        
        try {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        	if (!(myAthletes.compare(n, d, m, y))) {
        		Entry e = null;
        		switch (what) {
        		case "swim entry":
        			String w = where.getText();
        		    e = new SwimEntry(n, d, m, y, h, mm, s, km, w);
        		break;
        		case "sprint entry":
        			int rep = Integer.parseInt(repetitions.getText());
        		    int rec = Integer.parseInt(recovery.getText());
        			e = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
        		break;
        		case "cycle entry":
        			String ter = terrain.getText();
        		    String temp = tempo.getText();
        			e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, temp);
        		break;
        		default:
        			e = new Entry(n, d, m, y, h, mm, s, km);
        		break;
        		}
        		myAthletes.addEntry(e);
        	} else {
        		return "This entry has already been added\n";
        	}
        } catch(Exception e) {
        	System.out.println(e);
        	return "Must enter an interger in all non-name fields\n";
        }
        System.out.println("Adding "+what+" entry to the records");
        EnableButtons();
        return message;
    }
    
    public void DisableButtons() {
    	
    	lookUpByDate.setEnabled(false);
    	FindAllByDate.setEnabled(false);
    	FindByName.setEnabled(false);
        RemoveEntry.setEnabled(false);
        WeeklyDistance.setEnabled(false);
    }
    public void EnableButtons() {
   
    	lookUpByDate.setEnabled(true);
    	FindAllByDate.setEnabled(true);
    	FindByName.setEnabled(true);
        RemoveEntry.setEnabled(true);
        WeeklyDistance.setEnabled(true);
    }
    public String WeeklyDistance() {
    	String n = name.getText();
        outputArea.setText("calculating total ...");
    	String message = myAthletes.WeeklyDistance(n);
    	return message;
    }
    
    public String FindByName() {
    	String n = name.getText();
        outputArea.setText("looking up record ...");
        String message = myAthletes.FindByName(n);
        return message;
    }
    public String RemoveEntry() {
    	String message = "";
    	int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String n = name.getText();
        outputArea.setText("looking up record ...");
        message = myAthletes.removeEntry(n, d, m, y);
        if (myAthletes.EmptyList()) {
        	DisableButtons();
        }
        return message;
    }

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
    public String FindAllByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.FindAllByDate(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        where.setText("");
        recovery.setText("");
        repetitions.setText("");
        tempo.setText("");
        terrain.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI
