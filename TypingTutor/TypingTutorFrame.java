// TypingTutorFrame.java
// Application enables users to practice typing.
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TypingTutorFrame extends JFrame
{
    // JLabel and JTextArea to display text output
    private JLabel prompt1JLabel, prompt2JLabel;
    private JTextArea outputJTextArea;
    
    // JButtons to represent first row of keys
    private JButton tildeJButton, oneJButton, twoJButton, 
        threeJButton, fourJButton, fiveJButton, sixJButton, 
        sevenJButton, eightJButton, nineJButton, zeroJButton, 
        hyphenJButton, plusJButton, backspaceJButton;
        
    // JButtons to represent second row of keys
    private JButton tabJButton, qJButton, wJButton, eJButton,
        rJButton, tJButton, yJButton, uJButton, iJButton, oJButton,
        pJButton, leftBraceJButton, rightBraceJButton, slashJButton;
    
    // JButtons to represent third row of keys
    private JButton capsJButton, aJButton, sJButton, dJButton,
        fJButton, gJButton, hJButton, jJButton, kJButton, lJButton,
        colonJButton, quoteJButton, enterJButton;
        
    // JButtons to represent fourth row of keys
    private JButton shiftLeftJButton, zJButton, xJButton, cJButton,
        vJButton, bJButton, nJButton, mJButton, commaJButton, periodJButton,
        questionJButton, shiftRightJButton, upJButton;
        
    // JButtons to represent fifth row of keys
    private JButton spaceJButton, leftJButton, downJButton,
        rightJButton;
        
    // JButton to store the last JButton typed
    private JButton lastJButton;
    
    // array of JButtons
    private JButton[] keyJButtons =
        new JButton[KeyEvent.KEY_LAST + 1];
        
    // no-argument constructor
    public TypingTutorFrame()
    {
        super("Typing Tutor");
        setLayout(null); // position GUI components explicitly
        
        // set up prompt1JLabel
        prompt1JLabel = new JLabel("Type some text using your " + 
            "keyboard. The keys you press will be highlighted and " +
            "the text will be displayed.");
        prompt1JLabel.setBounds(15, 5, 725, 20);
        add(prompt1JLabel);
        
        // set up prompt2JLabel
        prompt2JLabel = new JLabel("Note: Clicking the buttons " +
            "with your mouse will not perform any action.");
        prompt2JLabel.setBounds(15, 20, 725, 25);
        add(prompt2JLabel);
        
        // set up outputJTextArea
        outputJTextArea = new JTextArea();
        outputJTextArea.setBounds(15, 50, 725, 175);
        outputJTextArea.setLineWrap(true);
        add(outputJTextArea);
        outputJTextArea.addKeyListener(
            new KeyListener() // anonymous inner class
            {
                // event handler called when any key is pressed
                public void keyPressed(KeyEvent event)
                {
                    // get the key code for this event
                    int buttonIndex = event.getKeyCode();
                    
                    // change the color of the associated JButton
                    changeColor(keyJButtons[buttonIndex]);
                }
                
                // event handler called when any key is released
                public void keyReleased(KeyEvent event)
                {
                    resetColor();
                }
                
                // event handler called when any key is typed
                public void keyTyped(KeyEvent event)
                {
                    // nothing to do
                }
            } // end anonymous inner class
        ); // end call to addKeyListener
        
        outputJTextArea.addFocusListener(
            new FocusAdapter() // anonymous inner class
            {
                // event handler called when outputJTextArea loses focus
                public void focusLost(FocusEvent event)
                {
                    resetColor();
                }
            } // end anonymous inner class
        ); // end call to addFocusListener
        
        createButtons(); // ceate and position keyboard buttons
    } // end construtor
    
    // create all buttons used for the keyboard
    private void createButtons()
    {
        // set up tildeJButton
        tildeJButton = new JButton("~");
        tildeJButton.setBounds(15, 250, 48, 48);
        add(tildeJButton);
        keyJButtons[KeyEvent.VK_BACK_QUOTE] = tildeJButton;
        
        // set up oneJButton
        oneJButton = new JButton("1");
        oneJButton.setBounds(63, 250, 48, 48);
        add(oneJButton);
        keyJButtons[KeyEvent.VK_1] = oneJButton;
        
        // set up twoJButton
        twoJButton = new JButton("2");
        twoJButton.setBounds(111, 250, 48, 48);
        add(twoJButton);
        keyJButtons[KeyEvent.VK_2] = twoJButton;
        
        // set up threeJButton
        threeJButton = new JButton("3");
        threeJButton.setBounds(159, 250, 48, 48);
        add(threeJButton);
        keyJButtons[KeyEvent.VK_3] = threeJButton;
        
        // set up fourJButton
        fourJButton = new JButton("4");
        fourJButton.setBounds(207, 250, 48, 48);
        add(fourJButton);
        keyJButtons[KeyEvent.VK_4] = fourJButton;
        
        // set up fiveJButton
        fiveJButton = new JButton("5");
        fiveJButton.setBounds(255, 250, 48, 48);
        add(fiveJButton);
        keyJButtons[KeyEvent.VK_5] = fiveJButton;
        
        // set up sixJButton
        sixJButton = new JButton("6");
        sixJButton.setBounds(303, 250, 48, 48);
        add(sixJButton);
        keyJButtons[KeyEvent.VK_6] = sixJButton;
        
        // set up sevenJButton
        sevenJButton = new JButton("7");
        sevenJButton.setBounds(351, 250, 48, 48);
        add(sevenJButton);
        keyJButtons[KeyEvent.VK_7] = sevenJButton;
        
        // set up eightJButton
        eightJButton = new JButton("8");
        eightJButton.setBounds(399, 250, 48, 48);
        add(eightJButton);
        keyJButtons[KeyEvent.VK_8] = eightJButton;
        
        // set up nineJButton
        nineJButton = new JButton("9");
        nineJButton.setBounds(447, 250, 48, 48);
        add(nineJButton);
        keyJButtons[KeyEvent.VK_9] = nineJButton;
        
        // set up zeroJButton
        zeroJButton = new JButton("0");
        zeroJButton.setBounds(495, 250, 48, 48);
        add(zeroJButton);
        keyJButtons[KeyEvent.VK_0] = zeroJButton;
        
        // set up hyphenJButton
        hyphenJButton = new JButton("-");
        hyphenJButton.setBounds(543, 250, 48, 48);
        add(hyphenJButton);
        keyJButtons[KeyEvent.VK_MINUS] = hyphenJButton;
        
        // set up plusJButton
        plusJButton = new JButton("+");
        plusJButton.setBounds(591, 250, 48, 48);
        add(plusJButton);
        keyJButtons[KeyEvent.VK_EQUALS] = plusJButton;
        
        // set up backspaceJButton
        backspaceJButton = new JButton("Backspace");
        backspaceJButton.setBounds(639, 250, 48, 48);
        add(backspaceJButton);
        keyJButtons[KeyEvent.VK_BACK_SPACE] = backspaceJButton;
        
        // set up tabJButton
        tabJButton = new JButton("Tab");
        tabJButton.setBounds(15, 298, 75, 48);
        add(tabJButton);
        keyJButtons[KeyEvent.VK_TAB] = tabJButton;
        
        // set up qJButton
        qJButton = new JButton("Q");
        qJButton.setBounds(90, 298, 48, 48);
        add(qJButton);
        keyJButtons[KeyEvent.VK_Q] = qJButton;
        
        // set up wJButton
        wJButton = new JButton("W");
        wJButton.setBounds(138, 298, 48, 48);
        add(wJButton);
        keyJButtons[KeyEvent.VK_W] = wJButton;
        
        // set up eJButton
        eJButton = new JButton("E");
        eJButton.setBounds(186, 298, 48, 48);
        add(eJButton);
        keyJButtons[KeyEvent.VK_E] = eJButton;
        
        // set up rJButton
        rJButton = new JButton("R");
        rJButton.setBounds(234, 298, 48, 48);
        add(rJButton);
        keyJButtons[KeyEvent.VK_R] = rJButton;
        
        // set up tJButton
        tJButton = new JButton("T");
        tJButton.setBounds(282, 298, 48, 48);
        add(tJButton);
        keyJButtons[KeyEvent.VK_T] = tJButton;
        
        // set up yJButton
        yJButton = new JButton("Y");
        yJButton.setBounds(330, 298, 48, 48);
        add(yJButton);
        keyJButtons[KeyEvent.VK_Y] = yJButton;
        
        // set up uJButton
        uJButton = new JButton("U");
        uJButton.setBounds(378, 298, 48, 48);
        add(uJButton);
        keyJButtons[KeyEvent.VK_U] = uJButton;
        
        // set up iJButton
        iJButton = new JButton("I");
        iJButton.setBounds(426, 298, 48, 48);
        add(iJButton);
        keyJButtons[KeyEvent.VK_I] = iJButton;
        
        // set up oJButton
        oJButton = new JButton("O");
        oJButton.setBounds(474, 298, 48, 48);
        add(oJButton);
        keyJButtons[KeyEvent.VK_O] = oJButton;
        
        // set up pJButton
        pJButton = new JButton("P");
        pJButton.setBounds(522, 298, 48, 48);
        add(pJButton);
        keyJButtons[KeyEvent.VK_P] = pJButton;
        
        // set up leftBraceJButton
        leftBraceJButton = new JButton("[");
        leftBraceJButton.setBounds(570, 298, 48, 48);
        add(leftBraceJButton);
        keyJButtons[KeyEvent.VK_OPEN_BRACKET] = leftBraceJButton;
        
        // set up rightBraceJButton
        rightBraceJButton = new JButton("]");
        rightBraceJButton.setBounds(618, 298, 48, 48);
        add(rightBraceJButton);
        keyJButtons[KeyEvent.VK_CLOSE_BRACKET] = rightBraceJButton;
        
        // set up slashJButton
        slashJButton = new JButton("\\");
        slashJButton.setBounds(666, 298, 48, 48);
        add(slashJButton);
        keyJButtons[KeyEvent.VK_BACK_SLASH] = slashJButton;
        
        // set up capsJButton
      capsJButton = new JButton("Caps");
      capsJButton.setBounds(15, 346, 75, 48);
      add(capsJButton);
      keyJButtons[KeyEvent.VK_CAPS_LOCK] = capsJButton;

      // set up aJButton
      aJButton = new JButton("A");
      aJButton.setBounds(90, 346, 48, 48);
      add(aJButton);
      keyJButtons[KeyEvent.VK_A] = aJButton;

      // set up sJButton
      sJButton = new JButton("S");
      sJButton.setBounds(138, 346, 48, 48);
      add(sJButton);
      keyJButtons[KeyEvent.VK_S] = sJButton;

      // set up dJButton
      dJButton = new JButton("D");
      dJButton.setBounds(186, 346, 48, 48);
      add(dJButton);
      keyJButtons[KeyEvent.VK_D] = dJButton;

      // set up fJButton
      fJButton = new JButton("F");
      fJButton.setBounds(234, 346, 48, 48);
      add(fJButton);
      keyJButtons[KeyEvent.VK_F] = fJButton;

      // set up gJButton
      gJButton = new JButton("G");
      gJButton.setBounds(282, 346, 48, 48);
      add(gJButton);
      keyJButtons[KeyEvent.VK_G] = gJButton;

      // set up hJButton
      hJButton = new JButton("H");
      hJButton.setBounds(330, 346, 48, 48);
      add(hJButton);
      keyJButtons[KeyEvent.VK_H] = hJButton;

      // set up jJButton
      jJButton = new JButton("J");
      jJButton.setBounds(378, 346, 48, 48);
      add(jJButton);
      keyJButtons[KeyEvent.VK_J] = jJButton;

      // set up kJButton
      kJButton = new JButton("K");
      kJButton.setBounds(426, 346, 48, 48);
      add(kJButton);
      keyJButtons[KeyEvent.VK_K] = kJButton;

      // set up lJButton
      lJButton = new JButton("L");
      lJButton.setBounds(474, 346, 48, 48);
      add(lJButton);
      keyJButtons[KeyEvent.VK_L] = lJButton;

      // set up colonJButton
      colonJButton = new JButton(":");
      colonJButton.setBounds(522, 346, 48, 48);
      add(colonJButton);
      keyJButtons[KeyEvent.VK_SEMICOLON] = colonJButton;

      // set up quoteJButton
      quoteJButton = new JButton("\"");
      quoteJButton.setBounds(570, 346, 48, 48);
      add(quoteJButton);
      keyJButtons[KeyEvent.VK_QUOTE] = quoteJButton;

      // set up enterJButton
      enterJButton = new JButton("Enter");
      enterJButton.setBounds(618, 346, 96, 48);
      add(enterJButton);
      keyJButtons[KeyEvent.VK_ENTER] = enterJButton;

      // set up shiftLeftJButton
      shiftLeftJButton = new JButton("Shift");
      shiftLeftJButton.setBounds(15, 394, 100, 48);
      add(shiftLeftJButton);
      keyJButtons[KeyEvent.VK_SHIFT] = shiftLeftJButton;

      // set up zJButton
      zJButton = new JButton("Z");
      zJButton.setBounds(115, 394, 48, 48);
      add(zJButton);
      keyJButtons[KeyEvent.VK_Z] = zJButton;

      // set up xJButton
      xJButton = new JButton("X");
      xJButton.setBounds(163, 394, 48, 48);
      add(xJButton);
      keyJButtons[KeyEvent.VK_X] = xJButton;

      // set up cJButton
      cJButton = new JButton("C");
      cJButton.setBounds(211, 394, 48, 48);
      add(cJButton);
      keyJButtons[KeyEvent.VK_C] = cJButton;

      // set up vJButton
      vJButton = new JButton("V");
      vJButton.setBounds(259, 394, 48, 48);
      add(vJButton);
      keyJButtons[KeyEvent.VK_V] = vJButton;

      // set up bJButton
      bJButton = new JButton("B");
      bJButton.setBounds(307, 394, 48, 48);
      add(bJButton);
      keyJButtons[KeyEvent.VK_B] = bJButton;

      // set up nJButton
      nJButton = new JButton("N");
      nJButton.setBounds(355, 394, 48, 48);
      add(nJButton);
      keyJButtons[KeyEvent.VK_N] = nJButton;

      // set up mJButton
      mJButton = new JButton("M");
      mJButton.setBounds(403, 394, 48, 48);
      add(mJButton);
      keyJButtons[KeyEvent.VK_M] = mJButton;

      // set up commaJButton
      commaJButton = new JButton(",");
      commaJButton.setBounds(451, 394, 48, 48);
      add(commaJButton);
      keyJButtons[KeyEvent.VK_COMMA] = commaJButton;

      // set up periodJButton
      periodJButton = new JButton(".");
      periodJButton.setBounds(499, 394, 48, 48);
      add(periodJButton);
      keyJButtons[KeyEvent.VK_PERIOD] = periodJButton;

      // set up questionJButton
      questionJButton = new JButton("?");
      questionJButton.setBounds(547, 394, 48, 48);
      add(questionJButton);
      keyJButtons[KeyEvent.VK_SLASH] = questionJButton;

      // set up upJButton
      upJButton = new JButton("^");
      upJButton.setBounds(618, 394, 48, 48);
      add(upJButton);
      keyJButtons[KeyEvent.VK_UP] = upJButton;

      // set up spaceJButton
      spaceJButton = new JButton("");
      spaceJButton.setBounds(208, 442, 300, 48);
      add(spaceJButton);
      keyJButtons[KeyEvent.VK_SPACE] = spaceJButton;

      // set up leftJButton
      leftJButton = new JButton("<");
      leftJButton.setBounds(570, 442, 48, 48);
      add(leftJButton);
      keyJButtons[KeyEvent.VK_LEFT] = leftJButton;

      // set up downJButton
      downJButton = new JButton("v");
      downJButton.setBounds(618, 442, 48, 48);
      add(downJButton);
      keyJButtons[KeyEvent.VK_DOWN] = downJButton;

      // set up rightJButton
      rightJButton = new JButton(">");
      rightJButton.setBounds(666, 442, 48, 48);
      add(rightJButton);
      keyJButtons[KeyEvent.VK_RIGHT] = rightJButton;
   } // end method createButtons

   // highlight JButton passed as argument
   private void changeColor(JButton changeJButton)
   {
      if (changeJButton != null)
      {
         resetColor();
         changeJButton.setBackground(Color.YELLOW);
         lastJButton = changeJButton;
      }
   } 

   // changes lastJButton's color back to default
   private void resetColor()
   {
      if (lastJButton != null)
         lastJButton.setBackground(this.getBackground());
   } 
} // end class TypingTutor