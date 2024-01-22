import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileSystemView;
import java.util.*;
import java.text.*;
import java.net.*;

public class EasySplitter extends JFrame implements ActionListener,ItemListener
{

JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17 ,l18,l19,l20;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
JButton bsp;
JButton ab1,ab2,ab3;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
JTextArea ta1,ta2;
JCheckBox c1,c2,c3,c4,c5;
JRadioButton r1,r2,r3,r4,r5,r6,r7;
JTabbedPane tp;
JScrollPane sp1,sp2,sp3;
ButtonGroup bg1,bg2,bg3;
JComboBox cb;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25 ,p26,p27,p28,p29;
JPanel x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;
JList li1;
JFileChooser fc1,fc2,fc3;
String[] str=new String[100];
int ctr=0;
String cmf=null;
int csize;
int ind;
String[] ps={"10 KB","100 KB","120 KB","500 KB","720 KB","1.2 MB","1.44 MB","100 MB","250 MB","650 MB"};
int[] pos={10240,102400,122880,512000,737280,1213952,1457644,103809020,26004085,674758630};
int attr[]=new int[3];
int[] size=new int[1000];
int[] no=new int[1000];
int[] lsize=new int[1000];
char[] mod=new char[1000];
int gin[]=new int[1000];
File src;


public EasySplitter()
{
super("Splitter_Merger - Powered by Ichha & Varsha");
Container c=getContentPane();
tp=new JTabbedPane();
tp.setTabPlacement(JTabbedPane.TOP);

l18=new JLabel( "Splitter_Merger",JLabel.CENTER);
l18.setFont(new Font("Jokerman", Font.PLAIN, 60));


p26=new JPanel();

p26.add(l18);

l19=new JLabel( "Powered By",JLabel.CENTER);


l19.setFont(new Font("Verdana", Font.BOLD, 50));


p27=new JPanel();

p27.add(l19);

l20=new JLabel( "Ichha & Varsha",JLabel.CENTER);

l20.setFont(new Font("Algerian", Font.PLAIN, 45));


p28=new JPanel();

p28.add(l20);
p29=new JPanel();

p29.add(l18);
p29.add(l19);
p29.add(l20);

tp.addTab("Home",p29);



l1=new JLabel("Source Files:(Double click each to configure splits separately)");
l1.setToolTipText("Double click on each item to set split configuration separately and then press Set button to save it");
x1=new JPanel(new FlowLayout(FlowLayout.LEFT));
x1.add(l1);
l2=new JLabel("Destination File:");
x2=new JPanel(new FlowLayout(FlowLayout.LEFT));
x2.add(l2);
l3=new JLabel("Comment:");
x3=new JPanel(new FlowLayout(FlowLayout.LEFT));
x3.add(l3);
li1=new JList();
int md=ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
li1.setSelectionMode(md);
li1.setVisibleRowCount(6);
li1.addMouseListener(new MouseAdapter()
{
public void mouseClicked(MouseEvent me)
{
try{
JList l=(JList)me.getSource();
int index=l.locationToIndex(me.getPoint());
ind=li1.getSelectedIndex();
if((me.getClickCount()==2)&&(!li1.isSelectionEmpty())&&(li1.getSelectedValue()!=null))
{
bsp.setVisible(true);
li1.setEnabled(false);
b1.setEnabled(false);
b2.setEnabled(false);
b3.setEnabled(false);
}
else
{
if (mod[ind]=='a')
{
cb.setSelectedIndex(gin[ind]);
r1.setSelected(true);
}
else if(mod[ind]=='b')
{
r2.setSelected(true);
r5.setSelected(true);
}
tf2.setText(String.valueOf(no[ind]));
tf3.setText(String.valueOf(size[ind])+" & "+String.valueOf(lsize[ind]));

}
}
catch(Exception e)
{

}
}
});

sp1=new JScrollPane(li1);

b1=new JButton("Add");
b2=new JButton("Remove");
b3=new JButton("Remove All");
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

p1=new JPanel(new GridLayout(3,1));
p1.add(b1);
p1.add(b2);
p1.add(b3);

p2=new JPanel(new BorderLayout());
p2.add(sp1,BorderLayout.CENTER);
p2.add(p1,BorderLayout.EAST);

tf1=new JTextField(25);
b4=new JButton("Browse");
b4.addActionListener(this);
p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
p3.add(tf1);
p3.add(b4);

ta1=new JTextArea(30,4);
ta1.setLineWrap(true);
ta1.setWrapStyleWord(true);

sp2=new JScrollPane(ta1);


p4=new JPanel();
p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
p4.add(x1);
p4.add(p2);
p4.add(Box.createVerticalStrut(20));
p4.add(x2);
p4.add(p3);
p4.add(Box.createVerticalStrut(20));
p4.add(x3);
p4.add(sp2);

r1=new JRadioButton("Predefined");
r2=new JRadioButton("Customized");
bg1=new ButtonGroup();
bg1.add(r1);
bg1.add(r2);
r1.addItemListener(this);
r2.addItemListener(this);

cb=new JComboBox();
for(int i=0;i<ps.length;i++)
cb.addItem(ps[i]);
cb.setSelectedIndex(2);

tf2=new JTextField(10);
tf3=new JTextField(15);
l4=new JLabel("  files");
r3=new JRadioButton("Split into:         ");
r4=new JRadioButton("Split each file:");
bg2=new ButtonGroup();
bg2.add(r3);
bg2.add(r4);
r5=new JRadioButton("bytes");
r6=new JRadioButton("KB");
r7=new JRadioButton("MB");
bg3=new ButtonGroup();
bg3.add(r5);
bg3.add(r6);
bg3.add(r7);
r3.addItemListener(this);
r4.addItemListener(this);
r5.addItemListener(this);
r6.addItemListener(this);
r7.addItemListener(this);

p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
p5.add(r1);
p5.add(cb);

p6=new JPanel();
p6.setLayout(new BoxLayout(p6,BoxLayout.X_AXIS));
p6.add(Box.createHorizontalStrut(25));
p6.add(r3);
p6.add(tf2);
p6.add(l4);

p7=new JPanel();
p7.setLayout(new BoxLayout(p7,BoxLayout.X_AXIS));
p7.add(Box.createHorizontalStrut(25));
p7.add(r4);
p7.add(tf3);

bsp=new JButton("Set>>");
bsp.addActionListener(this);
p9=new JPanel();
p9.setLayout(new BoxLayout(p9,BoxLayout.X_AXIS));
p9.add(Box.createHorizontalStrut(20));
p9.add(r5);
p9.add(r6);
p9.add(r7);
p9.add(bsp);

p8=new JPanel();
p8.setLayout(new BoxLayout(p8,BoxLayout.Y_AXIS));
p8.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"File Size"));
p8.add(p5);
p8.add(Box.createVerticalStrut(10));
x4=new JPanel(new FlowLayout(FlowLayout.LEFT));
x4.add(r2);
p8.add(x4);
p8.add(p6);
p8.add(p7);
p8.add(p9);

