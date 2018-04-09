package com.testExample;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.html.*;


public class PopupMenuInEditorPane{          
    private static String content = new StringBuffer()
        .append("<html><body>\n")
        .append("<a href=\"popup:It doest't have to be a valid URL\">\n")
        .append("Right click to see popup menu.</a><br>\n")
        .append("<a href=\"http://www.experts-exchange.com/jsp/qShow.jsp?qid=20143329\">\n")
        .append("You still can handle normal URLs.</a><br>\n")
        .append("And you can have mouse-insensitive text\n")
        .append("</body></html>\n")
        .toString();
    public static void main(String[] args) throws IOException{
        System.out.println(content);
        System.setErr(new PrintStream(new FileOutputStream("err.log")));
        JTextPane textPane = new JTextPane();
        textPane.setEditorKit(new Kit());
        textPane.setText(content);
        textPane.addHyperlinkListener(new LinkListener());
        textPane.setEditable(false);
        JFrame frame = new JFrame("HTML Popup Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(textPane);
        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    private static class Kit extends HTMLEditorKit{
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private HTMLEditorKit.LinkController linkController;

        public void install(JEditorPane c) {
            super.install(c);
            replaceLinkController(c);
        }

        public void deinstall(JEditorPane c){
            c.removeMouseListener(linkController);
            c.removeMouseMotionListener(linkController);
        }

        void replaceLinkController(JEditorPane c){
            {EventListener[] listeners = c.getListeners(MouseListener.class);
            for( int i=0; i<listeners.length; ++i){
                if(listeners[i] instanceof HTMLEditorKit.LinkController){
                    c.removeMouseListener((MouseListener)listeners[i]);
                }
            }}
            {EventListener[] listeners = c.getListeners(MouseMotionListener.class);
            for( int i=0; i<listeners.length; ++i){
                if(listeners[i] instanceof HTMLEditorKit.LinkController){
                    c.removeMouseMotionListener((MouseMotionListener)listeners[i]);
                }
            }}
            linkController = createLinkController();
            c.addMouseListener(linkController);
            c.addMouseMotionListener(linkController);
        }

        HTMLEditorKit.LinkController createLinkController(){
            return new PopupMenuInEditorPane.LinkController();
        } 

    }
  
    private static class LinkController extends HTMLEditorKit.LinkController{
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void mousePressed(final MouseEvent event){
            super.mousePressed(event);
            SwingUtilities.invokeLater( new Runnable(){
                public void run(){ 
                    checkPopup(event);
                }
            });
        }
        public void mouseReleased(MouseEvent event){
            checkPopup(event);
            super.mousePressed(event);
        }
        public void mouseClicked(MouseEvent event){
            checkPopup(event);
            if(isHTMLPane(event.getComponent()) && isPopupHref(getHref(event))){
                return;
            }
            super.mouseClicked(event);
        }

        public void mouseMoved(MouseEvent event){
            if(isHTMLPane(event.getComponent()) && isPopupHref(getHref(event))){
                event.consume();
                return;
            }
            super.mouseMoved(event);
        }

        void checkPopup(MouseEvent event){
            if( !isHTMLPopup(event) ){
                return;
            }
            String href = getHref(event);
            if(isPopupHref(href)){
                event.consume();
                showPopup(event,href);
            }
        }
        
        boolean isHTMLPopup(MouseEvent event){
            return event.isPopupTrigger()
                && isHTMLPane(event.getComponent()); 
        }
                                  
        boolean isHTMLPane(Component component){
            return component instanceof JEditorPane
                && ((JEditorPane)component)
                    .getDocument() instanceof HTMLDocument;
        }

        String getHref(MouseEvent event){
            JEditorPane editor = (JEditorPane)event.getSource();
            HTMLDocument doc = (HTMLDocument)editor.getDocument();

            Point pt = new Point(event.getX(), event.getY());
            Element e = doc.getCharacterElement(editor.viewToModel(pt));
            AttributeSet a = e.getAttributes();
            AttributeSet anchor = (AttributeSet) a.getAttribute(HTML.Tag.A);
            return (anchor == null ? null 
                : (String) anchor.getAttribute(HTML.Attribute.HREF) );
        }

        boolean isPopupHref(String href){
            return href != null && href.startsWith("popup:");
        }

        void showPopup(MouseEvent reason, String targetHref){
            JPopupMenu popup = new JPopupMenu();
            popup.add("Item 1");
            popup.add("Item 2");
            popup.show(reason.getComponent(),reason.getX(),reason.getY());
        }
    }

    private static class LinkListener implements HyperlinkListener{
        public void hyperlinkUpdate(HyperlinkEvent e) {
            JEditorPane pane = (JEditorPane) e.getSource();
            try {
                pane.setPage(e.getURL());
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}                        