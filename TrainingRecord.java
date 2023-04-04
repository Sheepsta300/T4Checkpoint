package checkpoint2;

import java.util.*;
import java.util.Calendar;
import java.util.regex.Pattern;


public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new LinkedList<Entry>();
    } //constructor

    // add a record to the list
   public void addSwimEntry(SwimEntry e) {
	   tr.add(e);
   }
   
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass

   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
             result = current.getEntry();
          }
        }
       return result;
   } // lookupEntry
   public String WeeklyDistance(String n) {
	   float total = 0;
	   String result = "";
	   ListIterator<Entry> iter = tr.listIterator();
	   while (iter.hasNext()) {
		   Entry current = iter.next();
		   if (Pattern.compile(Pattern.quote(n), Pattern.CASE_INSENSITIVE).matcher(current.getName()).find()) {
			   Calendar calender = Calendar.getInstance();
			   if (current.getCalendar().getTime().before(calender.getTime())) {
			   calender.add(Calendar.DATE, -7);
			       if (current.getCalendar().getTime().after(calender.getTime())) {
				    total+= current.getDistance();
			   	   }
			   }
		   }
	   }
	   result += total;
	   return result;
   }
   
   public String FindByName(String n) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       boolean check = false;
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (Pattern.compile(Pattern.quote(n), Pattern.CASE_INSENSITIVE).matcher(current.getName()).find()) {
        	  if (!check) {
         		 result = "";
         		 check = true;
         	 }
             result+= current.getEntry();
          }
        }
       return result;
   }
   public boolean EmptyList() {
	   if (tr.isEmpty()) {
		   return true;
	   }
	   return false;
   }
   
   public String FindAllByDate (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       boolean check = false;
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
        	 if (!check) {
        		 result = "";
        		 check = true;
        	 }
             result+= current.getEntry();
          }
       }
       return result;
   }
   public String removeEntry(String n, int d, int m, int y) {
	   String message = "Entry not found";
	   ListIterator<Entry> iter = tr.listIterator();
	   while (iter.hasNext()) {
		   Entry current = iter.next(); 
		   if (current.getDay()==d && current.getMonth()==m 
				   && current.getYear()==y && 
				   Pattern.compile(Pattern.quote(n), Pattern.CASE_INSENSITIVE).matcher(current.getName()).find()) {
			   tr.remove(current);
			   message = "Entry removed";
		   }
	   }
	   return message;
   }
   public boolean compare(String n, int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator();
	   while (iter.hasNext()) {
		   Entry current = iter.next(); 
		   if (current.getDay()==d && current.getMonth()==m 
				   && current.getYear()==y && 
				   Pattern.compile(Pattern.quote(n), Pattern.CASE_INSENSITIVE).matcher(current.getName()).find()) {
			   return true;
		   }
	   }
	   return false;
   }

   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }

} // TrainingRecord