c1=new JCheckBox("Delete original file after splitting");

c3=new JCheckBox("Generate batch file for merging");

p10=new JPanel(new GridLayout(3,1));
p10.add(c1);

p10.add(c3);

p11=new JPanel(new FlowLayout());
p11.add(p8);
p11.add(p10);

b5=new JButton("Split");
b6=new JButton("Close");
b7=new JButton("Help");
ab1=new JButton("About");
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
ab1.addActionListener(this);

p12=new JPanel(new FlowLayout());
p12.add(b5);
p12.add(b6);
p12.add(b7);
p12.add(ab1);

p13=new JPanel(new BorderLayout());
p13.add(p4,BorderLayout.WEST);
p13.add(p11,BorderLayout.CENTER);
p13.add(p12,BorderLayout.SOUTH);

tp.addTab("Split",p13);



//second tab

l5=new JLabel("Split File:");
x5=new JPanel(new FlowLayout(FlowLayout.LEFT));
x5.add(l5);
l6=new JLabel("Destination Folder:");
x6=new JPanel(new FlowLayout(FlowLayout.LEFT));
x6.add(l6);
l7=new JLabel("Comment:");
x7=new JPanel(new FlowLayout(FlowLayout.LEFT));
x7.add(l7);

tf4=new JTextField(25);
tf5=new JTextField(25);
ta2=new JTextArea(30,4);
ta2.setLineWrap(true);
ta2.setWrapStyleWord(true);
sp3=new JScrollPane(ta2);

b8=new JButton("Browse");
b9=new JButton("Browse");
b10=new JButton("Merge");
b11=new JButton("Close");
b12=new JButton("Get Comment");
b13=new JButton("View Details");
b14=new JButton("Help");
ab2=new JButton("About");

b8.addActionListener(this);
b9.addActionListener(this);
b10.addActionListener(this);
b11.addActionListener(this);
b12.addActionListener(this);
b13.addActionListener(this);
b14.addActionListener(this);
ab2.addActionListener(this);

c4=new JCheckBox("Delete split files after merging");

l8=new JLabel("Original File  :                      ");
l9=new JLabel("Original Size  :                      ");
l10=new JLabel("No of splits   :                      ");
l11=new JLabel("Each split size:                      ");
l12=new JLabel("Last split size:                      ");
l13=new JLabel("Have Comments  :                      ");
l14=new JLabel("Have Batchfile :                      ");

p14=new JPanel(new FlowLayout());
p14.add(tf4);
p14.add(b8);

p15=new JPanel(new FlowLayout());
p15.add(tf5);
p15.add(b9);

p16=new JPanel();
p16.setLayout(new BoxLayout(p16,BoxLayout.Y_AXIS));
p16.add(x5);
p16.add(p14);
p16.add(Box.createVerticalStrut(5));
p16.add(x6);
p16.add(p15);
p16.add(Box.createVerticalStrut(5));
p16.add(x7);
p16.add(sp3);
p16.add(c4);

p17=new JPanel();
p17.setLayout(new GridLayout(7,1,10,10));
p17.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Details"));
p17.add(l8);
p17.add(l9);
p17.add(l10);
p17.add(l11);
p17.add(l12);
p17.add(l13);
p17.add(l14);

p18=new JPanel(new GridLayout(1,6));
p18.add(b10);
p18.add(b11);
p18.add(b12);
p18.add(b13);
p18.add(b14);
p18.add(ab2);

p19=new JPanel(new BorderLayout());
p19.add(p16,BorderLayout.WEST);
p19.add(p17,BorderLayout.CENTER);
p19.add(p18,BorderLayout.SOUTH);

tp.addTab("Merge",p19);

//third tab

tf6=new JTextField(25);
tf7=new JTextField(25);
tf8=new JTextField(25);

l15=new JLabel("Default Split Folder:");
x8=new JPanel(new FlowLayout(FlowLayout.LEFT));
x8.add(l15);
l16=new JLabel("Default Merge Folder:");
x9=new JPanel(new FlowLayout(FlowLayout.LEFT));
x9.add(l16);
l17=new JLabel("Default Size:");
x10=new JPanel(new FlowLayout(FlowLayout.LEFT));
x10.add(l17);


b15=new JButton("Browse");
b16=new JButton("Browse");
b17=new JButton("Browse");
b15.addActionListener(this);
b16.addActionListener(this);
b17.addActionListener(this);

p20=new JPanel(new FlowLayout());
p20.add(tf6);
p20.add(b15);

p21=new JPanel(new FlowLayout());
p21.add(tf7);
p21.add(b16);

p22=new JPanel(new FlowLayout());
p22.add(tf8);
p22.add(b17);

p23=new JPanel();
p23.setLayout(new BoxLayout(p23,BoxLayout.Y_AXIS));
p23.add(x8);
p23.add(p20);
p23.add(Box.createVerticalStrut(15));
p23.add(x9);
p23.add(p21);
p23.add(Box.createVerticalStrut(15));
p23.add(x10);
p23.add(p22);

