import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class Login extends JFrame{
	JLabel userLb,passLb;
	JPanel userJP,passJP,buttonJP;
	JTextField user;
	JPasswordField pass;
	JButton ok,quit;
	Logined logined;
	public Login(){
		init();
		addFrame();
		actionListen();
		this.setTitle("»¶Ó­µÇÂ½");
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void init(){
		userLb=new JLabel("ÓÃ»§");
		passLb=new JLabel("ÃÜÂë");
		userJP=new JPanel();
		passJP=new JPanel();
		buttonJP=new JPanel();
		user=new JTextField(20);
		pass=new JPasswordField(20);
		ok=new JButton("µÇÂ½");
		quit=new JButton("ÍË³ö");
	}
	private void addFrame(){
		userJP.add(userLb);
		userJP.add(user);
		passJP.add(passLb);
		passJP.add(pass);
		buttonJP.add(ok);
		buttonJP.add(quit);
		this.setLayout(new GridLayout(3, 1));
		this.add(userJP);
		this.add(passJP);
		this.add(buttonJP);
	}
	
	private void hideFrame(){
		this.setVisible(false);
	}
	
	private void actionListen(){
		ok.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=user.getText().toString();
				String passW=pass.getText().toString();
				logined=new Logined();
				if(logined.login(name, passW)){
					new QuestionPanel(logined.getScore(name),name);
					hideFrame();
				}
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
}
