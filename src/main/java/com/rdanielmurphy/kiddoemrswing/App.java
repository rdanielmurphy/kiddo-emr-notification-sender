package main.java.com.rdanielmurphy.kiddoemrswing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App extends JFrame
{
    private static JTextArea textArea;
    private static JTextField phoneIdTextField;
    private static DefaultListModel listModel;

    public static void main( String[] args )
    {
        App ex = new App();
        ex.setVisible(true);
        ex.setSize(300, 300);
        ex.setLocationRelativeTo(null);
        ex.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane jtbExample = new JTabbedPane();

        //send a message tab pane
        JButton postMessageBtn = new JButton("Post Message");
        postMessageBtn.setSize(200, 50);
        postMessageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String apiKey = GCMConstants.PROJECT_API_KEY;  //project API key
                Content content = createContent(textArea.getText());

                POST2GCM.post(apiKey, content);
            }
        });

        textArea = new JTextArea(10,20);
        textArea.setLineWrap(true);
        JPanel postMessagePnl = new JPanel();
        postMessagePnl.setSize(300, 300);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        postMessagePnl.setLayout(layout);
        postMessagePnl.add(textArea);
        postMessagePnl.add(postMessageBtn);
        jtbExample.addTab("Send Message", postMessagePnl);

        //add a phone tab
        listModel = new DefaultListModel();
        JList listbox = new JList( listModel );
        JPanel addPhonePnl = new JPanel();
        addPhonePnl.add( listbox, BorderLayout.CENTER );
        JButton addPhoneBtn = new JButton("Add Phone");
        addPhoneBtn.setSize(200,50);
        addPhoneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                listModel.addElement(phoneIdTextField.getText());
            }
        });
        phoneIdTextField = new JTextField(20);
        JPanel panel = new JPanel();
        panel.setSize(300,300);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(phoneIdTextField);
        panel.add(addPhoneBtn);
        addPhonePnl.add(panel);
        jtbExample.addTab("Add Phone", addPhonePnl);

        // build tabs
        ex.add(jtbExample);
        ex.validate();
    }
    
    public static Content createContent(String messageText){
		
		Content c = new Content();

        // add phone ids
        for (int i = 0; i < listModel.size(); i++) {
            c.addRegId(listModel.get(i).toString());
        }

        c.createData(messageText, "Test Message");
		
		return c;
	}
}
