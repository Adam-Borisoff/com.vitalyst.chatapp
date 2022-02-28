package com.vitalyst.chatapp;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChatBoard extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 1 L;

  JTextField customername = new JTextField();
  JLabel customerlabel = new JLabel("Customer:");
  //Strings
  String[] clientlist = {
    "PA",
    "PHS"
  };
  String[] greetingstring = new String[clientlist.length];
  String[] misdirectstring = new String[clientlist.length];
  String[] escalatestring = {
    "pennsylvania",
    "phs"
  };
  String enterprisestring = new String();

  //buttons

  JButton[] client = new JButton[clientlist.length];
  JButton[] escalate = new JButton[clientlist.length];
  JButton[] misdirect = new JButton[clientlist.length];
  JButton[] greeting = new JButton[clientlist.length];
  JButton moretime = new JButton("More time");
  JButton noresponse = new JButton("No response");
  JButton enterprise = new JButton("Enterprise voice migration");

  JButton phsclose = new JButton("PHS Close call");

  JFrame frame = new JFrame("Chat canned responses");

  public ChatBoard() {

    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(500, 500);

    for (int y = 0, LW = 90, x = 0, i = 0; i < client.length; i++, x = x + 90) {
      client[i] = new JButton();
      client[i].setText(clientlist[i]);
      escalate[i] = new JButton();
      escalate[i].setText("Escalate");
      misdirect[i] = new JButton();
      misdirect[i].setText("Misdirect");

      greeting[i] = new JButton();
      greeting[i].setText("Greeting");

      frame.getContentPane().add(client[i]);
      if (x > 400) {
        x = 0;
        y = y + 90;
      }
      client[i].setBounds(x, y, LW, LW);
    }

    frame.getContentPane().add(customername);
    frame.getContentPane().add(customerlabel);

    customername.setBounds(60, 400, 180, 45);
    customerlabel.setBounds(0, 400, 90, 45);
    frame.setLayout(null);
    frame.setVisible(true);

    Clicklistener click = new Clicklistener();

    moretime.addActionListener(click);
    phsclose.addActionListener(click);
    enterprise.addActionListener(click);

    noresponse.addActionListener(click);

    for (int i = 0; i < client.length; i++) {
      client[i].addActionListener(click);
      greeting[i].addActionListener(click);
      escalate[i].addActionListener(click);
      misdirect[i].addActionListener(click);
    }

  }

  private class Clicklistener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      for (int i = 0; i < client.length; i++) {
        frame.remove(client[i]);
      }

      if (e.getSource() == client[0]) {
        frame.getContentPane().add(misdirect[0]);
        frame.getContentPane().add(escalate[0]);
        frame.getContentPane().add(greeting[0]);
        frame.getContentPane().add(enterprise);
        frame.getContentPane().add(moretime);

        frame.getContentPane().add(noresponse);

        frame.setVisible(true);
        moretime.setBounds(0, 0, 90, 90);
        greeting[0].setBounds(90, 0, 90, 90);
        enterprise.setBounds(0, 90, 90, 90);
        misdirect[0].setBounds(90, 90, 90, 90);
        escalate[0].setBounds(90, 180, 90, 90);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

      }

      if (e.getSource() == client[1]) {
        for (int i = 0; i < client.length; i++) {
          frame.remove(client[i]);
        }
        frame.getContentPane().add(greeting[1]);
        frame.getContentPane().add(phsclose);
        frame.getContentPane().add(escalate[1]);
        frame.getContentPane().add(misdirect[1]);
        greeting[1].setBounds(0, 0, 90, 90);
        phsclose.setBounds(0, 90, 90, 90);
        escalate[1].setBounds(90, 90, 90, 90);
        misdirect[1].setBounds(90, 0, 90, 90);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

      }
      //Pennsylvania
      if (e.getSource() == greeting[0]) {
        greetingstring[0] = "Vitalyst help desk. My name is Adam. May I please have your full agency name?";
        StringSelection stringSelectionObj = new StringSelection(greetingstring[0]);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }
      if (e.getSource() == misdirect[0]) {
        misdirectstring[0] = "I'm sorry " + customername.getText() + ", my team provides how-to support and training for Skype for Business, Teams and other Microsoft collaboration tools. For this issue, you will need to hang up and contact your normal Agency IT Help Desk";
        StringSelection stringSelectionObj = new StringSelection(misdirectstring[0]);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }
      if (e.getSource() == escalate[0]) {
        escalatestring[0] = "Isorry " + customername.getText() + " at this point we are unable to resolve your issue and you will need to disconnect and contact your normal Agency IT Help Desk";
        StringSelection stringSelectionObj = new StringSelection(escalatestring[0]);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }
      if (e.getSource() == enterprise) {
        enterprisestring = "I'm sorry " + customername.getText() + ", but my team is only permitted to support users who are part of the Microsoft Teams Enterprise Voice migration. To get help for your issue, you will need to disconnect and contact your normal Agency IT help Desk for support.";
        StringSelection stringSelectionObj = new StringSelection(enterprisestring);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }

      //phs
      if (e.getSource() == greeting[1]) {
        greetingstring[1] = "Thank you for contacting the PHS Microsoft 365 support line. My name is Adam. What can I help you with today?";
        StringSelection stringSelectionObj = new StringSelection(greetingstring[1]);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }
      if (e.getSource() == escalate[1]) {
        escalatestring[1] = "At this point, we need to get another support desk involved. Let me give you the number to call. It's 505-923-6825. Once your dial, please listen carefully and select the most appropriate option ";
        StringSelection stringSelectionObj = new StringSelection(escalatestring[1]);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }
      if (e.getSource() == misdirect[1]) {
        misdirectstring[1] = "I'm sorry " + customername.getText() + ", my group is only authorized to support applications such as Teams, Outlook, and SharePoint. For the problem youhaving, I have been asked to direct you to another support group. Let me give you the number to call. It505-923-6825.  Once you dial, please listen carefully and select the most appropriate option.";
        StringSelection stringSelectionObj = new StringSelection(misdirectstring[1]);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }
      if (e.getSource() == moretime) {
        String moretimestring = "Hi " + customername.getText() + ", do you need more time to respond?";
        StringSelection stringSelectionObj = new StringSelection(moretimestring);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }
      if (e.getSource() == phsclose) {
        String phsclosestring = "Thank you for contacting us today. As a friendly reminder, immediate expert support is available via chat and click-to-call in the 'Live Help' Teams App. Click-to-call has been recently released and is located under the 'Webinars' tab in the Live Help App.";
        StringSelection stringSelectionObj = new StringSelection(phsclosestring);
        Clipboard clipboardObj = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardObj.setContents(stringSelectionObj, null);
      }

    }

  }
  public static void main(String[] args) {
    new ChatBoard();
  }
}
