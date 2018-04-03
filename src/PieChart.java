import java.awt.Font;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  

public class PieChart {  
	ChartPanel frame1;  
	int[] result;
	int times;
	public  PieChart(int[] result,int times){  
		this.result=result;
		this.times=times;
		CategoryDataset dataset = getDataSet();  
		JFreeChart chart = ChartFactory.createBarChart3D(  
			 "Сѧ��������", // ͼ�����  
			"�������", // Ŀ¼�����ʾ��ǩ  
			"����", // ��ֵ�����ʾ��ǩ  
			dataset, // ���ݼ�  
			PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
			true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
			false,          // �Ƿ����ɹ���  
			false           // �Ƿ�����URL���� 	 
		);  
		  
		//�����￪ʼ  
		CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������  
		CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�  
		domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
		domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
		ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
		rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
		chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
		    
		//�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������  
		//����Ҳ������chartFrame,����ֱ������һ��������Frame
		frame1=new ChartPanel(chart,true);          
	       
	}  
	
	private CategoryDataset getDataSet() {  
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();   
		System.out.println(times);
		for(int i=0;i<times;i++){
			System.out.println("lalal");
			dataset.addValue(result[i],"��"+(i+1)+"��","��"+(i+1)+"��");
		}
		return dataset;   
	}
	
	public ChartPanel getChartPanel(){  
		return frame1;  
	}  
}  