b18=new JButton(" Save ");
b19=new JButton(" Close ");
b20=new JButton("Help");
ab3=new JButton("About");
b18.addActionListener(this);
b19.addActionListener(this);
b20.addActionListener(this);
ab3.addActionListener(this);
p25=new JPanel(new FlowLayout());
p25.add(b18);
p25.add(b19);
p25.add(b20);
p25.add(ab3);

p24=new JPanel(new BorderLayout());
p24.add(p23,BorderLayout.NORTH);
p24.add(p25,BorderLayout.SOUTH);
tp.addTab("Options",p24);

c.add(tp,BorderLayout.CENTER);

addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});

fc1=new JFileChooser();
fc1.setMultiSelectionEnabled(true);
fc2=new JFileChooser();
fc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
fc3=new JFileChooser();
fc3.addChoosableFileFilter(new filter1());

cb.setEnabled(true);
r3.setEnabled(false);
r4.setEnabled(false);
r5.setEnabled(false);
r5.setSelected(true);
r6.setEnabled(false);
r7.setEnabled(false);
tf2.setEnabled(false);
tf3.setEnabled(false);
r1.setSelected(true);
b12.setEnabled(false);
bsp.setVisible(false);
tf6.setEditable(false);
tf7.setEditable(false);
tf8.setEditable(false);
src=new File("jsplit.class");

