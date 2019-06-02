package face;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import estrutura.Lista;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Jogo extends OutputStream
{
    private final JTextArea destination;

    public Jogo (JTextArea destination)
    {
        if (destination == null)
            throw new IllegalArgumentException ("Destination is null");

        this.destination = destination;
    }

    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException
    {
        final String text = new String (buffer, offset, length);
        SwingUtilities.invokeLater(new Runnable ()
            {
                @Override
                public void run() 
                {
                    destination.append (text);
                }
            });
    }

    @Override
    public void write(int b) throws IOException
    {
        write (new byte [] {(byte)b}, 0, 1);
    }

    public static void main (String[] args) throws Exception
    {
        JTextArea textArea = new JTextArea (25, 80);

        textArea.setEditable (true);

        JFrame frame = new JFrame ("Jogo de cartas - Trabalho sobre lista encadeada");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane ();
        contentPane.setLayout (new BorderLayout ());
        JScrollPane scrollPane = new JScrollPane (
                textArea, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contentPane.add (
            scrollPane,
            BorderLayout.CENTER);
        frame.pack ();
        frame.setVisible (true);

        Jogo out = new Jogo (textArea);
        
        JButton btnJogar = new JButton("Rodar uma Partida do Jogo");

        scrollPane.setColumnHeaderView(btnJogar);
        System.setOut (new PrintStream (out));


            
        btnJogar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Lista lista = new Lista();
        		
        		//Adiciona os 10 jogadores
        		lista.inserirJogador("Thiago");
        		lista.inserirJogador("Matheus");
        		lista.inserirJogador("Gabriel");
        		lista.inserirJogador("Jeronimo");
        		lista.inserirJogador("Lorran");
        		lista.inserirJogador("Lucas");
        		lista.inserirJogador("Rafaela");
        		lista.inserirJogador("Kenji");
        		lista.inserirJogador("Joeh");
        		lista.inserirJogador("Paula");
                //Jogar a partida
        		lista.Jogar();
        		
        	}
        });
    		
        	
       
     
    }
}