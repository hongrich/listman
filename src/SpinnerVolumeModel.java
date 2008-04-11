/*import javax.swing.AbstractSpinnerModel;
public class SpinnerVolumeModel extends AbstractSpinnerModel{
    String s;
    public SpinnerVolumeModel(){
    	s="";
    }
    public void setValue(Object value){
    	if (Book.valid((String)value)) s=(String)value;
    }
    public Object getValue(){
    	return s;
    }
    public Object getNextValue(){
    	return changeLast(1);
    }
    public Object getPreviousValue(){
    	return changeLast(-1);
    }
    String changeLast(int n){
    	if (s.equals("")) if (n==1) return "1";
    	String[] ss=s.split("-");
    	if (ss.length==1) if (n==1) return s+"-"+(Integer.parseInt(s)+1)+"";
		String t="";
		for (int i=0;i<ss.length-1;i++) t+=ss[i]+"-";
		t+=Integer.parseInt(ss[ss.length-1])+n;
		return t;
    }
}*/