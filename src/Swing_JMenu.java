import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class Swing_JMenu extends JFrame{


    Object WindowEvent;
    //定义组件
    JMenuBar jmb;	//定义菜单栏
    JMenu jm1,jm2,jm3;	//定义菜单
    JMenu jm6;	//定义菜单中的菜单
    JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5;		//定义子菜单
    public static void main(String[] args) {
        Swing_JMenu a =new Swing_JMenu();

    }



    public Swing_JMenu()
    {
        //创建组件
        jmb=new JMenuBar();		//创建菜单栏
        jm1=new JMenu("文件");	//创建菜单
        jm2=new JMenu("馆藏检索");

        jm6=new JMenu("新建");
        jm3=new JMenu("帮助");
        jm3.addActionListener((new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                tanKuang();
            }

        }));
        //帮助添加弹框
        Action tabKuang = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "友情提示");
            }
        };



        jm3.add(tabKuang);



        jmi1=new JMenuItem("文档");	//创建子菜单
        jmi2=new JMenuItem("书目检索");
        jmi3=new JMenuItem("馆藏检索");
        jmi4=new JMenuItem("类");
        jmi5=new JMenuItem("退出");



        //添加退出功能
        jmi5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame();
            }

//            public void ActionListener(ActionEvent e)
//            {
//                closeFrame();
//            }

        });






        //设置布局管理器

        jm6.add(jmi1);	//把子菜单添加到菜单中

        jm2.add(jmi2);
        jm2.add(jmi3);

        jm6.add(jmi4);
        jm6.add(jmi5);

        jm1.add(jm6);	//把菜单添加到菜单中
        jmb.add(jm1);	//把菜单添加到菜单栏中
        jmb.add(jm2);
        jmb.add(jm3);







        this.add(jmb,BorderLayout.NORTH);	//把菜单栏添加到框架北部

        //设置界面属性
        this.setTitle("菜单栏案例");		//设置界面标题
        this.setSize(600, 500);				//设置界面像素
        this.setLocation(300, 300);			//设置界面初始位置
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置虚拟机和界面一同关闭

        this.setVisible(true);				//设置界面可视化

    }

    private void tanKuang(){
        //showMessageDialog提示样式：
        System.out.println("调用弹框功能");
        //JOptionPane.showMessageDialog(null, "文字", "标题", JOptionPane.INFORMATION_MESSAGE);
        Object[] options = {"确定","取消","帮助"};int response=JOptionPane.showOptionDialog(this, "这是个选项对话框，用户可以选择自己的按钮的个数", "选项对话框标题",
                JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(response==0){ this.setTitle("您按下了第OK按钮 ");

        }else if(response==1){ this.setTitle("您按下了第Cancel按钮 ");
        }else if(response==2){ this.setTitle("您按下了第Help按钮 ");}
    }


    private void closeFrame()
    {
        System.out.println("调用窗体关闭功能");
        int result = JOptionPane.showConfirmDialog(null, "是否要退出？", "退出确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION)
            this.dispose();
    }

}
