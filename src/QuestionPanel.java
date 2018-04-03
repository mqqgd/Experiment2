import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class QuestionPanel extends JFrame{
	int score;
	int timu,lunshu;
	int timuTime=0,lunshuTime=0;
	int[] AllScore;
	JLabel questionTimeJL,questionlunshuJL,scoreJL;
	JTextField questiontimeText,questionlunshuText,scoreText;
	JTextField answer;
	JLabel massage;
	JLabel Question;
	JButton begin,next;
	JPanel jp1,jp2,jp3;
	JPanel top;
	SetAQuestion saq;
	ArrayList<Topic> al;
	ArrayList<ArrayList<Topic>> allQuestion;
	JTextArea jta;
	JScrollPane jsp;
	LinkSql ls;
	String name;
	public QuestionPanel(int score,String name){
		this.name=name;
		this.score=score;
		init();
		thisFrame();
		addAction();
	}
	
	private void init(){
		 ls=new LinkSql();
		 allQuestion=new ArrayList<ArrayList<Topic>>();
		 saq=new SetAQuestion();
		 questionTimeJL=new JLabel("题目数量");
		 scoreJL=new JLabel("上次正确次数");
		 questionlunshuJL=new JLabel("出题次数");
		 questionlunshuText=new JTextField(4);
		 questiontimeText=new JTextField(4);
		 scoreText=new JTextField(4);
		 scoreText.setEditable(false);
		 begin=new JButton("开始答题");
		 jp1=new JPanel();
		 jp2=new JPanel();
		 jp3=new JPanel();
		 top=new JPanel();
		 next=new JButton("下一个");
		 next.setEnabled(false);
		 Question=new JLabel("?+?+?=");
		 answer=new JTextField(4);
		 massage=new JLabel("欢迎使用四则运算答题软件");
		 jta=new JTextArea();
		 jta.setEnabled(false);
		 jsp=new JScrollPane(jta);
		 addFrame();
	}
	
	private void addFrame(){
		jp1.add(questionTimeJL);
		jp1.add(questiontimeText);
		jp1.add(questionlunshuJL);
		jp1.add(questionlunshuText);
		jp1.add(begin);
		jp1.add(scoreJL);
		jp1.add(scoreText);
		jp2.add(massage);
		jp3.add(Question);
		jp3.add(answer);
		jp3.add(next);
		top.setLayout(new GridLayout(3, 1));
		top.add(jp1);
		top.add(jp2);
		top.add(jp3);
		scoreText.setText(String.valueOf(score));
		this.setLayout(new BorderLayout());
		this.add(top,BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
	}
	
	private void thisFrame(){
		this.setTitle("欢迎登陆");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addAction(){
		begin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timu=Integer.parseInt(questiontimeText.getText().toString());
				lunshu=Integer.parseInt(questionlunshuText.getText().toString());
				AllScore=new int[lunshu];
				for(int i=0;i<lunshu;i++){
					AllScore[i]=0;
					saq.setQuestion(timu);
					allQuestion.add(saq.getArrayList());
				}
				timuTime=0;
				lunshuTime=0;
				begin.setEnabled(false);
				next.setEnabled(true);
				massage.setText(String.format("第%d/%d轮，第%d/%d题",(lunshuTime+1),lunshu,(timuTime+1),timu));
				Question.setText(allQuestion.get(0).get(0).getTopic());
				jta.setText("");
				
			}
		});
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!answer.getText().equals("")){
					int result=Integer.parseInt(answer.getText().toString());
					jta.append(allQuestion.get(lunshuTime).get(timuTime).getTopic()+
							"="+result+"   "+allQuestion.get(lunshuTime).get(timuTime).getResult());
					if(allQuestion.get(lunshuTime).get(timuTime).getResult()==result){
						AllScore[lunshuTime]++;
						jta.append("   √\n");
					}else{
						jta.append(" ×\n");
					}
				}
				if(timuTime==(timu-1)){
					lunshuTime++;
					timuTime=0;
				}else{
					timuTime++;
				}
				if(!(timuTime<=(timu-1)&&lunshuTime<=(lunshu-1))){
					next.setEnabled(false);
					begin.setEnabled(true);
					int resultRight=0;
					for(int i=0;i<timu;i++){
						resultRight=resultRight+AllScore[i];
					}
					System.out.println(timu*lunshu+" "+resultRight);
					massage.setText(String.format("恭喜你！本次题目总%d道，答对%d道", timu*lunshu,resultRight));
					begin.setText("再次答题");
					ls.changeMySqlDate(String.format("update user set lastscore=%d where name='%s'",resultRight, name));
					scoreText.setText(String.valueOf(resultRight));
					new Tongji(AllScore,lunshu);
				}
				if((timuTime<=(timu-1)&&lunshuTime<=(lunshu-1))){
					massage.setText(String.format("第%d/%d轮，第%d/%d题",(lunshuTime+1),lunshu,(timuTime+1),timu));
					Question.setText(allQuestion.get(lunshuTime).get(timuTime).getTopic());
				}else{
					Question.setText("?+?=");
				}
				
			}
		});
	}
}
