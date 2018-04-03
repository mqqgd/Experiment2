
public class Topic {
	private int result;
	private String topic;
	public Topic(String topic,int result){
		this.topic=topic;
		this.result=result;
	}
	void setResult(int result){
		this.result=result;
	}
	int getResult(){
		return result;
	}
	void setTopic(String topic){
		this.topic=topic;
	}
	String getTopic(){
		return topic;
	}
}
