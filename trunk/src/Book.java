import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Date;
import java.text.SimpleDateFormat;
class Book{
	private String name="",author="",notes="";
	private ArrayList<Integer> volumes=new ArrayList<Integer>();
	private Boolean read=false,end=false,burn=false;
	private Date date;
	
	public void setName(String s){name=s;}
	public String getName(){return name;}
	public void setAuthor(String s){author=s;}
	public String getAuthor(){return author;}
	public void setList(ArrayList<Integer> a){volumes=a;}
	public ArrayList<Integer> getList(){return volumes;}
	public void setRead(Boolean b){read=b;}
	public Boolean getRead(){return read;}
	public void setEnd(Boolean b){end=b;}
	public Boolean getEnd(){return end;}
	public void setBurn(Boolean b){burn=b;}
	public Boolean getBurn(){return burn;}
	public void setDate(Date d){date=d;}
	public Date getDate(){return date;}
	public void setNotes(String s){notes=s;}
	public String getNotes(){return notes;}
	
	public Book(){}
	public Book(String[] data){
		date=new Date(System.currentTimeMillis());
		for (int i=0;i<data.length;i++){
			if (i==0) setName(data[i]);
			if (i==1) setAuthor(data[i]==null?"":data[i]);
			if (i==2) setList(toList(data[i]));
			if (i==3) setRead(data[i].equals("1")?true:false);
			if (i==4) setEnd(data[i].equals("1")?true:false);
			if (i==5) setBurn(data[i].equals("1")?true:false);
			if (i==6) setDate(parseDate(data[i]));
			if (i==7) setNotes(data[i]==null?"":data[i]);
		}
	}
	public Book(String n,String a,String l,Boolean r,Boolean e,Boolean b,Date d,String o){
		setName(n);
		if (a!=null) setAuthor(a);
		if (l!=null) setList(Book.toList(l));
		if (r!=null) setRead(r);
		if (e!=null) setEnd(e);
		if (b!=null) setBurn(b);
		if (d!=null) setDate(d);
		if (o!=null) setNotes(o);
	}
	
	public static ArrayList<Integer> toList(String s){
		ArrayList<Integer> list=new ArrayList<Integer>();
		if (s.length()!=0){
			String[] data=s.split(" ");
			for (String a:data){
				if (a.indexOf("-")>-1){
					String[] b=a.split("-");
					for (int i=Integer.parseInt(b[0]);i<=Integer.parseInt(b[1]);i++) list.add(i);
				}else{
					list.add(Integer.valueOf(a));
				}
			}
			Collections.sort(list);
		}
		return list;
	}
	public static String toText(ArrayList<Integer> list){
		int a=0,b=0;
		String s="";
		if (list.size()>0){
			for (Integer ii:list){
				int i=ii.intValue();
				if (a==0){a=i;b=i;continue;}
				if (i==b+1) b=i;
				else{
					if (a==b) s+=a+" ";
					else s+=a+"-"+b+" ";
					a=i;b=i;
				}
			}
			if (a==b) s+=a+" ";
			else s+=a+"-"+b+" ";
		}
		return s.trim();
	}
	public static Date parseDate(String s){
		try{
			return new SimpleDateFormat("yyyyMMddHHmmss").parse(s);
		}catch(Exception e){}
		return null;
	}
	public static String formatDate(Date d){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(d);
	}
	
	public boolean matches(String s){
		return (getName().toUpperCase().matches("(.*)"+s.toUpperCase()+"(.*)")||getAuthor().toUpperCase().matches("(.*)"+s.toUpperCase()+"(.*)")||getNotes().toUpperCase().matches("(.*)"+s.toUpperCase()+"(.*)"))?true:false;
	}
	
	public void print(){
		System.out.printf("%-22s,%-10s,%-5s(%-2d),%-5b,%-5b,%-5b,%-10s,%30s%n",getName(),getAuthor(),toText(getList()),getList().size(),getRead(),getEnd(),getBurn(),formatDate(getDate()),getNotes());
    }
    
    public static boolean valid(String s){
    	if (s.equals("")) return true;
    	if (s.startsWith("-")||s.endsWith("-")) return false;
    	boolean flag=true;
    	for (char c:s.toCharArray()) if (c!=' '&&c!='-'&&!(c>='0'&&c<='9')) flag=false;
    	if (!flag) return false;
    	int index=0;
    	while ((index=s.indexOf(' ',index+1))!=-1) if (s.charAt(index-1)==' '||s.charAt(index-1)=='-'||s.charAt(index+1)==' '||s.charAt(index+1)=='-') return false;
        index=0;
    	while ((index=s.indexOf('-',index+1))!=-1) if (s.charAt(index-1)==' '||s.charAt(index-1)=='-'||s.charAt(index+1)==' '||s.charAt(index+1)=='-') return false;
        return true;
    }
}

class Name implements Comparator<Book>{public int compare(Book b1,Book b2){return b1.getName().compareTo(b2.getName());}}
/*class Author implements Comparator<Book>{public int compare(Book b1,Book b2){return b1.getAuthor().compareTo(b2.getAuthor());}}
class Volumes implements Comparator<Book>{public int compare(Book b1,Book b2){
	if (b1.getList().size()<b2.getList().size()) return -1;
	if (b1.getList().size()==b2.getList().size()) return 0;
	return 1;
	}
}
class Read implements Comparator<Book>{public int compare(Book b1,Book b2){return b1.getRead().compareTo(b2.getRead());}}
class End implements Comparator<Book>{public int compare(Book b1,Book b2){return b1.getEnd().compareTo(b2.getEnd());}}
class Burn implements Comparator<Book>{public int compare(Book b1,Book b2){return b1.getBurn().compareTo(b2.getBurn());}}
*/