tf3.addFocusListener(new FocusAdapter()
{
public void focusLost(FocusEvent fe)
{
try
{
if(tf3.getText().equals(""))
{
csize=0;
}
else
{
if (r5.isSelected())
csize=Integer.parseInt(tf3.getText());
else if (r6.isSelected())
csize=(int)(Float.parseFloat(tf3.getText())*1024);
else if (r7.isSelected())
csize=(int)(Float.parseFloat(tf3.getText())*1024*1024);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog((Container)null,tf3.getText()+" : This is not a valid size","Splitter 1.7.0",JOptionPane.OK_OPTION);
}
}
});
getConfig();
}
public static void main(String as[])
{
EasySplitter js=new EasySplitter();
js.setLocation(50,50);
js.setSize(700,470);
js.show();
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
int res=fc1.showOpenDialog(null);
if(res==JFileChooser.APPROVE_OPTION)
{
File[] fl=fc1.getSelectedFiles();
for(int i=0;i<fl.length;i++)
{
str[ctr]=fl[i].getPath();
int fsize=(int)fl[i].length();
if(r1.isSelected())
{
int j=cb.getSelectedIndex();
csize=pos[j];
attr=getAttr(fsize,csize,0);
mod[ctr]='a';
gin[ctr]=j;
}
else if(r2.isSelected())
{
if(r3.isSelected())
attr=getAttr(fsize,0,Integer.parseInt(tf2.getText()));
else if(r4.isSelected())
attr=getAttr(fsize,csize,0);
mod[ctr]='b';
gin[ctr]=0;
}
size[ctr]=attr[0];
lsize[ctr]=attr[2];
no[ctr]=attr[1];
tf2.setText(String.valueOf(no[ctr]));
tf3.setText(String.valueOf(size[ctr])+" & "+String.valueOf(lsize[ctr]));
ctr++;
}
li1.setListData(str);
}
}
else if(e.getSource()==b2)
{
int[] ind=li1.getSelectedIndices();
String[] tsr=new String[1000];
int[] tsz=new int[1000];
int[] tsl=new int[1000];
int[] tn=new int[1000];
char[] tc=new char[1000];
int tg[]=new int[1000];
int dtr=0;
for(int i=0;i<ctr;i++)
{
int j;
for(j=0;(j<ind.length)&&(i!=ind[j]);j++);
if(j==ind.length)
{
tsr[dtr]=str[i];
tsz[dtr]=size[i];
tsl[dtr]=lsize[i];
tn[dtr]=no[i];
tc[dtr]=mod[i];
tg[dtr]=gin[i];
dtr++;
}
}
ctr=dtr;
str=tsr;
size=tsz;
lsize=tsl;
no=tn;
mod=tc;
gin=tg;
li1.setListData(str);
}
else if(e.getSource()==b3)
{
str=new String[1000];
size=new int[1000];
lsize=new int[1000];
no=new int[1000];
mod=new char[1000];
gin=new int[1000];
ctr=0;
li1.setListData(str);
}
else if(e.getSource()==b4)
{
int res=fc2.showDialog(null,null);
if(res==JFileChooser.APPROVE_OPTION)
{
String path=changesl(fc2.getSelectedFile().getPath()+"/SplitFiles");
tf1.setText(path);
}
}
else if(e.getSource()==b5)
{
boolean bx=true;
if(ctr==0)
JOptionPane.showMessageDialog((Container)null,"No source file is selected","Splitter 1.7.0",JOptionPane.OK_OPTION);
else if(tf1.getText().equals(""))
JOptionPane.showMessageDialog((Container)null,"No split folder is entered","Splitter_Merger",JOptionPane.OK_OPTION);
else
{
String dst=tf1.getText();
File f;
try
{
f=new File(dst);
if(!f.exists())
f.mkdirs();
String comments;
if (!(ta1.getText().equals("")))
comments=ta1.getText();
else
comments=null;
for(int i=0;i<ctr;i++)
{
boolean del=false,batch=false;
if(c1.isSelected()) del=true;

if(c3.isSelected()) batch=true;
String jsf=new File(str[i]).getName();
String dest=f.toString()+"/"+getName(jsf,0);

int res=split(str[i],dest,comments,no[i],size[i],lsize[i],del,batch);
if(res==0)
bx=false;
}
if(bx)
JOptionPane.showMessageDialog((Container)null,"Splitted Successfully!","Splitter_Merger",JOptionPane.OK_OPTION);
else
JOptionPane.showMessageDialog((Container)null,"Splitter encounters some errors!  Only Correct files if any are Splitted Successfully!","EasySplitter_Merger",JOptionPane.OK_OPTION);
}catch(Exception ef){
JOptionPane.showMessageDialog((Container)null,"Destination folder is not entered properly","Splitter _Merger",JOptionPane.OK_OPTION);
}

}
}
else if(e.getSource()==b6)
{
System.exit(0);
}
else if(e.getSource()==b7)
{
help hp=new help();
hp.setSize(500,400);
hp.setLocation(50,50);
hp.setVisible(true);
}
else if(e.getSource()==b8)
{
int res=fc3.showOpenDialog(null);
if(res==JFileChooser.APPROVE_OPTION)
{
String path=changesl(fc3.getSelectedFile().getPath());
tf4.setText(path);
}
}
else if(e.getSource()==b9)
{
int res=fc2.showDialog(null,null);
if(res==JFileChooser.APPROVE_OPTION)
{
String path=changesl(fc2.getSelectedFile().getPath()+"/MergedFiles");
tf5.setText(path);
}

}
else if(e.getSource()==b10)
{
boolean delkey=false;
if(tf4.getText().equals(""))
JOptionPane.showMessageDialog((Container)null,"No split file is entered","Splitter_Merger",JOptionPane.OK_OPTION);
else if(!(new File(tf4.getText()).exists()))
JOptionPane.showMessageDialog((Container)null,"Split file you specified not found or not correct!","Splitter _Merger",JOptionPane.OK_OPTION);
else if(tf5.getText().equals(""))
JOptionPane.showMessageDialog((Container)null,"Merge folder should be entered","Splitter _Merger",JOptionPane.OK_OPTION);
else
{
File f=new File(tf5.getText());
if (!f.exists()) f.mkdirs();
if(c4.isSelected()) delkey=true;
try
{
merge(tf4.getText(),tf5.getText(),delkey);
}
catch(Exception ex)
{
JOptionPane.showMessageDialog((Container)null,"Error occured in merging: Not merged","Splitter _Merger",JOptionPane.OK_OPTION);
}
}
}
else if(e.getSource()==b11)
{
System.exit(0);
}
else if(e.getSource()==b12)
{
try
{
String cname=getName((new File(tf4.getText())).getName(),-1);
File flc=new File(new File(tf4.getText()).getParent()+"/"+cname);
if (!flc.exists())
JOptionPane.showMessageDialog((Container)null,"Comment File not found!","Splitter_Merger",JOptionPane.OK_OPTION);
else
{
FileReader frc=new FileReader(flc);
BufferedReader brc=new BufferedReader(frc);
String data;
while((data=brc.readLine())!=null)
ta2.setText(ta2.getText()+data);
}
}catch(Exception ex2){
JOptionPane.showMessageDialog((Container)null,"Unreadable error!","Splitter_Merger",JOptionPane.OK_OPTION);
}
}
else if(e.getSource()==b13)
{
try
{
if (tf4.getText().equals(""))
{
JOptionPane.showMessageDialog((Container)null,"No split file specified!","Splitter_Merger",JOptionPane.OK_OPTION);
}
else if(!(new File(tf4.getText()).exists()))
{
JOptionPane.showMessageDialog((Container)null,"Split file you specified not found or not correct!","Splitter _Merger",JOptionPane.OK_OPTION);
}
else
{
FileReader fr=new FileReader(tf4.getText());
BufferedReader br=new BufferedReader(fr);

String l1=br.readLine();
StringTokenizer st1=new StringTokenizer(l1,",");
String beg=st1.nextToken();
if(!(beg.equals("jfs")))
{
JOptionPane.showMessageDialog((Container)null,"Not a valid split file!","Splitter_Merger",JOptionPane.OK_OPTION);
}
else
{
l8.setText("Original File    : "+st1.nextToken());
l9.setText("Original Size    : "+st1.nextToken()+" bytes");
String l2=br.readLine();
StringTokenizer st2=new StringTokenizer(l2,",");
String cmt=st2.nextToken();
String bat=st2.nextToken();
l10.setText("No of splits    : "+st2.nextToken());
l11.setText("Each split size : "+st2.nextToken()+" bytes");
l12.setText("Last split size : "+st2.nextToken()+" bytes");
String cf;
if(cmt.equals("null"))
cf="No";
else
{
cf="Yes";
b12.setEnabled(true);
cmf=changesl((new File(tf4.getText()).getParent())+"/"+cmt);
}
l13.setText("Have Comments   : "+cf);
String bf;
if(bat.equals("null"))
bf="No";
else
bf="Yes";
l14.setText("Have Batchfile  : "+bf);
}
}
}
catch(Exception ex1)
{
JOptionPane.showMessageDialog((Container)null,"Unexpected Error","Splitter_Merger",JOptionPane.OK_OPTION);
clearlab();
}

}
else if(e.getSource()==b14)
{
help hp=new help();
hp.setSize(500,400);
hp.setLocation(50,50);
hp.setVisible(true);
}
else if(e.getSource()==b15)
{
int res=fc2.showDialog(null,null);
if(res==JFileChooser.APPROVE_OPTION)
{
String path=changesl(fc2.getSelectedFile().getPath()+"/SplitFiles");
tf6.setText(path);
}

}
else if(e.getSource()==b16)
{
int res=fc2.showDialog(null,null);
if(res==JFileChooser.APPROVE_OPTION)
{
String path=changesl(fc2.getSelectedFile().getPath()+"/MergedFiles");
tf7.setText(path);
}

}
else if(e.getSource()==b17)
{
sizeset sz=new sizeset();
sz.setSize(250,270);
sz.setLocation(300,300);
sz.show();
}
else if(e.getSource()==b18)
{
if(tf6.getText().equals(""))
JOptionPane.showMessageDialog((Container)null,"Default split folder is not empty","Splitter_Merger",JOptionPane.OK_OPTION);
else if(tf7.getText().equals(""))
JOptionPane.showMessageDialog((Container)null,"Default merge folder is not empty","Splitter_Merger",JOptionPane.OK_OPTION);
else
{
setConfig();
getConfig();
JOptionPane.showMessageDialog((Container)null,"Default values saved!","Splitter_Merger",JOptionPane.OK_OPTION);
}
}
else if(e.getSource()==b19)
{
System.exit(0);
}
else if(e.getSource()==b20)
{
help hp=new help();
hp.setSize(500,400);
hp.setLocation(50,50);
hp.setVisible(true);
}
else if(e.getSource()==ab1)
{
about ab=new about();
ab.setSize(450,350);
ab.setLocation(100,50);
ab.setVisible(true);
}
else if(e.getSource()==ab2)
{
about ab=new about();
ab.setSize(450,350);
ab.setLocation(100,50);
ab.setVisible(true);
}
else if(e.getSource()==ab3)
{
about ab=new about();
ab.setSize(450,350);
ab.setLocation(100,50);
ab.setVisible(true);
}
else if(e.getSource()==bsp)
{
if(ctr!=0)
{
int fsize=(int)(new File(str[ind]).length());
if(r1.isSelected())
{
int j=cb.getSelectedIndex();
csize=pos[j];
attr=getAttr(fsize,csize,0);
mod[ind]='a';
}
else if(r2.isSelected())
{
if(r3.isSelected())
attr=getAttr(fsize,0,Integer.parseInt(tf2.getText()));
else if(r4.isSelected())
attr=getAttr(fsize,csize,0);
mod[ind]='b';
}
size[ind]=attr[0];
lsize[ind]=attr[2];
no[ind]=attr[1];
tf2.setText(String.valueOf(no[ind]));
tf3.setText(String.valueOf(size[ind])+" & "+String.valueOf(lsize[ind]));
}
bsp.setVisible(false);
li1.setEnabled(true);
b1.setEnabled(true);
b2.setEnabled(true);
b3.setEnabled(true);
}

}

