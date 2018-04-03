import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Tongji extends JFrame{
	PieChart pic;
	int time;
	int [] result;
	public Tongji(int[] result,int time){
		this.time=time;
		this.result=result;
		setFrame();
	}
	private void setFrame(){
		System.out.println(time);
		pic=new PieChart(result,time);
		this.setTitle("»¶Ó­µÇÂ½");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.add(pic.getChartPanel());
		
	}
}
