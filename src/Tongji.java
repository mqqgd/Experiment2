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
	
	//登陆界面
	private void setFrame(){
		System.out.println(time);
		pic=new PieChart(result,time);
		this.setTitle("您最终的得分统计");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.add(pic.getChartPanel());
		
	}
}