public void itemStateChanged(ItemEvent ie)
{
NumberFormat nf=NumberFormat.getNumberInstance();
nf.setMaximumFractionDigits(2);
nf.setGroupingUsed(false);
if(ie.getSource()==r1)
{
cb.setEnabled(true);
r3.setEnabled(false);
r4.setEnabled(false);
r5.setEnabled(false);
r6.setEnabled(false);
r7.setEnabled(false);
tf2.setEnabled(false);
tf3.setEnabled(false);
}
else if(ie.getSource()==r2)
{
cb.setEnabled(false);
r3.setEnabled(true);
r4.setEnabled(true);
r5.setEnabled(false);
r6.setEnabled(false);
r7.setEnabled(false);
tf2.setEnabled(true);
tf2.setText("1");
r3.setSelected(true);
tf3.setEnabled(false);

}
else if(ie.getSource()==r3)
{
r4.setEnabled(true);
r5.setEnabled(false);
r6.setEnabled(false);
r7.setEnabled(false);
tf2.setEnabled(true);
tf2.setText("1");
tf3.setEnabled(false);

}
else if(ie.getSource()==r4)
{
r3.setEnabled(true);
r5.setEnabled(true);
r6.setEnabled(true);
r7.setEnabled(true);
tf2.setEnabled(false);
tf2.setText("1");
tf3.setEnabled(true);
tf3.setText("1024");
csize=1024;

}
else if(ie.getSource()==r5)
{
tf3.setText(String.valueOf(csize));
}
else if(ie.getSource()==r6)
{
float csiz=(float) csize;
float cs=(csiz/1024);
tf3.setText(nf.format(cs));

}
else if(ie.getSource()==r7)
{
float csiz=(float) csize;
float cs=csiz/(1024*1024);
tf3.setText(nf.format(cs));

}

}


public int[] getAttr(int fsize,int size,int no)
{
int at[]=new int[3];
if(size!=0)
{
if(size>fsize)
{
at[0]=fsize;
at[1]=1;
at[2]=0;
}
else
{
at[0]=size;
at[2]=fsize%size;
if(at[2]==0)
at[1]=fsize/size;
else
at[1]=(fsize/size)+1;
}
}
else if(no!=0)
{
if(fsize%no==0)
{
at[0]=fsize/no;
at[1]=no;
at[2]=0;
}
else
{
at[2]=fsize%no;
at[0]=fsize/no;
at[1]=no;
at[2]+=at[0];
}
}
return at;
}

public String changesl(String path)
{
StringTokenizer st=new StringTokenizer(path,"\\");
StringBuffer sb=new StringBuffer();
while(st.hasMoreTokens())
{
sb.append(st.nextToken());
sb.append("/");
}
sb.deleteCharAt(sb.length()-1);
return (new String(sb));

}
public void clearlab()
{
l8.setText("Original File  :                      ");
l9.setText("Original Size  :                      ");
l10.setText("No of splits   :                      ");
l11.setText("Each split size:                      ");
l12.setText("Last split size:                      ");
l13.setText("Have Comments  :                      ");
l14.setText("Have Batchfile :                      ");
b12.setEnabled(false);

}

public void getConfig()
{
try
{
String cf = System.getProperty("user.dir") +
System.getProperty("file.separator") +
"EasySplitter.cfg";
FileReader fr1=new FileReader(cf);
BufferedReader br1=new BufferedReader(fr1);
String dsf=br1.readLine();
tf1.setText(dsf);
tf6.setText(dsf);
String dsf1=br1.readLine();
tf5.setText(dsf1);
tf7.setText(dsf1);
String dsf2=br1.readLine();
StringTokenizer tk1=new StringTokenizer(dsf2,"-");
String type=tk1.nextToken();
if(type.equals("1"))
{
r1.setSelected(true);
int sno=Integer.parseInt(tk1.nextToken());
cb.setSelectedIndex(sno);
tf8.setText(dsf2);
}
else if(type.equals("2"))
{
r2.setSelected(true);
r3.setSelected(true);
tk1.nextToken();
String sno=tk1.nextToken();
tf2.setText(sno);
tf8.setText(dsf2);
}
else if(type.equals("3"))
{
r4.setSelected(true);
r5.setSelected(true);
tk1.nextToken();
String sno=tk1.nextToken();
tf3.setText(sno);
tf8.setText(dsf2);
}
br1.close();
fr1.close();

}
catch(Exception eg)
{
JOptionPane.showMessageDialog((Container)null,"Error while executing the Configuration File!!\n No default values assumed!!\n Reason : "+eg.getMessage(),"Splitter_Merger",JOptionPane.OK_OPTION);
}
}

