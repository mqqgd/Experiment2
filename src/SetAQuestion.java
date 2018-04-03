import java.util.ArrayList;

public class SetAQuestion {
	int n;
	int next,time;
	String topic;
	GetRandomDigit grd=null;
	ArrayList<Topic> al;
	Topic question;
	ArithmeticResult ar;
	public void setQuestion(int n){
		this.n=n;
		init();
		setQuestion();
	}
	
	public ArrayList<Topic> getArrayList(){
		return al;
	}
	
	public void init(){
		grd=new GetRandomDigit();
		al=new ArrayList<Topic>();
		ar=new ArithmeticResult();
	}
	
	public void setQuestion(){
		//出题的数量
		int[] questionTopic;;
		int[] questionOprator;
		for(int i=0;i<n;i++){
			//出题的长度
			time=grd.Time();
			questionTopic=new int[time];
			questionOprator=new int[time-1];
			for(int t=0;t<time;t++){
				questionTopic[t]=grd.randomDigit();
				if(t<time-1){
					questionOprator[t]=grd.oprator();
				}
			}
			topic="";
			int bracketsIndex=-1;
			if(PQ()){
				bracketsIndex=grd.BracketsIndex(time);
			}
			for(int t=0;t<time;t++){
				if(bracketsIndex==t){
					topic=topic+"(";
				}
				
				topic=topic+questionTopic[t];
				if(bracketsIndex+1==t && bracketsIndex!=-1){
					topic=topic+")";
				}
				if(t<time-1){
					topic=topic+getType(questionOprator[t]);
				}
			}
			topic=topic+"=";
			double a=ar.Result(topic);
			if(a<0||a%1!=0||a>500){
				i--;
				continue;
			}
			question=new Topic(topic,(int)a);
			al.add(question);
		}
	}
	
	String getType(int type){
		if(type==1){
			return "+";
		}else if(type==2){
			return "-";
		}else if(type==3){
			return "×";
		}else{
			return "÷";
		}
	}
	
	boolean PQ(){
		int PQ=grd.probabilityQuestion();
		if(PQ<=120){
			return true;
		}else{
			return false;
		}
	}
}