public void setConfig()
{
try
   {
    String cf = System.getProperty("user.dir") +
             System.getProperty("file.separator") +
             "EasySplitter.cfg";
   FileWriter fw1=new FileWriter(cf);
   BufferedWriter bw1=new BufferedWriter(fw1);
   String data=tf6.getText();
   bw1.write(data);
   bw1.newLine();
   String data1=tf7.getText();
   bw1.write(data1);
   bw1.newLine();
   String data2=tf8.getText();
   bw1.write(data2);
   bw1.close();
   fw1.close();
   }
   catch(Exception eg)
   {
      JOptionPane.showMessageDialog((Container)null,"Error while writing defaults to the Configuration File!!\nReason : "+eg.getMessage(),"Splitter_Merger",JOptionPane.OK_OPTION);    
   }
 }

 public int split(String source,String dest,String cmt,int no,int size,int lsize,boolean del,
                                  boolean batch)
 {
    String name,entry;
    long fsize,mtime;
    boolean ronly;
    File fl=new File(source);
    if(fl.exists())
    {
      name=fl.getName();
      fsize=fl.length();
      mtime=fl.lastModified();
      ronly=fl.canWrite();
      if(ronly)
        ronly=false;
      else
        ronly=true;
    }
    else
    {
      JOptionPane.showMessageDialog((Container)null,"File not found","Splitter_Merger",JOptionPane.OK_OPTION);
      return 0;
    }
    try{
    
    FileInputStream fis=new FileInputStream(fl);
    FileWriter fw=new FileWriter(dest);
    BufferedWriter bw=new BufferedWriter(fw);
    String l1=new String("jfs"+","+name+","+String.valueOf(fsize)+","+String.valueOf(mtime)+","+String.valueOf(ronly));
    bw.write(l1,0,l1.length());
    bw.newLine();
    String cfile;
    if(cmt!=null)
    {
      cfile=getName(name,-1);
      File bfc=new File((new File(dest)).getParent()+"/"+cfile);
      if(!bfc.exists())
      {
        FileWriter fwc=new FileWriter(bfc);
        BufferedWriter bwc=new BufferedWriter(fwc);
        bwc.write(cmt,0,cmt.length());
        bwc.close();
        fwc.close();
      }
    }
    else
    {
      cfile="null";
    }
    String bfile;
    FileWriter fw2;
    BufferedWriter bw2;
    bfile=getName(name,-2);
    File bf=new File(new File(dest).getParent()+"/"+bfile);
    fw2=new FileWriter(bf);
    bw2=new BufferedWriter(fw2);
    if(batch)
      bfile=getName(name,-2);
    else
      bfile="null";
    String l2=new String(cfile+","+bfile+","+String.valueOf(no)+","+String.valueOf(size)+","+String.valueOf(lsize));
    bw.write(l2,0,l2.length());
    bw.newLine();
    if(lsize!=0) no--;
    for(int i=1;i<=no;i++)
    {
      String sname=getName(name,i);
      FileOutputStream fos=new FileOutputStream(new File(dest).getParent()+"/"+sname);
      byte[] data=new byte[size];
      int count=fis.read(data);
      fos.write(data);
      fos.close();
      String ln=new String(sname+","+String.valueOf(size));
      bw.write(ln,0,ln.length());
      bw.newLine();
      if(batch)
      {
        String lb;
        if(i==1)
        lb=new String("copy /b \""+sname+"\" \""+name+"\"");
        else
        lb=new String("copy /b \""+name+"\"+\""+sname+"\" \""+name+"\"");
        bw2.write(lb,0,lb.length());
        bw2.newLine();
      }
    }
    if(lsize!=0)
    {
      String sname=getName(name,++no);
      FileOutputStream fos=new FileOutputStream(new File(dest).getParent()+"/"+sname);
      byte[] data=new byte[lsize];
      int count=fis.read(data);
      fos.write(data);
      fos.close();
      String ln=new String(sname+","+String.valueOf(lsize));
      bw.write(ln,0,ln.length());
      bw.newLine();
      if(batch)
      {
        String lb;
        lb=new String("copy /b \""+name+"\"+\""+sname+"\" \""+name+"\"");
        bw2.write(lb,0,lb.length());
        bw2.newLine();
      }

    }
    String eof=new String("eof");
    bw.write(eof,0,eof.length());
    bw.close();
    if(batch)
    {
    String lb=new String("echo File "+name+" successfully merged");
    bw2.write(lb,0,lb.length());
    }
    bw2.close();
    fis.close();
       
    if(!batch) bf.delete();
    if(del) fl.delete();
    }catch(Exception e){
      JOptionPane.showMessageDialog((Container)null,"Some internal error: Cannot split "+name+"\nReason: "+e.getMessage(),"Splitter _Merger",JOptionPane.OK_OPTION);
      return 0;
    }
   
     
    return 1;
  }

  public int merge(String split,String dest,boolean del)
  {
    try
    {
      File fm=new File(split);
      FileReader fr=new FileReader(fm);
      BufferedReader br=new BufferedReader(fr);
     
      String l1=br.readLine();
      StringTokenizer st1=new StringTokenizer(l1,",");
      String beg=st1.nextToken();
      if(!(beg.equals("jfs")))
      {
        JOptionPane.showMessageDialog((Container)null,"Not a valid split file!","Splitter_Merger",JOptionPane.OK_OPTION);
        return 1;
      }
      String oname=st1.nextToken();
      long osize=Long.parseLong(st1.nextToken());
      long mtime=Long.parseLong(st1.nextToken());
      String rd=st1.nextToken();
      boolean ronly;
      if(rd.equals("true"))
        ronly=true;
      else
        ronly=false;
      File f=new File(dest+"/"+oname);
      f.setLastModified(mtime);
      if(ronly)
        f.setReadOnly();
      FileOutputStream fos=new FileOutputStream(f);
      String l2=br.readLine();
      StringTokenizer st2=new StringTokenizer(l2,",");
      String cfile=st2.nextToken();
             
      String bfile=st2.nextToken();
      String comments;
     
      int no=Integer.parseInt(st2.nextToken());
      for (int i=0;i<no;i++)
      {
        String ln=br.readLine();
        StringTokenizer st=new StringTokenizer(ln,",");
        File f1=new File(new File(split).getParent()+"/"+st.nextToken());
        FileInputStream fis=new FileInputStream(f1);
        byte[] data=new byte[Integer.parseInt(st.nextToken())];
        int count=fis.read(data);
        fos.write(data);
        fis.close();
        if(del) f1.delete();
         
      }
      fos.close();
      br.close();
      if(del)
      {
        fm.delete();
        if(!cfile.equals("null"))
          new File(new File(split).getParent()+"/"+cfile).delete();
        if(!bfile.equals("null"))
          new File(new File(split).getParent()+"/"+bfile).delete();
      }
    }catch(Exception e){}
   
    JOptionPane.showMessageDialog((Container)null,"Merged successfully!","Splitter_Merger",JOptionPane.OK_OPTION);
    return 1;
  }

  public String getName(String name,int i)
  {
    String lpart=name.substring(0,name.length()-4);
   
    String rpart;
    if(i==0) rpart=".jfs";
    else if(i==-1) rpart=".cmt";
    else if(i==-2) rpart=".bat";
    else if(i<10) rpart=".00"+String.valueOf(i);
    else if(i<100) rpart=".0"+String.valueOf(i);
    else  rpart="."+String.valueOf(i);
    return(new String(lpart+rpart));
  }


 class filter1 extends javax.swing.filechooser.FileFilter
 {
  public boolean accept(File fileobj)
  {
      String extension = "";

      if(fileobj.getPath().lastIndexOf('.') > 0)
          extension = fileobj.getPath().substring(
              fileobj.getPath().lastIndexOf('.')
                + 1).toLowerCase();
        if(extension != "")
             return extension.equals("jfs");
        else
            return fileobj.isDirectory();
    }

    public String getDescription()
    {
        return "EasySplitter Files (*.jfs)";
    }
  }      

  class help extends javax.swing.JFrame
  {
    JEditorPane ep;
    JScrollPane sp;
    JButton b;
    URL urls[],temp[];
    JPanel p;
    help()
    {
      super("Help - Splitter_Merger");
      ep=new JEditorPane();
      ep.setEditable(false);
     
      ep.addHyperlinkListener(new HyperlinkListener()
      {
      public void hyperlinkUpdate(HyperlinkEvent he)
      {
        if(he.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
        {
          try
          {
          openpage(he.getURL());
          }
          catch(Exception e){}
        }
        }});
      sp=new JScrollPane(ep,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      b=new JButton("OK");
      b.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent ae)
          {
             setVisible(false);
          }
       });
      p=new JPanel(new FlowLayout());
      p.add(b);
      getContentPane().setLayout(new BorderLayout());
      getContentPane().add(p,BorderLayout.SOUTH);
      getContentPane().add(sp,BorderLayout.CENTER);
      String url1 = "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") +"Help.htm";    //help
      try
      {
        ep.setPage(url1);
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog((Container)null,"Unable to locate the help file!!","Splitter_Merger",JOptionPane.OK_OPTION);        
      }
    }
   
    public void openpage(URL url)
    {
     try
     {
       ep.setPage(url);
     }
     catch(IOException ex2){
     JOptionPane.showMessageDialog((Container)null,"Unable to locate the help file!!","EasySplitter_Merger",JOptionPane.OK_OPTION);        
     }
    }
 
  }//end of class help
 
  class about extends javax.swing.JFrame
   {
     JLabel la1,la2,la3,la4,la5;
     JTextArea ta;
     JScrollPane sp;
     JPanel p1,p2,p3,p4,p5;
     JButton b;
     JLabel img;

     about()
     {
       super("About Splitter_Merger");
       la1=new JLabel("  Name : Splitter_Merger");
       
       la3=new JLabel("  Developed by :Ichha & Varsha");
       la4=new JLabel(" Vivekananda Institute(VIPS_TC)");
     
       img=new JLabel(new ImageIcon("img.jpg"));
       ta=new JTextArea(5,30);      
       ta.setText("  This software is licensed as free software to \n"+
                   "  use and distribute to others. If any doubts,\n"+
                   "  please feel free to mail to: ichha2111@gmail.com");
       sp=new JScrollPane(ta);
       b=new JButton("OK");
       b.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent ae)
          {
             setVisible(false);
          }
       });  
       
       p2=new JPanel(new GridLayout(5,1));
       p2.add(la1);
     
       p2.add(la3);
       p2.add(la4);
     
       
       
       p4=new JPanel(new FlowLayout(FlowLayout.CENTER));
       p4.add(b);
       
       p5=new JPanel(new GridLayout(1,2));
       p5.add(img);
       p5.add(p2);
       
       
       p3=new JPanel(new GridLayout(2,1));
       p3.add(p5);
       p3.add(sp);
       
       p1=new JPanel(new BorderLayout());
       p1.add(p4,BorderLayout.SOUTH);
       p1.add(p3,BorderLayout.CENTER);      
       getContentPane().add(p1);
   
     }    
 
   } //end of class about
 


  class sizeset extends javax.swing.JFrame  implements ActionListener,ItemListener
  {
    JLabel sl1,sl2,sl3;
    JList sli1;
    JScrollPane ssp1;
    JTextField stf1,stf2;
    JButton sb1,sb2;
    JRadioButton rs1,rs2,rs3,rs4,rs5,rs6,rs7;
    ButtonGroup bs1,bs2,bs3;
    JPanel sp5,sp6,sp7,sp8,sp9,sp10,sp11;
    int msize=csize;

    public sizeset()
    {
      super("Set Default Size");
      Container sc1=getContentPane();
      sli1=new JList();
      sli1.setListData(ps);
      sli1.setVisibleRowCount(4);
      sli1.setSelectedIndex(2);
      //sli1.setMultiSelectionEnabled(false);
      ssp1=new JScrollPane(sli1);
      rs1=new JRadioButton("Predefined");
      rs2=new JRadioButton("Customized");
      bs1=new ButtonGroup();
      bs1.add(rs1);
      bs1.add(rs2);
      rs1.addItemListener(this);
      rs2.addItemListener(this);

      stf1=new JTextField(10);
      stf2=new JTextField(15);
      sl1=new JLabel("  files");
      rs3=new JRadioButton("Split into:         ");
      rs4=new JRadioButton("Split each file:");
      bs2=new ButtonGroup();
      bs2.add(rs3);
      bs2.add(rs4);
      rs5=new JRadioButton("bytes");
      rs6=new JRadioButton("KB");
      rs7=new JRadioButton("MB");
      bs3=new ButtonGroup();
      bs3.add(rs5);
      bs3.add(rs6);
      bs3.add(rs7);
      rs3.addItemListener(this);
      rs4.addItemListener(this);
      rs5.addItemListener(this);
      rs6.addItemListener(this);
      rs7.addItemListener(this);

      sp5=new JPanel(new BorderLayout());
      sp5.add(rs1,BorderLayout.NORTH);
      sp5.add(ssp1,BorderLayout.CENTER);
      sp5.add(rs2,BorderLayout.SOUTH);

      sp6=new JPanel();
      sp6.setLayout(new BoxLayout(sp6,BoxLayout.X_AXIS));
      sp6.add(Box.createHorizontalStrut(25));
      sp6.add(rs3);
      sp6.add(stf1);
      sp6.add(sl1);

      sp7=new JPanel();
      sp7.setLayout(new BoxLayout(sp7,BoxLayout.X_AXIS));
      sp7.add(Box.createHorizontalStrut(25));
      sp7.add(rs4);
      sp7.add(stf2);

      sb1=new JButton("OK");
      sb2=new JButton("Cancel");
      sb1.addActionListener(this);
      sb2.addActionListener(this);
      sp9=new JPanel();
      sp9.setLayout(new BoxLayout(sp9,BoxLayout.X_AXIS));
      sp9.add(Box.createHorizontalStrut(20));
      sp9.add(rs5);
      sp9.add(rs6);
      sp9.add(rs7);

      sp10=new JPanel(new BorderLayout());
      sp10.add(sp6,BorderLayout.NORTH);
      sp10.add(sp7,BorderLayout.CENTER);
      sp10.add(sp9,BorderLayout.SOUTH);

      sp11=new JPanel(new FlowLayout());
      sp11.add(sb1);
      sp11.add(sb2);


      sp8=new JPanel(new BorderLayout());
      sp8.add(sp5,BorderLayout.NORTH);
      sp8.add(sp10,BorderLayout.CENTER);
      sp8.add(sp11,BorderLayout.SOUTH);
     
      sc1.add(sp8,BorderLayout.CENTER);
      rs1.setSelected(true);

     stf2.addFocusListener(new FocusAdapter()
     {
       public void focusLost(FocusEvent fe)
       {
        try
        {
        if(stf2.getText().equals(""))
        {
          msize=0;
        }
        else
        {
         if (rs5.isSelected())
           msize=Integer.parseInt(stf2.getText());
         else if (rs6.isSelected())
           msize=(int)(Float.parseFloat(stf2.getText())*1024);
         else if (rs7.isSelected())
           msize=(int)(Float.parseFloat(stf2.getText())*1024*1024);
        }
        }catch(Exception e)
        { JOptionPane.showMessageDialog((Container)null,stf2.getText()+" : This is not a valid size","Splitter _Merger",JOptionPane.OK_OPTION);}
       

       }
     });

    }
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==sb1)
      {
        if(rs1.isSelected())
        {
         tf8.setText("1-"+String.valueOf(sli1.getSelectedIndex())+"-"+String.valueOf(pos[sli1.getSelectedIndex()]));
        }
        else if(rs2.isSelected())
        {
          if(rs3.isSelected())
          {
            tf8.setText("2-0-"+stf1.getText());
          }
          else if(rs4.isSelected())
          {
            tf8.setText("3-0-"+String.valueOf(msize));
          }
        }
        this.setVisible(false);
      }
      else if(e.getSource()==sb2)
      {
        this.setVisible(false);
      }
    }
    public void itemStateChanged(ItemEvent ie)
    {
     
     NumberFormat nf1=NumberFormat.getNumberInstance();
     nf1.setMaximumFractionDigits(2);
     nf1.setGroupingUsed(false);
     if(ie.getSource()==rs1)
     {
      sli1.setEnabled(true);
      rs3.setEnabled(false);
      rs4.setEnabled(false);
      rs5.setEnabled(false);
      rs6.setEnabled(false);
      rs7.setEnabled(false);
      stf1.setEnabled(false);
      stf2.setEnabled(false);
     }
     else if(ie.getSource()==rs2)
     {
      sli1.setEnabled(false);
      rs3.setEnabled(true);
      rs4.setEnabled(true);
      rs5.setEnabled(false);
      rs6.setEnabled(false);
      rs7.setEnabled(false);
      stf1.setEnabled(true);
      stf1.setText("1");
      rs3.setSelected(true);
      stf2.setEnabled(false);
     }
     else if(ie.getSource()==rs3)
     {
      rs4.setEnabled(true);
      rs5.setEnabled(false);
      rs6.setEnabled(false);
      rs7.setEnabled(false);
      stf1.setEnabled(true);
      stf1.setText("1");
      stf2.setEnabled(false);
     }
     else if(ie.getSource()==rs4)
     {
      rs3.setEnabled(true);
      rs5.setEnabled(true);
      rs6.setEnabled(true);
      rs7.setEnabled(true);
      rs5.setSelected(true);
      stf1.setEnabled(false);
      stf1.setText("1");
      stf2.setEnabled(true);
      stf2.setText("1024");
      msize=1024;
     }
     else if(ie.getSource()==rs5)
     {
      stf2.setText(String.valueOf(msize));
     }
     else if(ie.getSource()==rs6)
     {
        float msiz=(float) msize;
        float ms=(msiz/1024);
        stf2.setText(nf1.format(ms));
     }
     else if(ie.getSource()==rs7)
     {
        float msiz=(float) msize;
        float ms=msiz/(1024*1024);
        stf2.setText(nf1.format(ms));
     }
   
    }
  }
}
